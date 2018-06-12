import domain.Frame

object Bowling {
  def score(frames: List[Frame]): Int = {
    frames.map(_.total).sum
  }
}
