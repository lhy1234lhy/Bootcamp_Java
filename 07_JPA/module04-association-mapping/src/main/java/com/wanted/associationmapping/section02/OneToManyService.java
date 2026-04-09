package com.wanted.associationmapping.section02;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OneToManyService {

    @Autowired
    private OneToManyRepository repository;

    @Transactional
    // 트랜젝션
    public Category findCategory(int categoryCode) {

        Category category = repository.find(categoryCode);

        return category;
    }
}
