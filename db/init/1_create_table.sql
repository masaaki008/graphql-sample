create table if not exists Author(
    id varchar(256),
    first_name varchar(256),
    last_name varchar(256),
    PRIMARY KEY (id)
);

create table if not exists Book(
    id varchar(256),
    name varchar(256),
    page_count int,
    author_id varchar(256),
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES Author(id)
);
