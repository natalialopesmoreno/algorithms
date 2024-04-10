package com.algorithms.datastructure;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args)  {
        // Grafo representando as dependências entre as tarefas
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Codificar a interface do usuário", Arrays.asList("Codificar as funcionalidades principais"));
        graph.put("Codificar as funcionalidades principais", Arrays.asList("Testar a interface do usuário"));
        graph.put("Testar a interface do usuário", Arrays.asList("Integrar a interface do usuário com as funcionalidades"));
        graph.put("Codificar as funcionalidades principais", Arrays.asList("Testar as funcionalidades principais"));
        graph.put("Testar as funcionalidades principais", Arrays.asList("Integrar a interface do usuário com as funcionalidades"));
        graph.put("Integrar a interface do usuário com as funcionalidades", Arrays.asList("Testar a integração"));

        // Realiza a ordenação topológica
        List<String> sortedTasks = topologicalSort(graph);

        // Imprime a ordem das tarefas
        System.out.println("Ordem das tarefas:");
        for (String task : sortedTasks) {
            System.out.println(task);
        }

        Map<String, List<String>> graphFamily = new HashMap<>();
        graphFamily.put("Mauricio", Arrays.asList("Belinho"));
        graphFamily.put("Waldemar", Arrays.asList("Roberto","Mauricio","Solange"));
        graphFamily.put("Marina", Arrays.asList("Vito"));
        graphFamily.put("Roberto", Arrays.asList("Marina", "Natalia","Andre"));
        graphFamily.put("Natalia", Arrays.asList("Mia"));
        graphFamily.put("Solange", Collections.emptyList());

        // Realiza a ordenação topológica
        List<String> sortedFamily = topologicalSort(graphFamily);

        // Imprime a ordem das tarefas
        System.out.println("Ordem da familia:");
        for (String people : sortedFamily) {
            System.out.println(people);
        }

    }

    private static List<String> topologicalSort(Map<String, List<String>> graph) {
        Stack<String> q = new Stack<String>();
        List<String> sortedList = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();
        Map<String, Integer> levelMap = new HashMap<String, Integer>();
        int level = 0;
        for(String vertice : graph.keySet()) {
            if(!visited.contains(vertice)){
                dfs(graph,vertice, visited, q, level,levelMap);

            }
        }

        while(!q.isEmpty()) {
            String s = q.pop();
            sortedList.add(s);
        }

        return sortedList;
    }

    private static void dfs(Map<String, List<String>> graph, String vertice, Set<String> visited, Stack<String> q, int level, Map<String, Integer> levelMap) {
        visited.add(vertice);
        levelMap.put(vertice, level);
        List<String> vizinhos = graph.getOrDefault(vertice, Collections.emptyList());
        for(int x = 0; x<level ; x++){
            System.out.print(" ");
        }
            System.out.println(vertice);
        for(String vizinho: vizinhos){
            if(!visited.contains(vizinho)){
                dfs(graph,vizinho,visited,q, level+3, levelMap);
            }
        }
        q.add(vertice);

    }


};



