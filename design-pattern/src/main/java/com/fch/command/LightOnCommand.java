package com.fch.command;

/**
 * @packageName com.fch.command
 * @ClassName LightOnCommand
 * @Description TODO ConcreteCommand：将一个接收者对象与一个动作绑定，调用接收者响应的操作，实现execute
 * @Author Fan-CUNH
 * @Date 2023/8/7 9:59
 * @Version 1.0
 */
public class LightOnCommand implements Command {

    /**
     * 聚合电灯具体的执行者
     */
    LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    /**
     * 执行动作（操作）
     */
    @Override
    public void execute() {
        // 调用接收的执行方法
        light.on();
    }

    /**
     * 撤销动作（操作）
     */
    @Override
    public void undo() {
        // 调用接收者的撤销放方法
        light.off();
    }
}
