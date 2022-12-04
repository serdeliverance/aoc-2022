package io.github.sdev.aoc2022.day04

import io.github.sdev.aoc2022.utils.Utils.{ filenameOf, readInput }

object Playground:
  @main def solution() =
    val filename = filenameOf(4, 2)
    val lines    = readInput(filename)
    val result   = Day04Part2.solution(lines)
    println(result)
