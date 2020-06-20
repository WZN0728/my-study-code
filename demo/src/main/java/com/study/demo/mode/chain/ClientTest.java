package com.study.demo.mode.chain;

/**
 * @author wuting
 * @date 2019/09/08
 */
public class ClientTest {

    public static void main(String[] args) {
        TeamLeader teamLeader = new TeamLeader(3, "TeamLeader");
        Departmentdirector departmentdirector = new Departmentdirector(7, "Departmentdirector");
        GeneralManager generalManager = new GeneralManager(Integer.MAX_VALUE, "GeneralManager");
        //如果当前的请求超过了自己的能力范畴,则直接推给上级去处理
        teamLeader.setNextHandler(departmentdirector);
        departmentdirector.setNextHandler(generalManager);
        //请假3天
        teamLeader.handlerRequest(3);
        //请假7天
        departmentdirector.handlerRequest(8);
        //请假100天
        generalManager.handlerRequest(100);
    }

}
