package io.github.sdev.aoc2022

import io.github.sdev.aoc2022.utils.Utils.{ filenameOf, readInput }
import io.github.sdev.aoc2022.day04.Day04Part2

object Playground:
  @main def solution() =
    val filename = filenameOf(4, 2)
    val lines    = readInput(filename)
    val result   = Day04Part2.solution(lines)
    println(result)
