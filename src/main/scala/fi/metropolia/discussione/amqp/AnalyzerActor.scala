package fi.metropolia.discussione.amqp

import akka.actor.Actor
import discussione.parser.Parser
import discussione.analyze.Analyzer

class AnalyzerActor extends Actor {
  def receive = {
	case message: String => new Analyzer().analyze(Parser.simple.parse(message))
  }
}
