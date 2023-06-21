package com.fch.servlet;


import com.alibaba.fastjson.JSON;
import com.fch.bean.Category;
import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.bean.User;
import com.fch.filter.Filter;
import com.fch.service.UserService;
import com.fch.service.impl.UserServiceImpl;
import com.fch.utils.CodeUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @packageName ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/6 14:27
 * @Version 1.0
 */
@WebServlet("*.action")
public class Servlet extends HttpServlet {

    /**
     * 调用 userService
     */
    UserService userService = null;

    public Servlet() {
        userService = new UserServiceImpl();
    }

    public static final Logger log = Logger.getLogger(Filter.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求uri
        String uri = request.getRequestURI();

        // 实例化CodeUtils工具类
        CodeUtils codeUtils = new CodeUtils();

        // 登录接口，判断当前用户是否登录
        if (uri.endsWith("load.action")) {
            // 声明一个 loadUser 用于接收登录对象
            User loadUser = null;

            // 1.获取前端请求的userId, password
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            log.info("userId：" + userId + "  password:" + password);

            // 2.验证是否登录
            loadUser = userService.userLoad(userId, password);
            if (loadUser != null) {
                // 3.登录用户存在于数据库。 将登录用户放入域中
                request.getSession().setAttribute("loaded", loadUser);

                // 4. 将商品分页数据第一页存入域中
                request.getSession().setAttribute("page", userService.getPage(1, 10));

                // 4.转发到showMess页面
                request.getRequestDispatcher("showMess.jsp").forward(request, response);
            } else {
                // 5.重定向到 load.jsp界面
                response.sendRedirect("load.jsp");
            }

        }

        // 根据商品分页展示
        else if (uri.endsWith("getMess.action")) {
            /*
             *   先传值，在转发
             */
            // 1.请求域传值  分页信息
            int currentPage = 1;
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }

            Page<Map<String, Object>> page = userService.getPage(currentPage, 10);

            request.getSession().setAttribute("page", page);

            // 3.登录成功，将request, response转发到showMess.jsp
            request.getRequestDispatcher("showMess.jsp").forward(request, response);
        }

        // 通过pid和pname查询商品信息
        else if (uri.endsWith("selectProduct.action")) {
            String pid = request.getParameter("pid");
            String panme = request.getParameter("pname");
            log.info("通过pid查询商品：" + pid);
            List<Map<String, Object>> proMess = userService.selectProductMess(pid, panme);
            if (proMess == null) {
                log.info("后端响应的JSON字符串:" + proMess);
                log.info(request.getSession().getAttribute("loaded").toString());
            } else {
                String proMessJson = JSON.toJSONString(proMess);
                log.info("后端响应的JSON字符串:" + proMessJson);
                response.getWriter().print(proMessJson);
            }
        }

        // 获取验证码
        else if (uri.endsWith("getCode.action")) {
            Random r = new Random();
            //设置响应格式为图片.jpg
            response.setContentType("image/jpeg");
            //创建一个不带透明色的对象 图片对象 三原色
            BufferedImage bufferedImage = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
            //获取画布对象

            Graphics g = bufferedImage.getGraphics();
            //设置背景颜色
            Color bgColor = codeUtils.getBackColor();
            g.setColor(bgColor);
            //画背景
            g.fillRect(0, 0, 80, 30);
            //设置前景色
            Color foreColor = codeUtils.getForeColor(bgColor);
            g.setColor(foreColor);

            //设置字体
            g.setFont(new Font("黑体", Font.BOLD, 26));
            //将随机字符串存到session
            String randomStr = codeUtils.getRandomStr();
            HttpSession session = request.getSession();
            session.setAttribute("code", randomStr);
            //画
            g.drawString(randomStr, 10, 28);
            //画噪点 干扰
            for (int i = 0; i < 30; i++) {
                g.setColor(Color.white);
                int x = r.nextInt(80);
                int y = r.nextInt(30);
                g.fillRect(x, y, 1, 1);
            }

            //将图片输出到响应流
            ServletOutputStream sos = response.getOutputStream();
            //把图片写到输出流区
            ImageIO.write(bufferedImage, "jpeg", sos);
        }

        // 验证验证码是否正确
        else if (uri.endsWith("checkCodeIsRight.action")) {
            // 1.获取前端请求数据
            String code = request.getParameter("code");
            log.info("前端发送的Code码：" + code);

            // 2.获得 session 中的code
            Object codeAttribute = request.getSession().getAttribute("code");
            log.info("后端生成的Code码：" + codeAttribute);

            // 3.判断两个 code 是否相同

            String codeJson = JSON.toJSONString(String.valueOf(codeAttribute.equals(code)));
            log.info(codeJson);
            response.getWriter().print(codeJson);
        }

