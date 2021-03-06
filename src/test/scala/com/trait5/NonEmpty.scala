package com.trait5

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  override def incl(x: Int) = { //вообще неиспользуется
    if (x < elem) new NonEmpty(elem, left.incl(x), right)
    else if (x > elem) new NonEmpty(elem, left, right.incl(x))
    else this
  }

  override def contains(x: Int) = {
    if (x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else true
  }
}
