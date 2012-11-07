package fi.metropolia.discussione.analyze

import scalaj.collection.Imports._
import fi.metropolia.discussione.parser.Parser
import fi.metropolia.mediaworks.juju.document.Doc
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor
import fi.metropolia.mediaworks.juju.syntax.parser.DocBuilder
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor.Result
import sun.misc.Sort

class Analyzer {

  val docBuilder = new DocBuilder
  
  def analyze(unprocessed: List[Unprocessed]) = {
    // Objectify.
	Map(
	  "discussion" -> unprocessed.map(analyzeOne),  
	  "summary" -> Map(
	    "keyphrases" -> analyzeAll(unprocessed)
	  )
	)
  }
  
  /**
   * Generates JSON in a following format:
   * {
   *   author:     "...",
   *   timestamp:  "...",
   *   message:    "...",
   *   keyphrases: { "word": 1.0, ... },
   * }
   */
  def analyzeOne(original: Unprocessed): Processed = {
	val result = process(original.message)

	new Processed(
	    original, 
	    keyphrase(result)
	)
  }
  
  def analyzeAll(data: List[Unprocessed]) = {
    keyphrase(process(data.map(_.message).reduce(_ + _))).filter(_._2 > 1)
  }
  
  private def process(message: String) =
    new KeyphraseExtractor(docBuilder.generateDocWithOmorfi(message)).process
  
  private def keyphrase(result: Result) =
    result.getKeyphrases().asScala.map { case (key, value) => (key.toString(), value) } // Todo: Weights.
  
}