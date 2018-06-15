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


  def runGames(games: (List[Frame], Int)*) = {
    games.foreach {
      case (game, result) => Bowling.score(game) shouldBe result
    }
  }

  it should "add a bonus equal to the next roll after a spare occurs" in {
    runGames(
      List(Frame(1, 9), Frame(5, 3)) -> 23, // (10 + 5) + 8 = 23
      List(Frame(1, 9), Frame(0, 3)) -> 13, // (10 + 0) + 3 = 18
      List(Frame(1, 5), Frame(5, 3), Frame(6, 4), Frame(9, 0)) -> 42, // 6 + 8 + (10 + 9) + 9 = 42
      List(Frame(1, 5), Frame(5, 3), Frame(6, 4), Frame(9, 1)) -> 43 // 6 + 8 + (10 + 9) + (10 + 0) = 43
    )
  }

  it should "add a bonus equal to the next two rolls after a strike occurs" in {
    runGames(
      List(Frame(10, 0), Frame(5, 3)) -> 26, // (10 + 5 + 3) + 8 = 26
      List(Frame(0, 0), Frame(10, 0)) -> 10, // 0 + (10 + 0 + 0) = 10
      List(Frame(10, 0), Frame(1, 9)) -> 30, // (10, 1 + 9) + (10 + 0) = 30 - Spare after Strike
      List(Frame(10, 0), Frame(10, 0), Frame(5, 5)) -> 55, // (10 + 10 + 5) + (10 + 5 + 5) + 10  - Double
      List.fill(5)(Frame(10, 0)) -> 120 // (10 + 10 + 10) + (10 + 10 + 10) + (10 + 10 + 10) + (10 + 10 + 10) + 10 - "High Five"
    )
  }



}
