import domain.Frame
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll
import org.scalatest.prop.Checkers
import org.scalatest.{FlatSpec, Matchers}

class FrameSpec extends FlatSpec with Matchers with Checkers {

  val notTenGen = (for {
    first <- Gen.choose(0, 10)
    second <- Gen.choose(0, 10)
  } yield Frame(first, second)) suchThat (f => f.first + f.second != 10)

  "isSpare" should "be true when the total score is 10" in {
    (0 to 10).zip(10 to 0 by -1).foreach {
      case (first, second) => assert(Frame(first, second).isSpare, s"Frame($first, $second).isSpare")
    }
  }

  it should "be false when the score is not 10" in {
    check {
      forAll(notTenGen)(frame => !frame.isSpare)
    }
  }
}
