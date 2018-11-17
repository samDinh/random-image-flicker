Feature: Service return a random file in the file tree

  Scenario: get a file from the root default folder
    Given there is only one file and it is at the root of the default folder
    When the client ask for a random file
    Then the client receives the only one file from the default folder
    
  Scenario: get a file from a sub-folder
    Given there is only one file and it is in a sub-folder of the default folder
    When the client ask for a random file
    Then the client receives the file in the sub-folder