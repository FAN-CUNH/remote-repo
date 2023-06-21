package com.fch.listener;
/**
 * @packageName ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/5 19:17
 * @Version 1.0
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Public constructor is required by servlet spec
     */
    public Listener() {
    }

    /**
     * ServletContextListener implementation:
     *
     *      This method is called when the servlet context is
     *      initialized(when the Web application is deployed).
     *      You can initialize servlet context related data here.
     *
     *      此时应用程序已初始化（部署 Web 应用程序时）。
     *      您可以在此处初始化与应用程序相关的数据。
     *
     * @param sce 应用程序事件
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application is initialized");

        // 1.通过事件获取程序事件源
        ServletContext servletContext = sce.getServletContext();

        // 2.通过事件源初始化数据
        servletContext.setAttribute("online", 0);
    }

    /**
     * ServletContextListener implementation:
     *
     *      This method is invoked when the Servlet Context
     *      (the Web application) is destroyed or
     *      Application Server shuts down.
     *
     *      此方法调用时Web应用程序未部署或应用程序服务器关闭。
     *
     * @param sce 应用程序事件
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application is destroyed");

        // 清除数据
        sce.getServletContext().removeAttribute("online");
    }


    /**
     * HttpSessionListener implementation:
     *
     *      session is created.
     *
     *      session被创建
     *
     * @param se session 事件
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session is created.");

        // 1.获取应用程序域
        ServletContext servletContext = se.getSession().getServletContext();

        // 2.获取属性数据 +1
        int online = (int) servletContext.getAttribute("online");
        online = online + 1;

        // 3.刷新属性数据
        servletContext.setAttribute("online",online);
    }

    /**
     * HttpSessionListener implementation:
     *
     * Session is destroyed.
     *
     * @param se session 事件
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session is destroyed.");

        // 1.获取应用程序域
        ServletContext servletContext = se.getSession().getServletContext();

        // 2.获取属性数据 -1
        int online = (int) servletContext.getAttribute("online");
        online = online - 1;

        // 3.刷新属性数据
        servletContext.setAttribute("online",online);
    }


    /**
     * HttpSessionAttributeListener implementation:
     *
     *      This method is called when an attribute is added to a session.
     *
     *      调用此方法时将属性添加到会话。
     *
     * @param sbe
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {

    }

    /**
     * HttpSessionAttributeListener implementation:
     *
     *      This method is called when an attribute is removed from a session.
     *
     *      调用此方法将属性时从会话中删除。
     *
     * @param sbe
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {

    }

    /**
     * HttpSessionAttributeListener implementation:
     *
     *      This method is invoked when an attribute is replaced in a session.
     *
     *      调用此方法将属性时在会话中被替换。
     *
     * @param sbe
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}
