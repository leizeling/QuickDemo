package com.example.quickdemo.codedesign.node.after;

public abstract class FlowNode {
    private FlowNode next;

    /**
     * 事务处理
     */
    public abstract void process();

    public FlowNode getNext() {
        return next;
    }

    public void setNext(FlowNode next) {
        this.next = next;
    }
}
