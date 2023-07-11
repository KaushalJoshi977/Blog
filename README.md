# Blog
with this applicaiton we can have following functionalities:-
1. Creating a new user by providing username and password.(@PostMapping)
2. Updating password for a User.(@PutMapping)
3. Adding blogs to a user.(@PostMapping)
4. Adding Images to blogs.(@PostMapping)
5. Find the number of images that can fit in a given screen.(@GetMapping)
7. Deleting user,blogs and images.(@DeleteMapping)

This application is made using concepts of Java, OOPs, DSA, SpringBoot, SpringMVC, JPA, Hibernate, MySQL. 

# We need to write configurations so that it connects to the MySql
# these are standard configurations to connect with DB

#Mandatory Step : Always create the database


#Write these properties as it is to make a connection with SQL.

spring.datasource.url=jdbc:mysql://localhost:3306/lms_rocks?createTableIfNotExists=true

#Set your login credentials here
spring.datasource.username=root
spring.datasource.password=


#We are writing this thing for hibernate
spring.jpa.hibernate.ddl-auto=update
#It means if the Entity has been modified :---> update the SQL table also



server.port=10000


