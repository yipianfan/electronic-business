package com.canoe.eb.account;

public class App {

    public static void main(String[] args) {
        TempTreeNode root = new TempTreeNode("A");
        TempTreeNode b = new TempTreeNode("B");
        TempTreeNode c = new TempTreeNode("C");
        root.left = b;
        root.right = c;

        TempTreeNode d = new TempTreeNode("D");
        TempTreeNode e = new TempTreeNode("E");
        b.left = d;
        b.right = e;

        TempTreeNode f = new TempTreeNode("F");
        TempTreeNode g = new TempTreeNode("G");
        c.left = f;
        c.right = g;

        TempTreeNode h = new TempTreeNode("H");
        TempTreeNode i = new TempTreeNode("I");
        d.left = h;
        d.right = i;

        TempTreeNode j = new TempTreeNode("J");
        TempTreeNode k = new TempTreeNode("K");
        g.left = j;
        j.right = k;

        preOrderRe(root);
        System.out.println();
        midOrderRe(root);
        System.out.println();
        postOrderRe(root);
    }


    public static void preOrderRe(TempTreeNode biTree) {
        System.out.print(biTree.value);
        TempTreeNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrderRe(leftTree);
        }
        TempTreeNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrderRe(rightTree);
        }
    }

    public static void midOrderRe(TempTreeNode biTree) {//中序遍历递归实现
        if (biTree == null)
            return;
        else {
            midOrderRe(biTree.left);
            System.out.print(biTree.value);
            midOrderRe(biTree.right);
        }
    }

    public static void postOrderRe(TempTreeNode biTree) {//后序遍历递归实现
        if (biTree == null)
            return;
        else {
            postOrderRe(biTree.left);
            postOrderRe(biTree.right);
            System.out.print(biTree.value);
        }
    }
}