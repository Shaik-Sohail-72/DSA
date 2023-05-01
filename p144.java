T/*here are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int arr[]:prerequisites){
            int src=arr[0];
            int dest=arr[1];
            adj.get(src).add(dest);
        }
        boolean vis[]=new boolean[numCourses];
        boolean rec[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(cycle(adj,vis,i,rec)){
                return false;
            }
        }
        return true;
    }
    public static boolean cycle(List<List<Integer>> adj,boolean vis[],int curr,boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i:adj.get(curr)){
            if(rec[i]==true){
                return true;
            }else if(vis[i]==false && cycle(adj,vis,i,rec)){
                return true;
            }
        }
        rec[curr]=false;
        return false;
    }
}