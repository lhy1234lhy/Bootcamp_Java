package com.wanted.cleanarchitecture.catalog.presentation.api.request;

public record CreateSectionRequest(
        Long authorId,
        String title,
        int sectionOrder
) {
}
