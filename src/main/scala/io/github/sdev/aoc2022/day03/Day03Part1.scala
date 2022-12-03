package io.github.sdev.aoc2022.day03

object Day03Part1:

  def solution(input: List[String]): Int =
    input
      .map(extractMissedItem)
      .collect {
        case Some(item) => item.toPriority()
        case None       => 0
      }
      .sum

  private def extractMissedItem(rucksack: String): Option[Char] =
    val splitIdx                     = rucksack.size / 2
    val (compartmentA, compartmentB) = (rucksack.substring(0, splitIdx), rucksack.substring(splitIdx))
    compartmentA.find(item => compartmentB.contains(item))

  extension (c: Char)
    def toPriority() =
      if (c.isLower) c.toInt - 96
      else c.toInt - 38
