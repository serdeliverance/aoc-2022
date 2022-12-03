package io.github.sdev.aoc2022.day03

import io.github.sdev.aoc2022.day03.Day03Part1.toPriority

object Day03Part2:

  def solution(input: List[String]): Int =
    input
      .grouped(3)
      .map(findBadgeTypeInGroup)
      .collect {
        case Some(budget) => budget.toPriority()
        case _            => 0
      }
      .sum

  private def findBadgeTypeInGroup(group: List[String]): Option[Char] =
    val someRucksack = group.head
    someRucksack.find(item => group(1).contains(item) && group(2).contains(item))
