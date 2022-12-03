package io.github.sdev.aoc2022.day02

import io.github.sdev.aoc2022.day02.Day02Part1.solution

class Day02Part1Spec extends munit.FunSuite {
  test("calculate game result") {
    val input = List("A Y", "B X", "C Z")

    val result = solution(input)

    assertEquals(result, 15)
  }
}
