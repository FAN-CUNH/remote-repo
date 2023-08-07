package com.fch.facade;

/**
 * @packageName com.fch.facade
 * @ClassName StaticClient
 * @Description TODO 客户端
 * @Author Fan-CUNH
 * @Date 2023/8/4 14:07
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
    }
}
