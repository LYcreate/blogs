package link.lycreate.blog.utils;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * @ClassName MD5Encode
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/4 15:39
 */
public class MD5Encode {
    public static String encode(String str) {
        String targetStr = new String();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            targetStr = Base64.getEncoder().encodeToString(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetStr;
    }
}
