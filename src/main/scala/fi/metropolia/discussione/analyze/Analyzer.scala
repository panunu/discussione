package fi.metropolia.discussione.analyze

import scalaj.collection.Imports._
import fi.metropolia.discussione.parser.Parser
import fi.metropolia.mediaworks.juju.document.Doc
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor
import fi.metropolia.mediaworks.juju.syntax.parser.DocBuilder
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor.Result

class Analyzer {

  val docBuilder = new DocBuilder
  
  def analyze(content: List[Entry]) = {
	val analysis = content.map(analyzeOne)
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
  def analyzeOne(entry: Entry): Processed = {
	val result = process(entry.message)

	new Processed(
	    entry.author,
	    entry.date,
	    entry.message, 
	    keyphrase(result)
	)
  }
  
  private def process(message: String) =
    new KeyphraseExtractor(docBuilder.generateDocWithOmorfi(message)).process
  
  private def keyphrase(result: Result) =
    result.getKeyphrases().asScala.map { case (key, value) => (key.toString(), value) } // Todo: Weights.
  
}