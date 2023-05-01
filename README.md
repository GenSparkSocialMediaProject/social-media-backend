# Social Media Forum Group Project

WORKING TITLE: "SPEAKR"

A social media forum sort of like Reddit or Twitter.

This is a group project for a class using Spring Boot and MySQL on the back end, 
and React on the front end. The build tool is Maven.

## Database

The database would have at least two tables, one for users and one for posts.

### User

A user record must have:

* `User_UUID` (from `user_tbl`)
* Name (`String`)
* Username (`String`)
* Join date (time)
* Bio (`String` up to 120 characters, may not be empty)
* Profile picture (if we have time to implement the feature before the project 
 deadline)

### Post

A post record must have:

* `Post_ID` (`String`)
* `User_UUID` of the user posting the post (User from `user_tbl`) 
* `Password` (`String`) hashed with bcrypt
* `Timestamp` (time)
* `Upvoters` (JSON `UserID[]`?)
* `Downvoters` (JSON `UserID[]`?)
* `Content` (`String` up to 256 characters)

A post record may have:

* IDs of replies
* Last updated? (users may edit their own posts?)

## Web server

### Entity controllers

* `UserController`
* `PostController`

### RESTful API

#### Users

* Create user
* Get all users
* Update user
* Delete user

##### Posts

* Get all posts (homepage)
* Get all posts from specific time to now
* Get all posts from specific user
* Get all replies referring to parent post
* Create new post
* Delete post
* Update post content
