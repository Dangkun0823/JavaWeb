package base;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class D {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip=InetAddress.getLocalHost();
        System.out.println(ip);
        System.out.println(ip.getHostName());
        System.out.println(ip.getAddress());
    }
}
