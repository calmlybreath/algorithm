package algs.offer;


/**
 * The type Binary tree mirror.
 */
public class BinaryTreeMirror {
    /**
     * 题目描述
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 输入描述:
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     *
     * @param root the root
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempLeftNode = root.left;
        root.left = root.right;
        root.right = tempLeftNode;
        mirror(root.left);
        mirror(root.right);
    }


    /**
     * The type Tree node.
     */
    public class TreeNode {
        /**
         * The Val.
         */
        int val = 0;
        /**
         * The Left.
         */
        TreeNode left = null;
        /**
         * The Right.
         */
        TreeNode right = null;

        /**
         * Instantiates a new Tree node.
         *
         * @param val the val
         */
        public TreeNode(int val) {
            this.val = val;

        }

    }
}
