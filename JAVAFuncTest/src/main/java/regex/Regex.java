package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jintienan on 2020/1/6.
 */
public class Regex {
    private static String stringParser(String target) {
        if(target.length() < 1) {
            return null;
        }
        Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");
        Matcher matcher = pattern.matcher(target);
        String ans = "";
        while(matcher.find()){
            ans += matcher.group();
        }
        return ans;
    }

    private static boolean isContained(String pattern, String contents) {

        return Pattern.matches(pattern, contents);
    }

    public static void main(String[] args) {
        // 过滤括号内的字符
        String content = "src: local('Open Sans Light'), local('OpenSans-Light'), url(http://fonts.gstatic.com/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTa-j2U0lmluP9RWlSytm3ho.woff2) format('woff2')";
        String ans = stringParser(content);
        System.out.println(ans);

        // 是否包含某个字符
        String pattern = ".*noob.*";
        String contents = "i am a noob!";
        boolean flg = isContained(pattern, contents);
        System.out.println(String.valueOf(flg));

    }

}
