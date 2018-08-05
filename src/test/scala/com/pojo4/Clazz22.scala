package com.pojo4


class Clazz22(mutableField: Int) {
  override def toString: String = s"Clazz22($mutableField)"
}

/**
  * Способ №2
  * SCALA позволяет создавать клас-компаньен (объект) и переопределять в нем метод по умолчанию apply - в котором можно можно пере-определять собственные параметры...
  * - прежде всего, такой клас-компаньен (объект) является синглтоном (подобно Enum в JAVA...) и поэтому здесь не нужен оператор 'new' для создания экземпляра класса
  * - метод по умолчанию apply вызывается неявно... и тем самым он имитирует конструктор (и с параметрами и без параметров)
  */
object Clazz22 {
  def apply() = new Clazz22(0) //def apply(): Clazz22 = new Clazz22(0)
  def apply(mutableField: Int) = new Clazz22(mutableField) //def apply(mutableField: Int): Clazz22 = new Clazz22(mutableField)
}
