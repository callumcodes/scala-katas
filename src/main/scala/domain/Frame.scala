package domain

case class Frame(first: Int, second: Int) {
  val isSpare: Boolean = first + second == 10
}
