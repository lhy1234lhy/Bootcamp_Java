package com.wanted.crud;

import com.wanted.crud.course.controller.CourseController;
import com.wanted.crud.course.model.service.CourseService;
import com.wanted.crud.course.view.CourseInputView;
import com.wanted.crud.course.view.CourseOutputView;
import com.wanted.crud.global.config.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) {

        // connection 만들기 (try-with-resource 문으로 감싸기, catch절 추가)
        try (Connection con = JDBCTemplate.getConnection()) {

            System.out.println("✅ 데이터베이스 연결 성공!!!");
            JDBCTemplate.printConnectionStatus();

            /* hi.
            *   request 시
            *   Application -> CourseInputView -> CourseController -> CourseService
            *   -> CourseDAO -> MySQL(RDBMS)
            *   response 시
            *   역순이다. 다만 CourseOutputView를 통해 결과물을 보여줄 것이다,
            *   역순으로 만들어봐라. 패키지를 나눠서 역할 분배
            * */

            /**
             * @deprecated 현재 아래에 작성 될 코드는 나중에는 사라지는 코드
             * */

            CourseService service = new CourseService(con); // con -> ser
            CourseController controller = new CourseController(service); // ser -> con
            CourseOutputView outputView = new CourseOutputView();
            CourseInputView inputView = new CourseInputView(controller, outputView);

            /* Application 이 실행되면 View 메소드 호출한다. */
            inputView.displayMainMenu();


        } catch (SQLException e) {
            System.err.println("🚨 데이터베이스 연결 실패"); // err + enter
        } finally{
            JDBCTemplate.close();
        }

    }

}
