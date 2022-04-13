package com.joaovicdsantos.anagrams

import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable.LinkedHashSet

import com.joaovicdsantos.anagrams.classes.Word

/** Word Tests
 * 
 * Perform the test of the basic functions
 * related to the Word class.
 *
 */
class WordSpec extends AnyFlatSpec {

  val defaultWord: Word = new Word()

  "The default word" must "be cow" in {
    assert(defaultWord.content.equals("cow"))
  }

  it must "be formed by 'c', 'o' and 'w'" in {
    assert(defaultWord.splited == List('c', 'o', 'w'))
  }

  it must "have 3 letters" in {
    assert(defaultWord.length == 3)
  }

}
