package assignments;

import java.util.HashMap;

public class BadVersion {
    int a;
    String string;
    BadVersion(int a, String string) {
        this.a = a;
        this.string = string;
    }
    public static int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        int m = l + (r - l) / 2;

        HashMap map = new HashMap();
        BadVersion b1 = new BadVersion(1, "s");
        map.put(b1, 1);
        BadVersion b2 = new BadVersion(2, "d");
//        b1 = b2;
        System.out.println(map.get(b1));
        return 0;
//        while (r - l > 1) {
//            if (isBadVersion(m)) {
//                r = m;
//            } else {
//                l = m;
//            }
//            m = l + (r - l) / 2;
//        }
//        return isBadVersion(l) ? l : r;
    }

    public static void main(String[] args) {
        firstBadVersion(2);
    }
}
