package com.tsone.graphqlsample.controller;

import com.tsone.graphqlsample.mapper.AuthorMapper;
import com.tsone.graphqlsample.types.Author;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    private final AuthorMapper authorMapper;

    public AuthorController(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    @MutationMapping
    public String registerAuthor(
        @Argument String id,
        @Argument String lastName,
        @Argument String firstName
    ) {
        Author author =
            Author.builder().id(id).lastName(lastName).firstName(firstName).build();
        this.authorMapper.registerAuthor(author);
        return id;
    }
}
