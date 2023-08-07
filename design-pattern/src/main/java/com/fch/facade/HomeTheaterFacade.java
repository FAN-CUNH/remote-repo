package com.fch.facade;

/**
 * @packageName com.fch.facade
 * @ClassName HomeTheaterFacade
 * @Description TODO 影院外观类
 * @Author Fan-CUNH
 * @Date 2023/8/4 15:09
 * @Version 1.0
 */
public class HomeTheaterFacade {
    // 聚合各个子系统 即各个电影院的组件
    private Light light;
    private Popcorn popcorn;
    private Stereo stereo;
    private Screen screen;
    private DVD dvd;
    private Projector projector;

    /**
     * 构造器 并且在实例化本类对象的时候 实例化其各个子组件
     */
    public HomeTheaterFacade() {
        this.light = Light.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.screen = Screen.getInstance();
        this.projector = Projector.getInstance();
        this.dvd = DVD.getInstance();
    }

    /**
     * 电影院播放准备工作
     */
    public void ready() {
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvd.play();
        light.on();
        light.dim();
    }

    /**
     * 电影院开始播放电影
     */
    public void play() {
        dvd.play();
    }

    /**
     * 电影院展厅播放电影
     */
    public void pause() {
        dvd.pause();
    }

    /**
     * 观影结束 电影院闭馆准备工作
     */
    public void end() {
        popcorn.off();
        screen.up();
        projector.off();
        stereo.off();
        dvd.off();
        light.off();
    }
}
