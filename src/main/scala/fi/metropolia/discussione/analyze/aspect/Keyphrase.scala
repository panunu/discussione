package fi.metropolia.discussione.analyze.aspect

import scalaj.collection.Imports._
import scala.collection.Map
import fi.metropolia.discussione.parser.Parser
import fi.metropolia.mediaworks.juju.document.Doc
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor
import fi.metropolia.mediaworks.juju.syntax.parser.DocBuilder
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor.Result
import fi.metropolia.discussione.analyze._

class Keyphrase {
  val docBuilder = new DocBuilder
  
  /**
   * Filters results: only takes words which have a frequency of > 1.
   */
  def all(data: List[Unprocessed]): Map[String, Double] = keyphrase(process(data.map(_.message).reduce(_ + _)))
  
  /**
   * Does not filter based on frequencies.
   */
  def single(original: Unprocessed): Map[String, Double] = keyphrase(process(original.message))
  
  private def keyphrase(result: Result) =
    result.getKeyphrases().asScala.map { case (key, value) => (key.toString().asInstanceOf[String], value) } // Todo: Weights.

  private def process(message: String) = {
    val extractor = new KeyphraseExtractor(docBuilder.generateDocWithOmorfi(message))
    extractor.addDefaultWeighters("hs")
    extractor.process
  }
  
}