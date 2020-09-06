package dk.service;

import dk.exception.ClientException;
import dk.exception.SystemException;
import dk.mapper.UserMapper;
import dk.model.Setting;
import dk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class UserService {

    @Value("${user.head.local-path}")
    private String localPath;
    @Value("${user.head.remote-path}")
    private String remotePath;
    @Value("${user.head.filename}")
    private String fileName;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SettingService settingService;

    public User login(User user) {
        //这种方式就是精准报错
        User query = new User();
        query.setUsername(user.getUsername());
        User exist = userMapper.selectOne(query);
        if (exist == null)    //进行校验
            throw new ClientException("USR001", "用户不存在");
        if (!exist.getPassword().equals(user.getPassword()))
            throw new ClientException("USR002", "用户名密码校验失败");
        return exist;
    }

    /**
     * 由于用户注册成功, 更新数据库时 可能出错.或者更新数据库成功了,但是用户头像上传失败
     * 此时就会造成数据更新出错, 我们使用 事务@Transactional 来解决
     * 默认事务的配置为 Spring事务的传播特性是 required,事务的隔离级别为 数据库的默认隔离级别
     */
    @Transactional
    public void register(User user, MultipartFile headFile) {

        User query = new User();
        query.setUsername(user.getUsername());
        User exist = userMapper.selectOne(query);
        if (exist != null) //根据 用户名 查询已有的用户信息, 如果已存在,就不允许注册
            throw new ClientException("USR003", "用户已存在,请更换用户名");

        //保存(插入) 注册用户信息
        String path = "/" + user.getUsername() + "/" + fileName;//本地路径
        user.setHead(remotePath + path);//设置用户头像, 远程访问的路径
        userMapper.insertSelective(user);//插入成功后,自增主键通过mybatis的<selectKey>返回对象

        //注册用户时,完成初始化设置: 同步更新数据库setting数据, 随便设置抽奖人数,我们这里默认设置为8
        Setting setting = new Setting();
        setting.setUserId(user.getId());
        setting.setBatchNumber(8);
        settingService.add(setting);//注册新用户完成, 添加setting信息


        //保存 用户注册头像 到本地文件夹
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            try {
                File dir = new File(localPath + "/" + user.getUsername());
                dir.mkdirs(); //mkdirs创建多级目录. mkdir创建一级目录.
                fos = new FileOutputStream(localPath + path);
                bos = new BufferedOutputStream(fos);
                bos.write(headFile.getBytes());
                bos.flush();
            } finally {
                if (bos != null)
                    bos.close();
                if (fos != null)
                    fos.close();
            }
        } catch (IOException e) {
            //打印捕获的异常,抛出自定义异常,统一异常拦截器进行打印自定义异常
            //除了前两个异常信息,第三个参数 e 也会把异常堆栈信息打印出来
            throw new SystemException("USR004", "用户注册失败: 头像上传出错",e);
        }
    }
}
