package assignments;

public class MysteryLength {
    public static void removeLength(String string) {
        int i = 1;
        while (i < string.length()) { // a dummy condition, just wanted to loop till we find the result as there is no case for not having result
            int currentLength = Integer.parseInt(string.substring(string.length() - i));
            if (string.substring(0, string.length() - i).length() == currentLength) {
                System.out.println(string.substring(0, string.length() - i));
                System.out.println(i);
                return;
            }
            ++i;
        }
    }

    public static void main(String[] args) {
        removeLength("JamesBond000712");
    }
}
