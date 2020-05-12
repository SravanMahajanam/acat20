import java.util.HashMap;

public class ReverseWords {
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return null;
        }
        HashMap special = new HashMap();
        int symbolLoc = 1;
        for (int i = 0; i < sentence.length(); ++i) {
            if (!((sentence.charAt(i) >= 65 && sentence.charAt(i) <= 90) || (sentence.charAt(i) >= 97 && sentence.charAt(i) <= 122))) {
                special.put(symbolLoc, sentence.charAt(i));
                ++symbolLoc;
            }
        }
        symbolLoc = 1;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        for (int i = sentence.length() - 1; i >= 0; --i) {
            if ((sentence.charAt(i) >= 65 && sentence.charAt(i) <= 90) || ((sentence.charAt(i) >= 97 && sentence.charAt(i) <= 122))) {
                temp.append(sentence.charAt(i));
            } else {
                if (temp.length() > 0) {
                    stringBuffer.append(temp.reverse());
                    temp = new StringBuffer();
                }
                stringBuffer.append(special.get(symbolLoc));
                ++symbolLoc;
            }
        }
        if (temp.length() > 0) {
            stringBuffer.append(temp.reverse());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println("This&is@a#sentence$this%is^a&second".equals(reverseWords(reverseWords("This&is@a#sentence$this%is^a&second"))));
    }
}
