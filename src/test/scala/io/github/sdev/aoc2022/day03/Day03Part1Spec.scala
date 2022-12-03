package io.github.sdev.aoc2022.day03

import io.github.sdev.aoc2022.day03.Day03Part1.solution

class Day03Part1Spec extends munit.FunSuite {
    test("find missed items and calculate priority sum") {
        val input = List(
          "vJrwpWtwJgWrhcsFMMfFFhFp",
          "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
          "PmmdzqPrVvPwwTWBwg",
          "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
          "ttgJtRGJQctTZtZT",
          "CrZsJsPPZsGzwwsLwLmpwMDw"
        )
      
        val result = solution(input)
      
        assertEquals(result, 157)
    }
}
