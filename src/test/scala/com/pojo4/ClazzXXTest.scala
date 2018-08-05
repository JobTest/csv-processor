package com.pojo4


/**
  * Проблема в том что такие POJO-классы не имеют конструктора по умолчанию, поэтому создавать такой объект нужно только через конструктор с параметрами...
  * Но SCALA есть способы которые позволяют обойти-решить эту проблему
  */
object ClazzXXTest extends App {

  val clazz11_1: Clazz11 = new Clazz11()
//    println( clazz11_1.privateField )
  println( clazz11_1 )

  val clazz11_2: Clazz11 = new Clazz11(1)
  //    println( clazz11_2.privateField )
  println( clazz11_2 )

  val clazz11_3 = new Clazz11()
  println( clazz11_3 )


  val clazz22_1: Clazz22 = Clazz22() //val clazz22_1: Clazz22 = Clazz22.apply()
  println( clazz22_1 )

  val clazz22_2: Clazz22 = Clazz22(1) //val clazz22_2: Clazz22 = Clazz22.apply(1)
  println( clazz22_2 )

  val clazz22_3 = Clazz22()
  println( clazz22_3 )


  val clazz33_1: Clazz33 = new Clazz33()
  println( clazz33_1 )
  clazz33_1.setMutableField(1) //clazz33_1.mutableField = 1
  println( "getMutableField=" + clazz33_1.getMutableField ) //println( "mutableField=" + clazz33_1.mutableField )
  println( clazz33_1 )

}
