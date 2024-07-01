CREATE TABLE posts(
    id SERIAL NOT NULL PRIMARY KEY ,
    title VARCHAR(255),
    content TEXT,
    created_at DATE
)