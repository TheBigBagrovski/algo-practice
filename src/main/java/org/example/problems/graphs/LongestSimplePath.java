package org.example.graphs;

public class LongestSimplePath {

    /**
     * Наидлиннейший простой путь.
     * Сложная
     * <p>
     * Дан граф (получатель). Найти в нём простой путь, включающий максимальное количество рёбер.
     * Простым считается путь, вершины в котором не повторяются.
     * Если таких путей несколько, вернуть любой из них.
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
     * Ответ: A, E, J, K, D, C, H, G, B, F, I
     */
    //временные затраты: O((Vertices!)*Vertices) (т.к. contains() -- O(n))
    //затраты памяти: O(Vertices) (т.к. храним только сам путь)
    public static Path longestSimplePath(Graph graph) {
        Path longestPath =  new Path();
        if (graph.getVertices().isEmpty()) return longestPath;
        for (Graph.Vertex vertex : graph.getVertices()) {
            if(longestPath.getLength()==graph.getVertices().size()) break;
            longestPath = recursiveSearch(graph, new Path(vertex), vertex, longestPath);
        }
        return longestPath;
    }

    private static Path recursiveSearch(Graph graph, Path path, Graph.Vertex vertex, Path longestPath) {
        for (Graph.Vertex neighbor : graph.getNeighbors(path.getVertices().get(path.getLength()))) {
            if(!path.contains(neighbor)) {
                Path newPath = new Path(path, graph, neighbor);
                if(newPath.getLength() > longestPath.getLength()) longestPath = newPath;
                longestPath = recursiveSearch(graph, newPath, neighbor, longestPath);
            }
        }
        return longestPath;
    }

}
