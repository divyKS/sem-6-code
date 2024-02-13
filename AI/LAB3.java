// BFS
// TC: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes
// SC: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list

// DFS
// TC: For an undirected graph, O(N) + O(2E), For a directed graph, O(N) + O(E), Because for every node we are calling the recursive function once, the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.
// SC: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LAB3{
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        
        // 'i' are the nodes
        for(int i = 0; i <= 5; i++){
            adjMatrix.add(new ArrayList<>());
        }

        adjMatrix.get(1).add(2);
        adjMatrix.get(1).add(5);
        
        adjMatrix.get(2).add(1);
        adjMatrix.get(2).add(3);
        adjMatrix.get(2).add(5);

        adjMatrix.get(3).add(2);
        adjMatrix.get(3).add(4);
        adjMatrix.get(3).add(5);

        adjMatrix.get(4).add(3);
        adjMatrix.get(4).add(5);
        
        adjMatrix.get(5).add(1);
        adjMatrix.get(5).add(2);
        adjMatrix.get(5).add(3);
        adjMatrix.get(5).add(4);
        
        // for(int i = 0; i <= 10; i++){
        //     adjMatrix.add(new ArrayList<>());
        // }

        // adjMatrix.get(1).add(2);
        // adjMatrix.get(1).add(7);

        // adjMatrix.get(2).add(3);
        // adjMatrix.get(2).add(6);

        // adjMatrix.get(3).add(4);
        // adjMatrix.get(3).add(5);

        // adjMatrix.get(7).add(8);
        // adjMatrix.get(7).add(10);

        // adjMatrix.get(8).add(9);


        // System.out.println(adjMatrix);

        // iterativeDFSTraversal(adjMatrix);

        recursiveDFSTraversal(adjMatrix);

    }

    static void bfsTraversal(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfsTraversal = new ArrayList<>();

        int noOfNodes = adj.size();
        boolean[] visited = new boolean[noOfNodes];

        // if an element has been pushed into the queue, then we have to mark it visited
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            bfsTraversal.add(node);
            visited[node] = true;
            for(int connectedNode: adj.get(node)){
                if(visited[connectedNode] == false){
                    visited[connectedNode] = true;
                    queue.add(connectedNode);
                }
            }
        }

        System.out.println(bfsTraversal);
    }

    static void iterativeDFSTraversal(ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> dfsTraversal = new ArrayList<>();

        int noOfNodes = adj.size();
        boolean[] visited = new boolean[noOfNodes];

        // if an element has been pushed into the stack, then we have to mark it visited
        stack.push(1);
        visited[1] = true;

        while(!stack.isEmpty()){
            int node = stack.pop();
            dfsTraversal.add(node);
            for(int connectedNode: adj.get(node)){
                if(visited[connectedNode] == false){
                    visited[connectedNode] = true;
                    stack.push(connectedNode);
                }
            }
        }

        System.out.println(dfsTraversal);
    }

    static void recursiveDFSTraversal(ArrayList<ArrayList<Integer>> adj){
        int noOfNodes = adj.size();
        boolean[] visited = new boolean[noOfNodes];
        
        ArrayList<Integer> dfsTraversal = new ArrayList<>();

        dfs(1, visited, adj, dfsTraversal);

        System.out.println(dfsTraversal);
        
    }

    static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsTraversal) {        
        visited[node] = true;
        dfsTraversal.add(node);
        for(int connectedNode: adj.get(node)){
            if(visited[connectedNode] == false){
                dfs(connectedNode, visited, adj, dfsTraversal );
            }
        }

    }
}