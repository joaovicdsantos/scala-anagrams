package com.joaovicdsantos.anagrams

import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable.LinkedHashSet

import com.joaovicdsantos.anagrams.classes.Word
import com.joaovicdsantos.anagrams.utils.Calculator

/** Calculator Tests
 *
 * Perform the test of the basic functions
 * related to the Calculator object.
 */
class CalculatorSpec extends AnyFlatSpec {

  val word: Word = new Word("cowo")

  "Factorial of 5" must "be 120" in {
    assert(Calculator.factorial(5) == 120)
  }

  "The word cowo" must "have as anagrams..." in {
    val cowoAnagrams = LinkedHashSet("cowo", "ocwo", "owco", "owoc", "cwoo", 
        "wcoo", "woco", "wooc", "coow", "ocow", "oocw", "oowc")
    assert((Calculator.showAnagrams(word.content) diff cowoAnagrams).isEmpty)
  }

  it must "have 2 letters 'o'" in {
    assert(Calculator.repetitions(word)('o') == 2)
  }

  it must "have 12 anagrams" in {
    assert(Calculator.anagrams(word) == 12)
  }

}
