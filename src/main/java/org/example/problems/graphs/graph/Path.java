package org.example.problems.graphs;

import java.util.List;

public class Path implements Comparable<Path> {
    private final List<Graph.Vertex> vertices;
    private final int length;

    public Path(List<Graph.Vertex> vertices, int length) {
        this.vertices = vertices;
        this.length = length;
    }

    @Override
    public int compareTo(Path other) {
        return Integer.compare(length, other.length);
    }

    public boolean isLoop(Graph graph) {
        return vertices.size() == graph.getVertices().size() + 1 && vertices.get(0).equals(vertices.get(vertices.size() - 1));
    }

    public boolean contains(Graph.Vertex v) {
        return vertices.contains(v);
    }

    public Path(Graph.Vertex first) {
        this(List.of(first), 0);
    }

    public Path() {
        this(List.of(), 0);
    }

    public Path(Path previous, Graph g, Graph.Vertex next) {
        this(
                List.copyOf(previous.vertices),
                previous.length + g.getConnection(previous.vertices.get(previous.vertices.size() - 1), next).getWeight()
        );
        vertices.add(next);
    }

    @Override
    public String toString() {
        return "<" + vertices + " of length " + length + ">";
    }

    public int getLength() {
        return length;
    }

    public List<Graph.Vertex> getVertices() {
        return vertices;
    }
}