package com.example.quickdemo.codedesign.node.after;

import com.example.quickdemo.codedesign.node.before.AccountHelper;
import com.example.quickdemo.codedesign.node.before.AccountInfo;

/**
 * 账号校验结点
 */
public class AdultAccountFlowNode extends FlowNode {
    @Override
    public void process() {
        AccountHelper.getInstance().checkAccountType(new AccountInfo(), new AccountHelper.AccountCallback() {
            @Override
            public void onResult(int type) {
                if (type == AccountHelper.ACCOUNT_TYPE_ADULT) {
                    System.out.println("是成人帐号");
                    FlowNode next = getNext();
                    if (next != null) {
                        next.process();
                    }
                } else {
                    System.out.println("不是成人帐号,结束流程");
                }
            }
        });
    }
}
