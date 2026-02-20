public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";   // Hardcoded string

        // Convert String to char array
        char[] chars = word.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}