package com.canoe.eb.account;

public class App {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        root.left = b;
        root.right = c;

        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        b.left = d;
        b.right = e;

        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        c.left = f;
        c.right = g;

        TreeNode h = new TreeNode("H");
        TreeNode i = new TreeNode("I");
        d.left = h;
        d.right = i;

        TreeNode j = new TreeNode("J");
        TreeNode k = new TreeNode("K");
        g.left = j;
        j.right = k;

        preOrderRe(root);
        System.out.println();
        midOrderRe(root);
        System.out.println();
        postOrderRe(root);
    }


    public static void preOrderRe(TreeNode biTree) {
        System.out.print(biTree.value);
        TreeNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrderRe(leftTree);
        }
        TreeNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrderRe(rightTree);
        }
    }

    public static void midOrderRe(TreeNode biTree) {//中序遍历递归实现
        if (biTree == null)
            return;
        else {
            midOrderRe(biTree.left);
            System.out.print(biTree.value);
            midOrderRe(biTree.right);
        }
    }

    public static void postOrderRe(TreeNode biTree) {//后序遍历递归实现
        if (biTree == null)
            return;
        else {
            postOrderRe(biTree.left);
            postOrderRe(biTree.right);
            System.out.print(biTree.value);
        }
    }
}