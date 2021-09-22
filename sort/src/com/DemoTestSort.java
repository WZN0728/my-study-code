package com;

import java.util.*;

/**
 * @author wuting
 * @date 2021/09/22
 */
public class DemoTestSort {

    public static void main(String[] args) {
        System.out.println(5 / 2);
        System.out.println(4 % 2);
        String s = "abc";
        System.out.println(s.charAt(1));
        int[] sums = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(fourSum(sums, 0));
        DemoTestSort test = new DemoTestSort();
        test.listNodeFun();
        generateParenthesis(3);
        System.out.println(reverse(103));
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(letterCombinations("23"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(lengthOfLongestSubstring("abcab"));
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(8);
        treeNode.right.right.right = new TreeNode(9);
        getLevelNumTreeNode(treeNode, 8);
        System.out.println("1当前变量所在的树的层数=" + count);
        System.out.println("2当前变量所在的树的层数=" + getLevelNumByLevelOrder(treeNode, 8));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.replaceAll("[^0-9a-zA-Z]", "");
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (!s.substring(i, i + 1).equalsIgnoreCase(s.substring(length - i - 1, length - i))) {
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = s.length();
        int start = 0, end = 0, ans = 0;
        Set set = new HashSet();
        while (start < num && end < num) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                ans = Math.max(ans, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return ans;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0 || "1".equals(digits)) {
            return result;
        }
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            result = combition(result, str[digits.charAt(i) - '0' - 2]);
        }
        return result;
    }

    private static List<String> combition(List<String> result, String s) {
        List list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (result.isEmpty()) {
                list.add(s.substring(i, i + 1));
            } else {
                for (String str : result) {
                    list.add(str + s.substring(i, i + 1));
                }
            }
        }
        return list;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }


    public static int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        long sum = 0;
        int a = 0;
        while (x != 0) {
            //先取余数
            a = x % 10;
            //目标数除尽
            x = x / 10;
            sum = sum * 10 + a;
        }
        return (int) sum == sum ? (int) sum : 0;
    }

    public void listNodeFun() {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.println(removeNthFromEnd(listNode1, 2));
        ListNode listNode4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(removeNthFromFirst(listNode4, 4));
        System.out.println(mergeTwoLists(listNode1, listNode2));
        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.println(swapPairs(listNode3));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        Arrays.sort(nums);
        Map map = new HashMap();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int z = j + 1, k = len - 1; z < len; z++) {
                    while (z < k && (nums[i] + nums[j] + nums[k] + nums[z]) > target) {
                        k--;
                    }
                    if (k == z) {
                        break;
                    }
                    int num = nums[i] + nums[j] + nums[k] + nums[z];
                    if (len == 4) {
                        if (num == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[z]));
                            return result;
                        } else {
                            return result;
                        }
                    }
                    if (num == target) {
                        List lists = Arrays.asList(nums[i], nums[j], nums[k], nums[z]);
                        if (!map.containsKey(lists.toString())) {
                            map.put(lists.toString(), "");
                            result.add(lists);
                        }
                    }
                }
            }
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode head) {
            this.val = val;
            this.next = head;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode cacheNode = new ListNode(0, head);
        ListNode slow = head, fast = head;
        int i = 0;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            i++;
            if (i == n) {
                slow = cacheNode;
            }
        }
        slow.next = slow.next.next;
        return cacheNode.next;
    }

    /**
     * 删除链表的节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromFirst(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        if (n == 1) {
            return head.next;
        }
        ListNode cur = head, pre = null;
        int count = 0;
        while (cur != null) {
            count++;
            if (count == n) {
                pre.next = pre.next.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode resultNode = new ListNode(0);
        ListNode curNode = resultNode;
        while (l1.next != null && l2.next != null) {
            if (l1.val >= l2.val) {
                curNode.next = l2;
                curNode = curNode.next;
                l2 = l2.next;
            } else {
                curNode.next = l1;
                curNode = curNode.next;
                l1 = l1.next;
            }
        }
        if (l1.next != null) {
            curNode.next = l1;
        }
        if (l2.next != null) {
            curNode.next = l2;
        }
        return resultNode.next;
    }

    static List<String> resultList = new ArrayList();

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return resultList;
        }
        dfs(n, n, "");
        return resultList;
    }

    private static void dfs(int left, int right, String resultStr) {
        if (left == 0 && right == 0) {
            resultList.add(resultStr);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, resultStr + "(");
        }
        if (right > left) {
            dfs(left, right - 1, resultStr + ")");
        }
    }

    static int count = 0;

    private static void getLevelNumTreeNode(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            return;
        }
        count++;
        getLevelNumTreeNode(root.left, val);
        getLevelNumTreeNode(root.right, val);
    }

    private static int getLevelNumByLevelOrder(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<List> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List list = new ArrayList();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                count--;
            }
            result.add(list);
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).contains(val)) {
                return i + 1;
            }
        }
        return -1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
