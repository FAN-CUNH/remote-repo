package com.fch.command;

/**
 * @packageName com.fch.command
 * @ClassName Command
 * @Description TODO 抽象命令接口 （连接命令发布者和命令具体执行者）
 * @Author Fan-CUNH
 * @Date 2023/8/7 9:50
 * @Version 1.0
 */
public interface Command {
    /**
     * 执行动作（操作）
     */
    public void execute();

    /**
     * 撤销动作（操作）
     */
    public void undo();
}
