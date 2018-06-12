package domain

case class Frame(first: Int, second: Int) {
  import Frame._

  val total: Int = first + second
  val isSpare: Boolean = first + second == MAX_PINS
}

object Frame {
  final val MAX_PINS = 10
}
