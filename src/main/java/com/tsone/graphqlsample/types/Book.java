package com.tsone.graphqlsample.types;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private String id;
    private String name;
    private int pageCount;
    private String authorId;
}
