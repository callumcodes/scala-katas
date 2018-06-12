import org.scalatest.{FlatSpec, Matchers}

class BowlingSpec extends FlatSpec with Matchers {

  "score" should "return 0 for 0 frames" in {
    Bowling.score() shouldBe 0
  }

}
