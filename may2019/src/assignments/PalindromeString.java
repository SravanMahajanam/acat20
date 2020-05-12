package assignments;

import java.util.HashSet;

public class PalindromeString {

    public static boolean isPalindromePossible(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] sChar = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        for (int i =0; i<sChar.length;++i) {
            if (set.contains(sChar[i])) {
                set.remove(sChar[i]);
                continue;
            }
            set.add(sChar[i]);
        }
        boolean even = s.length()% 2 == 0;
        if (even) {
            return set.size() == 0;
        } else {
            return set.size() == 1;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isPalindromePossible("cdbkxqnqtsqtqcuskbhwhcxjguhunaqytfgzfpxmimxpnubdrhnopplimtgascleyvpegdacvnpsnaaphktvoqodsnpjxmmdryjitrpveyqbjynhhgekukhbzknprpmxrhzxvgyucenmurehmkjyhtrhpuvloingdcsgvngfeanubjcctupmmtikihwxdmfedzlqnjeujfqfphjuwqgnygnkzvhvhppelztlwmvuisfcnbjudqdmxaaoydggaowltyrmlntecmkfpdencllzgvbmfnndsfmuhvgzqamiggxpcvltwijtodzyuuntzczfzgjrwpbqqxccgyajvtjfapkllgrsibyhlysjagbkigwkvlllvkohfisxrkilhblwybqrbdhadxowhedqcmuqldaehtrzywnhvzuurvcumqnbtkygcpvfxkseahownqdhoblktpyvmuvvajieuakfhurmdvivxzcabvnczinlkwizwsuuugyhlrcecjxorieikhwuxvuyvoktgxtsovnphkmhaalmdjtlpmsizogkeaypvwuxfewbuxpgjjcuzpkmitbbbzjbwjhjybzandgxynjfkihvjnjnigakjyaavgvtutuvoqamiiexmmkqvfjtkifvnziprmubtwwozpktbjqfiygwhssefppplgblrtvlsrihkawfcuvkbyzxmqeihoualjizvfrhscsbabdnwqsnuzettueqlweeacpgywdhvefoggdpwnzselbbihqlbdljknbniwgiclxburspmbuvxxzhwoivsbizjztywmvarqdysgpfqhmmenjcqznoigunpdvzhhmkfqxfsngbcpdppgvihelawdftqtaynhoidkugjfwfeunonihhtjuohwhxnwzihnwloxzehprqsmymwamaxvtqtwhihireyrtleijeaprcwydecqkmkfkdnqgevtiucfbjldjfltfhrkfkvrnktuuzqvjqmjlu"));
        System.out.println((System.currentTimeMillis() - start) * 1000);
    }
}
