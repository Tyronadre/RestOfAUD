package net.henrik.utils;

class Node<T> {
    T key;

    public Node(T t) {
        this.key = t;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                '}';
    }
}
