package fi.metropolia.discussione.analyze.actor

import akka.actor.Actor
import fi.metropolia.discussione.parser.Parser
import fi.metropolia.discussione.analyze.Analyzer
import fi.metropolia.discussione.amqp.AMQP
import com.codahale.jerkson.Json._

class AnalyzerActor extends Actor {
  
  private val analyzer = new Analyzer
  
  def receive = {
    case message: String => {
      val data = Parser.simple.parse(message)
            
      val amqp = new AMQP
      amqp produce("processed", AMQP.encode(generate(analyzer.analyze(data))))
      amqp close()
    }
  }
}
