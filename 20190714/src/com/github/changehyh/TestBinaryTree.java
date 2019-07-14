package com.github.changehyh;

import java.util.*;

public class TestBinaryTree {

    class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    //根据字符串创建二叉树 递归 先序遍历的方式
    public static int i = 0;
    TreeNode createTestTree(String s) {
        TreeNode root = null;
        if (s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        } else {
            i++;
        }
        return root;
    }

    //节点的个数
    int getSize(TreeNode root){
        if (root == null){
            return 0;
        }
        return getSize(root.left)+getSize(root.right)+1;
    }
    // 叶子结点个数
    int getLeafSize(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left ==null && root.right==null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }

    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k){
        if (root == null) {
            return 0;
        }
        if (k ==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, int value){
        if (root == null){
            return null;
        }
        if (root.val == value){
            return root;
        }
        TreeNode r = find(root.left,value);
        if (r != null){
            return r;
        }
        r = find(root.right,value);
        if (r != null){
            return r;
        }
        return null;
    }

    //二叉树的高度
    int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        if(l>=r){
            return l+1;
        }
        return r+1;
    }





    //二叉树的前序遍历
    void binaryTreePrevOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }
    //二叉树的中序遍历
    void binaryTreeInOrder(TreeNode root){
        if (root == null){
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val + " ");
        binaryTreeInOrder(root.right);
    }
    //二叉树的后序遍历
    void binaryTreePostOrder(TreeNode root){
        if (root == null){
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.val + " ");
    }

    //二叉树的前序遍历非递归
    void binaryTreePrevOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                System.out.println(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
    }

    //二叉树的中序遍历非递归
    void binaryTreeInOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }
    //二叉树的后序遍历非递归
    void binaryTreePostOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == pre){
                System.out.print(cur.val + " ");
                stack.pop();
                pre = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
    }
    public static void main(String[] args){
        //Scanner scanner = new Scanner(System.in);
        TestBinaryTree testBinaryTree = new TestBinaryTree();
//        while (scanner.hasNext()){
//            String  s = scanner.nextLine();
//            TestBinaryTree.TreeNode root = testBinaryTree.createTestTree(s);
//          //  testBinaryTree.binaryTreePrevOrder(root);
//            System.out.println(testBinaryTree.getLeafSize(root));
//        }
        String str = "ABC##DE#G##F###";
        TreeNode root = testBinaryTree.createTestTree(str);
        System.out.println(testBinaryTree.getLeafSize(root));
        System.out.println(testBinaryTree.getKLevelSize(root,4));
        TreeNode ret =testBinaryTree.find(root,'C');
        System.out.println(ret.val);
       // System.out.println(testBinaryTree.height(root));
//        testBinaryTree.binaryTreePrevOrder(root);
//        System.out.println("================");
        testBinaryTree.binaryTreeInOrder(root);
        System.out.println("================");
        testBinaryTree.binaryTreeInOrderNonR(root);
        System.out.println("================");

        testBinaryTree.binaryTreePostOrder(root);
        System.out.println("===============");
        testBinaryTree.binaryTreePostOrderNonR(root);
    }
}
