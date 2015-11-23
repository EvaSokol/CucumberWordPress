Feature: CRUD Post functionality

	Scenario Outline: create simple post
		Given user opens 'New Post' page
		When user specifies <post_title>
		And user specifies post body
		And user clicks 'Publish' button
		Then post should be added to the wordpress
		Examples:
		|post_title|
		|null      |
		|10        |
		|<test>    |
		|!@#$      |
		|Title     |
		
	Scenario: delete post
		Given user opens 'All Posts' page
	    When user selects checkbox near newly created post
	    And user selects 'move to trash' from dropdown menu
	    And user clicks 'Apply' button
	    Then post should be deleted from the page

	Scenario Outline: Edit post
		Given user opens 'All Posts' page
		When user selects 'Edit' link for newly created post
		And user specifies <new_post_body> as post body
		And user clicks 'Publish' button
		Then Post's body should be updated
		Examples:
		|new_post_body|
		|Test Body    |
		|RAndom!@##$! |
		