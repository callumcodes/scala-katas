object Partridge {

  private val alanRelatedTerms = List(
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

    val matchedTerms = words.filter(alanRelatedTerms.contains)

    if(matchedTerms.nonEmpty)
      "Mine's a Pint" + "!" * matchedTerms.length
    else
      "Lynn, I've pierced my foot on a spike!!"

  }
}
