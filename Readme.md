## Spring Boot File Upload / Download Rest API Example

**Tutorial**: [
1- This is used to store receive the files in REST post call and store to database
2- Storing the files to database for data privacy and prtection act.
3- Storing the file also helps to keep clients records handy at time of need
4- Storing the words of files into dictionary and retriving on the fly as and when needed.
5- Insertion takes O(N) and Retrieval takes O(N) 
   
]


## Steps to Setup

**1. Clone the repository** 

```bash
git clone https://github.com/ab48917/spring-boot-file-to-dictionary.git
```

**2. Configure MySQL database**

Create a MySQL database named `file_demo`, and change the username and password in `src/main/resources/application.properties` as per your MySQL
installation -

```properties
spring.datasource.username= <YOUR MYSQL USERNAME>
spring.datasource.password= <YOUR MYSQL PASSWORD>
```

**3. Run the app using maven**

```bash
cd spring-boot-file-to-dictionary
mvn spring-boot:run
```

That's it! The application can be accessed at `http://localhost:8080`.

You may also package the application in the form of a jar and then run the jar file like so -

```bash
mvn clean package
java -jar target/spring-boot-dictionary-0.0.1-SNAPSHOT.jar
```