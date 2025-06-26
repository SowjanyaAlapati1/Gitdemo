
@smoke
Feature: Purchase the order from lets shop website

Background:
Given user landed on website
  
  Scenario Outline: Test the order submission
    Given user login to application with <emailid> and <password>
    When I add <productname1> to cart
    And click on checkout <productname1> and submit the order
    Then THANKYOU FOR THE ORDER.message will displayed
    
    Examples: 
      | emailid               | password     | productname1 |
      | babykalluri@gmail.com | Baby@123     | ZARA COAT 3 |
      
