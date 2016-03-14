package deck

/**
  * Created by mbn2671 on 2/5/16.
  */

trait Suite

object CLUB extends Suite
object DIAMOND extends Suite
object HEARTS extends Suite
object SPADE extends Suite
object INVALID_SUITE extends Suite


object Suite {
  def apply(name: String): Suite = {
    name match {
      case "C" => CLUB
      case "D" => DIAMOND
      case "H" => HEARTS
      case "S" => SPADE
      case _ => INVALID_SUITE
    }
  }
}
