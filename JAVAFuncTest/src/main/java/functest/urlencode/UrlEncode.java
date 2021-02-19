package functest.urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncode {
    public static void main(String[] args) {
//        前端得到： %25E6%2596%25B9%2520%25E5%25BC%258F
//        后端得到： %E6%96%B9%20%E5%BC%8F
//        string a = "%25E6%2596%25B9%2520%25E5%25BC%258F";
//        string b = "%E6%96%B9%20%E5%BC%8F";
//        System.out.println("\n 采用utf-8字符集:");
//        string urlStr = URLEncoder.encode(b);
//        System.out.println(urlStr.equals(a) );
//        System.out.println("\n 采用GBK字符集:");
//        string urlStr2 = URLEncoder.encode("天津大学", "GBK");
//        System.out.println(urlStr2);
//        string keyWord = URLDecoder.decode("%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6+Rico", "UTF-8");
//        System.out.println(keyWord);
//        System.out.println("\n 采用GBK字符集进行解码:");
//        System.out.println(URLDecoder.decode("%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6+Rico", "GBK"));

        // URLEncoder.encode(a);
        // 前端 %25E6%259D%258E%2520%25E6%2599%2593%25E4%25BD%25B3
        // 后端 %E6%9D%8E%20%E6%99%93%E4%BD%B3 -- 李晓佳  --  %C0%EE+%CF%FE%BC%D1
        // string ss1 =URLEncoder.encode(URLEncoder.encode("方式 ","UTF-8"));  后端的加码
        String a = "%E6%9D%8E%20%E6%99%93%E4%BD%B3";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        try {
            b =URLDecoder.decode(a , "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            System.out.println(e1.getMessage());
        }
        try {
            c =URLEncoder.encode(b , "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            System.out.println(e2.getMessage()); // %C0%EE+%CF%FE%BC%D1
        }
        try {
            d =URLDecoder.decode(c , "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            System.out.println(e3.getMessage()); // %C0%EE+%CF%FE%BC%D1
        }
        try {
            e =URLEncoder.encode(a , "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            System.out.println(e4.getMessage()); // %C0%EE+%CF%FE%BC%D1
        }

        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("d:" + d);
        System.out.println("e:" + e);  // 目标： %25E6%259D%258E%2520%25E6%2599%2593%25E4%25BD%25B3
                                    //           %25E6%259D%258E%2520%25E6%2599%2593%25E4%25BD%25B3


    }
}
