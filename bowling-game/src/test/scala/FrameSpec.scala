import domain.{Frame, Non, Spare, Strike}
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll
import org.scalatest.prop.Checkers
import org.scalatest.{FlatSpec, Matchers}

class FrameSpec extends FlatSpec with Matchers with Checkers {

  val frameGen = for {
    first <- Gen.choose(0, 10)
    second <- Gen.choose(0, 10)
  } yield Frame(first, second)

  val notTenGen = frameGen suchThat (f => f.total != 10 && f.first != 10)

  val notStrike = frameGen suchThat (_.first != 10)

  "bonus" should "be a spare when the total score is 10 (except strike)" in {
    (0 to 9).zip(10 to 0 by -1).foreach {
      case (first, second) => assert(Frame(first, second).bonus == Spare, s"Frame($first, $second).isSpare")
    }
  }

  it should "be None when the score is not 10" in {
    check {
      forAll(notTenGen)(frame => frame.bonus == Non)
    }
  }

  it should "be a strike when the first ball rolled is 10" in {
    Frame(10, 0).bonus shouldBe Strike
  }

  it should "include the final throw in the total" in {
    Frame(10, 5, Some(5)).total shouldBe 20
  }

}
