package org.example.problems.graphs;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphBuilder {

    public static class VertexImpl implements Graph.Vertex {
        private final String nameField;

        public VertexImpl(String name) {
            this.nameField = name;
        }

        @Override
        public @NotNull String getName() {
            return nameField;
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    public static class EdgeImpl implements Graph.Edge {
        private final int weightField;
        private final Graph.Vertex _begin;
        private final Graph.Vertex _end;

        public EdgeImpl(int weight, Graph.Vertex begin, Graph.Vertex end) {
            this.weightField = weight;
            this._begin = begin;
            this._end = end;
        }

        @Override
        public Graph.@NotNull Vertex getBegin() {
            return _begin;
        }

        @Override
        public Graph.@NotNull Vertex getEnd() {
            return _end;
        }

        @Override
        public int getWeight() {
            return weightField;
        }
    }

    private final Map<String, Graph.Vertex> vertices = new HashMap<>();
    private final Map<Graph.Vertex, Set<EdgeImpl>> connections = new HashMap<>();

    private void addVertex(Graph.Vertex v) {
        vertices.put(v.getName(), v);
    }

    public Graph.Vertex addVertex(String name) {
        Graph.Vertex vertex = new VertexImpl(name);
        addVertex(vertex);
        return vertex;
    }

    public void addConnection(Graph.Vertex begin, Graph.Vertex end, int weight) {
        EdgeImpl edge = new EdgeImpl(weight, begin, end);

        connections.computeIfAbsent(begin, k -> new HashSet<>()).add(edge);
        connections.computeIfAbsent(end, k -> new HashSet<>()).add(edge);
    }

    public Graph build() {
        return new Graph() {
            @Override
            public Vertex get(String name) {
                return vertices.get(name);
            }

            @Override
            public @NotNull Set<Vertex> getVertices() {
                return new HashSet<>(vertices.values());
            }

            @Override
            public @NotNull Set<Edge> getEdges() {
                Set<Edge> edges = new HashSet<>();
                for (Set<EdgeImpl> edgeSet : connections.values()) {
                    edges.addAll(edgeSet);
                }
                return edges;
            }

            @Override
            public @NotNull Map<Vertex, Edge> getConnections(@NotNull Vertex v) {
                Map<Vertex, Edge> result = new HashMap<>();
                Set<EdgeImpl> edges = connections.get(v);
                if (edges != null) {
                    for (EdgeImpl edge : edges) {
                        if (v == edge.getBegin()) {
                            result.put(edge.getEnd(), edge);
                        } else {
                            result.put(edge.getBegin(), edge);
                        }
                    }
                }
                return result;
            }
        };
    }
}
