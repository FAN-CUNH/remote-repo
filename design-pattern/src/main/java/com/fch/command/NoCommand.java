package com.fch.command;

/**
 * @packageName com.fch.command
 * @ClassName NoCommand
 * @Description TODO 没有任何命令，即空方法，用于初始化每个按钮，当调用空命令，对象什么都不做 -> 可以省掉对空判断
 * @Author Fan-CUNH
 * @Date 2023/8/7 10:12
 * @Version 1.0
 */
public class NoCommand implements Command {
    /**
     * 执行动作（操作）
     */
    @Override
    public void execute() {

    }

    /**
     * 撤销动作（操作）
     */
    @Override
    public void undo() {

    }
}
