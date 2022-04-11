package com.example.quickdemo.codedesign.node.after;

/**
 * 打赏服务
 */
public class TipService extends FlowNode{

    public void onClickTip() {
        // 构建校验链表
        // (1) 创建结点
        NetworkFlowNode networkFlowNode = new NetworkFlowNode();
        LoginFlowNode loginFlowNode = new LoginFlowNode();
        AdultAccountFlowNode adultAccountFlowNode = new AdultAccountFlowNode();
        // (2)根据校验顺序连接结点
        networkFlowNode.setNext(loginFlowNode);
        loginFlowNode.setNext(adultAccountFlowNode);
        adultAccountFlowNode.setNext(this);

        // 触发链表调用
        networkFlowNode.process();
    }

    @Override
    public void process() {
        doTip();
    }

    /**
     * 进行打赏
     */
    public void doTip() {
        System.out.println("通过了一系列合法性校验，可以进行打赏");
    }
}
