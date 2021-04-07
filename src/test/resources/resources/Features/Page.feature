Feature: Verifying AdactinHotelApp

  Scenario Outline: Verifying AdactinHotelApp Login Deatails With valid Credentials
    Given User is on the AdactinHotelApp login page
    When User should enter "<userName>" and "<passWord>"
    Then User should click the login button
    Then User should verify login and in search hotels Page
    Then User should search hotels using preferred valid details
      | location | hotels      | roomType | numberOfRooms | checkIn    | checkOut   | apr | cpr |
      | Sydney   | Hotel Creek | Double   |             2 | 05/04/2021 | 06/04/2021 |   2 |   2 |
      | London   | Hotel Creek | Double   |             2 | 05/04/2021 | 06/04/2021 |   2 |   2 |
    Then User should click the search button
    Then User should select hotel and click the continue button
    Then User should book hotel using valid user details
      | firstName | lastName | address        | crediCardNo        | creditCardType | expiryMonth | expiryYear | cvv |
      | sand      | kumar    | 18 kodambakkam | 987654321123456789 | AMEX           |          11 |       2021 | 123 |
      | prakash   | kumar    | 18 kodambakkam | 987654321123456789 | AMEX           |           4 |       2022 | 888 |
      | leo       | kumar    | 18 kodambakkam | 987654321123456789 | AMEX           |           4 |       2022 | 888 |
      | praveen   | kumar    | 18 kodambakkam | 987654321123456789 | AMEX           |           4 |       2022 | 888 |
      | sand      | kumar    | 18 kodambakkam | 987654321123456789 | AMEX           |           4 |       2022 | 888 |
    Then User should book the hotel and verify order details
    Then User should logout and exit

    Examples: 
      | userName | passWord |
      | prakash0 | J5M3AD   |
      | prakash0 | J5M3AD   |
