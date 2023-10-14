# Spring Boot With Java Project Template

<BR>

### Tech Stack
- Spring Boot 2.7.13-SNAPSHOT
- Java 17

<BR>

### How to use (based on Intelij)
1. Download release tag by zip
2. Change project name.
    - directory
    - settings.gradle > rootProject.name
3. Delete ".gradle", ".idea" directory only once. And reopen project.
4. Change "Build and Run" configuration. (gradle -> InteliJ IDEA)
5. Run ApiServerApplication

<BR>

### Run Configuration
(1) DB

```bash
$ docker pull mysql:8
$ docker run --name local-mysql -e MYSQL_ROOT_PASSWORD=${PASSWORD} -d -p 3306:3306 mysql:8
```

(2) Application
1. VM Option <BR>
```
-Dspring.profiles.active=core,local -Ddb.url={URL} -Ddb.user={USER} -Ddb.password={PASSWORD}
```

<BR>

### Feature
#### API Server
1. REST API

#### Core
1. Spring Data JPA
2. Mybatis
3. AOP

#### Batch Server
1. Tasklet
2. Reader + (Processor) + Writer
3. ShedLock
4. Spring Schedule

<BR>

--- 

<BR>
