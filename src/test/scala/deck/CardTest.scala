package deck

import org.scalatest.{Matchers, FunSpec}
import main.scala.deck._



/**
  * Created by mbn2671 on 2/3/16.
  */
class CardTest extends FunSpec with Matchers {

  describe("Verify that card ") {
    it(" is Ace") {
      Card.apply("HA").isAce shouldBe true
    }

    it(" is not Ace") {
      Card.apply("HT").isNotAce shouldBe true
    }

    it(" should require valid rank") {
      intercept[IllegalArgumentException] {
        Card.apply("H0")
      }
    }

    it(" should require valid suite") {
      intercept[IllegalArgumentException] {
        Card.apply("B2")
      }
    }

    it(" should require valid rank and suite") {
      intercept[IllegalArgumentException] {
        Card.apply("TT")
      }
    }
  }

  describe("Verify that given cards ") {
    it(" have same suite") {
      val card1 = Card("CA")
      val card2 = Card("C4")
      card1.matchesSuite(card2) shouldBe true
    }

    it(" have same rank") {
      val card1 = Card("HK")
      val card2 = Card("CK")
      card1.matchesRank(card2) shouldBe true
    }

    it(" are in sequence") {
      val card1 = Card("H9")
      val card2 = Card("CT")
      val card3 = Card("HJ")
      val card4 = Card("CQ")
      val card5 = Card("HK")
      card1.isOneRankHigherThan(card2) shouldBe true
      card2.isOneRankHigherThan(card3) shouldBe true
      card3.isOneRankHigherThan(card4) shouldBe true
      card4.isOneRankHigherThan(card5) shouldBe true
    }

    it(" are not in sequence") {
      val card1 = Card("H9")
      val card2 = Card("C2")
      card1.isOneRankHigherThan(card2) shouldBe false
    }
  }

  describe("New Card") {
    it(" should be created") {
      val card = Card("S2")
      card.suite shouldBe SPADE
      card.rank shouldBe Rank.TWO
    }

    it(" should be created with T (Ten) as rank and value 10") {
      val card2 = Card("DT")
      card2.suite shouldBe DIAMOND
      card2.rank shouldBe Rank.TEN
      card2.rank.value should equal(10)
    }

    it(" should be created with J (Jack) as rank and value 11") {
      val card3 = Card("HJ")
      card3.suite shouldBe HEARTS
      card3.rank shouldBe Rank.JACK
      card3.rank.value should equal(11)
    }

    it(" should be created with Q (Queen) as rank and value 12") {
      val card4 = Card("SQ")
      card4.suite shouldBe SPADE
      card4.rank shouldBe Rank.QUEEN
      card4.rank.value should equal(12)
    }

    it(" should be created with K (King) as rank and value 13") {
      val card5 = Card("DK")
      card5.suite shouldBe DIAMOND
      card5.rank shouldBe Rank.KING
      card5.rank.value should equal(13)
    }

    it(" should be created with A (Ace) as rank and value 14") {
      val card6 = Card("SA")
      card6.suite shouldBe SPADE
      card6.rank shouldBe Rank.ACE
      card6.rank.value should equal(14)
    }
    /*it(" should fail when invalid rank is given") {
    intercept[IllegalArgumentException] {
      Card.createCardFromString("H0")
    }
  }*/

    /*it(" should fail when invalid suit is given") {
      intercept[IllegalArgumentException] {
        Card.createCardFromString("B2")
      }
    }*/
  }
}
