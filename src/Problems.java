import java.util.*;

public class Problems {
    public static void main(String[] args) {
        String s = "aaaabbbbbccc";
        System.out.println(countOfChar(s));

        int[] index = {0, 0};
        String position = "DOWN UP 2xRIGHT DOWN 13xLEFT";
        System.out.println(Arrays.toString(findDistance(position, index)));

        String[] arr = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSSaaaa"};
        String s1 = "ODG";
        System.out.println(returnLongString(arr, s1));

        String[] arr1 = {"apple", "applet", "bread", "aper"};
        String prefix = "app";
        System.out.println(printPrefix(arr1, prefix));

        String str1 = "12345";
        System.out.println(returnFirstNonRepeat(str1));

        String senetense = "the quick the brown quick brown the frog";
        String word1 = "quick";
        String word2 = "frog";
        System.out.println(measureDistance(senetense, word1, word2));

        String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab"};
        String input = "abcd";
        System.out.println(strinContainsCHars(dict, input));


        String number = "-123";
        System.out.println(converToNumber(number));

        int[] a = {1,2,3,4,5};
        int[] b = {1,9,10,11,12,13,14,15,16,17,18};
        System.out.println(findMedian(a,b));

        int[] bishopPos = {0, 0};
        int[] immovablePos = {1, 2};

        System.out.println( canReachBishop(bishopPos, immovablePos));
    }


