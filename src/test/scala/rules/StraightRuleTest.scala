package rules

/**
  * Created by mbn2671 on 2/16/16.
  */

import deck._
import main.scala.deck._
import main.scala.rules.{StraightRule, FlushRule, GameRule}
import org.scalatest.{FunSpec, Matchers}

/**
  * Created by mbn2671 on 2/4/16.
  */
class StraightRuleTest extends FunSpec with Matchers {
  describe("Straight ") {
    it(" validation succeeds") {
      val c1: Card = new Card(HEARTS, Rank.ACE)
      val c2: Card = new Card(HEARTS, Rank.FOUR)
      val c3: Card = new Card(SPADE, Rank.THREE)
      val c4: Card = new Card(DIAMOND, Rank.TWO)

      val hand = new Hand(List(c1, c2, c3, c4))

      val rule: GameRule = new StraightRule
      rule.validateRule(hand) shouldBe true

    }
  }

  describe("Straight ") {
    it(" validation fails") {
      val c1: Card = new Card(HEARTS, Rank.ACE)
      val c2: Card = new Card(HEARTS, Rank.FOUR)
      val c3: Card = new Card(SPADE, Rank.FIVE)
      val c4: Card = new Card(DIAMOND, Rank.TWO)

      val hand = new Hand(List(c1, c2, c3, c4))

      val rule: GameRule = new StraightRule
      rule.validateRule(hand) shouldBe false

    }
  }
}
