package io.githug.sdev.aoc2022.day05

import io.github.sdev.aoc2022.day05.Day05Part1.solution

class Day05Part1Spec extends munit.FunSuite {
  test("moving suplies between stacks") {
    val input = List(
      "    [D]",
      "[N] [C]",
      "[Z] [M] [P]",
      " 1   2   3 ",
      "",
      "move 1 from 2 to 1",
      "move 3 from 1 to 3",
      "move 2 from 2 to 1",
      "move 1 from 1 to 2"
    )

    val result = solution(input)

    assertEquals(result, "CMZ")
  }
}
