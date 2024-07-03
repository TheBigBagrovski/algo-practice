package org.example.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dejkstra {

    class VertexInfo implements Comparable<VertexInfo> {
        private final Graph.Vertex vertex;
        private final int distance;
        private final Graph.Vertex prev;

        public VertexInfo(Graph.Vertex vertex, int distance, Graph.Vertex prev) {
            this.vertex = vertex;
            this.distance = distance;
            this.prev = prev;
        }

        @Override
        public int compareTo(VertexInfo other) {
            return Integer.compare(distance, other.distance);
        }
    }

    public Map<Graph.Vertex, VertexInfo> shortestPath(Graph graph, Graph.Vertex from) {
        Map<Graph.Vertex, VertexInfo> info = new HashMap<>();
        for (Graph.Vertex vertex : graph.getVertices()) {
            info.put(vertex, new VertexInfo(vertex, Integer.MAX_VALUE, null));
        }
        Set<Graph.Vertex> visited = new HashSet<>();
        VertexInfo fromInfo = new VertexInfo(from, 0, null);
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>();
        queue.add(fromInfo);
        info.put(from, fromInfo);
        while (!queue.isEmpty()) {
            VertexInfo currentInfo = queue.poll();
            Graph.Vertex currentVertex = currentInfo.vertex;
            visited.add(currentVertex);
            for (Graph.Vertex vertex : graph.getNeighbors(currentVertex)) {
                if (visited.contains(vertex)) continue;
                Graph.Edge edge = graph.getConnection(currentVertex, vertex);
                if (edge != null) {
                    int weight = edge.getWeight();
                    int newDistance = info.get(currentVertex).distance + weight;
                    if (info.get(vertex).distance > newDistance) {
                        VertexInfo newInfo = new VertexInfo(vertex, newDistance, currentVertex);
                        queue.add(newInfo);
                        info.put(vertex, newInfo);
                    }
                }
            }
        }
        return info;
    }

}
