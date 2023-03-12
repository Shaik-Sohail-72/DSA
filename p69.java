/*Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.

Example 1:

Input: 
N = 2
A = [[1, 2],
     [3, 4]]
Output:
1 2 3 4
Explanation: 

Hence, elements will be returned in the 
order {1, 2, 3, 4}.
Example 2:

Input: 
N = 3 
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
Output: 
1 2 4 3 5 7 6 8 9
Explanation: 

Hence, elements will be returned in 
the order {1, 2, 4, 3, 5, 7, 6, 8, 9}.

Your Task:
You don't need to read input or print anything. Your task is to complete the function downwardDiagonal() which takes an integer N and a 2D matrix A[ ][ ] as input parameters and returns the list of all elements of its anti-diagonals from top to bottom.

Expected Time Complexity: O(N*N)
Expected Auxillary Space: O(N*N)

Constraints:
1 ≤ N, M ≤ 103
0 ≤ A[i][j] ≤ 106*/
class Solution{
    static ArrayList<Integer> downwardDiagonal(int N, int A[][]){
        ArrayList<Integer> ls=new ArrayList<>();
        for(int m=0;m<N;m++){
            int row=0;
            int col=m;
            while(col>=0){
                ls.add(A[row][col]);
                row++;
                col--;
            }
        }
        for(int m=1;m<N;m++){
            int row=m;
            int col=N-1;
            while(row<N){
                ls.add(A[row][col]);
                row++;
                col--;
            }
        }
        return ls;
    }
}