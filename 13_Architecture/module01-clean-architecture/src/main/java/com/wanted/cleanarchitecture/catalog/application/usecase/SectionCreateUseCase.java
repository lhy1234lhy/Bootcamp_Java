package com.wanted.cleanarchitecture.catalog.application.usecase;

import com.wanted.cleanarchitecture.catalog.application.command.CreateCourseCommand;
import com.wanted.cleanarchitecture.catalog.application.command.CreateSectionCommand;

public interface SectionCreateUseCase {
    Long handle(CreateSectionCommand command);
}
