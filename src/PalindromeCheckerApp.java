import java.util.Scanner;

class UseCase8PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of linked list
    static Node head = null;

    // Method to insert character at end
    public static void insert(char data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to reverse linked list
    public static Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Method to check palindrome
    public static boolean isPalindrome() {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        // Step 1: Find middle using Fast & Slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);

        Node firstHalf = head;

        // Step 3: Compare halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Linked List Based Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Preprocess: remove spaces and convert to lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Convert string to linked list
        for (int i = 0; i < input.length(); i++) {
            insert(input.charAt(i));
        }

        // Check palindrome
        if (isPalindrome()) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        sc.close();
    }
}