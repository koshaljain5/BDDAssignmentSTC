Feature: Verify stctv OTT Subscription for all countries

  Background: 
    Given User navigates to stctv Home page "https://subscribe.stctv.com/" and clicks on "English" language

  @VerifySubscriptions
  Scenario: Verify stctv Subscriptions for all countries
    
    And User clicks on country as "<country>" verifies "<lite>", "<classic>" and "<premium>" subscription details with currency
    
		Examples:
      | country | lite          | classic       | premium       |
      | Bahrain | 2 BHD/month   | 3 BHD/month   | 6 BHD/month   |
      | KSA     | 15 SAR/month  | 25 SAR/month  | 60 SAR/month  |
      | Kuwait  | 1.2 KWD/month | 2.5 KWD/month | 4.8 KWD/month |