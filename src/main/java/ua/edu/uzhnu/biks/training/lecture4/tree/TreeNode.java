package ua.edu.uzhnu.biks.training.lecture4.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Actine on 02.03.2017.
 */
public class TreeNode {

    private String data;
    private List<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    public TreeNode getChild(int index) {
        return children.get(index);
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        String result = "\n" + data;
        for (TreeNode child : children) {
            result += child.toString().replaceAll("\\n", "\n• ");
        }
        return result;
    }
}
