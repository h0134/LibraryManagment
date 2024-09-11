CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    status VARCHAR(10) NOT NULL DEFAULT 'AVAILABLE'
);

CREATE TABLE issued_books (
    id SERIAL PRIMARY KEY,
    book_id INTEGER NOT NULL REFERENCES books(id),
    user_id INTEGER NOT NULL REFERENCES users(id),
    issue_date DATE NOT NULL,
    return_date DATE
);


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) NOT NULL UNIQUE,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

