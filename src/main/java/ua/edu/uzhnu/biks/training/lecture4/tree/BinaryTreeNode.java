package ua.edu.uzhnu.biks.training.lecture4.tree;

/**
 * Created by Actine on 02.03.2017.
 */
public class BinaryTreeNode {

    private int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return (left != null ? left.toString() : "")
                + " " + value + " "
                + (right != null ? right.toString() : "");
    }
}
