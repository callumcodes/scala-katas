package domain

case class Frame(first: Int, second: Int, third: Option[Int] = None) {

  import Frame._

  val total: Int = first + second + third.getOrElse(0)

  val bonus: FrameBonus = (first, second) match {
    case (MAX_PINS, _) => Strike
    case (f, s) if f + s == MAX_PINS => Spare
    case _ => Non
  }
}

object Frame {
  final val MAX_PINS = 10
}
