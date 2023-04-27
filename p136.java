/*Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:

V = 4 , adj = [[1] , [2], [3], [3]]

Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:

V = 3 , adj = [[1] , [2], []]

Output: 0
Explanation: no cycle in the graph

Your task:
You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105*/
class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        boolean rec[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(dfs(adj,vis,i,rec)){
                return true;
            }
        }
        return false;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int curr,boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int ele:adj.get(curr)){
            if(rec[ele]==true){
                return true;
            }
            if(vis[ele]==false){
                if(dfs(adj,vis,ele,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
}