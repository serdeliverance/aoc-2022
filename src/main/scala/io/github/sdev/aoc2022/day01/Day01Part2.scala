package io.github.sdev.aoc2022.day01

object Day01Part2:

  def solution(input: List[String]): Int =
    if (input.isEmpty) 0
    else calculateTop3CaloriesSum(List.empty, List.empty, input)

  private def calculateTop3CaloriesSum(currentList: List[Int], listOfLists: List[List[Int]], input: List[String]): Int =
    ???
