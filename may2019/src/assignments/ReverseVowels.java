package assignments;

public class ReverseVowels {

    public static String reverseVowels(String string) {
        StringBuffer input = new StringBuffer(string);
        int leftPointer = 0;
        int rightPointer = input.length() - 1;
        while (leftPointer < rightPointer) {
            if (isVowel(input.charAt(leftPointer)) && isVowel(input.charAt(rightPointer))) {
                char temp = input.charAt(leftPointer);
                input.setCharAt(leftPointer, input.charAt(rightPointer));
                input.setCharAt(rightPointer, temp);
                leftPointer++;
                rightPointer--;
            } else {
                if (!isVowel(input.charAt(leftPointer))) {
                    leftPointer++;
                }
                if (!isVowel(input.charAt(rightPointer))) {
                    rightPointer--;
                }
            }
        }
        return input.toString();
    }

    private static boolean isVowel(char c) {
        switch (c){
            case 'A': case 'E': case 'I': case 'O': case 'U': case 'a': case 'e': case 'i': case 'o': case 'u':
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("Helo"));
    }
}
