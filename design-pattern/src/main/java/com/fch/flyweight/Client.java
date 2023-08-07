package com.fch.flyweight;

/**
 * @packageName com.fch.flyweight
 * @ClassName StaticClient
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/5 14:10
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        WebsiteFactory websiteFactory = new WebsiteFactory();
        Website website = websiteFactory.getWebsite("新闻");
        Website website1 = websiteFactory.getWebsite("博客");
        Website website2 = websiteFactory.getWebsite("博客");
        website.use(new User("张三"));
        website1.use(new User("李四"));
        website2.use(new User("王五"));
        websiteFactory.getWebsiteCount();
    }
}
