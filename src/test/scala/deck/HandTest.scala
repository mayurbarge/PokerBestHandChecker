package deck

import main.scala.deck._
import main.scala.rules._
import org.scalatest.{FunSpec, Matchers}


/**
  * Created by mbn2671 on 2/3/16.
  */
class HandTest extends FunSpec with Matchers {
  trait Setup {
    val gameRules: List[(String, GameRule)] = List(
      ("FOUR OF A KIND", new FourOfAKindRule),
      ("FLUSH", new FlushRule),
      ("STRAIGHT RULE", new StraightRule),
      ("THREE OF A KIND", new ThreeOfAKindRule),
      ("HIGH CARD", new GameRule {
        override def validateRule(hand: Hand): Boolean = true
      })
    )
  }

  describe("Verify hand ") {
    it(" is empty") {
      val hand = new Hand(null)
      hand.isEmpty shouldBe true

      val hand2 = new Hand(List())
      hand2.isEmpty shouldBe true
    }
  }

  describe("4 of a kind ") {
    new Setup {
      it(" validation succeeds") {
        val hand = new Hand(List(
          new Card(HEARTS, Rank.ACE),
          new Card(CLUB, Rank.ACE),
          new Card(SPADE, Rank.ACE),
          new Card(DIAMOND, Rank.ACE)))

        Hand.applyAllRules(hand, gameRules) equals "FOUR OF A KIND"
      }
    }

    describe("3 of a kind ") {
      new Setup {
        it(" validation succeeds") {
          val hand = new Hand(List(
            new Card(HEARTS, Rank.ACE),
            new Card(CLUB, Rank.TWO),
            new Card(SPADE, Rank.TWO),
            new Card(DIAMOND, Rank.TWO)))

          Hand.applyAllRules(hand, gameRules) equals "THREE OF A KIND"
        }
      }
    }

    describe("Flush And 3-of-a-kind") {
      new Setup {
        it(" validation hits in Flush.") {
          val hand = new Hand(List(
            new Card(HEARTS, Rank.ACE),
            new Card(HEARTS, Rank.TWO),
            new Card(HEARTS, Rank.TWO),
            new Card(HEARTS, Rank.TWO)))

          Hand.applyAllRules(hand, gameRules) equals "FLUSH"
        }
      }
    }

    describe("HIGH CARD") {
      new Setup {
        it(" validation succeeds") {
          val hand = new Hand(List(
            new Card(HEARTS, Rank.ACE),
            new Card(CLUB, Rank.FIVE),
            new Card(SPADE, Rank.NINE),
            new Card(HEARTS, Rank.TWO)))

          Hand.applyAllRules(hand, gameRules) equals "HIGH CARD"
        }
      }
    }
  }
}
