package demo;

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

        //================================================================
        /*TempTreeNode m = new TempTreeNode("M");
        TempTreeNode n = new TempTreeNode("N");
        i.left = m;
        i.right = n;*/

        System.out.println("前序:");
        preOrder(root);
        /*System.out.println("中序:");
        midOrderRe(root);
        System.out.println("后序:");
        postOrderRe(root);*/
    }

    static void preOrder(TempTreeNode node) {
        System.out.print(node.value);
        if(node.left != null)
            preOrder(node.left);
        if(node.right != null)
            preOrder(node.right);
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