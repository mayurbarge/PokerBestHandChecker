package main.scala.deck

import deck.{INVALID_SUITE, Suite, Rank}
import Rank._
import Suite._


case class Card(suite:Suite, rank: Rank) {
  require(rank != Rank.INVALID)
  require(suite != INVALID_SUITE)

  def isAce = rank == ACE
  def isNotAce = !isAce
  def isOneRankHigherThan(c: Card) = Math.abs(rank.value - c.rank.value) == 1
  def matchesRank(c: Card) = rank == c.rank
  def matchesSuite(c: Card) = suite == c.suite

}

object Card {
  def apply(str: String): Card = {
    Card(
      Suite(str.substring(0,1)), Rank(str.substring(1, str.length)))
  }

}




/*
case class Card(suite:Suite, rank: Rank) {
  def isAce = rank == ACE
  def isNotAce = !isAce
  def isOneRankHigherThan(c: Card) = Math.abs(rank.id - c.rank.id) == 1
  def matchesRank(c: Card) = rank.id == c.rank.id
  def matchesSuite(c: Card) = suite == c.suite

}

object Card {
  def createCardFromString(str: String): Card = {
    return new Card(
      Suite.withName(str.substring(0,1)), Rank.withNameAs(str.substring(1, str.length)))
  }

}

*/