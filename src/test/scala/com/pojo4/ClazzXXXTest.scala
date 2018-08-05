package com.pojo4


/**
  * case-класы в SCALA позволяют автоматически генерить специальные методы как: 'hashCode()', 'equals()', 'toString()'
  * (Эти специальные методы нужны для использования POJO-класа в качестве ключа для: хеш-таблиц, ...)
  * А также SCALA позволяют автоматически генерить все варианты apply-методов в класе-компаньена (сингтона) для конструктора case-класа (POJO-класа)
  * (тем самым SCALA предоставляет удобство для разработчика максимально упрощает создание и иннициализацию больших POJO-класов)
  */
object ClazzXXXTest extends App {

  val clazz111_1 = new Clazz111(1)
  println( "immutableField=" + clazz111_1.immutableField )
  println( clazz111_1 )

  val clazz111_2 = Clazz111(1)
  println( "immutableField=" + clazz111_2.immutableField )
  println( clazz111_2 )

  val clazz111_3 = Clazz111()
  println( "immutableField=" + clazz111_3.immutableField )
  println( clazz111_3 )


  val clazz222_1 = new Clazz222()
  println( "immutableField=" + clazz222_1.immutableField )
  println( clazz222_1 )

  val clazz222_2 = new Clazz222(1)
  println( "immutableField=" + clazz222_2.immutableField )
  println( clazz222_2 )

  val clazz222_3 = Clazz222()
  println( "immutableField=" + clazz222_3.immutableField )
  println( clazz222_3 )

  val clazz222_4 = Clazz222(1)
  println( "immutableField=" + clazz222_4.immutableField )
  println( clazz222_4 )

}
