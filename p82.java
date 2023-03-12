/*Given a matrix where every row is sorted in increasing order. Write a function that finds and 
returns a smallest common element in all rows. If there is no common element, then returns -1.

Example-1:
Input: mat [4][5] = { {1, 2, 3, 4, 5},
 {2, 4, 5, 8, 10},
 {3, 5, 7, 9, 11},
 {1, 3, 5, 7, 9}
 };
Output: 5*/
class SmallestCommonElement {
    private boolean binarySearch(int[] arr, int low, int high, int target) {
      while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
          return true;
        } else if (arr[mid] < target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return false;
    }
    public int smallestCommonElement(int[][] mat) {
      if (mat.length == 1) return mat[0][0];
      for (int a: mat[0]) {
        int count = 0;
        for (int i = 1; i < mat.length; i++) {
          if (binarySearch(mat[i], 0, mat[i].length - 1, a)) {
            count++;
          } else {
            break;
          }
        }
        if (count == mat.length - 1) return a;
      }
      return -1;
    }
}