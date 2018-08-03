package com.ajax_systems.akka.service.dto



object Test extends App {

//  val thing: Thing = new Thing(0)
  val thing: Thing = new Thing

//  println( "_value = " + thing.value )
  println( thing )

  thing.value_=(10)
  println( thing )

//  println( "_value = " + thing._value )
  println( "value = " + thing.value )


  // ///////////////////////////////

  val adder = new MyAdder(2)
  println( adder )
  val result = adder(4) // equivalent to x.apply(4)
  println( result )

}
