package io.github.sdev.aoc2022.day04

import io.github.sdev.aoc2022.day04.Day04Part1.solution

class Day04Part1Spec extends munit.FunSuite {
  test("overlapping working elvs count") {
    val input = List("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8")

    val result = solution(input)

    assertEquals(result, 2)
  }
}
