object Main extends App {
  override def main(args: Array[String]): Unit = {
    if(args.length != 1) println("Sentence should be one argument")
    else println(Partridge.chat(args(0).split(' ').toList))
  }
}
