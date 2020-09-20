package Tree;

import sun.print.SunAlternateMedia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    public boolean hasPathSum_DontKnowWhyWrong(TreeNode root, int sum) {
        if (root == null || sum == 0) {
            return false;
        }
        int currentSum = 0;
        return auxHasPathSum(root, sum, currentSum);
    }

    private boolean auxHasPathSum(TreeNode root, int sum, int currentSum) {
        if (root == null) {
            if (currentSum == sum) {
                return true;
            }
            return false;
        }

        currentSum += root.val;
        return auxHasPathSum(root.left, sum, currentSum) || auxHasPathSum(root.right, sum, currentSum);
    }

    public boolean hasPathSum_correct(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum_correct(root.left, sum - root.val) || hasPathSum_correct(root.right, sum);
    }

    // all root-to-leaf paths where each path's sum equals the given sum.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }
        ArrayList<Integer> currPath = new ArrayList<>();
        auxPathSum(root, sum, retList, currPath);
        return retList;
    }

    private void auxPathSum(TreeNode root, int sum, List<List<Integer>> retList, ArrayList<Integer> currPath) {
        if (root == null) {
            return;
        }
        currPath.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            retList.add(new ArrayList<>(currPath));
        } else {
            auxPathSum(root.left, sum - root.val, retList, currPath);
            auxPathSum(root.right, sum - root.val, retList, currPath);
        }
        currPath.remove(currPath.size());
    }
}
