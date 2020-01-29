package interview;

public class MiddleLL {

    static class Node<T>
    {

        Node<T> next;

        T item;

        public Node(T item)
        {
            this.item = item;
        }

    }

    public static void main(String[] args) {


        Node<Integer> root = new Node<>(0);

        Node<Integer> tail = root;

        for (int i = 0; i < 1; i++)
        {
            tail.next = new Node<>(i + 1);
            tail = tail.next;
        }

        Node<Integer> fast = root;
        Node<Integer> slow = root;

        int i = 0;

        while (fast.next != null)
        {
            fast = fast.next;
            i++;
            if (i % 2 == 0)
            {
                slow = slow.next;
            }
        }

        System.out.println(slow.item);
    }
}
