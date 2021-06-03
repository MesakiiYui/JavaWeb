package leetcode;
import sun.reflect.generics.tree.Tree;

import java.net.StandardSocketOptions;
import java.util.*;

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
}


public class Solution {
    /**
     *
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        if(root1== null){
            return false;
        }
        if(isSame(root1, root2)){
            return true;
        }
        return isContains(root1.left, root2) || isContains(root1.right, root2);
    }

    public static boolean isSame(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }
        return false;
    }


}
