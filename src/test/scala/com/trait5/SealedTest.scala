package com.trait5


/**
  * @see https://habr.com/post/318960
  *      http://qaru.site/questions/26457/what-is-a-sealed-trait
  *      ( https://stackoverflow.com/questions/1898932/case-objects-vs-enumerations-in-scala )
  */

sealed trait Answer
case object Yes extends Answer
case object No extends Answer

//trait Enum[A] {
//  trait Value { self: A =>
//    _values :+= this
//  }
//  private var _values = List.empty[A]
//  def values = _values
//}
//
//sealed trait Currency extends Currency.Value
//object Currency extends Enum[Currency] {
//  case object EUR extends Currency
//  case object GBP extends Currency
//}
//
////object Currency extends Enum[Currency]
////sealed trait Currency extends Currency.Value
////case object EUR extends Currency
////case object GBP extends Currency


object SealedTest extends App {

  val x: Answer = Yes
//  val x: Answer = No
  x match {
    case No => println("No")
    case _ => println(" unknown? ")
  }

//  Currency.EUR
}
