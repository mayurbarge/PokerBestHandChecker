package main.scala.parser

import java.io.File
import java.util
import deck.{Rank, Suite}
import main.scala.deck.{Hand, Card}
import main.scala.rules._
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by mbn2671 on 2/5/16.
  */
class Parser (filePath: String) {
  private final val regex = "[H|C|D|S][2-9|T|J|Q|K|A]*".r

  def readAllHands: List[Hand] = {
    Source.fromFile(filePath).getLines.toList.map(
      e => readHand(e)
    )
  }

  def readHand(line: String): Hand = {
    val cards = regex.findAllIn(line.toString).toList.map(Card.apply(_))
    new Hand(cards)
  }

}

  /*
def processFile : List[String] = {
  val lines = new ListBuffer[String]
  Source.fromFile(filePath).getLines.foreach(
  e => lines += e
  )
  lines.toList
}

def processLine(line: Any): List[Card] = {
  val hand = new ListBuffer[Card]()

  regex.findAllIn(line.toString).foreach(
    e => hand += Card.createCardFromString(e)
  )
  hand.toList
}*/

