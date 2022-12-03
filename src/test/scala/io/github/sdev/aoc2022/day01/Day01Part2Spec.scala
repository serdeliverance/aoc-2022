package io.github.sdev.aoc2022.day01

import io.github.sdev.aoc2022.day01.Day01Part2.solution

class Day01Part2Spec extends munit.FunSuite {
    test("calculate top 3 max calories sum") {
    val input = List("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000")

    val result = solution(input)

    assertEquals(result, 45000)
  }
}