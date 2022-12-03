package io.github.sdev.aoc2022.day03

import io.github.sdev.aoc2022.utils.Utils.{ filenameOf, readInput }

object Playground:
  @main def solution() =
    val filename = filenameOf(3, 2)
    val lines    = readInput(filename)
    val result   = Day03Part2.solution(lines)
    println(result)
