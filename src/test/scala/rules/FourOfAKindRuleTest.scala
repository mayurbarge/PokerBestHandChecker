package rules

/**
  * Created by mbn2671 on 2/16/16.
  */

import deck._
import main.scala.deck._
import main.scala.rules.{FourOfAKindRule, GameRule}
import org.scalatest.{Matchers, FunSpec}

/**
  * Created by mbn2671 on 2/4/16.
  */
class FourOfAKindRuleTest extends FunSpec with Matchers {
  describe("Four Of A Kind rule ") {
    it(" validation succeeds") {
      val c1: Card = new Card(HEARTS, Rank.ACE)
      val c2: Card = new Card(CLUB, Rank.ACE)
      val c3: Card = new Card(SPADE, Rank.ACE)
      val c4: Card = new Card(DIAMOND, Rank.ACE)

      val hand = new Hand(List(c1, c2, c3, c4))

      val rule: GameRule = new FourOfAKindRule

      rule.validateRule(hand) shouldBe true
    }

    it(" validation fails") {
      val c1: Card = new Card(HEARTS, Rank.ACE)
      val c2: Card = new Card(CLUB, Rank.TWO)
      val c3: Card = new Card(SPADE, Rank.ACE)
      val c4: Card = new Card(DIAMOND, Rank.ACE)

      val hand = new Hand(List(c1, c2, c3, c4))

      val rule: GameRule = new FourOfAKindRule

      rule.validateRule(hand) shouldBe false
    }
  }
}
