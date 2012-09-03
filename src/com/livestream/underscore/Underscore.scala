package com.livestream.underscore
import java.util.concurrent.atomic.AtomicInteger

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
      var myCount = new AtomicInteger(count)
      def apply(v1: Any) = {
        if (myCount.decrementAndGet() < 0) {
          fn
        }
      }
    }
  }

//  private[this] def init(a: Int) = {
//    println("inited : " + a)
//    System.currentTimeMillis()
//  }
//
//  private[this] def render() {
//    println("rendering")
//  }
//
//  private[this] def asyncSave(callback: => Any) {
//    new Thread() {
//      override def run() {
//        println("running callback " + Thread.currentThread())
//        callback
//      }
//    }.start()
//  }
//
//  def main(args: Array[String]) {
//    var v1 = once(init(12))
//    println(v1())
//    println(v1())
//    println(v1())
//    var v2 = after(3, render)
//    for (i <- 1 to 4) {
//      asyncSave(v2())
//    }
//  }
}