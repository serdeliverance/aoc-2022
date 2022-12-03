package io.github.sdev.aoc2022.day02

import io.github.sdev.aoc2022.utils.Utils.{ filenameOf, readInput }

object Playground:
  @main def solution() =
    val filename = filenameOf(2, 2)
    val lines    = readInput(filename)
    val result   = Day02Part2.solution(lines)
    println(result)
