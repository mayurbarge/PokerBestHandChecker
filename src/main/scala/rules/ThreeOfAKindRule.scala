package main.scala.rules

/**
  * Created by mbn2671 on 2/5/16.
  */
import main.scala.deck._
class ThreeOfAKindRule extends AccumulateCountsRule {
  def validateRule(hand: Hand): Boolean = {
    val countOfHits = countOfRuleHitsForHandPairs(hand, (c1: Card, c2: Card) => c1.matchesRank(c2))
    countOfHits >=2
  }
}
