package model;

import java.util.*;
import java.lang.*;
import java.io.*;

import javax.xml.crypto.Data;

public class ShortestPath {
    int V = 0;

    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void printPath(Map map) {

        Iterator<Map.Entry<Integer, List<Integer>>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = entries.next();
            Integer key = entry.getKey();
            List<Integer> values = entry.getValue();
            System.out.print(key + " ---- ");
            System.out.println(values);
        }

    }

    DataOut dijkstra(int graph[][], int src) {
        int dist[] = new int[V]; // The output array. dist[i] will hold
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist);
        System.out.println("paths");
        DataOut dataOut = new DataOut();
        dataOut.setDist(dist);
        dataOut.setMap(map);
        return dataOut;
    }

    // Driver method
    public DataOut findShortest(int graph[][], int fromNode) {

        V = graph.length;
        ShortestPath t = new ShortestPath();
       DataOut dataOut= t.dijkstra(graph, fromNode);
       return dataOut;
    }


}

