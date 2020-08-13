 # Week Four Assignment

Each assingment within week four should be committed separately.  
Any code completed within commit should be listed in square brackets at the beginning of commit message.  

Commit message examples:  
[SHA-1] Implement CRUD RESTful API for Appointment resource   
[SHA-1][SHA-2] Implement CRUD RESTful API for Appointment resource   
[SHA-2] Implement @ControllerAdvice to handle exceptions  

## General assignment "I'm finally recovered!!"
 
SHA-1: Implement EnlistmentController with create REST method  
    - controller should accept EnlistmentForm, simple object to register new patient with all required Patient data
    - controller should use implementation of Spring Type Converter to convert EnlistmentForm to Patient , and store Patient, created (if some other is needed) JPA entity to database  
SHA-2: Implement Appointment controller with create REST method  
    - controller should accept needed patient ID data, doctor ID data, and appointment date(use  form or PATH parameters)
    - make sure that no same doctor, and same patient can have multiple appointments on the same date
SHA-4: Modify Patient controller for uploading picture of patient and save it to database
    - add picture field to Patient table
    - Controller method parameters are image and PATIENT_ID(PATIENT_ID should be PATH parameter)
SHA-5: Implement @ExceptionHandler to catch and handle all exceptions 
SHA-6 Use JSR-303: Bean Validation on EnlistmentForm to validate requests to EnlistmentController
SHA-7 Use @ResponseStatus on custom exception  
SHA-8 Customize error messages from REST controller with Message Source 
---

SHa-9: Add some java library(example apache-commons...) of your choice to the application(gradle dependency) and use it in code for something of your choice    
------------

Additional info: Covered lectures in week four use Thymeleaf as part of Model View Controller architecture.  
To see examples of REST controllers similar to assignment you can check Section 24 - 'RESTFul WebServices with Spring MVC'.

#### Covered lectures
1. CRUD Operations with Spring MVC
    - Introduction
    - Display a Recipe by ID
    - Assignment - Display remaining recipe properties
    - Assignment Review - Display Remaing Recipe Properties
    - Processing Form Posts with Spring MVC
    - Creating a Command Object and Type Conversions in Spring
    - Create a Recipe
    - Update a Recipe
    - Delete a Recipe
    - View Ingredients
    - Show Ingredient
    - Update Ingredient
    - Create an Ingredient
    - Assignment - Delete an Ingredient
    - Assignment Review - Delete Ingredient
    - Using the Debugger
    - Uploading Images with Spring MVC
    - Persisting images to Database
    - Displaying images from Database
2. Validation and Constraints with Spring MVC
    - Introduction to Validation and Constraints with Spring MVC
    - Overview of Exception Handling
    - Using Spring MVC Annotation @ResponseStatus
    - Spring MVC Exception Handler
    - Showing Error Data on 404 Error Page
    - Assignment: Handle Number Format Exception
    - Assignment Review: Handle Number Format Exception
    - Spring MVC Controller Advice
    - Data Validation with JSR-303
    - Data Validation with Spring MVC
    - Customizing Error Messages with Message Source
    - Introduction to Internationalization 
    - Internationalization with Spring MVC
