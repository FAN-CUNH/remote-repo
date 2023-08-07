package com.fch.command;

import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.command
 * @ClassName Client
 * @Description TODO 命令模式客户端
 * @Author Fan-CUNH
 * @Date 2023/8/7 10:37
 * @Version 1.0
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        // 创建电灯对象(命令接收者)
        LightReceiver lightReceiver = new LightReceiver();

        // 创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        // 需要一个遥控器
        RemoteController remoteController = new RemoteController();

        // 给我们的遥控器设置命令，比如 no = 0 这一组是点灯的开和关的操作
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        log.info("--- 按下电灯的打开按钮 ---");
        remoteController.onPushed(0);
        log.info("--- 按下电灯的关闭按钮 ---");
        remoteController.offPushed(0);
        log.info("--- 按下撤销按钮 ---");
        remoteController.undoPushed();
    }
}
