package com;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wuting
 * @date 2021/09/22
 */
public class DemoTestSort2 {

    /**
     * @author wuting
     * @date 2021/07/02
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        swapPairs(listNode);
        RepayReduceDetail repayReduceDetail = new RepayReduceDetail();
        repayReduceDetail.setCouponReduceAmount(new BigDecimal(10));
        repayReduceDetail.setOtherReduceAmount(new BigDecimal(50));
        repayReduceDetail.setCouponReduceValidFlag(0);
        repayReduceDetail.setOtherReduceValidFlag(1);
        System.out.println(JSON.toJSONString(repayReduceDetail));
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    @Data
    static class RepayReduceDetail {
        private BigDecimal otherReduceAmount;
        private BigDecimal couponReduceAmount;
        private Integer otherReduceValidFlag;
        private Integer couponReduceValidFlag;
    }

}
