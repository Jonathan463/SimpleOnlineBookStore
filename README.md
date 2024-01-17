# Simple Book Store API

## Overview

Simple Book Store is a Restful API built using Spring Boot framework and Postgres Database with JPA for database interaction.

## Endpoints

### 1. addBook

#### Request
- Method: `POST`
- Path: `/addBook`
- Content-Type: `application/json`
- Headers:
  - `API-Key: abdakand_qwad`

##### Request Body
```json
{
  "name": "There was a country",
  "price": 2000,
  "category": "EDUCATIONAL",
  "language": "ENGLISH",
  "author": "Chinua Achebe"
}
Response
{
  "data": {
    "name": "There was a country",
    "price": 2000,
    "category": "EDUCATIONAL",
    "author": "Chinua Achebe",
    "delFlag": false,
    "language": "FRENCH"
  },
  "responseMsg": "Book Saved Successfully",
  "responseCode": "200"
}
2. getAllBook
Request
Method: GET
Path: /getAllBook
Headers:
API-Key: abdakand_qwad
Response
{
  "data": [
    {
      "name": "Things fall apart",
      "price": 2000.00,
      "category": "EDUCATIONAL",
      "language": "ENGLISH",
      "author": "Chinua Achebe"
    },
    // ... other books
  ],
  "responseMsg": "Success",
  "responseCode": "200"
}
3. updateBook
Request
Method: POST
Path: /updateBook
Content-Type: application/json
Headers:
API-Key: abdakand_qwad
Request Body
{
  "id": "3",
  "name": "48 laws of power",
  "price": 7000
}
Response
{
  "data": {
    "name": "48 laws of power",
    "price": 7000
  },
  "responseMsg": "Successfully updated",
  "responseCode": "200"
}
4. deleteBook
Request
Method: POST
Path: /deleteBook
Content-Type: application/json
Headers:
API-Key: abdakand_qwad
Request Body
{
  "id": "4"
}
Response
{
  "data": {
    "response": "Successfully Deleted"
  },
  "responseMsg": "Book with Id 4 has been logically deleted",
  "responseCode": "200"
}
Design Explanation
The service follows best standards, modularized using various packages such as model, service, repository, serviceImpl, util, authentication, controller, and enums. Logical deletion is implemented using a delFlag instead of permanently deleting a record. The Validator class is used for request validation, and HTTP status codes (e.g., 200, 201, 202, and 400) are employed.

Testing
The API was thoroughly tested using JUnit tests and Mockito tests.
