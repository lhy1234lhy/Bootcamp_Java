package com.wanted.cleanarchitecture.catalog.application.usecase;

import com.wanted.cleanarchitecture.catalog.application.command.AddModuleCommand;
import com.wanted.cleanarchitecture.catalog.application.command.AddSectionCommand;
import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.application.command.PublishCourseCommand;

// UseCase는 명령(Command)을 처리(handle)하는 곳이다.
public interface CourseCommandUseCase {

    Long handle(CreateCourseCommand command);

    void handle(AddSectionCommand command);

    void handle(AddModuleCommand command);

    void handle(PublishCourseCommand command);

    // 반환해줄 값이 여러개면 record 써서 여러개 씀.
}
