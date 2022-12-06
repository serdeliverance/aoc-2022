package io.github.sdev.aoc2022.day06

import Day06Part1.solution

class Day06Part1Spec extends munit.FunSuite {
    test("find marker sequence #1") {
        val input = "bvwbjplbgvbhsrlpgdmjqwftvncz"

        val result = solution(input)

        assertEquals(result, 5)
    }

    test("find marker sequence #2") {
        val input = "nppdvjthqldpwncqszvftbrmjlhg"

        val result = solution(input)

        assertEquals(result, 6)
    }

    test("find marker sequence #3") {
        val input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"

        val result = solution(input)

        assertEquals(result, 10)
    }

    test("find marker sequence #4") {
        val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

        val result = solution(input)

        assertEquals(result, 11)
    }
}