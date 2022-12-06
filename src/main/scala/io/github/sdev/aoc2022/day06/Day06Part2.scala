package io.github.sdev.aoc2022.day06

import scala.collection.mutable.Queue
import scala.annotation.tailrec
import Day06Part1.findBeginningMessagePositionWithMarkerOfSize


object Day06Part2:

    def solution(input: String) =
        findBeginningMessagePositionWithMarkerOfSize(input, 14)