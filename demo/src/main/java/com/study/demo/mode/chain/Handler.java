package com.study.demo.mode.chain;

/**
 * @author wuting
 * @date 2019/09/08
 */
public interface Handler {

    /**
     * @Description: 处理当前的逻辑请i去
     * @Param: [dayNums]
     * @return: void
     * @Author: wuting
     * @Date: 2019/9/8
     */
    void handlerRequest(int dayNums);

    /**
     * @Description: 获取下一个处理者
     * @Param: []
     * @return: com.study.demo.mode.chain.Handler
     * @Author: wuting
     * @Date: 2019/9/8
     */
    Handler getNextHandler();

    /**
     * @Description: 设置下一个请求的处理者
     * @Param: []
     * @return: void
     * @Author: wuting
     * @Date: 2019/9/8
     */
    void setNextHandler(Handler handler);

}
