package com.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wuting
 * @date 2019/05/16
 */
public class TreeNodeDemo {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createTreeNode(inputList);
        System.out.println("二叉树的递归前序遍历:");
        preTreeNodeSearch(treeNode);
        System.out.println();
        System.out.println("二叉树的非递归前序遍历:");
        preOrderWithStack(treeNode);
        System.out.println();
        System.out.println("二叉树的递归中序遍历:");
        inOrderTreeNodeSearch(treeNode);
        System.out.println();
        System.out.println("二叉树的非递归中序遍历:");
        //inOrderWithStack(treeNode);
        System.out.println();
        System.out.println("二叉树的递归后续遍历:");
        postTreeNodeSearch(treeNode);
        System.out.println();
        System.out.println("二叉树的非递归后续遍历:");
        //postOrderWithStack(treeNode);
        System.out.println();
        System.out.println("二叉树的层序遍历:");
        levelOrderWithQueue(treeNode);
    }

    private static class TreeNode {
        int data;
        TreeNode leftChildNode;
        TreeNode rightChildNode;

        public TreeNode(int data) {
            this.data = data;
        }

    }

    //构建与一个二叉树
    public static TreeNode createTreeNode(LinkedList<Integer> linkedList) {
        TreeNode treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return treeNode;
        }
        Integer data = linkedList.removeFirst();
        if (data != null) {
            treeNode = new TreeNode(data);
            treeNode.leftChildNode = createTreeNode(linkedList);
            treeNode.rightChildNode = createTreeNode(linkedList);
        }
        return treeNode;
    }

    //二叉树的递归前序遍历(根、左、右)
    public static void preTreeNodeSearch(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + "   ");
        preTreeNodeSearch(treeNode.leftChildNode);
        preTreeNodeSearch(treeNode.rightChildNode);
    }

    //二叉树的递归中序遍历(左、根、右)
    public static void inOrderTreeNodeSearch(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTreeNodeSearch(treeNode.leftChildNode);
        System.out.print(treeNode.data + "   ");
        inOrderTreeNodeSearch(treeNode.rightChildNode);
    }

    //二叉树的递归后续遍历(左、右、根)
    public static void postTreeNodeSearch(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postTreeNodeSearch(treeNode.leftChildNode);
        postTreeNodeSearch(treeNode.rightChildNode);
        System.out.print(treeNode.data + "   ");
    }

    //二叉树的非递归前序遍历
    public static void preOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.print(treeNode.data + "   ");
                stack.push(treeNode);
                treeNode = treeNode.leftChildNode;
            }
            //如果没有左孩子,则弹出栈顶元素,遍历右孩子
            while (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChildNode;
            }
        }
    }

    //二叉树的非递归中序遍历
    public static void inOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data + "   ");
                stack.push(treeNode.leftChildNode);
            }
            while (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChildNode;
            }
        }
    }

    //二叉树的非递归后续遍历
    public static void postOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data + "   ");
                stack.push(treeNode.leftChildNode);
            }
            while (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChildNode;
            }
        }
    }

    //二叉树的层序遍历
    public static void levelOrderWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.data + "    ");
            if (treeNode.leftChildNode != null) {
                queue.offer(treeNode.leftChildNode);
            }
            if (treeNode.rightChildNode != null) {
                queue.offer(treeNode.rightChildNode);
            }
        }
    }

}
