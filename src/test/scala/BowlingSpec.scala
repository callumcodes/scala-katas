import domain.Frame
import org.scalacheck.Gen
import org.scalatest.prop.Checkers
import org.scalatest.{FlatSpec, Matchers}
import org.scalacheck.Prop.forAll


class BowlingSpec extends FlatSpec with Matchers with Checkers {

  // Generates a frame where the total score is 0 - 9
  val frameGen = for {
    first <- Gen.choose(0, 9)
    second <- Gen.choose(0, 9 - first)
  } yield Frame(first, second)

  val gameGen: Gen[List[Frame]] = Gen.listOfN(10, frameGen)

  "score" should "return 0 for 0 frames" in {
    Bowling.score(Nil) shouldBe 0
  }

  it should "calculate the score for a single frame (without a strike or spare) by combining the two numbers" in {
    check {
      forAll(frameGen)(frame => Bowling.score(List(frame)) == frame.first + frame.second)
    }
  }

  it should "calculate the score of an entire game (without strikes/spares) by combining all the frame scores" in {
    check {
      forAll(gameGen) {
        case game => Bowling.score(game) == game.map(f => f.first + f.second).sum
      }
    }
  }

}
