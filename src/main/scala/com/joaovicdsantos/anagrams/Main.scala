package com.joaovicdsantos.anagrams

import java.io.File
import java.io.PrintWriter
import scala.io.StdIn
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
              s"repetitions: ${word.repetitions}")

      print("Show anagrams and save them to file(y/N)? ")
      val res = StdIn.readChar()
      if (res.equals('y')) {
        // Create file
        val writer = new PrintWriter(new File(s"./${word.content}.anagrams.txt"))

        val anagrams = word.showAnagrams
        println(s"anagrams: ${anagrams}")

        for (anagram <- anagrams) {
          writer.write(s"$anagram\n")
        }

        writer.close()

      }

    }

  }

}
