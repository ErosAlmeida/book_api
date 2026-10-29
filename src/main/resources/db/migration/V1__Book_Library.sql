CREATE TABLE book (
                      id UUID PRIMARY KEY,
                      nome VARCHAR(100) NOT NULL,
                      description VARCHAR(255) NOT NULL,
                      quantity INT NOT NULL DEFAULT 0,
                      quantity_lent INT NOT NULL DEFAULT 0,
                      date DATE NOT NULL
);