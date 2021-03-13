package cn.limaolin.controller;

import com.itheima.framework.anno.Controller;
import com.itheima.framework.anno.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 包名:com.itheima.controller
 *
 * @author Leevi
 * 日期2020-08-01  12:04
 */

public class MemberController {

    public void addMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("addMember");
    }


    public void deleteMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("deleteMember");
    }
}
