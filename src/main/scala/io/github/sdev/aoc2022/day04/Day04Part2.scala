package io.github.sdev.aoc2022.day04

import Day04Part1.countOverlaps

object Day04Part2:

  def solution(input: List[String]) =
    countOverlaps(input, existsOverlap)

  private def existsOverlap(r1: Range, r2: Range) =
    !r1.intersect(r2).isEmpty
