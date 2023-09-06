package com.tsone.graphqlsample.mapper;

import com.tsone.graphqlsample.types.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorMapper {
    Author getById(@Param("id") String id);
    int registerAuthor(Author author);
}
