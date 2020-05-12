package assignments;

public class AttendanceRecord {
    public static boolean checkRecord(String s) {
        char[] record = s.toCharArray();
        int abCount = 0;
        int lCount = 0;
        for (int i=0; i<record.length;++i) {
            if(record[i] == 'A') {
                abCount++;
                if (abCount == 2)
                    return false;
                lCount = 0;
            } else if(record[i] == 'L') {
                lCount++;
                if (lCount == 3)
                    return false;
            } else
                lCount = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        String rec = "PPALLLP";
        System.out.println(checkRecord(rec));
    }
}
