# Fix for ClassNotFoundException: com.flowershop.FlowershopApplication

## Problem
`java.lang.ClassNotFoundException: com.flowershop.FlowershopApplication`

## Root Cause
The compiled class file is not found in the classpath, usually due to:
1. Corrupted Maven build
2. Missing or incorrect main class configuration
3. Compilation errors not properly resolved

## Solution Applied

### 1. Added Main Class to pom.xml
Modified the `spring-boot-maven-plugin` configuration to explicitly specify the main class:

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <mainClass>com.flowershop.FlowershopApplication</mainClass>
        <excludes>
            <exclude>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
            </exclude>
        </excludes>
    </configuration>
</plugin>
```

### 2. Steps to Resolve

Run these commands in order:

```bash
# 1. Clean the project (remove all compiled files)
./mvnw clean

# 2. Compile the project
./mvnw compile

# 3. Package the application
./mvnw package -DskipTests

# 4. Run the application
./mvnw spring-boot:run
```

OR use your IDE:
- **IntelliJ IDEA**: Right-click on project → Maven → Reload Project → Run FlowershopApplication
- **Eclipse**: Right-click on project → Maven → Update Project → Run As → Spring Boot App

### 3. Verify the Main Class

The `FlowershopApplication.java` file is correct:
```java
package com.flowershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlowershopApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowershopApplication.class, args);
    }
}
```

### 4. Alternative: Run from JAR

After packaging, you can run directly from the JAR:
```bash
java -jar target/flowershop-0.0.1-SNAPSHOT.jar
```

## Expected Result
After running `./mvnw spring-boot:run`, you should see:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.2)

... Application started successfully
```

## If Issue Persists

1. **Delete target directory manually**:
   ```bash
   rm -rf target/
   ```

2. **Delete IDE-specific files**:
   ```bash
   rm -rf .idea/
   rm -rf .classpath .project .settings/
   ```

3. **Reimport Maven project** in your IDE

4. **Check Java version**:
   ```bash
   java -version
   # Should be Java 17 or higher
   ```

5. **Verify file encoding**: Ensure all Java files are UTF-8 encoded

## Changes Made to Fix
✅ Added explicit `<mainClass>` configuration in pom.xml
✅ Verified FlowershopApplication.java is correct
✅ Ensured package structure is: `com.flowershop.FlowershopApplication`


mongodb started
brew services start mongodb-community@7.0

mongodb-community@7.0  stopped


//port 8080 is in use
lsof -i :8080

kill -9 12345

mvn spring-boot:run
./mvnw spring-boot:run


✅ Option 3: Temporary port via command line
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8082


