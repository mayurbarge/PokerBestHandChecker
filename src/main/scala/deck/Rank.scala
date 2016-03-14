package deck

case class Rank(name: String, val value: Int) extends Ordered[Rank] {
  def compare(that: Rank): Int =  value compare that.value
}


object Rank {
  val TWO = Rank("TWO", 2)
  val THREE = Rank("THREE", 3)
  val FOUR = Rank("FOUR", 4)
  val FIVE = Rank("FIVE", 5)
  val SIX = Rank("SIX", 6)
  val SEVEN = Rank("SEVEN", 7)
  val EIGHT = Rank("EIGHT", 8)
  val NINE = Rank("NINE", 9)
  val TEN = Rank("TEN", 10)
  val JACK = Rank("JACK", 11)
  val QUEEN = Rank("QUEEN", 12)
  val KING = Rank("KING", 13)
  val ACE = Rank("ACE", 14)
  val INVALID = Rank("INVALID", 0)

  def apply(name:String): Rank = {
    name match {
      case "2" => TWO
      case "3" => THREE
      case "4" => FOUR
      case "5" => FIVE
      case "6" => SIX
      case "7" => SEVEN
      case "8" => EIGHT
      case "9" => NINE
      case "T" => TEN
      case "J" => JACK
      case "Q" => QUEEN
      case "K" => KING
      case "A" => ACE
      case _ => INVALID
    }
  }
}


/*
object Rank extends Enumeration {
  type Rank = Value;
  val TWO = Value(0)
  val THREE = Value(1)
  val FOUR = Value(2)
  val FIVE = Value(3)
  val SIX = Value(4)
  val SEVEN = Value(5)
  val EIGHT = Value(6)
  val NINE = Value(7)
  val TEN = Value(8)
  val JACK = Value(9)
  val QUEEN = Value(10)
  val KING = Value(11)
  val ACE = Value(12)
  val INVALID = Value(13)


  def withNameAs(name: String) : Rank = {
    //var rank : Rank =  new Rank
    name match {
      case "2" =>
        return TWO
      case "3" =>
        return THREE
      case "4" =>
        return FOUR
      case "5" =>
        return FIVE
      case "6" =>
        return SIX
      case "7" =>
        return SEVEN
      case "8" =>
        return EIGHT
      case "9" =>
        return NINE
      case "T" =>
        return TEN
      case "J" =>
        return JACK
      case "Q" =>
        return QUEEN
      case "K" =>
        return KING
      case "A" =>
        return ACE
    }
    return INVALID
  }
}
*/