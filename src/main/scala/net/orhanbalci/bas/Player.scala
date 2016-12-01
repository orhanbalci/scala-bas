package net.orhanbalci.bas
import akka.actor.{Actor, ActorRef, Props}
import akka.io.{Tcp}


class Player(id : String, connection : ActorRef) extends Actor {
	
	def receive = {
		case Tcp.Received => 
		case Tcp.PeerClosed =>
			context.parent ! Table.UnRegister(id)
			context stop self

	}
}

object Player {
	def props(id : String, connection : ActorRef)  : Props ={
		Props(new Player(id, connection))
	}

}