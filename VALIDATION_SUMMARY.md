# User Model Validation Summary

## All Fields with Proper Validation

### ✅ Completed Validations

1. **firstName**
   - `@NotBlank` - Cannot be null or empty
   - `@Size(min=2, max=50)` - Must be between 2-50 characters
   - `@Pattern` - Only letters and spaces allowed
   - Error message: "First name is required", "First name must be between 2 and 50 characters", "First name should contain only letters"

2. **lastName**
   - `@NotBlank` - Cannot be null or empty
   - `@Size(min=2, max=50)` - Must be between 2-50 characters  
   - `@Pattern` - Only letters and spaces allowed
   - Error message: "Last name is required", "Last name must be between 2 and 50 characters", "Last name should contain only letters"

3. **email**
   - `@NotBlank` - Cannot be null or empty
   - `@Email` - Must be valid email format
   - `@Size(max=100)` - Maximum 100 characters
   - Error message: "Email is required", "Email should be valid", "Email must not exceed 100 characters"

4. **mobile**
   - `@NotBlank` - Cannot be null or empty
   - `@Pattern(regexp="^[0-9]{10}$")` - Exactly 10 digits
   - Error message: "Mobile number is required", "Mobile number must be 10 digits"

5. **address**
   - `@NotBlank` - Cannot be null or empty
   - `@Size(min=10, max=200)` - Must be between 10-200 characters
   - Error message: "Address is required", "Address must be between 10 and 200 characters"

6. **gender**
   - `@NotBlank` - Cannot be null or empty
   - `@Pattern(regexp="^(Male|Female|Other)$")` - Must be Male, Female, or Other
   - Error message: "Gender is required", "Gender must be Male, Female, or Other"

7. **dob** (Date of Birth)
   - `@NotBlank` - Cannot be null or empty
   - `@Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$")` - Must be in YYYY-MM-DD format
   - Error message: "Date of birth is required", "Date of birth must be in format YYYY-MM-DD"

8. **id**
   - `@Id` - MongoDB primary key (no validation needed)

9. **createdAt**
   - No validation (system-generated timestamp)

## Changes Made

1. **User.java**
   - Added `import jakarta.validation.constraints.*;`
   - Added validation annotations to all user input fields
   - Each field has meaningful error messages

2. **UserController.java**
   - Added `@Valid` annotation to `registerUser()` method parameter
   - Added `import jakarta.validation.constraints.Valid;`
   - This triggers validation before the method executes

3. **pom.xml**
   - Added `spring-boot-starter-validation` dependency
   - This includes Hibernate Validator and Jakarta Bean Validation API

## How Validation Works

When a POST request is made to `/api/users`:
1. Spring automatically validates the User object based on annotations
2. If validation fails, Spring returns HTTP 400 (Bad Request) with error details
3. If validation passes, the request proceeds to the service layer

## Example Valid Request

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "mobile": "1234567890",
  "address": "123 Main Street, New York, NY",
  "gender": "Male",
  "dob": "1990-01-15"
}
```

## Example Invalid Requests

**Invalid Email:**
```json
{
  "firstName": "John",
  "email": "invalid-email"
}
```
Response: 400 Bad Request - "Email should be valid"

**Invalid Mobile:**
```json
{
  "mobile": "12345"
}
```
Response: 400 Bad Request - "Mobile number must be 10 digits"

**Missing Required Field:**
```json
{
  "firstName": "John"
}
```
Response: 400 Bad Request - Multiple validation errors for missing fields
