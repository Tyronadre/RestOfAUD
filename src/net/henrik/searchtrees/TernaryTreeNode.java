package net.henrik.searchtrees;

public class TernaryTreeNode<T> {
    public T key1;
    public T key2;
    public TernaryTreeNode<T> left;
    public TernaryTreeNode<T> middle;
    public TernaryTreeNode<T> right;

    public TernaryTreeNode(T key1, T key2, TernaryTreeNode<T> left, TernaryTreeNode<T> middle, TernaryTreeNode<T> right) {
        this.key1 = key1;
        this.key2 = key2;
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    @Override
    public String toString() {
        var string = new StringBuilder();
        if(key1 != null)
            string.append("k1: ").append(key1);
        if (key2!= null)
            string.append(" k2: ").append(key2);
        if (left != null || middle != null || right != null)
            string.append("\n \t");
        if (left != null)
            string.append(" L: ").append(left);
        if (middle!= null)
            string.append(" M: ").append(middle);
        if (right != null)
            string.append(" R: ").append(right);
        string.append("\n");
        return string.toString();
    }
}
