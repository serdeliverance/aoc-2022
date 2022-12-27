package io.github.sdev.aoc2022.day07

import io.github.sdev.aoc2022.day07.Day07Part1.solution

class Day07Part1Spec extends munit.FunSuite {
  test("build simple directory") {
    val input = List(
      "$ cd / ",
      "$ ls ",
      "dir a ",
      "14848514 b.txt ",
      "8504156 c.dat ",
      "dir d ",
      "$ cd a ",
      "$ ls ",
      "dir e ",
      "29116 f ",
      "2557 g ",
      "62596 h.lst ",
      "$ cd e ",
      "$ ls ",
      "584 i ",
      "$ cd .. ",
      "$ cd .. ",
      "$ cd d ",
      "$ ls ",
      "4060174 j ",
      "8033020 d.log ",
      "5626152 d.ext ",
      "7214296 k "
    )

    val result = solution(input)

    assertEquals(result, 95437)
  }
}
