import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConvertCrypto {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String[] string = new String[100];
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int i=0;
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.equals("done")) {
                break;
            }
            System.out.println(s);
            if(s!=null)
                string[i++] = s;
            else
                break;
        }
        int count = 0;
        int offset = 0;
        for(int j=0;j<string.length;j++) {
            int starCount = 0;
            String s = string[j];
            if(s != null && s.isEmpty()) {
                offset = 0;
                //starCount=0;
                System.out.println();
            }
            else if (s != null){
                char[] stringCount = s.toCharArray();
                for(char c : stringCount) {
                    if(c == '*') {
                        starCount++;
                    }
                }
                String finalString = generateString(s,starCount,offset);
                System.out.println(finalString);
                //offset++;
                offset = offset+starCount;
            }
        }
    }
    public static String generateString(String s, int startCount,int offset) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<(s.length() - startCount-offset);i++) {
            sb.append(".");
        }
        for(int i=0;i<(startCount);i++) {
            sb.append("*");
        }
        for(int i=0;i<(offset);i++) {
            sb.append(".");
        }
        return sb.toString();
    }
}