package com.pojo4

/**
  * Способ №1
  * SCALA позволяет иннициализировать поля-параметры прямо в конструкторе класа (и тогда можно уже непередавать эти параметры в конструкторе) - это иммитирует констуктор по умолчанию (без параметров)
  */
class Clazz11(privateField: Int = 0) {
  override def toString: String = s"Clazz11($privateField)"
}
