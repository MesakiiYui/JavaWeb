package functest.notNullCheck;

public class CompanyNullCheck {
    public static void main(String[] args){
        CompanyVo companyVo = new CompanyVo();
        Company company = new Company();
        company.setCompanyId(1L);
//        company.setName("aLi");
        companyVo.setComany(company);
        if(null == companyVo.getComany()){
            System.out.println("null");
        }
        if(null != companyVo.getComany()
                && null != companyVo.getComany().getName()){
            System.out.println("not null");
        }
    }
}
