package com.pojo4

/**
  * Прежде всего SCALA это безопасный язык.
  * Такая безопасность основывается на атомарности (то есть неизменных - immutable) объектов, которые создаются в программе.
  * ***
  * В JAVA чтобы достич атомарности для объектов применяются бины - это POJO-классы - они служат чтобы хранить состояние объекта.
  * Такие POJO-классы имеют приватные поля и публичные get-set-методы которые выполняют только единственную операцию (получить или сохранить) данные.
  * Чтобы создавать такие бины (POJO-классы) в JAVA приходится преодолевать много проблем, например:
  * - каждый POJO-класс может изменять свое состояние (то есть является - mutable) и по этой причине использовать такой объект в качестве ключа в хеш-таблицах является небезопасно...
  * + чтобы в многопоточной среде получить синхронный объект для этого применяются:
  *   - (статические) static-классы и Enum-ы
  *   - а для более глубокой синхронизации тела объекта - synchronization-блоки и volatile-поля
  * + concurrency-библиотека которая имеет:
  *   - атомарные типы классов...
  *   - и синхронизированные хеш-таблицы (которые построены на технологиях быстрого перебора и дробления блоков...)
  * ***
  * В этом плане SCALA продвинулась дальше и облегчила способ создания/описания для POJO-классов.
  * Можно прямо в конструкторе POJO-класса перечислить все поля этого класса, а SCALA уже сам создаст поля-класса и get-set-методы для доступа к ним...
  */

//По умолчанию все POJO-классы являются immutable-объектами с приватными полями (в этом случае SCALA не создает публичные get-set-методы для полей)
class Clazz0(privateField: Int) {
  override def toString: String = s"Clazz0($privateField)"
}

//'val' делает поле immutable и позволяет создавать только публичные get-методы
class Clazz2(val immutableField: Int) {
  override def toString: String = s"Clazz2($immutableField)"
}

//'var' делает поле mutable и позволяет создавать публичные get-set-методы
class Clazz3(var mutableField: Int) {
  override def toString: String = s"Clazz3($mutableField)"
}


object ClazzXTest extends App {

  val clazz0: Clazz0 = new Clazz0(1)
  //  println( clazz0.privateField )
  println( clazz0 )

  val clazz2: Clazz2 = new Clazz2(1)
  println( "immutableField=" + clazz2.immutableField )
//  clazz2.immutableField = 2
  println( clazz2 )

  val clazz3: Clazz3 = new Clazz3(1)
  clazz3.mutableField = 2
  println( "mutableField=" + clazz3.mutableField )
  println( clazz3 )

}