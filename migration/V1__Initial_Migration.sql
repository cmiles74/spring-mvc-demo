CREATE TABLE todo_item (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    modified_at TIMESTAMP
);