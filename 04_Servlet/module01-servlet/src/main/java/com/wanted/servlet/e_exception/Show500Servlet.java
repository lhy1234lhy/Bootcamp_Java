package com.wanted.servlet.e_exception;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/show500error")
public class Show500Servlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("500 Servlet 호출됨");
        resp.sendError(500, "505번 에러는 개발자의 100% 실수!!");
    }
}
