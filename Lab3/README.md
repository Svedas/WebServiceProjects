# Reference for Role-Permissions web service

### Setting up

- git clone https://github.com/Svedas/WebServiceProjects
- docker-compose up --build -d

### Usage

## List of all users

```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getUsers xmlns:ns2="http://ws_soap/">
        </ns2:getUsers>
    </S:Body>
</S:Envelope>
```xml

## List of all users with delailed info

```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getUsersWithInfo xmlns:ns2="http://ws_soap/">
        </ns2:getUsersWithInfo>
    </S:Body>
</S:Envelope>
```xml

## Add user

```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addUser xmlns:ns2="http://ws_soap/">
        	<email>petri@gmail.com</email>
        	<role>Manager</role>
        	<accessLevel>One</accessLevel>
        </ns2:addUser>
    </S:Body>
</S:Envelope>
```xml

## Get user 

```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getUser xmlns:ns2="http://ws_soap/">
        	<email>hax@gmail.com</email>
        </ns2:getUser>
    </S:Body>
</S:Envelope>
```xml

## Edit user

```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:putUser xmlns:ns2="http://ws_soap/">
        	<email>hax@gmail.com</email>
        	<role>Manager</role>
        	<accessLevel>OneTwo</accessLevel>
        </ns2:putUser>
    </S:Body>
</S:Envelope>
```xml

## Delete user

```xml
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:deleteUser xmlns:ns2="http://ws_soap/">
        	<email>hax@gmail.com</email>
        </ns2:deleteUser>
    </S:Body>
</S:Envelope>
```xml

# Prefilled database

```json
{
    "message": "Success",
    "data": [
        {
            "firstName": "Bill",
            "lastName": "Gates",
            "email": "gates@gmail.com"
        },
        {
            "firstName": "Elon",
            "lastName": "Musk",
            "email": "musk@gmail.com"
        },
        {
            "firstName": "Petras",
            "lastName": "Petri",
            "email": "petri@gmail.com"
        },
        {
            "firstName": "Mark",
            "lastName": "Zucc",
            "email": "zucc@gmail.com"
        },
        {
            "firstName": "Hacker",
            "lastName": "hax",
            "email": "hax@gmail.com"
        }
    ]
}
```json













