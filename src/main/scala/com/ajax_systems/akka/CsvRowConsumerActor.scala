package com.ajax_systems.akka

import akka.actor.{Actor, ActorLogging, Props}
import com.ajax_systems.akka.CsvRowConsumerActor.ConsumeCsvRow

class CsvRowConsumerActor extends Actor with ActorLogging {

  override def receive: Receive = {

    case ConsumeCsvRow(row) =>
      log.info("Received {}", row)

  }
}

object CsvRowConsumerActor {

  def props(): Props = Props[CsvRowConsumerActor]

  case class ConsumeCsvRow(row: Vector[String])

}

