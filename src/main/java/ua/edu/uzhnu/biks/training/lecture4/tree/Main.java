package ua.edu.uzhnu.biks.training.lecture4.tree;

/**
 * Created by Actine on 02.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("Мої документи");

        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new TreeNode("Нова папка (" + i + ")");
        }

        nodes[0].addChild(nodes[1]);
        nodes[0].addChild(nodes[2]);
        nodes[0].addChild(nodes[3]);
        nodes[1].addChild(nodes[4]);
        nodes[1].addChild(nodes[6]);
        nodes[4].addChild(nodes[5]);
        root.addChild(nodes[0]);
        root.addChild(nodes[7]);
        root.addChild(nodes[8]);
        nodes[8].addChild(nodes[9]);

        System.out.println(root.toString());
        System.out.println(root.getChild(0).getChild(1));
        System.out.println(root.getChild(0).getChild(0).getData());

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(8);
        binaryTree.insert(15);
        binaryTree.insert(20);
        binaryTree.insert(1);
        binaryTree.insert(12);
        binaryTree.insert(6);
        System.out.println(binaryTree);
        System.out.println(binaryTree.contains(6));
        System.out.println(binaryTree.contains(11));
    }

}
