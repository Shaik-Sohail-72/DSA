/*Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 

Example 1:

Input:
3 3
0 1 5
1 2 3
0 2 1

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:

Input:
2 1
0 1 5

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() which takes number of vertices V and an adjacency matrix adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains a list of lists containing two integers where the first integer a[i][0] denotes that there is an edge between i and a[i][0][0] and second integer a[i][0][1] denotes that the distance between edge i and a[i][0][0] is a[i][0][1].

In other words , adj[i][j] is of form  { u , wt } . So,this denotes that i th node is connected to u th node with  edge weight equal to wt.

 

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 

Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
Graph is connected and doesn't contain self loops & multiple edges.*/
class Solution{
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int n,int c){
            this.node=n;
            this.cost=c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    //adj creation
        ArrayList<Edge> graph[]=new ArrayList[V];
        for(int i=0;i<V;i++){
	        graph[i]=new ArrayList<>();
	    }
	    for(int arr[]:edges){
	        int u=arr[0];
	        int v=arr[1];
	        int wt=arr[2];
	        graph[u].add(new Edge(u,v,wt));
	        graph[v].add(new Edge(v,u,wt));
	    }
	    //end
	    int mstCost=0;
	    boolean vis[]=new boolean[V];
	    PriorityQueue<Pair> pq=new PriorityQueue<>();
	    pq.add(new Pair(0,0));
	    while(!pq.isEmpty()){
	        Pair curr=pq.remove();
	        if(vis[curr.node]==false){
	            vis[curr.node]=true;
	            mstCost+=curr.cost;
	            for(int i=0;i<graph[curr.node].size();i++){
	                Edge e=graph[curr.node].get(i);
	                pq.add(new Pair(e.dest,e.wt));
	            }
	        }
	    }
	    return mstCost;
	}
}