    private static String countOfChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> hm : map.entrySet()) {
            sb.append(hm.getKey()).append(hm.getValue());
        }
        return sb.toString();
    }

    private static int[] findDistance(String position, int[] index) {
        int x = index[0];
        int y = index[1];

        if (position.contains(" "))
            position = fixPosition(position);
        position = position.toUpperCase();
        for (int i = 0; i < position.length(); i++) {
            if (position.charAt(i) == 'L') {
                x--;
            } else if (position.charAt(i) == 'R') {
                x++;
            } else if (position.charAt(i) == 'U') {
                y++;
            } else if (position.charAt(i) == 'D') {
                y--;
            }
        }
        return new int[]{x, y};
    }

    private static String fixPosition(String position) {
        String[] s = position.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            int count = 0;
            if (s[i].contains("x")) {
                String cnt = s[i].substring(0, s[i].indexOf("x"));
                count = Integer.parseInt(cnt);
            }
            StringBuilder dir = new StringBuilder("");
            if (s[i].toUpperCase().contains("UP")) {
                dir.append("U");
            } else if (s[i].toUpperCase().contains("DOWN")) {
                dir.append("D");
            } else if (s[i].toUpperCase().contains("LEFT")) {
                dir.append("L");
            } else if (s[i].toUpperCase().contains("RIGHT")) {
                dir.append("R");
            }
            if (count == 0)
                sb.append(dir);
            while (count > 0) {
                sb.append(dir);
                count--;
            }

        }

        return sb.toString();
    }

    private static int returnLongString(String[] arr, String s1) {
        if (arr.length == 0 || s1.isEmpty()) {
            return -1;
        }
        int maxLen = -1;
        for (int i = 0; i < arr.length; i++) {
            boolean contains = false;
            for (int j = 0; j < arr[i].length(); j++) {
                if (s1.charAt(0) == (arr[i].charAt(j))) {
                    contains = true;
                    for (int k = 1; k < s1.length(); k++) {
                        if (s1.charAt(k) != (arr[i].charAt(j + k))) {
                            contains = false;
                            break;
                        }
                    }
                }
            }
            if (contains) {
                if (maxLen < arr[i].length())
                    maxLen = arr[i].length();
            }
        }
        return maxLen;
    }

    private static List<String> printPrefix(String[] arr1, String prefix) {
        List<String> li = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            boolean contains = false;
            if (prefix.charAt(0) == arr1[i].charAt(0)) {
                contains = true;
                for (int k = 1; k < prefix.length(); k++) {
                    if (prefix.charAt(k) != (arr1[i].charAt(k))) {
                        contains = false;
                        break;
                    }
                }
            }
            if (contains) {
                li.add(arr1[i]);
            }
        }
        return li;
    }

    private static char returnFirstNonRepeat(String str1) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> hm : map.entrySet()) {
            if (hm.getValue() == 1)
                return hm.getKey();
        }
        return '0';
    }

    private static int measureDistance(String senetense, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        String[] str = senetense.split(" ");
        int ind1 = -1;
        int ind2 = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(word1)) {
                ind1 = i;
            } else if (str[i].equals(word2)) {
                ind2 = i;
            }
            if ((ind1 != -1 && ind2 != -1)) {
                distance = Math.min(distance, Math.abs(ind1 - ind2) - 1);
            }

        }
        if (distance == Integer.MAX_VALUE)
            return -1;
        return distance;
    }

    private static List<String> strinContainsCHars(String[] dict, String input) {
        List<String> li = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            charSet.add(c);
        }
        for (int i = 0; i < dict.length; i++) {
            boolean check = true;
            Map<Character, Integer> hm = new HashMap<>();
            for (char c : dict[i].toCharArray()) {
                hm.put(c, hm.getOrDefault(c, 0) + 1);
            }
            for (int j = 0; j < input.length(); j++) {
                if (!hm.containsKey(input.charAt(j))) {
                    check = false;
                    break;
                } else if (hm.containsKey(input.charAt(j))) {
                    if (hm.get(input.charAt(j)) > 0) {
                        hm.put(input.charAt(j), hm.get(input.charAt(j)) - 1);
                    } else {
                        check = false;
                        break;
                    }
                }

            }
            if (check && (dict[i].length() == input.length())) {
                li.add(dict[i]);
            }
        }
        return li;
    }

    private static int converToNumber(String number) {
        int n = 0;
        int k = 0;
        if (number.charAt(0) == '-') {
            k = 1;
        }
        for (int i = k; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                n = (n * 10) + (int) (number.charAt(i) - '0');
            } else {
                return -1;
            }
        }
        if (k == 1)
            n = -n;
        return n;
    }


    public static double findMedian(int[] a,int[] b){

        int n1 = a.length;
        int n2 = b.length;
        if(n1>n2) return findMedian(b,a);
        int n = n1+n2;
        int median = (n+1)/2;
        int start=0;
        int end = n1;

        while(start<=end){
            int median1 = (start+end)/2;
            int median2 = median-median1;

            int l1 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(median1>0) l1 = a[median1-1];
            if(median1<n1) r1 = a[median1];
            if(median2>0) l2 = b[median2-1];
            if(median2<n2) r2 = b[median2];

            if(l1<=r2 && l2<=r1){
                if((n%2 == 0)){
                    double sol = (Math.min(r1,r2)+Math.max(l1,l2))/2.0;
                    return sol;
                }
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                end = median1-1;
            }
            else{
                start = median1+1;
            }
        }
        return 0.0;
    }
    private static double findMedian1(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1+n2;
        int mid2 = n/2;
        int mid1 = mid2-1;
        int mid1val = -1;
        int mid2val = -1;
        int i = 0,j = 0,k = 0;
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                if(k == mid1) mid1val = a[i];
                else if(k == mid2) mid2val = a[i];
                k++;
                i++;
            }
            else{
                if(k == mid1) mid1val = b[j];
                else if(k == mid2) mid2val = b[j];
                k++;
                j++;
            }
            if(mid1val != -1 && mid2val != -1)
                break;
        }
        while(i<n1){
            if(k == mid1) mid1val = a[i];
            else if(k == mid2) mid2val = a[i];
            k++;
            i++;
            if(mid1val != -1 && mid2val != -1)
                break;
        }
        while(j<n2){
            if(k == mid1) mid1val = b[j];
            else if(k == mid2) mid2val = b[j];
            k++;
            j++;
            if(mid1val != -1 && mid2val != -1)
                break;
        }
        if(n%2 == 0){
            return (mid1val+mid2val)/2.0;
        }
        return (double)mid2val;
    }
    public static String canReachBishop(int[] bishopPos, int[] immovablePos) {
        int x1 = bishopPos[0];
        int y1 = bishopPos[1];
        int x2 = immovablePos[0];
        int y2 = immovablePos[1];

        if (x1 == x2 && y1 == y2) {
            return "YES, 0";
        }

        if ((x1 + y1) % 2 != (x2 + y2) % 2) {
            return "NO";
        }

        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            return "YES, 1";
        }
        return "YES, 2";
    }
}
