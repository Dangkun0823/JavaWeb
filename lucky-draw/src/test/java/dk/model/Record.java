package dk.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import dk.base.BaseEntity;

/**
 * 学生表
 */
@Getter
@Setter
@ToString
public class Record extends BaseEntity {
    
    private Integer id;

    private Integer memberId;

    private Integer awardId;

    /**
     * 创建时间
     */
    private Date createTime;
}