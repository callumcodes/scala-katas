import domain.Frame

import scala.annotation.tailrec

object Bowling {
  def score(frames: List[Frame]): Int = {
    evaluateGame(frames, 0)
  }

  @tailrec
  private def evaluateGame(frames: List[Frame], score: Int): Int = frames match {
    case Nil => score
    case head :: next :: tail if head.isSpare => evaluateGame(next :: tail, score + head.total + next.first)
    case head :: tail => evaluateGame(tail, score + head.total)
  }
}
