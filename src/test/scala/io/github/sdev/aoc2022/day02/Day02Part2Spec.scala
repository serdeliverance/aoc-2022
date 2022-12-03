package io.github.sdev.aoc2022.day02

import io.github.sdev.aoc2022.day02.Day02Part2.solution

class Day02Part2Spec extends munit.FunSuite {
  test("calculate game result based on strategy") {
    val input = List("A Y", "B X", "C Z")

    val result = solution(input)

    assertEquals(result, 12)
  }
}
