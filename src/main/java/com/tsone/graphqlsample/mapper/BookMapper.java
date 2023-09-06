package com.tsone.graphqlsample.mapper;

import com.tsone.graphqlsample.types.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {
    Book getById(@Param("id") String id);
    int registerBook(Book book);
}
