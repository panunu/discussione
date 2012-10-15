package discussione.amqp

import akka.actor.Actor

class AnalyzerActor extends Actor {
  def receive = {
	case message: String => println(message)
  }
}
