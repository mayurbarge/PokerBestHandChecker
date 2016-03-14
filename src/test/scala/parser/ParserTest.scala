package parser


import deck.{HEARTS, Suite, Rank}
import org.scalatest.{Matchers, FunSpec}
import main.scala.deck._
import main.scala.parser.Parser

/**
  * Created by mbn2671 on 2/3/16.
  */
class ParserTest extends FunSpec with Matchers {
  describe("A Parser ") {
    it(" should read Line") {
      val parser = new Parser(null)
      val card = new Card(HEARTS, Rank.TWO)

      val hand = parser.readHand("HA H2")
      val cards = hand.asList
      cards.size should be(2)

      cards(0).isAce should be(true)
      cards(0).matchesSuite(card) should be(true)
      cards(1).matchesRank(card) should be(true)
      cards(1).matchesSuite(card) should be(true)
    }

    it(" should not read invalid Lines") {
      val parser = new Parser(null)
      val hand = parser.readHand("00 R0 ##")

      hand.isEmpty should be(true)

    }

  }

}
