Feature: User registration Form

Background: Given user should be enter the valid all attribute  

 Scenario Outline: verify the that user basic details
 When user enter the all valid data to the respective fields
 | FirstName  | Prakash          |
 | LastName   | H N              |
 | PhoneNumber| 8722000134       |
 | Mail Id    | Prakash@gmail.com|
 And user click on the continue button 
 Then user should registered basic details successfully