import java.util.Scanner;
import java.util.Stack;

 class PalindromeCheckerApp {

    // ===== Approach 1: Iterative (Two-Pointer) =====
    public static boolean iterativePalindrome(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = processed.length() - 1;

        while (start < end) {
            if (processed.charAt(start) != processed.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // ===== Approach 2: Recursive =====
    public static boolean recursivePalindrome(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursivePalindrome(str, start + 1, end - 1);
    }

    // ===== Approach 3: Stack-Based =====
    public static boolean stackPalindrome(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // ===== Iterative Timing =====
        long startTime1 = System.nanoTime();
        boolean result1 = iterativePalindrome(input);
        long endTime1 = System.nanoTime();
        long time1 = endTime1 - startTime1;

        // ===== Recursive Timing =====
        long startTime2 = System.nanoTime();
        boolean result2 = recursivePalindrome(processed, 0, processed.length() - 1);
        long endTime2 = System.nanoTime();
        long time2 = endTime2 - startTime2;

        // ===== Stack Timing =====
        long startTime3 = System.nanoTime();
        boolean result3 = stackPalindrome(input);
        long endTime3 = System.nanoTime();
        long time3 = endTime3 - startTime3;

        // ===== Results =====
        System.out.println("\n--- Results ---");
        System.out.println("Iterative Result: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Recursive Result: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Stack Result: " + result3 + " | Time: " + time3 + " ns");

        scanner.close();
    }
}