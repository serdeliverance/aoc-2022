package io.github.sdev.aoc2022.day01

import scala.annotation.tailrec

object Day01Part2:

  def solution(input: List[String]): Int =
    if (input.isEmpty) 0
    else calculateTop3CaloriesSum(List.empty, List.empty, input)

  @tailrec
  private def calculateTop3CaloriesSum(currentList: List[Int], listOfCaloriesSum: List[Int], input: List[String]): Int =
    if (input.isEmpty) (currentList.sum :: listOfCaloriesSum).sorted.reverse.take(3).sum
    else if (input.head.trim().isEmpty())
      calculateTop3CaloriesSum(List.empty, currentList.sum :: listOfCaloriesSum, input.tail)
    else calculateTop3CaloriesSum(input.head.toInt :: currentList, listOfCaloriesSum, input.tail)
