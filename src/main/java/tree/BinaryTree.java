package tree;

import com.sun.istack.internal.Nullable;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    BinaryTree() {}

    BinaryTree(@Nullable Node<T> root)   {
        this.root = root;
    }

    void insert(T data) {
        root = insertRec(this.root, data);
    }

    private Node<T> insertRec(Node<T> root, T data)    {
        if(isNull(root))    {
            root = new Node<>(data);
        }
        else if(data.compareTo(root.getData()) >= 0) {
            root.setLeft(insertRec(root.getLeft(), data));
        }
        else if (data.compareTo(root.getData()) < 0) {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    public void print()    {
       String tree = print(this.root) + print(this.root.getLeft()) + print(this.root.getRight());
       System.out.println("The tree is: " + tree);
    }

    String print(Node<T> node)  {
        return nonNull(node) ? node.getData().toString() + "==>" : "";
    }

    void deleteTree()   {
        this.root = null;
    }

    void traverse(TreeTraversal traversalType)  {
        traversalType.traverse(this.root);
    }
}


