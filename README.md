# Week Three Assignment

## General assignments: "I'm already felling better"

Each assignment within week three should be committed separately.  
Any code completed within commit should be listed in square brackets at the beginning of commit message.  

Commit message examples:  
[SHA-1] Implement SHA domain model  
[SHA-1][SHA-3] Implement SHA domain model  
[SHA-2] Use Lombok annotations  


SHA-1: Implement SHA domain model from sha-jdl.png
    - sha-jdl.txt contains JDL text used to define model
    - any existing classes from previous weeks that don't fit the model can be removed/refactored
    - persistence specific fields (e.g. ID) are not present in model, add it by yourself
    - Use JPA Enumerations  
    - Specify cascade type in JPA annotated domain model where needed
    - specify JPA fetch types where for relationships
SHA-2: Annotate domain model with JPA annotations
    - Use @Data Lombok annotations 
SHA-3: Implement all needed JPA CRUD repositories
SHA-4: Implement ManyToMany, OneToMany(ManyToOne), OneToOne relationships
SHA-5: Prepopulate database with doctors, symptoms, patients, their patientMedicalRecord, their symptoms and their patientTreatmentHistories - Use your imagination for data
    -Important note. If you encounter circular references with some of the relationships(example. Patient <-> PatientMedicalRecord google and use Lomboks @EqualsAndHashCode.Exclude for backend side and @JsonIgnore for generted json output for frontend side)
SHA-6: Use @PrePersist and @PreUpdate (add fields to model if necessary) 

SHA-7: Implement JPA Query Method to find all Patients older than 21 who were enlisted after 01.01.2020
SHA-8: Implement JPA Query Method to find all Patients whose symptoms include either "Coughing" or "Fever" Symptom. (Add "coughing" and "fever" as symptoms and refactor task SHA-5 that some patients have these symptoms in their medical record)

SHA-9: Use Slf4J Lombok annotations and log some events  
SHA-10: Use @MappedSuperclass annotation for Entity inheritance
    - as you may notice Entity Doctor and Patient have some same attributes(firstName, lastName) so we can have some benefit from @MappedSuperclass and combine them into one class

### Test assignments

SHA-11: Use Mockito in one test 
SCC-12: Write integration test with @DataJpaTest  
SCC-14: Write PatientController test using MockMvc  