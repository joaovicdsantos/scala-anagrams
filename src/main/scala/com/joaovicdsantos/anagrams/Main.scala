package com.joaovicdsantos.anagrams

import scala.util.Failure

import com.joaovicdsantos.anagrams.classes.Word
import com.joaovicdsantos.anagrams.exception.AnagramsException


/** Main Object
 *
 * run the project
 */
object Main {
  def main(args: Array[String]) = {
    
    if (args.length < 1) {
      throw new AnagramsException("Word not found!\nUsage: scala anagrams <words>")
    }

    println("....:::::: Anagrams ::::::....")

    for (i <- args) {

      val word = new Word(i)

      println(s"word: ${word.content}\n" +
              s"splited: ${word.splited}\n" +
              s"length: ${word.length}\n" +
              s"number of anagrams: ${word.anagrams}\n" +
              s"repetitions: ${word.anagrams}")

    }
    
  }
}
