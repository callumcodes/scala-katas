import org.scalatest.{FlatSpec, Matchers}

class PartridgeSpec extends FlatSpec with Matchers {

  val lynnMessage = "Lynn, I've pierced my foot on a spike!!"

  "Alan" should "say spike message when there are no words" in {
    Partridge.chat() shouldBe lynnMessage
  }

  it should "say spike message for unrelated words" in {
    Partridge.chat(List("Hello", "World")) shouldBe lynnMessage
  }

  it should "say 'Mine's a pint!' for 'Partridge'" in {
    Partridge.chat(List("Partridge")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!' for 'PearTree'" in {
    Partridge.chat(List("PearTree")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!' for 'Chat'" in {
    Partridge.chat(List("Chat")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!' for 'Dan'" in {
    Partridge.chat(List("Dan")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!' for 'Toblerone'" in {
    Partridge.chat(List("Toblerone")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!' for 'Lynn'" in {
    Partridge.chat(List("Lynn")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!' for 'AlphaPapa'" in {
    Partridge.chat(List("AlphaPapa")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!' for 'Nomad'" in {
    Partridge.chat(List("Nomad")) shouldBe "Mine's a Pint!"
  }

  it should "say 'Mine's a pint!!' for two related terms" in {
    Partridge.chat(List("AlphaPapa", "Partridge")) shouldBe "Mine's a Pint!!"
  }

  it should "say 'Mine's a pint!!!' for three related terms" in {
    Partridge.chat(List("AlphaPapa", "Partridge", "Lynn")) shouldBe "Mine's a Pint!!!"
  }

  it should "say 'Mine's a pint!!!!' for four related terms" in {
    Partridge.chat(List("AlphaPapa", "Partridge", "Lynn", "Dan")) shouldBe "Mine's a Pint!!!!"
  }

  it should "say 'Mine's a pint!! for two related terms and one unrelated term" in {
    Partridge.chat(List("Chat", "with", "Partridge")) shouldBe "Mine's a Pint!!"
    Partridge.chat(List("Partridge", "book", "Nomad")) shouldBe "Mine's a Pint!!"
  }

  it should "say 'Mine's a pint!!! for three related terms and and many unrelated terms" in {
    Partridge.chat(List(
      "Following",
      "the",
      "success",
      "of",
      "the",
      "movie",
      "AlphaPapa",
      "Alan",
      "Partridge",
      "has",
      "a",
      "new",
      "book",
      "called",
      "Nomad"
    )) shouldBe "Mine's a Pint!!!"
  }

  it should "Duplicate terms should produce extra !'s" in {
    Partridge.chat(List("Partridge", "Partridge", "Partridge")) shouldBe "Mine's a Pint!!!"
  }
}
