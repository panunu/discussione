package fi.metropolia.discussione.analyze

import fi.metropolia.discussione.parser.Parser
import fi.metropolia.mediaworks.juju.document.Doc
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor
import fi.metropolia.mediaworks.juju.syntax.parser.DocBuilder

class Analyzer {

  val docBuilder = new DocBuilder
  
  def analyze(content: List[Parser.Entry]) = {
    content.map(msg => extract(msg.message))
  }
  
  def extract(message: String) = {
    val extrator = new KeyphraseExtractor(docBuilder.generateDocWithOmorfi(message))
    extrator.process().getKeyphrases()
  }
  
}