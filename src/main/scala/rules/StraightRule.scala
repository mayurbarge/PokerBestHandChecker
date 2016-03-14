package main.scala.rules

/**
  * Created by mbn2671 on 2/5/16.
  */
import main.scala.deck._

class StraightRule extends AccumulateBooleanRule {
  def validateRule(hand: Hand): Boolean = {
    //val sortedHand = hand.sortBy(_.rank)
    val sortedHand = hand.sortedByRank
    isRuleHitForAllHandPairs(sortedHand, isCardsInSequence)
  }

  def isCardsInSequence(c1: Card, c2: Card): Boolean = {
    checkAces(c1, c2) || c2.isOneRankHigherThan(c1)
  }

  def checkAces(c1: Card, c2: Card): Boolean = {
    c1.isAce || c2.isAce
  }
}
