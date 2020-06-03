package functest.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneVarify {
    public static boolean phoneNumVerify(String phoneNum){
        //由于话务有时会带入加0开头的12位手机号码,删除开头的0  判断后面的11位是否满足手机号码校验--2015-7-29
        if(phoneNum.length() > 11 && phoneNum.startsWith("0")){
            phoneNum = phoneNum.substring(1);
        }
        Pattern p =Pattern.compile("^1\\d{10}$");
        Matcher m = p.matcher(phoneNum);
        boolean flag = m.matches();
        if(!flag){
            System.out.println("手机号码[" + phoneNum + "]不符合手机号码校验规范!");
        }
        return flag;
    }

    public static void main(String[] args){
        String num = "13814204281 ";
        num = num.trim();
        boolean ans  = phoneNumVerify(num);
        System.out.println("结果是"+ ans);
    }
}
