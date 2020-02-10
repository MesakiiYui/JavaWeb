package functest.String;

public class BufferAndBuiler {
    protected String strOri = "";
    private static void StringBufferImpl() {
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        sb.append("xx");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.delete(0,1);
        System.out.println(sb);

        StringBuffer sb2 = new StringBuffer();
        sb.append(sb2);
        sb2 = sb;

    }

    private static void StringBuilderImpl() {
        StringBuilder sb = new StringBuilder();

    }
    public void strOriChange() {
        strOri+= "+strOriChange";
    }
    public void strOriChange2() {
        strOri+= "+strOriChange2";
    }

    public static void main(String[] args) {
        //StringBufferImpl();
        BufferAndBuiler bb = new BufferAndBuiler();
        bb.strOriChange();
        bb.strOriChange2();
        System.out.println(bb.strOri);
    }
}
