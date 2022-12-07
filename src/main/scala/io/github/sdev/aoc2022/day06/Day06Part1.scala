package io.github.sdev.aoc2022.day06

import scala.collection.mutable.Queue
import scala.annotation.tailrec

object Day06Part1:

  def solution(input: String) =
    findBeginningMessagePositionWithMarkerOfSize(input, 4)

  def findBeginningMessagePositionWithMarkerOfSize(input: String, markerSize: Int) =
    if (input.length() <= markerSize) -1
    else
      findBeginningMessagePosition(
        Queue[Char](input.substring(0, markerSize).toList: _*),
        markerSize,
        input.substring(markerSize).toList
      )

  @tailrec
  private def findBeginningMessagePosition(
      current: Queue[Char],
      lastMarkerCharPosition: Int,
      remaining: List[Char]
  ): Int =
    if (allDistincts(current)) then lastMarkerCharPosition
    else if (remaining.isEmpty) then -1
    else {
      current.dequeue()
      current.enqueue(remaining.head)
      findBeginningMessagePosition(current, lastMarkerCharPosition + 1, remaining.tail)
    }

  private def allDistincts(queue: Queue[Char]) =
    queue.toList.distinct.size == queue.size
