# Backend Lab 1
Author: Mykhailo Balakhon IM-22, Order in group: 1st
Variant: 1 (Currency)

## Run instructions

1. **Clone the Repository:**
   Use a version control tool like Git to clone the repository to your local machine. Open a terminal or command prompt and run the following command:
   ```bash
   git clone <repository_url>
   ```

2. **Navigate to the Project Directory:**
   Change your working directory to the one where the Java application is located. Use the `cd` command:
   ```bash
   cd <project_directory>
   ```

3. **Build the Project (if needed):**
   You need maven build tool to build the project and run tests using:
   ```bash
   mvn clean package
   ```

4. (1) **Run the Application:**
   Find an executable JAR file and run it using:
   ```bash
   java -jar target/<jar_file_name>.jar
   ```
4. (2) **Run the Docker-compose application:**
   Build lab docker image using:
   ```bash
   docker build . -t backend-lab:latest
   ```
   Start the application using:
   ```bash
   docker compose up
   ```
