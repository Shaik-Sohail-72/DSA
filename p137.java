/*There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.*/
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //create adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge:connections){
            int src=edge.get(0);
            int dest=edge.get(1);
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        
        // main
        List<List<Integer>> mainls=new ArrayList<>();
        int dt[]=new int[n];
        int low[]=new int[n];
        int time=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(adj,vis,i,dt,low,time,-1,mainls);
            }
        }
        return mainls;
    }
    public static void dfs(List<List<Integer>> connections,boolean vis[],int curr,int dt[],int low[],int time,int par,List<List<Integer>> mainls){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int neigh:connections.get(curr)){
            if(neigh==par){
                continue;
            }else if(vis[neigh]==true){
                low[curr]=Math.min(low[curr],dt[neigh]);
            }else{
                dfs(connections,vis,neigh,dt,low,time,curr,mainls);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(dt[curr]<low[neigh]){
                    mainls.add(Arrays.asList(curr,neigh));
                }
            }
        }
    }
}