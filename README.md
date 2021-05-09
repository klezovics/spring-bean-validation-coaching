Full info is available here: https://reflectoring.io/bean-validation-with-spring-boot/
Bean validation anti-patterns: https://reflectoring.io/bean-validation-anti-patterns/#anti-pattern-1-validating-only-in-the-persistence-layer


Base cases:

1. Validate input to a controller (com.klezovich.beanvalidation.UserControllerTest.testInvalidUserDtoNotValidated)
  1.1 @Valid annotation in the controller input argument
  1.2 Constraints on the DTO class such as @Min(10), @NotNull, @NotBlank
  Full list is here: https://www.baeldung.com/javax-validation
  
2. Validate a nested object (com.klezovich.beanvalidation.UserControllerTest.testInvalidUserDtoWithAddressFailsValidation)

3. How to test that constraints are setup correctly (com.klezovich.beanvalidation.dto.UserDtoTest)

4. Let's also validate path variables and request parameters (com.klezovich.beanvalidation.controller.ValidateParametersController)

5. Validation of JPA entites ... its enabled by defaults, so just add the contraints annotations 
   on the entity (com.klezovich.beanvalidation.repository.AddressRepositoryTest)
   
6 Let's implement a custom validator (com.klezovich.beanvalidation.customvalidator.IpAddressValidatorTest)

7. Let's just validate something programmatically -> same package as above

8. Validate items in a different way depending on create or update (https://reflectoring.io/bean-validation-with-spring-boot/#using-validation-groups-to-validate-objects-differently-for-different-use-cases)


== Note == 

How to create a custom annotation: https://www.baeldung.com/java-custom-annotation

= Controller = 
1. @Valid 
2. Add constraints

= Service = 
1. @Validated
2. @Valid 
3. Add constraints 

= Repository =
1. Add constraints