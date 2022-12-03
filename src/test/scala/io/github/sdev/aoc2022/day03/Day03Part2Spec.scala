package io.github.sdev.aoc2022.day03

import io.github.sdev.aoc2022.day03.Day03Part2.solution

class Day03Part2Spec extends munit.FunSuite {
    test("determine badge and calculate priority sum") {
        val input = List(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        )

        val result = solution(input)

        assertEquals(result, 70)
    }
}
