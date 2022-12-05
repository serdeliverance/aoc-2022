package io.github.sdev.aoc2022

import io.github.sdev.aoc2022.utils.Utils.{ filenameOf, readInput }
import io.github.sdev.aoc2022.day05.Day05Part1

object Playground:
  @main def solution() =
    val filename = filenameOf(5, 1)
    val lines    = readInput(filename)
    val result   = Day05Part1.solution(lines)
    println(result)
