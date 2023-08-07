package com.fch.command;

/**
 * @packageName com.fch.command
 * @ClassName RemoteController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/7 10:22
 * @Version 1.0
 */
public class RemoteController {
    // 执行动作
    Command[] onCommands;
    Command[] offCommands;

    // 执行撤销
    Command undoCommand;

    // 构造器，完成对按钮初始化
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    // 给我们的按钮设置需要的命令
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    // 按下 开 命令
    public void onPushed(int no) {
        // 调用对应的按钮
        onCommands[no].execute();
        // 记录此次操作用于撤销
        undoCommand = onCommands[no];
    }

    // 按下 关 命令
    public void offPushed(int no) {
        // 调用对应的按钮
        offCommands[no].execute();
        // 记录此次操作用于撤销
        undoCommand = offCommands[no];
    }

    /**
     * 按下 撤销 命令
     */
    public void undoPushed() {
        undoCommand.undo();
    }
}
