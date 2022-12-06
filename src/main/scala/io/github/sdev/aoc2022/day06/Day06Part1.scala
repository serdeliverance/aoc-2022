package io.github.sdev.aoc2022.day06

import scala.collection.mutable.Queue
import scala.annotation.tailrec


object Day06Part1:

    def solution(input: String) =
        if (input.length() <= 4) -1
        else findBeginningPackagePosition(Queue[Char](input.substring(0, 4).toList :_*), 4, input.substring(4).toList)

    @tailrec
    private def findBeginningPackagePosition(current: Queue[Char], lastMarkerCharPosition: Int, remaining: List[Char]): Int =
        if (allDistincts(current)) then lastMarkerCharPosition
        else if (remaining.isEmpty) then - 1
        else {
            current.dequeue()
            current.enqueue(remaining.head)
            findBeginningPackagePosition(current, lastMarkerCharPosition + 1, remaining.tail)
        }

    private def allDistincts(queue: Queue[Char]) =
        queue.toList.distinct.size == queue.size
