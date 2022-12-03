package io.github.sdev.aoc2022.day01

import io.github.sdev.aoc2022.utils.Utils.{ filenameOf, readInput }

object Playground:

  @main def solution() =
    val filename = filenameOf(1, 2)
    val lines    = readInput(filename)
    val result   = Day01Part2.solution(lines)
    println(result)
