package functest.NotNullCheck;

public class CompanyNullCheck {
    private void objectNulCheck(){
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
    private void nullSetCheck(){
        CompanyVo companyVo = new CompanyVo();
        // companyVo.setComany(null);
        System.out.println(companyVo.getComany());
    }

    public static void main(String[] args){
        CompanyNullCheck companyNullCheck = new CompanyNullCheck();
        companyNullCheck.nullSetCheck();
    }
}
