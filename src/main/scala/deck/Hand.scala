package main.scala.deck

import main.scala.deck.Card
import main.scala.rules.GameRule

/**
  * Created by mbn2671 on 2/15/16.
  */
class Hand(cards: List[Card]) {
  //require( (cards != null) && cards.length > 0
  def asList: List[Card] = cards
  def isEmpty: Boolean = (cards == null) || (cards.length == 0)

  def sortedByRank: Hand = {
    new Hand(cards.sortBy(_.rank))
  }
}

object Hand {

  def applyAllRules(hand: Hand, allRules: List[(String, GameRule)]): String = {
    val matchedRule = allRules.dropWhile(_._2.validateRule(hand) != true)
    // first matched rule is returned
    matchedRule.head._1
  }
}







/*

    def ruleMatched(tuple: (String, GameRule), hand: Hand) =  {
      val ruleMatched = tuple._2.validateRule(hand)
      if(ruleMatched)
        printMatchedRuleName(tuple._1)
      ruleMatched
    }

    def printMatchedRuleName(name: String) = println("Matched rule : " + name)
*/