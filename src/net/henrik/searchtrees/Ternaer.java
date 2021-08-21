package net.henrik.searchtrees;

public class Ternaer {
    public TernaryTreeNode<Integer> root;

    public static void main(String[] args) {
        var tree = new Ternaer();
        System.out.println(tree.root);
        tree.makeBinary(tree.root);
        System.out.println(tree.root);
    }

    public Ternaer() {
        var t0 = new TernaryTreeNode<>(1, 3, null, null, null);
        var t1 = new TernaryTreeNode<>(6, null, null, null, null);
        var t2 = new TernaryTreeNode<>(11, 13, null, null, null);
        var t3 = new TernaryTreeNode<>(5, 10, t0, t1, t2);
        var t4 = new TernaryTreeNode<>(21, null, null, null, null);
        var t5 = new TernaryTreeNode<>(25, 39, null, null, null);
        var t6 = new TernaryTreeNode<>(23, null, t4, t5, null);
        var t7 = new TernaryTreeNode<>(41, null, null, null, null);
        var t8 = new TernaryTreeNode<>(45, 48, null, null, null);
        var t9 = new TernaryTreeNode<>(51, 52, null, null, null);
        var t10 = new TernaryTreeNode<>(42, 50, t7, t8, t9);
        root = new TernaryTreeNode<>(20, 40, t3, t6, t10);

    }

    void makeBinary(TernaryTreeNode<Integer> root) {
        if (root == null) return;
        if (root.key2 == null) {
            if (root.left != null || root.middle != null) {
                makeBinary(root.left);
                makeBinary(root.middle);
            }
        } else if (root.left == null && root.middle == null && root.right == null) {
            root.middle = new TernaryTreeNode<>(root.key2, null, null, null, null);
            root.key2 = null;
        } else {
            makeBinary(root.left);
            makeBinary(root.middle);
            makeBinary(root.right);
            var t1 = new TernaryTreeNode<>(root.key2, null, root.middle, root.right, null);
            root.key2 = null;
            root.middle = t1;
            root.right = null;
        }
    }
}
