package fi.metropolia.discussione.analyze

import fi.metropolia.discussione.analyze.aspect._
import scala.collection.Map

class Analyzer {
  val keyphrase = new Keyphrase
  val stream = new Stream
  val award = new Award
  val difference = new Difference

  def analyze(unprocessed: List[Unprocessed]) = {
	  Map(
	    "discussions" -> process(unprocessed),
	    "summary" -> Map(
        "keyphrases" -> keyphrase.all(unprocessed).filter(_._2 >= 0.2),
        "differences" -> difference.all(unprocessed),
        "stream" -> stream.all(unprocessed),
        "awards" -> award.all(unprocessed)
	    )
	  )
  }
  
  private def process(unprocessed: List[Unprocessed]) = {
    unprocessed.map(original => Map(
	    "data" -> original,
	    "keyphrases" -> keyphrase.single(original)
    ))
  }
  
}