-- DROP TABLE ACCOUNT; DROP TABLE BOOK_STOCK; DROP TABLE BOOK;

CREATE TABLE bookstore.BOOK (
    ISBN         VARCHAR(50)    NOT NULL,
    BOOK_NAME    VARCHAR(100)   NOT NULL,
    PRICE        INT,
    PRIMARY KEY (ISBN)
);

CREATE TABLE bookstore.BOOK_STOCK (
    ISBN     VARCHAR(50)    NOT NULL,
    STOCK    INT            NOT NULL,
    PRIMARY KEY (ISBN),
    CONSTRAINT positive_stock CHECK (STOCK >= 0)
);

CREATE TABLE bookstore.ACCOUNT (
    USERNAME    VARCHAR(50)    NOT NULL,
    BALANCE     INT            NOT NULL,
    PRIMARY KEY (USERNAME),
    CONSTRAINT positive_balance CHECK (BALANCE >= 0)
);

INSERT INTO bookstore.BOOK( ISBN, BOOK_NAME, PRICE ) VALUES( '0001', 'The First Book', 30);
INSERT INTO bookstore.BOOK_STOCK(ISBN, STOCK) VALUES('0001', 10) ;
INSERT INTO bookstore.ACCOUNT(USERNAME, BALANCE) VALUES('user1',20);