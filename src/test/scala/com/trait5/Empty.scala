package com.trait5

class Empty extends IntSet {
  override def incl(x: Int) = new NonEmpty(x, new Empty(), new Empty())
  override def contains(x: Int) = false
}

object Empty extends IntSet {
  override def incl(x: Int) = new NonEmpty(x, new Empty(), new Empty())
  override def contains(x: Int) = true //вообще неиспользуется
}
