package javase.day9.work;

/**
 * @ClassName BinaryTree
 * @Description 使用课上代码Tree+TreeNode实现将1,25,34,78,90,123,234,56放入查找二叉树
 * @Author Cunhao Fan
 * @Date 2023/4/17 16:26
 * @Version 1.0
 */
    /*Tree模版类*/
    class Tree {
        /*根结点*/
        private TreeNode rootNode;
        /*构造方法*/

        public Tree(TreeNode rootNode) {
            this.rootNode = rootNode;
        }

        public Tree() {
        }
        /*getset方法*/

        public TreeNode getRootNode() {
            return rootNode;
        }

        public void setRootNode(TreeNode rootNode) {
            this.rootNode = rootNode;
        }
    }

    /*TreeNode模版类*/
    class TreeNode {
        /*结点的值*/
        private int value;
        /*左子树，右子树*/
        private TreeNode leftNode;
        private TreeNode rightNode;
        /*构造方法*/

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode() {
        }
        /*setget方法*/

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }


public class BinaryTree {
    /*遍历二叉树*/
    public void printNodeValue(TreeNode root){
        /*如果结点不为空，则遍历左右子树*/
        if (root != null){
            System.out.println("结点上的值："+root.getValue());
            /*递归调用，遍历左子树*/
            printNodeValue(root.getLeftNode());
            /*遍历左子树*/
            printNodeValue(root.getRightNode());
        }
    }
    public static void main(String[] args) {
        /*实例化二叉树*/
        Tree myTree = new Tree();
        /*实例化结点*/
        TreeNode root = new TreeNode(78);
        TreeNode treeNode1 = new TreeNode(25);
        TreeNode treeNode2 = new TreeNode(123);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(34);
        TreeNode treeNode5 = new TreeNode(56);
        TreeNode treeNode6 = new TreeNode(90);
        TreeNode treeNode7 = new TreeNode(234);
        root.setLeftNode(treeNode1);
        root.setRightNode(treeNode2);
        treeNode1.setLeftNode(treeNode3);
        treeNode1.setRightNode(treeNode4);
        treeNode4.setRightNode(treeNode5);
        treeNode2.setLeftNode(treeNode6);
        treeNode2.setRightNode(treeNode7);
        /*遍历二叉树*/
        BinaryTree myBinaryTree = new BinaryTree();
        myBinaryTree.printNodeValue(root);
    }
}
