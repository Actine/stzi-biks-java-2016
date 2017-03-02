package ua.edu.uzhnu.biks.training.lecture4.tree;

/**
 * Created by Actine on 02.03.2017.
 */
public class BinaryTree {

    private BinaryTreeNode root;

    public void insert(int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value);

        if (root == null) {
            root = newNode;
            return;
        }

        BinaryTreeNode current = root;
        while (true) {
            if (value > current.getValue()) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                } else {
                    current = current.right;
                }
            } else {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                } else {
                    current = current.left;
                }
            }
        }
    }

    public boolean contains(int value) {
        BinaryTreeNode current = root;
        while (true) {
            if (current == null) {
                return false;
            }
            if (value == current.getValue()) {
                return true;
            } else if (value > current.getValue()) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
