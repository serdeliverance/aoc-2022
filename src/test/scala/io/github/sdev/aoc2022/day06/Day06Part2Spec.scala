package io.github.sdev.aoc2022.day06

import Day06Part2.solution

class Day06Part2Spec extends munit.FunSuite {
    test("find marker sequence #1") {
        val input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"

        val result = solution(input)

        assertEquals(result, 19)
    }

    test("find marker sequence #2") {
        val input = "bvwbjplbgvbhsrlpgdmjqwftvncz"

        val result = solution(input)

        assertEquals(result, 23)
    }

    test("find marker sequence #3") {
        val input = "nppdvjthqldpwncqszvftbrmjlhg"

        val result = solution(input)

        assertEquals(result, 23)
    }

    test("find marker sequence #4") {
        val input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"

        val result = solution(input)

        assertEquals(result, 29)
    }

        test("find marker sequence #5") {
        val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

        val result = solution(input)

        assertEquals(result, 26)
    }
}