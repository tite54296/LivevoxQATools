Feature: Navigate World bank site

  Scenario: Open main page
    When I access world bank site
    Then the World bank home page should open
    
  Scenario: Open data page
    When I click on data on main page
    Then the World bank data page should open

  Scenario: Open old site page
    When I click on old site on data page
    Then I should be taken to old site
    And I click on By Country on old site page
    Then the tab name should be Data
    And the section name should be Countries and Economies
    
  Scenario: Open High incomes
    When I click on high incomes on Income levels section
    Then the High incomes page should open
    
  Scenario Outline: Open Andorra details
  	Given I access high incomes site 
    When I click on <country> on High income page
    Then the <country> page should open
    And GDP at market prices (current US$) should be present
    And Population, total should be present
    And CO2 emissions (metric tons per capita) should be present
    When I click on home on the current page
    Then the World bank home page should open
    Examples:
    |country|
    |Andorra|
		|Kuwait|
		|Antigua and Barbuda|
		|Latvia|
		|Aruba|
		|Liechtenstein|
		|Australia|
		|Lithuania|
		|Austria|
		|Luxembourg|
		|Bahamas, The|
		|Macao SAR, China|
		|Bahrain|
		|Malta|
		|Barbados|
		|Monaco|
		|Belgium|
		|Nauru|
		|Bermuda|
		|Netherlands|
		|British Virgin Islands|
		|New Caledonia|
		|Brunei Darussalam|
		|New Zealand|
		|Canada|
		|Northern Mariana Islands|
		|Cayman Islands|
		|Norway|
		|Channel Islands|
		|Oman|
		|Chile|
		|Poland|
		|Croatia|
		|Portugal|
		|Curacao|
		|Puerto Rico|
		|Cyprus|
		|Qatar|
		|Czech Republic|
		|San Marino|
		|Denmark|
		|Saudi Arabia|
		|Estonia|
		|Seychelles|
		|Faroe Islands|
		|Singapore|
		|Finland|
		|Sint Maarten (Dutch part)|
		|France|
		|Slovak Republic|
		|French Polynesia|
		|Slovenia|
		|Germany|
		|Spain|
		|Gibraltar|
		|St. Kitts and Nevis|
		|Greece|
		|St. Martin (French part)|
		|Greenland|
		|Sweden|
		|Guam|
		|Switzerland|
		|Hong Kong SAR, China|
		|Taiwan, China|
		|Hungary|
		|Trinidad and Tobago|
		|Iceland|
		|Turks and Caicos Islands|
		|Ireland|
		|United Arab Emirates|
		|Isle of Man|
		|United Kingdom|
		|Israel|
		|United States|
		|Italy|
		|Uruguay|
		|Japan|
    
