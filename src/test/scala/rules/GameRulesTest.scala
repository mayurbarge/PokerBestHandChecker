package main.scala.rules

import deck._
import main.scala.deck._
import org.scalatest.{Matchers, FunSpec}

/**
  * Created by mbn2671 on 2/4/16.
  */
class GameRulesTest extends FunSpec with Matchers {
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
  }

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

  describe("Three Of A Kind rule ") {
    it(" validation succeeds") {
      val c1: Card = new Card(HEARTS, Rank.ACE)
      val c2: Card = new Card(HEARTS, Rank.ACE)
      val c3: Card = new Card(HEARTS, Rank.ACE)
      val c4: Card = new Card(DIAMOND, Rank.TWO)

      val hand = new Hand(List(c1, c2, c3, c4))

      val rule: GameRule = new ThreeOfAKindRule
      rule.validateRule(hand) shouldBe true

    }
  }
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
}