Feature: Ebay add to card Action

 Scenario: Search by scenario
    Given launch to ebay application
	When search products
	Then successfully retrieve

  Scenario: Add to cart	
	When select product from results
	Then add to cart
	 