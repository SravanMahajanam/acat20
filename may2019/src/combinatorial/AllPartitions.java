package combinatorial;

public class AllPartitions {
    public static void printPartitions(String in) {
        auxPrintPartitions(in, "");
    }

    private static void auxPrintPartitions(String in, String subset) {
        if (in.length()==0) {
            System.out.println(subset.substring(1));
            return;
        }
        for (int i = 0;i<in.length();++i) {
            auxPrintPartitions(in.substring(i+1), subset+"+"+in.substring(0, i+1) );
        }
    }

    public static void main(String[] args) {
        printPartitions("abc");
    }
}
