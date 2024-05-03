import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        ArrayList<Integer> length = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> dicA = new HashMap<>();
        HashMap<Integer, ArrayList<String>> dicB = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            int len = phone_book[i].length();
            if (length.contains(len)) continue;

            ArrayList<String> lstA = new ArrayList<>();
            ArrayList<String> lstB = new ArrayList<>();

            for (int j = i; j < phone_book.length; j++) {
                if (phone_book[j].length() == len) {
                    lstA.add(phone_book[j].substring(0, len));
                } else {
                    lstB.add(phone_book[j].substring(0, len));
                }
            }

            dicA.put(len, lstA);
            dicB.put(len, lstB);
            length.add(len);
        }

        for (int len : length) {
            ArrayList<String> tempA = dicA.get(len);
            ArrayList<String> tempB = dicB.get(len);
            HashSet<String> tempBSet = new HashSet<>(tempB);
            ArrayList<String> tempTotal = new ArrayList<>(tempA);
            tempTotal.addAll(tempBSet);

            if (tempTotal.size() != new HashSet<>(tempTotal).size()) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
