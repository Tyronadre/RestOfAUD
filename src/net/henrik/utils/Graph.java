package net.henrik.utils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Graph<T, V> {
    List<Node<T>> nodeList;
    List<Edge<T, V>> edgeList;

    public Graph() {
        this.nodeList = new LinkedList<>();
        this.edgeList = new LinkedList<>();
    }

    public void addNode(T t) {
        if (t == null)
            throw new NullPointerException();
        if (nodeList.stream().anyMatch(tNode -> tNode.key.equals(t)))
            throw new IllegalArgumentException();
        else nodeList.add(new Node<>(t));
    }

    public void addEdge(T from, T to, V cost) {
        if (from == null || to == null || cost == null)
            throw new NullPointerException();
        if (nodeList.stream().noneMatch(tNode -> tNode.key.equals(from) || tNode.key.equals(to)) ||
                edgeList.stream().anyMatch(tvEdge -> tvEdge.from.key.equals(from) && tvEdge.to.key.equals(to)))
            throw new IllegalArgumentException();
        edgeList.add(new Edge<>(getNode(from), getNode(to), cost));

    }

    private Node<T> getNode(T key) {
        if (key == null)
            throw new NoSuchElementException();
        if (nodeList.stream().anyMatch(tNode -> tNode.key.equals(key)))
            return (Node<T>) nodeList.stream().filter(tNode -> tNode.key.equals(key)).toArray()[0];
        else return null;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodeList=" + nodeList +
                ", edgeList=" + edgeList +
                '}';
    }

    public boolean containsEdge(T from, T to) {
        if (from == null || to == null)
            throw new NullPointerException();
        return edgeList.stream().anyMatch(tvEdge -> tvEdge.from.key.equals(from) && tvEdge.to.key.equals(to));
    }

    public boolean containsNode(T key) {
        if (key == null)
            throw new NullPointerException();
        return nodeList.stream().anyMatch(tNode -> tNode.key.equals(key));
    }

    public void exportTGF() {
        File file = new File("graph.tgf");
        try {
            if (file.createNewFile())
                System.out.println("File created" + file.getName());
            else
                System.out.println("File already existed, overwriting it");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //BUILD THE STRING THAT WILL BE WRITTEN;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++)
            stringBuilder.append(i + 1).append(' ').append(nodeList.get(i).key).append('\n');
        stringBuilder.append("#\n");
        for (int i = 0; i < edgeList.size(); i++)
            stringBuilder.append(nodeList.indexOf(edgeList.get(i).from)+1).append(' ').append(nodeList.indexOf(edgeList.get(i).to)+1).append(' ').append(edgeList.get(i).distance).append('\n');

        try (Writer writer = new FileWriter(file)) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Graph created!");

    }
}
