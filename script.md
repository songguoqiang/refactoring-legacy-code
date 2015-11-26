* What is legacy code?
* Tests -> Characterization Tests
* Tests -> Golden Master Tests
* Exploratives Refactoring
Identifizieren von Dingen die ich bereinigen kann, ohne ein konkrtes Ziel ausser sauberem (testbaren) Code
* Mikado Methode
  - players.add(new Player) r�ckg�ngig machen und erst toString implementieren
* Use the Compiler Luke
  - remove places -> extract method currentPlayersPlace
  - add places to player
  - extract moveBy
  - replcace places
  - remove places
  - move stuff to player
  - clean up 
* --- cleanup questions ---
  - create enum
  - replace Strings with enum
  
* writing test for complex methods


* After players and places move to tests for complex methods