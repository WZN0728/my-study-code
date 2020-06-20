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
        System.out.println("�������ĵݹ�ǰ�����:");
        preTreeNodeSearch(treeNode);
        System.out.println();
        System.out.println("�������ķǵݹ�ǰ�����:");
        preOrderWithStack(treeNode);
        System.out.println();
        System.out.println("�������ĵݹ��������:");
        inOrderTreeNodeSearch(treeNode);
        System.out.println();
        System.out.println("�������ķǵݹ��������:");
        //inOrderWithStack(treeNode);
        System.out.println();
        System.out.println("�������ĵݹ��������:");
        postTreeNodeSearch(treeNode);
        System.out.println();
        System.out.println("�������ķǵݹ��������:");
        //postOrderWithStack(treeNode);
        System.out.println();
        System.out.println("�������Ĳ������:");
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

    //������һ��������
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

    //�������ĵݹ�ǰ�����(��������)
    public static void preTreeNodeSearch(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + "   ");
        preTreeNodeSearch(treeNode.leftChildNode);
        preTreeNodeSearch(treeNode.rightChildNode);
    }

    //�������ĵݹ��������(�󡢸�����)
    public static void inOrderTreeNodeSearch(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTreeNodeSearch(treeNode.leftChildNode);
        System.out.print(treeNode.data + "   ");
        inOrderTreeNodeSearch(treeNode.rightChildNode);
    }

    //�������ĵݹ��������(���ҡ���)
    public static void postTreeNodeSearch(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postTreeNodeSearch(treeNode.leftChildNode);
        postTreeNodeSearch(treeNode.rightChildNode);
        System.out.print(treeNode.data + "   ");
    }

    //�������ķǵݹ�ǰ�����
    public static void preOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //�������ʽڵ�����ӣ�����ջ
            while (treeNode != null) {
                System.out.print(treeNode.data + "   ");
                stack.push(treeNode);
                treeNode = treeNode.leftChildNode;
            }
            //���û������,�򵯳�ջ��Ԫ��,�����Һ���
            while (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChildNode;
            }
        }
    }

    //�������ķǵݹ��������
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

    //�������ķǵݹ��������
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

    //�������Ĳ������
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
