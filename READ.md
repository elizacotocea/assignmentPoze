# Assignment

Build a small REST API that manages photos.

### Configuration TODOs
Have a look over the existing configuration (application.properties) and understand how they work.

- Update database config (user/password)
- Create database in pgAdmin


### Functional TODOs

Each user has a first name, last name, username and a password. 
Each photo has a size, type, venue and an owner (i.e. the user who took the picture).

You need to be able to: 

- create users and photos
    - the username and the password of a user are mandatory
    - the length of the username should not exceed 100 characters
    - only the png, jpg files are supported
    - jpg files are supported to have at most a size of 150 and png files a size of 230 (unit doesn't matter)
- retrieve users and photos
    - the users can be retrieve sorted by username, first name or last name, either ascending or descending
    - the photos will be retrieved paginated; with a default of 10 photos per page 
- retrieve the photos of a certain user
- retrieve the photos from a given venue
- retrieve the users by first name

Create a test for the user creation endpoint.
