package io.github.sdev.aoc2022.day01

import scala.annotation.tailrec

object Day01Part1:

  def solution(input: List[String]): Int =
    if (input.isEmpty) 0
    else calculateMaxCalories(0, 0, input)

  @tailrec
  private def calculateMaxCalories(currentElvCalories: Int, maxCalories: Int, input: List[String]): Int =
    if (input.isEmpty) getMaxCalories(currentElvCalories, maxCalories)
    else if (input.head.isEmpty) calculateMaxCalories(0, getMaxCalories(currentElvCalories, maxCalories), input.tail)
    else calculateMaxCalories(currentElvCalories + input.head.toInt, maxCalories, input.tail)

  private def getMaxCalories(a: Int, b: Int) =
    if (a > b) a
    else b
