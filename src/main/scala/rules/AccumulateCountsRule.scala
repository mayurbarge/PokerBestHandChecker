package main.scala.rules
import main.scala.deck._
/**
  * Created by mbn2671 on 2/5/16.
  */

trait AccumulateCountsRule extends GameRule {

  def countOfRuleHitsForHandPairs(hand: Hand, rule: (Card, Card) => Boolean): Int = {
    val cards = hand.asList

    def processRule(acc:Int,i:Int): Int = {
      if(rule(cards(i), cards(i+1)) )
        return acc + 1 // return 1 for each match
      return acc
    }

    (0 until cards.length-1).foldLeft(0)((x,y) => processRule(x,y))

  }
}






/*
trait AccumulateIntRule extends GameRule {

  def iterateAndSumCounts(cards: List[Card], rule: (Card, Card) => Boolean) = {
    var count = 0
    for (i <- 0 until (cards.length - 1)) {
      if(rule(cards(i), cards(i+1)))
        count = count + 1
    }
    count
  }
/*
  def getCount(c1: Card, c2: Card) = {
    var count = 0
    if(c1.matchesRank(c2))
      count = 1
    count
  }*/
}
*/