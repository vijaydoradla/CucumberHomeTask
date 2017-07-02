Feature: Add to card Outline

Scenario: Search by scenario outline
	Given launch to ebay application outline
	When search products outline
	Then successfully retrieve outline
	
Scenario:  Add to cart outline
	When select product from results outline
	Then add to cart outline

    