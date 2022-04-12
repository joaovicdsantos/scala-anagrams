package com.joaovicdsantos.anagrams.utils

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

}
