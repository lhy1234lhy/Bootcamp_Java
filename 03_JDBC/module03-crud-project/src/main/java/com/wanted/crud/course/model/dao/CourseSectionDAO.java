package com.wanted.crud.course.model.dao;

import java.sql.Connection;

public class CourseSectionDAO {

    private final Connection connection;

    // 생성자를 통한 초기화
    public CourseSectionDAO(Connection connection) {
        this.connection = connection;
    }
}
