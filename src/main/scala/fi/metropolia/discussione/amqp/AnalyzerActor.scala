package fi.metropolia.discussione.amqp

import akka.actor.Actor
import fi.metropolia.discussione.parser.Parser
import fi.metropolia.discussione.analyze.Analyzer

class AnalyzerActor extends Actor {
  def receive = {
	case message: String => new Analyzer().analyze(Parser.simple.parse(message))
  }
}
