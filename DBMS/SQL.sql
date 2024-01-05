-- Create Database
CREATE DATABASE LibraryDB;

-- Use the created database
USE LibraryDB;

-- Create Books Table
CREATE TABLE Books (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(200) NOT NULL,
    ISBN VARCHAR(50),
    PublicationDate DATE,
    CONSTRAINT UC_ISBN UNIQUE (ISBN)
);

-- Create Authors Table
CREATE TABLE Authors (
    AuthorID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    CONSTRAINT UC_AuthorEmail UNIQUE (Email)
);

-- Create BookAuthors Table for Many-to-Many Relationship
CREATE TABLE BookAuthors (
    BookID INT,
    AuthorID INT,
    Contribution VARCHAR(100),
    PRIMARY KEY (BookID, AuthorID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID),
    FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID)
);

-- Basic Queries

-- Select all books
SELECT * FROM Books;

-- Select distinct authors' last names
SELECT DISTINCT LastName FROM Authors;

-- Select books with title 'Java Programming'
SELECT * FROM Books WHERE Title = 'Java Programming';

-- Select books with title 'Java Programming' or author 'John Doe'
SELECT * FROM Books WHERE Title = 'Java Programming' OR (SELECT LastName FROM Authors WHERE AuthorID = BookAuthors.AuthorID) = 'Doe';

-- Order books by publication date in ascending order
SELECT * FROM Books ORDER BY PublicationDate ASC;

-- Insert a new book
INSERT INTO Books (Title, ISBN, PublicationDate) 
VALUES ('Python Basics', '978-1234567890', '2021-06-20');

-- Update ISBN for book with BookID 1
UPDATE Books SET ISBN = '978-0987654321' WHERE BookID = 1;

-- Delete author with AuthorID 3
DELETE FROM Authors WHERE AuthorID = 3;

-- Select top 3 books
SELECT * FROM Books LIMIT 3;

-- Select authors with first name starting with 'J'
SELECT * FROM Authors WHERE FirstName LIKE 'J%';

-- Select books with IDs 1, 2, 3
SELECT * FROM Books WHERE BookID IN (1, 2, 3);

-- Alias: Select Title as Book_Title, PublicationDate as Pub_Date from Books
SELECT Title AS Book_Title, PublicationDate AS Pub_Date FROM Books;

-- Join Operations

-- Inner Join: List books and their authors
SELECT Books.Title, Authors.FirstName, Authors.LastName FROM Books 
INNER JOIN BookAuthors ON Books.BookID = BookAuthors.BookID 
INNER JOIN Authors ON BookAuthors.AuthorID = Authors.AuthorID;

-- Left Join: List all books and their authors
SELECT Books.Title, Authors.FirstName, Authors.LastName FROM Books 
LEFT JOIN BookAuthors ON Books.BookID = BookAuthors.BookID 
LEFT JOIN Authors ON BookAuthors.AuthorID = Authors.AuthorID;

-- Right Join: List all authors and their books
SELECT Books.Title, Authors.FirstName, Authors.LastName FROM Books 
RIGHT JOIN BookAuthors ON Books.BookID = BookAuthors.BookID 
RIGHT JOIN Authors ON BookAuthors.AuthorID = Authors.AuthorID;

-- Full Join (Union of Left and Right Join): List all books and their authors, and all authors and their books
SELECT Books.Title, Authors.FirstName, Authors.LastName FROM Books 
LEFT JOIN BookAuthors ON Books.BookID = BookAuthors.BookID 
LEFT JOIN Authors ON BookAuthors.AuthorID = Authors.AuthorID
UNION
SELECT Books.Title, Authors.FirstName, Authors.LastName FROM Books 
RIGHT JOIN BookAuthors ON Books.BookID = BookAuthors.BookID 
RIGHT JOIN Authors ON BookAuthors.AuthorID = Authors.AuthorID;

-- Other Operations

-- Union: Combine distinct lists of book titles and author names
SELECT Title FROM Books
UNION
SELECT CONCAT(FirstName, ' ', LastName) FROM Authors;

-- Create Index on LastName in Authors table
CREATE INDEX idx_author_lastname ON Authors (LastName);

-- Drop a temporary table (if exists)
DROP TABLE IF EXISTS TempTable;

-- Alter Table: Add a new column 'Country' to Authors table
ALTER TABLE Authors ADD COLUMN Country VARCHAR(50);

-- View: Create a view of authors with first and last names
CREATE VIEW AuthorView AS SELECT FirstName, LastName FROM Authors;
