package fi.metropolia.discussione.analyze

/*import fi.metropolia.mediaworks.juju.document.Doc;
import fi.metropolia.mediaworks.juju.extractor.Grams;
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor;
import fi.metropolia.mediaworks.juju.extractor.keyphrase.KeyphraseExtractor.Result;
import fi.metropolia.mediaworks.juju.syntax.parser.DocBuilder;*/
import discussione.parser.Parser

class Analyzer {

  def analyze(content: List[Parser.Entry]) = {
    content.map(println)
  }
  
}