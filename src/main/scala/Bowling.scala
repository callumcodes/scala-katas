import domain.{Frame, Spare, Strike}

import scala.annotation.tailrec

object Bowling {
  def score(frames: List[Frame]): Int = {
    evaluateGame(frames, 0)
  }

  @tailrec
  private def evaluateGame(frames: List[Frame], score: Int): Int = frames match {
    case Nil => score
    case head :: Nil => evaluateGame(Nil, score + head.total)
    case head :: next :: after :: tail if head.bonus == Strike && next.bonus == Strike =>
      evaluateGame(next :: after :: tail, score + head.total + next.total + after.first)
    case head :: next :: tail if head.bonus == Strike => evaluateGame(next :: tail, score + head.total + next.first + next.second)
    case head :: next :: tail if head.bonus == Spare => evaluateGame(next :: tail, score + head.total + next.first)
    case head :: tail => evaluateGame(tail, score + head.total)
  }
}
