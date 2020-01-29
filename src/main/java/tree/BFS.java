package tree;

import java.util.Scanner;

import static java.util.Objects.nonNull;

public class BFS {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        BinaryTree<String> tree = new BinaryTree<>();

        try {
            System.out.println("Please key in input for Binary tree. When done, terminate input with Ctrl + D");
            while (scanner.hasNext()) {
                String raw = scanner.nextLine();
                tree.insert(raw);
                tree.print();
            }
        }
        finally {
            scanner.close();
        }

    }

//    public interface
}
