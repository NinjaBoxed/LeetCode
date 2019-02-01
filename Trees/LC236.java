/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LC236 {
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelper(root, p , q);
        
        return lca;
    }
    
    private boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        boolean result = false;
        boolean left = lowestCommonAncestorHelper(root.left, p, q);
        boolean right = lowestCommonAncestorHelper(root.right, p, q);
        
        if(left && right) {
            lca = root;
        }
        if(root == p || root == q) {
            if(left || right) {
                lca = root;
            }
        }
        
        return left || right || root == p || root == q;
    }
}