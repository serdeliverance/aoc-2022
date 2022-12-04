package io.github.sdev.aoc2022.day04

object Day04Part1:

  def solution(input: List[String]) =
    input
      .filter(line => line matches "([0-9]|([1-9][0-9]+))-([0-9]|([1-9][0-9]+)),([0-9]|([1-9][0-9]+))-([0-9]|([1-9][0-9]+))")
      .map(parse)
      .count(rangePair => oneContainsAnother(rangePair._1, rangePair._2))

  private def parse(raw: String): (Range, Range) =
    val splittedInput = raw.split(",")
    (convertToRange(splittedInput(0)), convertToRange(splittedInput(1)))

  private def convertToRange(str: String): Range =
    val splitted = str.split("-")
    Range.inclusive(splitted(0).toInt, splitted(1).toInt)

  private def oneContainsAnother(r1: Range, r2: Range) =
    r1.containsSlice(r2) || r2.containsSlice(r1)
