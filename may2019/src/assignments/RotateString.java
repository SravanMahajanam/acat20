package assignments;

import java.util.Arrays;

public class RotateString {
    public static String rotateNaive(char[] str, int offset) {
        if (str.length == 0) {
            return "";
        }
        while (offset > 0) {
            char lastChar = str[str.length - 1];
            for (int i = str.length - 1; i > 0; --i) {
                str[i] = str[i - 1];
            }
            str[0] = lastChar;
            offset--;
        }
        return str.toString();
    }

    public static String rotateInline(char[] str, int offset) {
        if(str.length == 0)
            return "";
        offset = offset%str.length;
        if (offset == 0)
            str.toString();
        char[] newArray = Arrays.copyOf(str, str.length);
        for (int i = 0; i < offset; ++i) {
            str[i] = newArray[str.length - offset + i];
        }
        for (int i = offset; i<str.length;++i) {
            str[i] = newArray[i - offset];
        }
        return new String(str);
    }

    public static void rotateString(String string, int offset) {
        offset = offset % string.length();
        int length = string.length();
        string = string.substring(length - offset) + string.substring(0, length - offset);
        System.out.println(string);
    }

    public static void main(String[] args) {
        char[] in = "cppjavapy".toCharArray();
        rotateString("cppjavapy", 2);
    }
}