package functest.breakDoubleLoop;

public class BreakDoubleLoop {

    public static void main(String[] args) {
        outLoop:for(int i = 0; i < 14; i += 1) {
            innerLoop:for(int j = 0; j < 5; j += 1){
            System.out.println(i + " + " + j);
            if(i + j == 13){
                break outLoop;
            }
            }
        }
    }
}
