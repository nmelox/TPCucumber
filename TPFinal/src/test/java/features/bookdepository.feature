Feature: Trabajo Practico Final Curso Automation II.

Scenario Outline: Search a Book

Given I enter a <searchword>
When I press Search button 
And I sort result by <orderBy>
And I click on first element
Then Book page must be shown

Examples:

|searchword					|orderBy				|
|Sailor moon tomo 7 |price_low_high	|

