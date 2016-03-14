package main.scala.rules

/**
  * Created by mbn2671 on 2/5/16.
  */
import main.scala.deck._

class FlushRule extends AccumulateBooleanRule {
  def validateRule(hand: Hand): Boolean = {
    isRuleHitForAllHandPairs(hand, (c1:Card, c2: Card) => {c1.matchesSuite(c2)})
  }
}
