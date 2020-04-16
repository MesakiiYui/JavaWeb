package functest.String;

public class GetLastChar {
    public static void main(String[] args){
        String caseNo = "C310100VEH2000002J";
        String lastCharCaseNo = caseNo.substring(caseNo.length() - 1);
        if("J".equals(lastCharCaseNo)){
            System.out.println("get");
        }
    }
}
