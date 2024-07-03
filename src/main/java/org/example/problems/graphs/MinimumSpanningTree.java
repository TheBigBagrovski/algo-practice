package org.example.graphs;

import java.util.HashSet;
import java.util.Set;

public class MinimumSpanningTree {

    /**
     * Минимальное остовное дерево.
     * Средняя
     * <p>
     * Дан связный граф (получатель). Найти по нему минимальное остовное дерево.
     * Если есть несколько минимальных остовных деревьев с одинаковым числом дуг,
     * вернуть любое из них. Веса дуг не учитывать.
     * <p>
     * Пример:
     * <p>
     * G -- H
     * |    |
     * A -- B -- C -- D
     * |    |    |    |
     * E    F -- I    |
     * |              |
     * J ------------ K
     * <p>
     * Ответ:
     * <p>
     * G    H
     * |    |
     * A -- B -- C -- D
     * |    |    |
     * E    F    I
     * |
     * J ------------ K
     */
    //временные затраты: O(Vertices * Edges)
    //затраты памяти: O(Vertices)
    public static Graph minimumSpanningTree(Graph graph) {
        Set<Graph.Vertex> added = new HashSet<>();
        GraphBuilder answer = new GraphBuilder();
        if (graph.getEdges().isEmpty()) return answer.build();
        for (Graph.Vertex vertex : graph.getVertices()) {
            answer.addVertex(vertex.getName());
            for (Graph.Vertex neighbor : graph.getNeighbors(vertex))
                if (!added.contains(vertex) || !added.contains(neighbor)) {
                    answer.addConnection(vertex, neighbor, 1);
                    added.add(neighbor);
                    added.add(vertex);
                }
        }
        return answer.build();
    }
}
