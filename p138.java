/*Given an undirected graph (not necessarily connected) with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components, or in other words, removing which increases the number of connected components.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Example 1:

Input:

V = 5 , adj = [[1] , [0, 4], [3, 4], [2, 4], [1, 2, 3]]

Output:[1,4]
Explanation: Removing the vertex 1 will
discconect the graph as-

Removing the vertex 4 will disconnect the
graph as-

 

Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.
 

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 

Constraints:
1 ≤ V ≤ 104*/
class Solution{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj){
        List<Integer> ls=new ArrayList<>();
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        boolean ap[]=new boolean[V];
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(adj,vis,i,dt,low,time,-1,ap);
            }
        }
        int c=0;
        for(int i=0;i<V;i++){
            if(ap[i]==true){
                c++;
            }
        }
        int arr[];
        if(c==0){
            arr=new int[1];
            arr[0]=-1;
        }else{
            arr=new int[c];
            int j=0;
            for(int i=0;i<V;i++){
                if(ap[i]==true){
                    arr[j++]=i;
                }
            }
        }
        return arr;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> connections,boolean vis[],int curr,int dt[],int low[],int time,int par,boolean ap[]){
        vis[curr]=true;
        int children=0;
        dt[curr]=low[curr]=++time;
        for(int neigh:connections.get(curr)){
            if(neigh==par){
                continue;
            }else if(vis[neigh]==false){
                dfs(connections,vis,neigh,dt,low,time,curr,ap);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(dt[curr]<=low[neigh] && par!=-1){
                    ap[curr]=true;
                }
                children++;
            }else if(vis[neigh]==true){
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }
        if(par==-1 && children>1){
            ap[curr]=true;
        }
    }
}