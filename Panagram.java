public class Panagram {
    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwxyz";
        input = input.toLowerCase();
        int[] freq = new int[26];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ')
                freq[(int) input.charAt(i) - 97]++;
        }

        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] <= 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Given sentence is a pangram: " + input);
        } else {
            System.out.println("Given sentence is not a pangram: " + input);
        }
    }
}
