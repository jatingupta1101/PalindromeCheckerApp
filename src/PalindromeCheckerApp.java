public class PalindromeCheckerApp {

    // Node class for UC8
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // UC8: Linked List Palindrome
    public static boolean isPalindromeUsingLinkedList(String str) {
        if (str == null || str.length() == 0)
            return true;

        Node head = new Node(str.charAt(0));
        Node current = head;

        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node nextNode;

        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // UC9: Recursive Palindrome
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App");

        String input = "madam";

        if (isPalindromeUsingLinkedList(input)) {
            System.out.println("UC8 (Linked List): " + input + " is a Palindrome");
        } else {
            System.out.println("UC8 (Linked List): " + input + " is NOT a Palindrome");
        }

        if (isPalindromeRecursive(input, 0, input.length() - 1)) {
            System.out.println("UC9 (Recursive): " + input + " is a Palindrome");
        } else {
            System.out.println("UC9 (Recursive): " + input + " is NOT a Palindrome");
        }
    }
}