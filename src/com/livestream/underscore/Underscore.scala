package com.livestream.underscore

object Underscore {

  def once(fn: => Any) = {
    var ran = false
    var memo: Any = null
    new Function1[Any, Any] {
      def apply(v1: Any) = {
        if (ran) {
          memo
        } else {
          ran = true
          memo = fn
          memo
        }
      }
    }
  }
  
  def after(count: Int, fn: => Any) = {
    new Function1[Any, Any] {
      var myCount = count
      def apply(v1: Any) = {
        myCount = myCount - 1
        if (myCount < 0) {
          fn
        }
      }
    }
  }

//private[this] def init(a: Int) = {
//  println("inited : " + a)
//  System.currentTimeMillis()
//}
//
//private[this]def render() {
//  println("rendering")
//}
//
//private[this] def asyncSave(callback: => Any) {
//  new Thread() {
//    override def run() {
//      println("running callback " + Thread.currentThread())
//      callback
//    }
//  }.start()
//}
//
// def main(args: Array[String]) {
//    var v = once(init(12))
//    println(v())
//    println(v())
//    println(v())
//    var v = after(3, render)
//  for (i <- 1 to 4) {
//    asyncSave(v())
//  }
//}
}