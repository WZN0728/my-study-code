package com.study.demo.mode.chain;

/**
 * @author wuting
 * @date 2019/09/08
 * 从上面请假的例子中，我们可以看到，当我们需要请假的时候，
 * 我们直接调用请假的接口，无需关心处理者到底是谁，即把请求者和处理者之间
 * 的逻辑剥离开来，降低耦合度。同时，如果我们需要增加新的处理者的话，
 * 我们只需要重新组合链表即可。
 * 有优点也必定有缺点，比如，当链表很长的时候，一级一级请求，
 * 在性能上可能会有一些影响。同时，如果我们没有正确设置处理者，
 * 可能会导致请求没有人处理。
 */
public class Leader implements Handler {

    private int mCountDayNums;

    private Handler handler;

    private String managerName;

    public Leader(int mCountDayNums, String managerName) {
        this.mCountDayNums = mCountDayNums;
        this.managerName = managerName;
    }

    @Override
    public void handlerRequest(int dayNums) {
        if (dayNums <= mCountDayNums) {
            System.out.println(managerName + "同意了你的申请,dayNums:" + dayNums);
        } else {
            Handler handlerReq = getNextHandler();
            if (handlerReq != null) {
                handlerReq.handlerRequest(dayNums);
            } else {
                System.out.println(managerName + "拒绝了你的请求,dayNums:" + dayNums);
            }
        }
    }

    @Override
    public Handler getNextHandler() {
        return handler;
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }

}