        // 通过 pid 删除单个商品信息
        else if (uri.endsWith("deleteProductByPid.action")) {
            // 0.获取前端请求的数据
            String pid = request.getParameter("dele");
            log.info("需要删除的单个商品条目pid:" + pid);

            // 1.声明一个boolean变量用于存储更新数据的标记
            boolean flag = userService.deleteProductByPid(pid);

            // 2.根据结果做出响应
            if (flag) {
                // 删除成功，重定向到展示信息界面
                request.getRequestDispatcher("getMess.action").forward(request, response);
                log.info("删除单个商品成功！");
            } else {
                // 删除失败，弹框失败
                log.info("删除单个商品失败！");
            }
        }

        // 批量删除
        else if (uri.endsWith("deleteAllProductById.action")) {
            // 0.获取前端请求参数 str
            String[] allPid = request.getParameterValues("str");
            StringBuilder pids = new StringBuilder();
            for (String s : allPid) {
                pids.append(s).append(", ");
            }
            String substring = pids.toString().substring(0, pids.length() - 2);
            System.out.println("批量删除商品的pid：" + substring);
            boolean deleAllById = userService.deleteAllProductById(substring);
            System.out.println("批量删除是否成功：" + deleAllById);
            if (deleAllById) {
                // 删除成功
                /*request.getRequestDispatcher("getMess.action").forward(request, response);*/
                response.getWriter().print("<script>window.location='showMess.jsp'</script>");
                System.out.println("批量删除成功");

            } else {
                System.out.println("批量删除失败");
            }
        }
        // 显示勾选后显示最后一个商品的信息
        else if (uri.endsWith("showCheckedMess.action")) {
            // 0.获取前端请求参数 pid
            String pid = request.getParameter("pid");
            System.out.println("勾选后的pid：" + pid);

            // 1.获取需要展示的信息
            Product product = userService.showCheckedMess(pid);
            String jsonString = JSON.toJSONString(product);

            // 2.响应数据
            response.getWriter().print(jsonString);

        } else if (uri.endsWith("addProduct.action")) {
            //前端拿值
            String pid = "";
            String pname = "";
            double shop_price = 0;
            String cid = "";
            String pimage = null;

            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            List<FileItem> fileItems;
            try {
                fileItems = servletFileUpload.parseRequest(request);
                for (FileItem f :
                        fileItems) {
                    if (f.isFormField()) {
                        //普通项
                        String name = f.getName();
                        if ("pid".equals(f.getFieldName())) {
                            pid = f.getString("UTF-8");
                        } else if ("pname".equals(f.getFieldName())) {
                            pname = f.getString("UTF-8");
                        } else if ("shop_price".equals(f.getFieldName())) {
                            shop_price = Double.parseDouble(f.getString("UTF-8"));
                        } else if ("selcategory".equals(f.getFieldName())) {
                            cid = f.getString("UTF-8");
                        }
                        String value = f.getString("UTF-8");
                        System.out.println(name + "=" + value);
                    } else {
                        //文件上传项
                        //1 获取文件名
                        String fileName = f.getName();
                        System.out.println("这是我要上传的文件图片名：" + fileName);
                        //2 获取输入流
                        InputStream inputStream = f.getInputStream();
                        String realPath = request.getServletContext().getRealPath("products");
                        FileOutputStream fileOutputStream = new FileOutputStream(realPath + File.separator + fileName);
                        pimage = "products" + File.separator + fileName;
                        System.out.println("存入数据库文件名：" + pimage);

                        System.out.println("这是真实路径：" + (realPath + File.separator + fileName));
                        //3 读文件写文件
                        int len = 0;
                        byte[] bs = new byte[1024];
                        while ((len = inputStream.read(bs)) != -1) {
                            fileOutputStream.write(bs, 0, len);
                        }

                        /*  response.sendRedirect(request.getContextPath() + File.separator + "showImg.jsp");*/
                    }

                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Product product = new Product();
            product.setPid(pid);
            product.setPname(pname);
            product.setShop_price(shop_price);
            System.out.println("shop_price类型" + shop_price);
            product.setPimage(pimage);
            product.setCid(cid);
            boolean result = userService.addProducts(product);
            System.out.println("是否添加成功："+result);

            response.setCharacterEncoding("gbk");

            if (result) {
                response.getWriter().print("<script>alert('添加成功');window.location='" + request.getContextPath() + "/showMess.jsp'</script>");
            } else {
                response.getWriter().print("<script>alert('失败');window.location='" + request.getContextPath() + "/addProduct.jsp'</script>");
            }
            System.out.println("______________________________________");
            System.out.println("pid= " + pid + " pname= " + pname + " shop_price= " + shop_price + " selCategory " + cid);

        } else if (uri.endsWith("selectCategory.action")) {
            // 获取所有商品类别信息
            List<Category> list = userService.getCategory();
            String categoryString = JSON.toJSONString(list);
            System.out.println(list + "\n" + categoryString);
            response.getWriter().print(categoryString);
        }
    }
}
