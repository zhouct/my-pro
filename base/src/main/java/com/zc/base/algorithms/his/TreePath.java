package com.zc.base.algorithms.his;

public class TreePath {

    /**
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if(root != null){
            sum += pathSum(sum, root.left, targetSum - root.val);
            sum += pathSum(sum, root.right, targetSum - root.val);
        }
        return sum;
    }

    private int pathSum(int sum, TreeNode root, int targetSum) {
        if(targetSum == 0){
            sum += 1;
        }else if(targetSum > 0){
            if(root != null){
                sum += pathSum(sum, root.left, targetSum - root.val);
                sum += pathSum(sum, root.right, targetSum - root.val);
            }
        }
        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
