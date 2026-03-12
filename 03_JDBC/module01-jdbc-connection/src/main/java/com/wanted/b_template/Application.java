package com.wanted.b_template;

import java.sql.Connection;

import static com.wanted.b_template.JDBCTemplate.close;

public class Application {
    public static void main(String[] args) {

        Connection con = JDBCTemplate.getCConnection();
        System.out.println("con = " + con);
        close(con);

    }
}
