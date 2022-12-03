package io.github.sdev.aoc2022.day01

import io.github.sdev.aoc2022.day01.Day01Part1.solution

class Day01Part1Spec extends munit.FunSuite {
    test("calculate max calories") {
        val input = List("1000",
            "2000",
            "3000",
            "",
            "4000",
            "",
            "5000",
            "6000",
            "",
            "7000",
            "8000",
            "9000",
            "",
            "10000")
        
        val result = solution(input)

        assertEquals(result, 24000)
    }
}