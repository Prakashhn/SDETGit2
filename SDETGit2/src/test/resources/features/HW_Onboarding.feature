Feature: User Login
    
 Scenario: to to check the Seller can able to onboard the HW product and submitted
 Given seller is on the Product description page of Hardware onboarding
 When seller enter the valid details 
 And seller click on the Submit button
 Then seller should get the product in the hardware product list
 And status of product is Submit is displayed.
 
 