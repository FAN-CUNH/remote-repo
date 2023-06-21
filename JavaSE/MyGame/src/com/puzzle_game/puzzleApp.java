package com.puzzle_game;

import com.puzzle_game.ui.GameJFrame;
import com.puzzle_game.ui.LoginJFrame;
import com.puzzle_game.ui.RegisterJFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName puzzleApp
 * @Description 游戏程序
 * @Author Cunhao Fan
 * @Date 2023/5/7 20:00
 * @Version 1.0
 */
public class puzzleApp {
    public static void main(String[] args) {
        new GameJFrame();
        new LoginJFrame();
        new RegisterJFrame();
    }
}
