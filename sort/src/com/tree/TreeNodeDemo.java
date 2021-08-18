package com.tree;

import java.util.*;

/**
 * @author wuting
 * @date 2019/05/16
 */
public class TreeNodeDemo {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createTreeNode(inputList);
        String str = "1,2,3,#,#,4,5";
        System.out.println(deserialize(serialize(createNode(str))));
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
        System.out.println();
        System.out.println(rightSideView(treeNode));
        //System.out.println(lowestCommonAncestor(treeNode, treeNode, treeNode));
        //System.out.println(isBalance(treeNode));
    }

    /**
     * �ǵݹ鷽ʽ���������
     *
     * @return
     */
    private static TreeNode createNode(String str) {
        // 1,2,3,null,null,4,5,null,null,null,null
        String[] values = str.split(",");
        List<TreeNode> queue = new ArrayList();
        queue.add(new TreeNode(Integer.parseInt(values[0])));
        boolean isLeft = true;
        int index = 0;
        for (int i = 1; i < values.length; i++) {
            if (!values[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                if (isLeft) {
                    queue.get(index).leftChildNode = node;
                } else {
                    queue.get(index).rightChildNode = node;
                }
                queue.add(node);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
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

    /**
     * �������Ĳ�����1��2��3��4��5
     * ��ʵ������������������϶����Ƚ��ȳ���ԭ��ʵ�ֶ����������ӽ�
     * ��������ӽ�,��ô��ʵ��������ӵ�����ı�һ������е�˳��
     *
     * @param treeNode
     * @return
     */
    public static List<Integer> rightSideView(TreeNode treeNode) {
        List<Integer> resultList = new ArrayList<>();
        if (treeNode == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList();
        //��һ�ο϶��Ÿ��ڵ�
        queue.offer(treeNode);
        //�����־λ��Ҫ������ִֻ��һ��,ֻȡ�ұߵĽڵ�
        boolean findRightFlag = false;
        while (!queue.isEmpty()) {
            findRightFlag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!findRightFlag) {
                    resultList.add(node.data);
                    findRightFlag = true;
                }
                //�����������ȷ��ҽڵ�,��������ӽ�,���ȷ���ڵ�
                if (node.rightChildNode != null) {
                    queue.offer(node.rightChildNode);
                }
                if (node.leftChildNode != null) {
                    queue.offer(node.leftChildNode);
                }
            }
        }
        return resultList;
    }

    /**
     * �������������������
     *
     * @param treeNode
     * @param a
     * @param b
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode treeNode, TreeNode a, TreeNode b) {
        if (treeNode == null || a == treeNode || b == treeNode) {
            return treeNode;
        }
        TreeNode leftTreeNode = lowestCommonAncestor(treeNode.leftChildNode, a, b);
        TreeNode rightTreeNode = lowestCommonAncestor(treeNode.rightChildNode, a, b);
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

    /**
     * ƽ�������
     *
     * @param node
     * @return
     */
    public static boolean isBalance(TreeNode node) {
        if (node == null) {
            return true;
        }
        return maxTree(node) != -1;
    }

    private static int maxTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxTree(node);
        int right = maxTree(node);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<TreeNode> listNode = new ArrayList();
        listNode.add(root);
        //{1,2,3,null,null,4,5,null,null,null,null}
        for (int i = 0; i < listNode.size(); i++) {
            TreeNode node = listNode.get(i);
            if (node == null) {
                continue;
            }
            listNode.add(node.leftChildNode);
            listNode.add(node.rightChildNode);
        }
        //{1,2,null,null,3,4,5}
        while (listNode.get(listNode.size() - 1) == null) {
            listNode.remove(listNode.size() - 1);
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(listNode.get(0).data);
        for (int i = 1; i < listNode.size(); i++) {
            if (listNode.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append("," + listNode.get(i).data);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("{}")) {
            return null;
        }
        //dataValue {1,2,3,#,#,4,5}
        String[] dataValue = data.substring(1, data.length() - 1).split(",");
        List<TreeNode> queue = new ArrayList();
        boolean isLeft = true;
        int index = 0;
        TreeNode node = new TreeNode(Integer.parseInt(dataValue[0]));
        queue.add(node);
        for (int i = 1; i < dataValue.length; i++) {
            if (!dataValue[i].equals("#")) {
                TreeNode nodeValue = new TreeNode(Integer.parseInt(dataValue[i]));
                if (isLeft) {
                    queue.get(index).leftChildNode = nodeValue;
                } else {
                    queue.get(index).rightChildNode = nodeValue;
                }
                queue.add(nodeValue);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
    }

}
