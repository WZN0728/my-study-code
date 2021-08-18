package com.tree;

import java.util.*;

/**
 * @author wuting
 * @date 2020/11/18
 */
public class TreeNodeDemo2 {

    private static class TreeNode {

        private TreeNode leftTreeNode;
        private TreeNode rightTreeNode;

        private Integer data;

        public TreeNode(Integer data) {
            this.data = data;
        }

    }

    public static void preTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + " ");
        preTreeNode(treeNode.leftTreeNode);
        preTreeNode(treeNode.rightTreeNode);
    }

    public static void midTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midTreeNode(treeNode.leftTreeNode);
        System.out.print(treeNode.data + " ");
        midTreeNode(treeNode.rightTreeNode);
    }

    public static void postTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postTreeNode(treeNode.leftTreeNode);
        postTreeNode(treeNode.rightTreeNode);
        System.out.print(treeNode.data + " ");
    }

    public static void orderTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode treeNode1 = queue.poll();
            System.out.print(treeNode1.data + " ");
            if (treeNode1.leftTreeNode != null) {
                queue.offer(treeNode1.leftTreeNode);
            }
            if (treeNode1.rightTreeNode != null) {
                queue.offer(treeNode1.rightTreeNode);
            }
        }
    }

    public static TreeNode lowestCommonAnsetor(TreeNode treeNode, TreeNode a, TreeNode b) {
        if (treeNode == null) {
            return null;
        }
        TreeNode leftTreeNode = lowestCommonAnsetor(treeNode, a, b);
        TreeNode rightTreeNode = lowestCommonAnsetor(treeNode, a, b);
        if (leftTreeNode != null && rightTreeNode != null) {
            return treeNode;
        }
        if (leftTreeNode != null) {
            return leftTreeNode;
        }
        if (rightTreeNode != null) {
            return rightTreeNode;
        }
        return null;
    }

    public static List getRightTreeNode(TreeNode treeNode) {
        List resultList = new ArrayList();
        if (treeNode == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(treeNode);
        boolean findRightFlag = false;
        while (!queue.isEmpty()) {
            findRightFlag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!findRightFlag) {
                    resultList.add(node);
                    findRightFlag = true;
                }
                if (node.rightTreeNode != null) {
                    queue.offer(node.rightTreeNode);
                }
                if (node.leftTreeNode != null) {
                    queue.offer(node.leftTreeNode);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, 12, null, null, 8, null}));
        TreeNode treeNode = createTreeNode(linkedList);
        preTreeNode(treeNode);
        System.out.println();
        midTreeNode(treeNode);
        System.out.println();
        postTreeNode(treeNode);
        System.out.println();
        orderTreeNode(treeNode);
        System.out.println();
        System.out.println(getRightTreeNode(treeNode));
    }

    private static TreeNode createTreeNode(LinkedList<Integer> linkedList) {
        TreeNode treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return treeNode;
        }
        Integer data = linkedList.removeFirst();
        if (data != null) {
            treeNode = new TreeNode(data);
            treeNode.leftTreeNode = createTreeNode(linkedList);
            treeNode.rightTreeNode = createTreeNode(linkedList);
        }
        return treeNode;
    }

}
