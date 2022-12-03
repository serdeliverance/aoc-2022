package io.github.sdev.aoc2022.day01

import io.github.sdev.aoc2022.utils.Utils.readInput

object Playground:

    @main def solution() =
        val lines = readInput("input-day01part1.txt")
        val result = Day01Part1.solution(lines)
        println(result)