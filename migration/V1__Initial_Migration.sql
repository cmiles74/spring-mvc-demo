CREATE TABLE todo_item (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    description TEXT NOT NULL,
    completed_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT now(),
    modified_at TIMESTAMP
);