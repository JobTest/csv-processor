package com.trait5


/**
  * @see http://bavadim.me/programming/2015/01/25/Notes-about-FP.html
  */
object IntSetTest extends App {

  val elem1 = new NonEmpty(1, new Empty(), new Empty())
  println( "contains 1 = " + elem1.contains(1) )
  println( "contains 2 = " + elem1.contains(2) )

  val elem2 = IntSet(2)
  println( "contains 1 = " + elem2.contains(1) )
  println( "contains 2 = " + elem2.contains(2) )
}