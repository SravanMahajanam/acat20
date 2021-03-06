import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class OrgRolesCorrector {
    public static void main(String args[]) throws IOException {

        // <query-items item-descriptor="organization" id-only="true">relativeRoles is null</query-items>

        String[] orgs = new String[] {"005261000", "059690000", "063963J00", "087573W00", "000081619", "087574800", "000081618", "038370000", "000081615", "000081614", "000081617", "000081616", "021970000", "000081622", "000081621", "000081624", "000081623", "083142700", "000081620", "087573G00", "0894J1100", "000040071", "058020000", "066500000", "001310000", "041820700", "093330100", "087573600", "000081626", "000081625", "000081628", "000081627", "000081633", "000081512", "000081632", "000081635", "0850H0000", "056390000", "0258J0100", "000081631", "000081630", "055510000", "050120000", "0767E4200", "000069997", "039730000", "022115000", "064170000", "008200900", "087573V00", "087574700", "018420000", "063960400", "095820000", "000081600", "073758100", "024250000", "000081602", "000081601", "083142600", "046460000", "0894J1000", "087573F00", "077061600", "000069867", "057590000", "087110200", "000069982", "018650100", "064400000", "000081607", "087575800", "000081604", "000081603", "000081606", "000081605", "000081611", "000081610", "000081613", "000081612", "0767E4100", "006940000", "0894J2000", "000046410", "001710000", "063967R00", "087573U00", "087574600", "000081539", "000081545", "000057436", "000081544", "000081547", "000081546", "000081541", "063960700", "058196700", "000081543", "000081542", "002040100", "036330400", "090440100", "087573E00", "091070100", "060760000", "055500000", "057980000", "000081549", "082490000", "000081548", "087575700", "090500100", "000081555", "073752J00", "000081558", "058193300", "000081552", "000081551", "020460000", "000081554", "000081553", "0767E4400", "000081550", "090900000", "040510000", "000069436", "003380000", "000081637", "000081636", "000081639", "087573T00", "087574500", "000081638", "000081643", "000081522", "083142800", "000081646", "000081645", "000081642", "088140000", "000081641", "0696A0100", "043800000", "087573D00", "000047415", "051000000", "000047411", "006620000", "087575600", "083550000", "000081526", "022810800", "000081649", "0474A0000", "000081655", "0850H0100", "000081534", "0842E0000", "000081654", "000081533", "000081657", "000081535", "000081656", "000081651", "000081650", "032550000", "000081532", "000081653", "000081652", "002890400", "0767E4300", "008380300", "052370000", "0839J0000", "0767E2000", "000039247", "0919E0100", "000065531", "057790500", "022818300", "083142300", "023850000", "044030000", "087573K00", "075031700", "000039249", "057820000", "0767E5000", "000055977", "090840200", "000039254", "000039252", "077592000", "0842A0000", "000040126", "000039250", "009110000", "028090000", "000075473", "069490000", "000041466", "087573Z00", "000041460", "0997F0200", "044281700", "083142200", "012730200", "090560100", "098590000", "035840200", "006521200", "087573J00", "012830000", "058196800", "024770000", "097302400", "091850000", "073752400", "000054427", "0702H0000", "039670000", "073751300", "0767E1900", "093640000", "000065428", "087573900", "037850100", "0926E0100", "076490000", "000074482", "077530900", "081400000", "001960000", "078860000", "000041122", "0997F0100", "087573Y00", "000008379", "083140200", "058194800", "083142500", "005260000", "087573800", "032290200", "073751D00", "0997F0000", "000008382", "000008381", "0874F0000", "000008380", "0767E4000", "094790200", "005261100", "020610000", "000044414", "000044412", "069560000", "000044410", "064260000", "083140100", "087573X00", "003030000", "012100100", "0672J0000", "015270100", "070750100", "083142400", "0481J0000", "090700000", "087573H00", "0767E5100", "073752600", "000041034", "006880400", "090840300", "087573700", "043380000", "0424F0000", "007540000", "010940400", "008200000", "067900000", "083146500", "001340100", "0894J1900", "087310000", "087574000", "038960000", "089460300", "066850000", "031720000", "000069047", "083149900", "096510100", "0009H0100", "000040527", "0956A0100", "000040528", "039930000", "033810100", "000040522", "037750100", "0894J0800", "069490400", "000039416", "000050435", "010940100", "043520000", "000063653", "089470000", "057790200", "001340000", "063010000", "069520100", "002230000", "0211J0000", "089460200", "003280000", "087573N00", "0894J1800", "005360300", "0009H0000", "000051430", "000047162", "028950000", "078260000", "083149800", "005260500", "096510200", "008201300", "0894J0700", "069490300", "022114700", "058970400", "084170100", "0919A0000", "0638F0000", "063010100", "039780000", "0894J1700", "087573M00", "073751P00", "0596E0000", "0815E0100", "000040322", "005260400", "0767E1800", "097100000", "008740000", "0894J0600", "001270000", "058192J00", "000040331", "052480000", "091670000", "000041425", "0684E0000", "0894J1600", "084940000", "087573L00", "097300300", "029590200", "019970000", "053050000", "058191X00", "0894J0500", "072850000", "093130100", "022810000", "063730000", "096740100", "089770000", "017740000", "0767E4700", "000830000", "022816800", "010370100", "087574400", "0911J0100", "073590000", "000081589", "000081588", "000081585", "0894J1500", "000081584", "000081587", "044820000", "000081586", "000081581", "000081580", "000081583", "000081582", "000080494", "087573C00", "091460000", "083149500", "041600000", "087575500", "000040918", "080040000", "0894J0400", "000081596", "000081595", "063650000", "000081598", "000081597", "000081592", "000081591", "0767E4600", "000081594", "000081593", "0228J0100", "000081590", "0830E0000", "0653J0100", "000081559", "063966100", "087574300", "087573R00", "000081567", "000081566", "000081569", "000081568", "000082531", "000081563", "0894J1400", "000081564", "013360000", "073756200", "091890100", "000081561", "000081560", "058198300", "083149400", "093470000", "058440000", "000082538", "077530100", "058870000", "000083515", "000083516", "0435F0000", "000081579", "000081573", "084540000", "000081576", "000081570", "001400000", "005260Z00", "000081572", "000081571", "0767E4500", "087574C00", "087574B00", "067220000", "0767E4900", "030310000", "000040834", "080740000", "061710000", "008200200", "087574200", "087573Q00", "088530200", "029250000", "046060200", "087320000", "083149700", "048130000", "077530000", "057980400", "0435F0100", "031880100", "062850000", "053900000", "058192N00", "093610000", "097300700", "087574A00", "0767E4800", "065220000", "033100000", "061580000", "000040610", "083890000", "089460400", "087574100", "096980000", "090310100", "000050420", "0894J1200", "092050000", "000050423", "000050421", "068230000", "008710100", "000050426", "083149600", "015720000", "000990000", "000039871", "000039872", "014590000", "004790000", "097060100", "0258J0200", "000039875", "000081494", "092540000", "000050416"};

        int sizeOfNewArray = 100;
        int roleIdStart = 300050;

        int quotient = orgs.length / sizeOfNewArray;
        boolean isRemainder = orgs.length % sizeOfNewArray == 0;
        if(!isRemainder){
            quotient ++;
        }
        int startPoint = 0;
        for (int i = 0 ; i < quotient ; i ++ ) {
            int arrayLength = ((startPoint + sizeOfNewArray) > orgs.length) ? orgs.length : (startPoint + sizeOfNewArray) ;
            String[] smallerArray = Arrays.copyOfRange(orgs, startPoint, arrayLength);
            String fileName = "D:\\RQLScript"+i+".txt";
            roleIdStart = generateScript(fileName,smallerArray ,roleIdStart,sizeOfNewArray);
            startPoint = startPoint + sizeOfNewArray ;
        }

    }

    public static int generateScript(String fileName, String[] orgs, int roleIdStart, int batchSize)throws IOException{

        String s= "<add-item item-descriptor=\"organizationalRole\" id=\"_rId1_\">\n"+
                "  <set-property name=\"accessRights\"><![CDATA[updateAccountAddress,createAccountAddress]]></set-property>\n"+
                "  <set-property name=\"function\"><![CDATA[admin]]></set-property>\n"+
                "  <set-property name=\"relativeTo\"><![CDATA[_Org1_]]></set-property>\n"+
                "  <set-property name=\"type\"><![CDATA[organizationalRole]]></set-property>\n"+
                "  <set-property name=\"name\"><![CDATA[Administrator]]></set-property>\n"+
                "</add-item>\n"+


                "<add-item item-descriptor=\"organizationalRole\" id=\"_rId2_\">\n"+
                "  <set-property name=\"function\"><![CDATA[buyer]]></set-property>\n"+
                "  <set-property name=\"relativeTo\"><![CDATA[_Org1_]]></set-property>\n"+
                "  <set-property name=\"type\"><![CDATA[organizationalRole]]></set-property>\n"+
                "  <set-property name=\"name\"><![CDATA[Buyer]]></set-property>\n"+
                "</add-item>\n"+


                "<add-item item-descriptor=\"organizationalRole\" id=\"_rId3_\">\n"+
                "  <set-property name=\"function\"><![CDATA[approver]]></set-property>\n"+
                "  <set-property name=\"relativeTo\"><![CDATA[_Org1_]]></set-property>\n"+
                "  <set-property name=\"type\"><![CDATA[organizationalRole]]></set-property>\n"+
                "  <set-property name=\"name\"><![CDATA[Approver]]></set-property>\n"+
                "</add-item>\n"+


                "<add-item item-descriptor=\"organizationalRole\" id=\"_rId4_\">\n"+
                "  <set-property name=\"accessRights\"><![CDATA[updateAccountAddress,createAccountAddress]]></set-property>\n"+
                "  <set-property name=\"function\"><![CDATA[accountAddressManager]]></set-property>\n"+
                "  <set-property name=\"relativeTo\"><![CDATA[_Org1_]]></set-property>\n"+
                "  <set-property name=\"type\"><![CDATA[organizationalRole]]></set-property>\n"+
                "  <set-property name=\"name\"><![CDATA[Account Address Manager]]></set-property>\n"+
                "</add-item>\n"+


                "<add-item item-descriptor=\"organizationalRole\" id=\"_rId5_\">\n"+
                "  <set-property name=\"accessRights\"><![CDATA[manageProfileAddress]]></set-property>\n"+
                "  <set-property name=\"function\"><![CDATA[profileAddressManager]]></set-property>\n"+
                "  <set-property name=\"relativeTo\"><![CDATA[_Org1_]]></set-property>\n"+
                "  <set-property name=\"type\"><![CDATA[organizationalRole]]></set-property>\n"+
                "  <set-property name=\"name\"><![CDATA[Profile Address Manager]]></set-property>\n"+
                "  </add-item>\n"+

                "<update-item item-descriptor=\"organization\" id=\"_Org1_\">\n"+
                "  <set-property name=\"relativeRoles\"><![CDATA[_rId1_,_rId2_,_rId3_,_rId4_,_rId5_]]></set-property>\n"+
                "</update-item>";


        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        for (int i=0; i< orgs.length;i++){
            String orgItem= "<print-item item-descriptor=\"organization\" id=\""+ orgs[i] +"\"/>\n";
            writer.append(orgItem);
        }
        String orgseparator= "===================================================================================== \n";
        writer.append(orgseparator);
        int printItemId = roleIdStart;

        for (int i=0; i< batchSize*5;i++){
            String printItem= "<print-item item-descriptor=\"organizationalRole\" id=\""+ printItemId +"\"/>\n";
            writer.append(printItem);
            printItemId = printItemId + 1;
        }
        String separator= "===================================================================================== \n";
        writer.append(separator);
        for (int i=0; i< orgs.length;i++){
            writer.append(' ');
            String temp = s.replaceAll("_Org1_", orgs[i]);
            temp = temp.replaceAll("_rId1_", String.valueOf(roleIdStart));
            temp = temp.replaceAll("_rId2_", String.valueOf(roleIdStart+1));
            temp = temp.replaceAll("_rId3_", String.valueOf(roleIdStart+2));
            temp = temp.replaceAll("_rId4_", String.valueOf(roleIdStart+3));
            String transformedString = temp.replaceAll("_rId5_", String.valueOf(roleIdStart+4));
            roleIdStart = roleIdStart+5;
            writer.append(transformedString);
            writer.append("\n");
        }
        writer.close();
        return roleIdStart;
    }
}