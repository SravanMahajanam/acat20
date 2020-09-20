import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class NumConverter {
    public static String numToXlColConverter(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        while (n > 26){
            int q = n / 26;
            n = n - (q * 26);
            stringBuffer.append((char) (q - 1 + 'A'));
        }
        stringBuffer.append((char) (n - 1 + 'A'));
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(numToXlColConverter(527));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse("");
        } catch (Exception e) {

        }

    }
}


