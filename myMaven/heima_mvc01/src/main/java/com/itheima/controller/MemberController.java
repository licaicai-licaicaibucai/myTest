package com.itheima.controller;


import com.limaolin.framework.anno.Controller;
import com.limaolin.framework.anno.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class MemberController {
    @RequestMapping("/member/addMember")
    public void addMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("addMember");
    }

    @RequestMapping("/member/deleteMember")
    public void deleteMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("deleteMember");
    }
}
