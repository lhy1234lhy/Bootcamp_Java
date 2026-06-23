package com.wanted.entitymapping.section02.embedded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional
    public void registBook(BookRegistDTO newBook) {

        // 이게 엔티티
        Book book = new Book(
                newBook.getBookTitle(),
                newBook.getAuthor(),
                newBook.getPublisher(),
                newBook.getCreatedDate(),
                new Price( // 임베드 가능하게
                        newBook.getRegularPrice(),
                        newBook.getDiscountRate()
                )
        );

        repository.save(book);

    }
}
