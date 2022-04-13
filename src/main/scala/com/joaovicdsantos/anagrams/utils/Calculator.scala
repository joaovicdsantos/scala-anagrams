package com.joaovicdsantos.anagrams.utils

import scala.collection.mutable.LinkedHashSet
import scala.collection.mutable.Set

import com.joaovicdsantos.anagrams.classes.Word


/** Performs calculations related to the anagram
 *
 * It has utility functions that facilitate calculations related to anagrams.
 */
object Calculator {

  /** Calculate Factorial
   * 
   * Recursive function for factorial calculation.
   *
   * @param n number for calculate
   * @return result
   */
  def fatorial(n: Int): Int = {
    if (n <= 1)
      1
    else
      n*fatorial(n-1)
  }

  /** Count the repetitions of letters
   *
   * Iterates over two lists to search for repetead letters.
   *
   * @param word object Word
   * @return Map formed by: letter -> repetitions
   */
  def repetitions(word: Word): Map[Char, Int] = {
    var letters: Map[Char, Int] = Map()

    word.content foreach(c => {
      letters = letters + (c -> 0)
      word.content foreach(c2 => {
        if (c == c2) {
          val quantity = letters(c)+1
          letters += (c -> quantity)
        }
      })
    })

    letters
  }

  
  /** Calculate the number of anagrams
   *
   * Makes use of calculation functions to calculate the
   * number of anagrams.
   *
   * @param word object Word
   * @return number of anagrams
   */
  def anagrams(word: Word): Int = {
    var result: Int = fatorial(word.content.length)
    val wordRepetitions: Map[Char, Int] = repetitions(word)

    wordRepetitions foreach { case (k, v) => result /= fatorial(v) }

    result
  }

  /** Show All Anagrams
   *
   * Assemble all possible combinations.
   *
   * @param wordContent word for anagrams to be found
   * @return list with all anagrams
   */
  def showAnagrams(wordContent: String): Set[String] = {
    if (wordContent.length == 0) {
      Set(wordContent)
    } else {
      var anagrams: Set[String] = new LinkedHashSet[String]()
      for (w <- showAnagrams(wordContent.toCharArray.slice(1, wordContent.length).mkString))
        for (pos <- 0 to w.length)
          anagrams += s"${w.slice(0, pos).mkString}${wordContent(0)}${w.slice(pos, w.length).mkString}"
      anagrams
    }  
  }

}
