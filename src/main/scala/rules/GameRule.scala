package main.scala.rules

/**
  * Created by mbn2671 on 2/4/16.
  */

import main.scala.deck._
trait GameRule {
  def validateRule(hand: Hand): Boolean
}
