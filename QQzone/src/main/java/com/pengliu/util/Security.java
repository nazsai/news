package com.pengliu.util;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * 安全类
 *    QQ空间的M5D加密
 * 
 * @name        类名
 * @version     1.0
 * @since       1.0
 *
 */
public class Security {
	
public static final String HEXSTRING = "0123456789ABCDEF";

    public static String md5(String originalText) throws Exception {
        byte buf[] = originalText.getBytes("ISO-8859-1");
        StringBuffer hexString = new StringBuffer();
        String result = "";
        String digit = "";

        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(buf);

            byte[] digest = algorithm.digest();

            for (int i = 0; i < digest.length; i++) {
                digit = Integer.toHexString(0xFF & digest[i]);

                if (digit.length() == 1) {
                    digit = "0" + digit;
                }

                hexString.append(digit);
            }

            result = hexString.toString();
        } catch (Exception ex) {
            result = "";
        }

        return result.toUpperCase();
    }

    public static String hexchar2bin(String md5str) throws UnsupportedEncodingException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(md5str.length() / 2);

        for (int i = 0; i < md5str.length(); i = i + 2)
        {
            baos.write((HEXSTRING.indexOf(md5str.charAt(i)) << 4 |
                    HEXSTRING.indexOf(md5str.charAt(i + 1))));
        }

        return new String(baos.toByteArray(), "ISO-8859-1");
    }

    /**
     * 
     * 获取QQ空间加密 密码
     *
     * @param qq http://check.ptlogin2.qq.com/check?uin={0}&appid=15000101&r={1} 该请求的js返回的第三个参数
     * @param password   QQ密码
     * @param verifycode 验证码
     * @return 加密后的密码
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static String GetPassword(String qq,String password, String verifycode){
    	String V = "";
    	try{
    		//  hexchar2bin(md5(t))
	        String P = hexchar2bin(md5(password));
	        //md5(r + e)
	        String R = md5(P + hexchar2bin(qq.replace("\\x", "").toUpperCase()));
	        //rsa_encrypt(r)
	        String s="";
	        //p = (s.length / 2).toString(16)
	        
	        
	        //l = TEA.strToBytes(i.toUpperCase(), !0)
	        
//	        V = md5(U + verifycode.toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
			return "加密时不小心就失败了，请求管理员修复啊";
		}
        return V;
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
    	String str = GetG_TK("CyWdWNORLh6n8qUPM9zcWErXBq4EdRnodt1sWlINbEU_");
    	System.out.println(str);
	}

    /**
     * QQ空间每次发送请求的密码字符
     * 获取G_TK
     * 
     * @param str QQ登录后Cookie中的skey   example @kkfsfafas
     * @return    G_TK字符串
     */
    public static String GetG_TK(String str){
    	   int hash = 5381;
    	   for(int i = 0, len = str.length(); i < len; ++i){
    		   hash += (hash << 5) + str.charAt(i);
    	   }
    	   return (hash & 0x7fffffff)+"";
    }
    
}