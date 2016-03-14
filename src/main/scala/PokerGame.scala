package main.scala


import main.scala.deck.{Hand, Card}
import main.scala.parser.Parser
import main.scala.rules._

object PokerGame {

  def main(args: Array[String]) {

    val parser: Parser = new Parser(System.getProperty("user.dir") + "/input.txt")
    val handList: List[Hand] = parser.readAllHands

    handList.foreach(
     e =>  processHand(e)
    )
  }

  def processHand(hand : Hand) = {

    val gameRules: List[(String, GameRule)] = List(
      ("FOUR OF A KIND", new FourOfAKindRule),
      ("FLUSH", new FlushRule),
      ("STRAIGHT RULE", new StraightRule),
      ("THREE OF A KIND", new ThreeOfAKindRule),
      ("HIGH CARD", new GameRule {
        override def validateRule(hand: Hand): Boolean = true
      })
    )

    val matchedRuleName = Hand.applyAllRules(hand, gameRules)

    printMatchedRule(matchedRuleName)
  }

  def printMatchedRule(rule: String) = {
    println("Matched rule: " + rule)
  }
}