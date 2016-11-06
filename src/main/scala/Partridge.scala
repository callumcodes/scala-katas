object Partridge {

  val alanRelatedTerms = List(
    "Partridge",
    "PearTree",
    "Chat",
    "Dan",
    "Toblerone",
    "Lynn",
    "AlphaPapa",
    "Nomad"
  )

  def chat(words: List[String] = List()): String = {
    if(words.intersect(alanRelatedTerms).nonEmpty)
      "Mine's a Pint" + "!" * words.length
    else
      "Lynn, I've pierced my foot on a spike!!"
  }
}
