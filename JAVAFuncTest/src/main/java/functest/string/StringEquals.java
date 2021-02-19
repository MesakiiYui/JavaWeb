package functest.string;


public class StringEquals {


    public static void main(String[] args){
        //     "isForbidCounts": "",
        String a = "马睿                                                                                                                    ##@@马睿                                                                                                                    ##@@130203197709270915";
        String damageName = "马睿";
        String insurantName = "马睿";
        String insurantIdcardNumber = "130203197709270915";
        String[] aList = a.split("##@@");
        Boolean res1 = aList[0].equals(damageName);
        Boolean res2 = aList[1].equals(insurantName);
        Boolean res3 = aList[2].equals(insurantIdcardNumber);
        System.out.println(res1.toString()+res2.toString()+res3.toString());
    }
}