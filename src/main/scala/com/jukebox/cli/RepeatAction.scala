package com.jukebox.cli

object RepeatAction {

  implicit class Repeat(count: Int) {
    def times(doIt: => Unit) = {
      def loop(loopCount: Int) {
        if(loopCount > 0) {
          doIt
          loop(loopCount-1)
        }
      }
      loop(count)
    }
  }

}
