package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
  public static final String POP = "Pop";
  public static final String SCIENCE = "Science";
  public static final String SPORTS = "Sports";
  public static final String ROCK = "Rock";
  ArrayList players = new ArrayList();
  int[] places = new int[6];
  int[] purses  = new int[6];
  boolean[] inPenaltyBox  = new boolean[6];

  List popQuestions = new LinkedList();
  List scienceQuestions = new LinkedList();
  List sportsQuestions = new LinkedList();
  List rockQuestions = new LinkedList();

  int currentPlayer = 0;
  boolean isGettingOutOfPenaltyBox;

  public Game() {
    for (int i = 0; i < 50; i++) {
      popQuestions.add("Pop Question " + i);
      scienceQuestions.add("Science Question " + i);
      sportsQuestions.add("Sports Question " + i);
      rockQuestions.add("Rock Question " + i);
    }
  }

  public boolean add(String playerName) {
    players.add(playerName);
    int numberOfPlayers = players.size();

    places[numberOfPlayers] = 0;
    purses[numberOfPlayers] = 0;
    inPenaltyBox[numberOfPlayers] = false;

    System.out.println(playerName + " was added");
    System.out.println("They are player number " + numberOfPlayers);
    return true;
  }

  public void roll(int roll) {
    System.out.println(players.get(currentPlayer) + " is the current player");
    System.out.println("They have rolled a " + roll);

    if (inPenaltyBox[currentPlayer]) {
      if (roll % 2 != 0) {
        isGettingOutOfPenaltyBox = true;

        System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
        askQuestion();
      } else {
        System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
      }

    } else {

      places[currentPlayer] = places[currentPlayer] + roll;
      if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

      System.out.println(players.get(currentPlayer)
              + "'s new location is "
              + places[currentPlayer]);
      System.out.println("The category is " + currentCategory());
      askQuestion();
    }

  }

  private void askQuestion() {
    if (currentCategory() == POP)
      System.out.println(popQuestions.remove(0));
    if (currentCategory() == SCIENCE)
      System.out.println(scienceQuestions.remove(0));
    if (currentCategory() == SPORTS)
      System.out.println(sportsQuestions.remove(0));
    if (currentCategory() == ROCK)
      System.out.println(rockQuestions.remove(0));
  }


  private String currentCategory() {
    if (places[currentPlayer] == 0) return POP;
    if (places[currentPlayer] == 4) return POP;
    if (places[currentPlayer] == 8) return POP;
    if (places[currentPlayer] == 1) return SCIENCE;
    if (places[currentPlayer] == 5) return SCIENCE;
    if (places[currentPlayer] == 9) return SCIENCE;
    if (places[currentPlayer] == 2) return SPORTS;
    if (places[currentPlayer] == 6) return SPORTS;
    if (places[currentPlayer] == 10) return SPORTS;
    return ROCK;
  }

  public boolean wasCorrectlyAnswered() {
    if (inPenaltyBox[currentPlayer]){
      if (isGettingOutOfPenaltyBox) {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;
      } else {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
      }



    } else {

      System.out.println("Answer was corrent!!!!");
      purses[currentPlayer]++;
      System.out.println(players.get(currentPlayer)
              + " now has "
              + purses[currentPlayer]
              + " Gold Coins.");

      boolean winner = didPlayerWin();
      currentPlayer++;
      if (currentPlayer == players.size()) currentPlayer = 0;

      return winner;
    }
  }

  public boolean wrongAnswer(){
    System.out.println("Question was incorrectly answered");
    System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
    inPenaltyBox[currentPlayer] = true;

    currentPlayer++;
    if (currentPlayer == players.size()) currentPlayer = 0;
    return true;
  }


  private boolean didPlayerWin() {
    return !(purses[currentPlayer] == 6);
  }
}