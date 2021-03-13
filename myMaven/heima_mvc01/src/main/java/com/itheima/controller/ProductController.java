package com.itheima.controller;

import com.limaolin.framework.anno.Controller;
import com.limaolin.framework.anno.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 包名:com.itheima.controller
 *
 * @author Leevi
 * 日期2020-08-01  12:04
 */
@Controller
public class ProductController {
    @RequestMapping("/product/addProduct")
    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("addProduct");
    }

    @RequestMapping("/product/deleteProduct")
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("deleteProduct");
    }
}
