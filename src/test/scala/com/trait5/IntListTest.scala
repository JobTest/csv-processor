package com.trait5


/**
  * @see http://bavadim.me/programming/2015/01/25/Notes-about-FP.html
  */

trait IntList {
  def isEmpty: Boolean
  def head: Int
  def tail: IntList

  override def toString: String = s"IntList($isEmpty, $head, $tail)"
}

class Nil extends IntList {
  override def isEmpty: Boolean = true
  override def head: Nothing = throw new NoSuchElementException("Nil.head")
  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

class Cons(val head: Int, val tail: IntList) extends IntList {
  override def isEmpty = false
}


object IntListTest extends App {

  val nil = new Nil()
  val cons = new Cons(1, nil)

  println( "isEmpty = " + cons.isEmpty )
  println( "head = " + cons.head )
//  println( "tail = " + cons.tail )
}
