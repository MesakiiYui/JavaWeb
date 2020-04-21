package runoob;

public class VariableTypes {
    private void pupAge(){
        int age = 0;
        age = age + 7;
        System.out.println("小狗的年龄是: " + age);
    }


    // 这个实例变量对子类可见
    private String name;
    // 私有变量，仅在该类可见
    private double salary;
    //在构造器中对name赋值
    private VariableTypes (String empName){
        name = empName;
    }
    //设定salary的值
    private void setSalary(double empSal){
        salary = empSal;
    }
    // 打印信息
    private void printEmp(){
        System.out.println("名字 : " + name );
        System.out.println("薪水 : " + salary);
    }


    //salary是静态的私有变量
    private static double salaryStatic;
    // DEPARTMENT是一个常量
    private static final String DEPARTMENT = "开发人员";

    public static void main(String[] args){
        VariableTypes variableTypes = new VariableTypes("dingding");
        variableTypes.pupAge();


        VariableTypes empOne = new VariableTypes("RUNOOB");
        empOne.setSalary(1000);
        empOne.printEmp();


        salaryStatic = 10000;
        System.out.println(DEPARTMENT+"平均工资:"+salaryStatic);
    }
}
