/*Example - 1 :
Input : 4 4

1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Output : 1 2 5 3 6 9 4 7 10 13 8 11 14 12 15 16

Example - 2 :
Input : 5 6

1 2 3 4 5 6
7 8 9 10 11 12 
13 14 15 16 17 18
19 20 21 22 23 24
25 26 27 28 29 30

Output : 1 2 7 3 8 13 4 9 14 19 5 10 15 20 25 6 11 16 21 26 12 17 22 27 18 23 28 24 29 30

*/
import java.util.*;
class matrixBFS{
	static class Pair{
		int i;
		int j;
		Pair(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				grid[i][j]=sc.nextInt();
			}
		}
		boolean vis[][]=new boolean[m][n];
		bfs(grid,vis,0,0);
	}
	public static boolean isValid(int[][] grid,int i,int j){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
			return false;
		}
		return true;
	}
	public static void bfs(int[][] grid,boolean vis[][],int row,int col){
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(row, col));
		while(!q.isEmpty()){
			Pair curr=q.remove();
			int i=curr.i;
			int j=curr.j;
			if(vis[i][j]==false){
				System.out.print(grid[i][j]+" ");
				vis[i][j]=true;
				if(isValid(grid,i-1,j)){
					q.add(new Pair(i-1,j));
				}
				if(isValid(grid,i,j+1)){
					q.add(new Pair(i,j+1));
				}
				if(isValid(grid,i+1,j)){
					q.add(new Pair(i+1,j));
				}
				if(isValid(grid,i,j-1)){
					q.add(new Pair(i,j-1));
				}
			}
		}
	}
}