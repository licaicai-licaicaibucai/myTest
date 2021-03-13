package com.limaolin.framework.servlet;


import com.limaolin.framework.anno.Controller;
import com.limaolin.framework.anno.RequestMapping;
import com.limaolin.framework.entry.MvcMethod;
import com.limaolin.framework.utils.ClassScannerUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包名:${PACKAGE_NAME}
 *
 * @author Leevi
 * 日期2020-08-01  12:06
 * init方法只在Servlet对象创建的时候执行一次
 *
 * 每一个方法都有应该有三部分: method、requestMappingValue、clazz，最终是根据requestMappingValue区匹配，然后执行method
 *                        Map<String,MvcMethod>
 */
public class DispatcherServlet extends HttpServlet {
    private Map<String,MvcMethod> mvcMethodMap = new HashMap<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            //读取servlet的初始化参数的值
            String scanPackage = config.getInitParameter("scanPackage");
            //将包扫描的代码写在init方法里面
            //第二部分: 获取Controller中的方法上的RequestMapping注解的值
            //获取controller包里面的所有类的字节码对象的List
            List<Class<?>> classList = ClassScannerUtils.getClasssFromPackage(scanPackage);
            if (classList != null) {
                for (Class<?> clazz : classList) {
                    //判断clazz对应的类上是否有Controller注解，如果有才获取它的所有方法
                    if (clazz.isAnnotationPresent(Controller.class)) {
                        //获取该字节码对象中的所有公有方法
                        Method[] methods = clazz.getMethods();
                        //遍历出每一个方法
                        for (Method method : methods) {
                            //先判断该方法上是否有RequestMapping注解
                            if (method.isAnnotationPresent(RequestMapping.class)) {
                                //获取方法上的RequestMapping注解的值
                                String requestMappingValue = method.getAnnotation(RequestMapping.class).value();
                                mvcMethodMap.put(requestMappingValue,new MvcMethod(method,clazz.newInstance()));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //第一部分: 获取要匹配的请求路径中的内容
            //1. 获取请求路径uri
            String uri = request.getRequestURI();
            //2. 从请求路径中进行截取"项目部署路径之后和.do之前"的那一部分
            //项目部署路径
            String contextPath = request.getContextPath();
            //要进行匹配的路径
            String mappingPath = uri.substring(contextPath.length(), uri.lastIndexOf("."));

            //判断请求路径中的mappingPath和RequestMapping注解的值是否匹配
            //第三部分: 判断mappingPath和requestMappingValue是否匹配，如果匹配则调用这个方法
            //就是用mappingPath匹配map中的key
            MvcMethod mvcMethod = mvcMethodMap.get(mappingPath);
            if (mvcMethod != null) {
                //执行方法
                mvcMethod.getMethod().invoke(mvcMethod.getObject(),request,response);
            }else {
                throw new RuntimeException("请求路径错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
