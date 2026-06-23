package com.wanted.cleanarchitecture.catalog.application.command;

public record CreateSectionCommand(
        Long authorId,
        String title,
        int sectionOrder,
        Long courseId
) {

}
