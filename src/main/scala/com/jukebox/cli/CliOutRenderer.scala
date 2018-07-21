package com.jukebox.cli

object CliOutRenderer {

  implicit class Repeat(count: Int) {
    def repeat(doIt: => Unit) = {
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
