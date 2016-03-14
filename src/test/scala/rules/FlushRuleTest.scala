package rules

/**
  * Created by mbn2671 on 2/16/16.
  */

import deck._
import main.scala.deck._
import main.scala.rules.{FlushRule, FourOfAKindRule, GameRule}
import org.scalatest.{FunSpec, Matchers}

/**
  * Created by mbn2671 on 2/4/16.
  */
class FlushRuleTest extends FunSpec with Matchers {

  describe("Flush ") {
    it(" validation succeeds") {
      val c1: Card = new Card(HEARTS, Rank.ACE)
      val c2: Card = new Card(HEARTS, Rank.TWO)
      val c3: Card = new Card(HEARTS, Rank.THREE)
      val c4: Card = new Card(HEARTS, Rank.THREE)

      val hand = new Hand(List(c1, c2, c3, c4))

      val rule: GameRule = new FlushRule
      rule.validateRule(hand) shouldBe true
    }
  }

  describe("Flush ") {
    it(" validation fails") {
      val c1: Card = new Card(HEARTS, Rank.ACE)
      val c2: Card = new Card(CLUB, Rank.TWO)
      val c3: Card = new Card(HEARTS, Rank.THREE)
      val c4: Card = new Card(HEARTS, Rank.THREE)

      val hand = new Hand(List(c1, c2, c3, c4))

      val rule: GameRule = new FlushRule
      rule.validateRule(hand) shouldBe false
    }
  }
}
