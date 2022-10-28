package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode {

    public int val = 0;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v) {
        this.val = v;
    }


    public static class TreeHelper {

        public List<Integer> treeValues = new ArrayList<>();

        public void test() {
            TreeNode root = new TreeNode(10);
            TreeNode level_1_left_1 = new TreeNode(8);
            {
                TreeNode level_2_left_1_left = new TreeNode(7);
                TreeNode level_2_left_2_right = new TreeNode(9);
                level_1_left_1.left = level_2_left_1_left;
                level_1_left_1.right = level_2_left_2_right;
            }
            TreeNode level_1_right_1 = new TreeNode(12);
            {
                TreeNode level_2_right_1_left = new TreeNode(11);
                TreeNode level_2_right_2_right = new TreeNode(13);
                level_1_right_1.left = level_2_right_1_left;
                level_1_right_1.right = level_2_right_2_right;
            }
            root.left = level_1_left_1;
            root.right = level_1_right_1;


            //forTreeNode(root);

            //Collections.sort(treeValues);
            for(int i = 0; i < treeValues.size(); i++) {
                System.out.println(" treeValues : " + treeValues.get(i));
            }

            System.out.println(" tree hasValid : " + hasValid1(root));

        }
        //中序遍厉
        public void forTreeNode(TreeNode node) {
            if(node == null) {
                return;
            }
            if(node.left != null) {
                forTreeNode(node.left);
            }
            treeValues.add(node.val);
            if(node.right != null) {
                forTreeNode(node.right);
            }
        }

        public int preNodeValue = -1;

        /**
         * 校验是否为二叉排序树
         * 中序遍厉，如果当前是否大于前一个节点，那是，那么继续，否则不满足
         * @param root
         * @return
         */
        public boolean hasValid1(TreeNode root) {
            if(root == null) {
                return true;
            }
            //访问左子树
            if(!hasValid1(root.left)) {
                return false;
            }
            //
            if(root.val <= preNodeValue) {
                return false;
            }
            preNodeValue = root.val;

            //访问右子树
            return hasValid1(root.right);
        }

        //不对
//        public boolean hasValid(TreeNode root, int min, int max) {
//            if(root == null) {
//                return true;
//            }
//            if(root.val <= min) {
//                return false;
//            }
//            if(root.val >= max) {
//                return false;
//            }
//            //8，8，10
//            return hasValid(root.left, min, root.val) && hasValid(root.right, root.val, max);
//        }

    }

}
