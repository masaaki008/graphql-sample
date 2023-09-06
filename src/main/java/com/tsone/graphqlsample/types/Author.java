package com.tsone.graphqlsample.types;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Author {
    private String id;
    private String firstName;
    private String lastName;
}
