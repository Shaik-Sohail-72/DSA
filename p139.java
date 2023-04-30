/*Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 

Example 1:

Input:

V = 5 , adj = [[2,3] , [0], [1], [4], []]

Output:
3
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph
Example 2:

Input:

V =  3 , adj = [[1] , [2], [0]]

Output:
1
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function kosaraju() which takes the number of vertices V and adjacency list of the graph as inputs and returns an integer denoting the number of strongly connected components in the given graph.
 

Expected Time Complexity: O(V+E).
Expected Auxiliary Space: O(V+E).
 

Constraints:
1 ≤ V ≤ 5000
0 ≤ E ≤ (V*(V-1))
0 ≤ u, v ≤ N-1
Sum of E over all testcases will not exceed 25*106*/
class Solution{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        // Step-1 O(V+E)
        boolean vis[]=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                topSort(adj,vis,i,st);
            }
        }
        
        // Step-2 O(V+E)
        boolean tVis[]=new boolean[V];
        ArrayList<ArrayList<Integer>> tGraph=new ArrayList<>();
        for(int i=0;i<V;i++){
            tGraph.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int neigh:adj.get(i)){
                tGraph.get(neigh).add(i);
            }
        }
        
        // Step3 O(V+E)
        int c=0;
        while(!st.isEmpty()){
            int curr=st.pop();
            if(tVis[curr]==false){
                dfs(tGraph,tVis,curr);
                c++;
            }
        }
        return c;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int curr){
        vis[curr]=true;
        for(int neigh:adj.get(curr)){
            if(vis[neigh]==false){
                dfs(adj,vis,neigh);
            }
        }
    }
    public static void topSort(ArrayList<ArrayList<Integer>> adj,boolean vis[],int curr,Stack<Integer> st){
        vis[curr]=true;
        for(int neigh:adj.get(curr)){
            if(vis[neigh]==false){
                topSort(adj,vis,neigh,st);
            }
        }
        st.push(curr);
    }
}