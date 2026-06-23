package com.wanted.servlet.f_forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// 응답 특화 서블릿

@WebServlet("/print")
public class ResponseLoginSuccessServlet extends HttpServlet {

    /* hi.
    *   forward 받은 서블릿에서도 요청방식이 get이면 doGet,
    *   post 이면 doPost를 오버라이딩 해야한다.
    *  */

    // 최초에 요청받을 때 post로 받았기 떄문에 응답할 때도 doPost를 가여옴
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getAttribute("userId").toString();
        System.out.println("/print 서블릿이 전달 받은 userId : " + userId);

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")
                .append(userId)
                .append("님 환영합니다.</h3>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.print(responseText.toString());

        out.flush();
        out.close();

    }
}
