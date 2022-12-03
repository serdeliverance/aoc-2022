package io.github.sdev.aoc2022.utils

import scala.io.Source._
import scala.io.Source

object Utils:

    def readInput(filename: String) =
        Source.fromResource(filename).getLines().toList

