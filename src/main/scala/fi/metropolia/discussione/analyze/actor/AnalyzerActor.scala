package fi.metropolia.discussione.analyze.actor

import akka.actor.Actor
import fi.metropolia.discussione.parser.Parser
import fi.metropolia.discussione.analyze.Analyzer

class AnalyzerActor extends Actor {
  private val analyzer = new Analyzer
  
  def receive = {
    case message: String => analyzer.analyze(Parser.simple.parse(message))
  }
}
