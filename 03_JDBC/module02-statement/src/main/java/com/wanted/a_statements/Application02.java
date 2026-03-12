package com.wanted.a_statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

public class Application02 {

    public static void main(String[] args) {

        /* comment.
         *   JDBC 의 핵심적인 인터페이스 2가지.
         *   1. Statement
         *   - SQL문을 저장하고 실행할 수 있는 기능을 가진 인터페이스
         *   2. ResultSet
         *   - SQL문 결과 집합을 받아올 수 있는 인터페이스
         *  */

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            // statement 는 Connection 을 통해 객체 생성
            stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("조회하실 사번을 입력해주쇼!! : ");
            String empId = sc.nextLine();
            String empName = sc.nextLine();

            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'");

            if(rset.next()){
                /* hi. next() : ResultSet 을 목록화 시켜
                 *   행이 존재하면 True, 존재하지 않으면 False를 반환한다.
                 * */
                System.out.println(rset.getString("EMP_ID") + "번 " +
                        rset.getString("EMP_NAME") + "사원"
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(con);
            close(rset);
        }


    }

}
