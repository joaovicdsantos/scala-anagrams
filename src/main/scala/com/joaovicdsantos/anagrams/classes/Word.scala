package com.joaovicdsantos.anagrams.classes

import com.joaovicdsantos.anagrams.utils.Calculator


/** Represents the word
 *
 * Contains the attributes that will be needed for a word
 * @param content a word
 * @param splited char list
 * @param length word length
 */
class Word(val content: String, val splited: List[Char], val length: Int) {
  
  /** Instance with only text
   *
   * @constructor
   */
  def this(content: String) = this(content, content.map(_.toChar).toList, content.length)

  /** Instance example object
   *
   * @constructor
   */
  def this() = this("cow", List('c', 'o', 'w'), 3)

  /** Calculate Anagrams
   *
   * @return number of anagrams
   */
  def anagrams = Calculator.anagrams(this)
  
  /** Show Repetitions
   *
   * @return repetitions map
   */
  def repetitions = Calculator.repetitions(this)

}
