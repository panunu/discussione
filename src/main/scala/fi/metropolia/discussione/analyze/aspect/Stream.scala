package fi.metropolia.discussione.analyze.aspect

import scala.collection.mutable.Map
import fi.metropolia.discussione.analyze._

class Stream {
  val keyphrase = new Keyphrase

  // TODO: This is horrible. Refactor to functional once you know how.
  def all(data: List[Unprocessed]): Map[String, List[Map[String, Any]]] = {
    val keyphrases = data.map(keyphrase single _)

    val dictionary = keyphrases.flatMap(_.map(_._1)).distinct
	  val streamed = Map[String, List[Map[String, Any]]]()
    var x = 0.0

	  for (word <- dictionary) {
      var x = 0.0
	    for (keyphrase <- keyphrases) {
	  	  streamed.put(word, streamed.getOrElse(word, List()) ::: List(Map("name" -> word, "x" -> x, "y" -> keyphrase.getOrElse(word, 0.0))))
        x = x + 1
	    }
	  }

    streamed
  }
  
}
