FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app


# Copy the pom.xml file to the working directory
COPY pom.xml .

# Copy the source code to the working directory
COPY src src

# Fix the error: Error: Unable to access jarfile target/student-0.0.1-SNAPSHOT.jar
COPY target/student-0.0.1-SNAPSHOT.jar /app.jar

# The data.sql file is copied into the /docker-entrypoint-initdb.d/ directory. 
# This directory is recognized by some database containers (e.g., MySQL, PostgreSQL) 
# as the location to execute initialization scripts during container startup.
COPY src/main/resources/data.sql /docker-entrypoint-initdb.d/

# The ENV instruction sets the SPRING_DATASOURCE_URL environment variable within the Docker image
ENV SPRING_DATASOURCE_URL=jdbc:mysql://172.17.0.2:3306/dev_database

# Expose port 8080 from the container. 
# This is necessary for accessing the application running inside the container
EXPOSE 8080

# Run the application - command to run when the container starts.
ENTRYPOINT ["java", "-jar", "/app.jar"]