package com.wanted.cleanarchitecture.catalog.application.usecase;

import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.application.command.CreateSectionCommand;
import com.wanted.cleanarchitecture.catalog.presentation.api.response.CreateCourseResponse;

public interface CourseCommandUseCase {

    // 실제 어플리케이션 비즈니스 로직 실행
    Long handle(CreateCourseCommand command);
    Long handle(CreateSectionCommand command);

}
