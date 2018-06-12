import domain.Frame

object Bowling {
  def score(frames: List[Frame]): Int = {
    frames.map(f => f.first + f.second).sum
  }
}
