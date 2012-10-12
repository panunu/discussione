package discussione.analysis

import akka.actor.Actor

class HelloActor extends Actor {
  
  def receive = {
	case message: String => println(message)
  }
}
