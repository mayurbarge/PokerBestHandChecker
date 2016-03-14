package main.scala.rules

/**
  * Created by mbn2671 on 2/5/16.
  */
import main.scala.deck._

trait AccumulateBooleanRule extends GameRule {

  def isRuleHitForAllHandPairs(hand: Hand, rule: (Card, Card) => Boolean) = {

    val cards = hand.asList
    def processRule(acc:Boolean,i:Int): Boolean = {
      acc && rule(cards(i), cards(i+1))
    }

    (0 until cards.length-1).foldLeft(true)((x,y) => processRule(x,y))

  }
}
