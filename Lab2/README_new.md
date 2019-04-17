# Reference for Role-Permissions web service

### Setting up

- git clone https://github.com/Svedas/WebService_Restful
- docker-compose up --build -d

### Usage

Responses have these forms:

**Form format**

```json
{
	"message": "Information",
	"data": []
}
```

## List of all users

**Definition**

`GET /users`

**Response**

- `200 OK` on success

```json
{
	"message": "OK",
    "data": [
        {
            "email": "veryOrigina@gmail.com",
            "role": "Manager",
            "accessLevel": "One",
            "user": {
                "firstName": "Namer",
                "lastName": "Surnamer",
                "email": "veryOrigina;@gmail.com"
            }
        }
    ]
}
```


## Adding new user

**Definition**

`POST /users`

**Arguments**

- `"email":string`  user email
- `"role":string`  user role
- `"accessLevel":string`  user access level for his permissions


**Response**

- `201 Created` on success

```json
{
    "message": "Created",
    "data": {
        "email": "veryOrigina@gmail.com",
		"role": "Manager",
		"accessLevel": "One",
		"user": {
			"firstName": "Namer",
			"lastName": "Surnamer",
			"email": "veryOrigina;@gmail.com"
		}
    }
}
```


## Getting user info

**Definition**

`GET /users/<email>`

**Response**

- `200 OK` on success
- `404 Not Found` if client do not exists

```json
{
    "message": "OK",
    "data": {
        "email": "veryOrigina@gmail.com",
		"role": "Manager",
		"accessLevel": "One",
		"user": {
			"firstName": "Namer",
			"lastName": "Surnamer",
			"email": "veryOrigina;@gmail.com"
		}
    }
}
```

## Deleting user

**Definition**

`GET /users/<email>`

**Response**

- `204 No content` on success
- `404 Not Found` if client do not exists


## Updating client

**Definition**

`PUT /user/<email>`

**Arguments**

- `"role":string`  user role
- `"accessLevel":string`  user access level for his permissions

**Response**

- `200 OK` on success

```json
{
    "message": "OK",
    "data": {
        "email": "veryOrigina@gmail.com",
		"role": "Manager",
		"accessLevel": "One",
		"user": {
			"firstName": "Namer",
			"lastName": "Surnamer",
			"email": "veryOrigina;@gmail.com"
		}
    }
}
```