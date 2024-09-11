// Add a user 

curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
"username": "simran",
"password": "securePassword12345",
"firstName": "simran",
"lastName": "preet",
"email": "simran@preet.com"
}
'
Response: {
"status": "success",
"message": "User added successfully.",
}

// Add book 

curl --location 'http://localhost:8080/books' \
--header 'Content-Type: application/json' \
--data '{
"title": "The Great Gatsby",
"author": "F. Scott Fitzgerald"
}
'

Response:
{
"status": "success",
"message": "Book added successfully.",
"data": {
"id": 2,
"title": "The Great Gatsby",
"author": "F. Scott Fitzgerald",
"status": "AVAILABLE"
}
}


// Issue the book


curl --location 'http://localhost:8080/books/issue' \
--header 'Content-Type: application/json' \
--data '{
"userId": 2,
"bookId": 2,
"numberOfDays": 15
}
'

Response:
{
"status": "success",
"message": "Book issued successfully.",
"data": null
}


// Return book

curl --location 'http://localhost:8080/books/return' \
--header 'Content-Type: application/json' \
--data '{
"userId": 2,
"bookId": 2
}'
 Response:
{
"status": "success",
"message": "Book returned successfully.",
"data": null
}


// Get all books

curl --location 'http://localhost:8080/books'

Response:
{
"status": "success",
"message": "Books fetched successfully.",
"data": [
{
"id": 1,
"title": "The Great Gatsby",
"author": "F. Scott Fitzgerald",
"status": "ISSUED"
},
{
"id": 2,
"title": "The Great Gatsby",
"author": "F. Scott Fitzgerald",
"status": "AVAILABLE"
}
]
}


// Search Book

curl --location 'http://localhost:8080/books/search?title=The%20Great'

Response:

{
"status": "success",
"message": "Books found successfully.",
"data": [
{
"id": 1,
"title": "The Great Gatsby",
"author": "F. Scott Fitzgerald",
"status": "ISSUED"
},
{
"id": 2,
"title": "The Great Gatsby",
"author": "F. Scott Fitzgerald",
"status": "AVAILABLE"
}
]
}