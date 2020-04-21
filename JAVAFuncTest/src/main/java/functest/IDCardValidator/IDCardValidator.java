package functest.IDCardValidator;

public class IDCardValidator {
    public String getBirthDay(String custNo) {
        String birthdayTemp = "";
        if(custNo == null || custNo.length()<1){
            return null;
        } else if(custNo.length() == 18) {
            birthdayTemp = custNo.substring(6, 14);
        } else if(custNo.length() == 15) {
            birthdayTemp = "19" + custNo.substring(6,12);
        } else {
            return null;
        }
        String birthday = birthdayTemp.substring(0,4)+"-"+birthdayTemp.substring(4,6)+"-"+birthdayTemp.substring(6,8);
        return birthday;

    }

    public static void main(String[] args){
        String str1 = "330183199312223232";
        String str2 = "130503670401001";
        IDCardValidator validator = new IDCardValidator();
        String birthday = validator.getBirthDay(str1);
        String birthday2 = validator.getBirthDay(str2);
        System.out.println("birthday:"+birthday);
        System.out.println("birthday2:"+birthday2);


    }


}

