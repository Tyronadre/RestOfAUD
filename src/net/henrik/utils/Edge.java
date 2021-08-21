package net.henrik.utils;

class Edge<T, V> {
    Node<T> from;
    Node<T> to;
    V distance;

    public Edge(Node<T> from, Node<T> to, V distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }
}
