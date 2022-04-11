package com.example.quickdemo.codedesign.node.after;

import com.example.quickdemo.codedesign.node.before.LoginHelper;

/**
 * 登录结点
 */
public class LoginFlowNode extends FlowNode{
    @Override
    public void process() {
        if (LoginHelper.getInstance().isLogin()) {
            System.out.println("用户已登录");
            FlowNode next = getNext();
            if (next != null) {
                next.process();
            }
        } else {
            System.out.println("用户未登录");
            LoginHelper.getInstance().requestLogin(new LoginHelper.LoginCallback() {
                @Override
                public void onResult(boolean success) {
                    if (success) {
                        System.out.println("用户登录成功");
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
