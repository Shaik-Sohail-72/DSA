// https://leetcode.com/problems/binary-tree-level-order-traversal/]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> mainls=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        if(root==null){
            return mainls;
        }
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode curr=q.remove();
                ls.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            mainls.add(ls);
        }
        return mainls;
    }
}