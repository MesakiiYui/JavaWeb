package functest.string;

public class StringSplit {
    public static void main(String[] args) {
        String str = ",243141,243157,120409,350118,643126,120376,120346,120402,149104,245651,263111,120344,292129,120413,120402,486611,264129,136002,350108,101668107,120404,120405,120345,120351,120411,120360,292111,120402,140103,243108,120358,120407,316611,263110,120394,120344,120345,139602,120351,589110,120343,304109,178626,120395,186106,120370,251107,120387,373651,281108,120406,292123,266108,120385,292131,120410,120362,120408,120403,120355,149614,373671,590610,";
        String[] strArr = str.split(",");
        for(String i : strArr) {
            System.out.println(i);
        }
    }
}