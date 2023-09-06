package com.tsone.graphqlsample.controller;

import com.tsone.graphqlsample.mapper.AuthorMapper;
import com.tsone.graphqlsample.mapper.BookMapper;
import com.tsone.graphqlsample.types.Author;
import com.tsone.graphqlsample.types.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookMapper bookMapper;
    private final AuthorMapper authorMapper;

    public BookController(BookMapper bookMapper, AuthorMapper authorMapper) {
        this.bookMapper = bookMapper;
        this.authorMapper = authorMapper;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return this.bookMapper.getById(id);
    }

    @MutationMapping
    public String registerBook(
        @Argument String id,
        @Argument String name,
        @Argument int pageCount,
        @Argument String authorId
    ) {
        Book book =
            Book.builder().id(id).name(name).pageCount(pageCount).authorId(authorId).build();
        this.bookMapper.registerBook(book);
        return id;
    }

    @SchemaMapping
    public Author author(Book book) {
        return this.authorMapper.getById(book.getAuthorId());
    }
}
