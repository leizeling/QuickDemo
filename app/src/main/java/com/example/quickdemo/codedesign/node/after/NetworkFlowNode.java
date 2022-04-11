package com.example.quickdemo.codedesign.node.after;

import com.example.quickdemo.codedesign.node.before.NetworkHelper;

/**
 * 网络结点
 */
public class NetworkFlowNode extends FlowNode{
    @Override
    public void process() {
        if (NetworkHelper.getInstance().isConnect()) {
            System.out.println("网络已连接");
            FlowNode next = getNext();
            if (next != null) {
                next.process();
            }
        } else {
            System.out.println("网络未连接");
            NetworkHelper.getInstance().requestConnectNetwork(new NetworkHelper.NetworkCallback() {
                @Override
                public void onResult(boolean result) {
                    if (result) {
                        System.out.println("网络连接成功");
                        FlowNode next = getNext();
                        if (next != null) {
                            next.process();
                        }
                    } else {
                        System.out.println("用户登录失败，结束流程");
                    }
                }
            });
        }
    }
}
