

   Feature: Capstone Project

  Scenario: Verify IFRAME functionality
    Given I launch the URL "http://webdriveruniversity.com/index.html"
    Then the title of the page should be "WebdriverUniversity.com"

    When I click on the IFRAME link
    Then a new tab should open and I switch to that tab

    And I verify the presence of the Image
    When I click on the right arrow button
    Then the images should change accordingly

  