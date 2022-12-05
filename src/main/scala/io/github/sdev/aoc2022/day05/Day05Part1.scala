package io.github.sdev.aoc2022.day05

import scala.collection.mutable.Stack
import scala.util.Try
import scala.util.Success
import scala.collection.mutable.Queue
import scala.util.Failure

// TODO exercise variant: refactor to use a pure functional programming approach (no mutable state)
object Day05Part1:
  import Parser.parse

  case class Cmd(quantity: Int, from: Int, to: Int)

  extension (s: Stack[String])
    def pullN(n: Int): List[String] =
      def doPullN(s: Stack[String], n: Int, pulledElements: List[String]): List[String] =
        if (n == 0 || s.isEmpty) pulledElements.reverse
        else {
          val removed = s.pop()
          doPullN(s, n - 1, removed :: pulledElements)
        }
      doPullN(s, n, List.empty)

  def solution(input: List[String]) =
    val (stackList, cmdList) = parse(input)
    cmdList.foreach(cmd => {
      val crates = stackList(cmd.from - 1).pullN(cmd.quantity)
      crates.foreach(c => stackList(cmd.to - 1).push(c))
    })
    buildOutput(stackList)

  private def buildOutput(stackList: Array[Stack[String]]) =
    stackList
      .map(stack => Try(stack.pop()))
      .collect { case Success(top) =>
        top
      }
      .mkString

object Parser:
  import Day05Part1.Cmd

  private val WHITESPACE_REGEX = " +"

  sealed trait InputType
  case class StackInput(line: String)                   extends InputType
  case class StackCount(count: Int)                     extends InputType
  case object NonInput                                  extends InputType
  case class Command(quantity: Int, from: Int, to: Int) extends InputType

  def parse(input: List[String]): (Array[Stack[String]], List[Cmd]) =
    var processingCommands = false
    val eof                = input.size - 1
    var i                  = 0

    var stackCount = 0

    var stackInput = Queue[String]()

    while (i <= eof) {
      val line = parseLine(input(i))
      line match
        case StackInput(line)            => stackInput.enqueue(line)
        case StackCount(count)           => stackCount = count
        case Command(quantity, from, to) => // TODO push commands to a queue
        case NonInput                    => ()

      i += 1
    }

    (null, null)

  private def parseLine(line: String): InputType =
    if (isHeaderLine(line)) parseHeader(line)
    else if (isStackLine(line)) parseStackLine(line)
    else if (isCommandLine(line)) parseCommandLine(line)
    else NonInput

  private def parseHeader(line: String): StackCount =
    val count = line.split(WHITESPACE_REGEX).map(_.toInt).size
    StackCount(count)

  private def isHeaderLine(line: String) =
    line
      .split(WHITESPACE_REGEX)
      .headOption
      .map(h =>
        Try(h.toInt) match
          case Failure(_) => false
          case Success(_) => true
      )
      .getOrElse(false)

  private def parseCommandLine(line: String) =
    val splitted = line.split(WHITESPACE_REGEX)
    val quantity = splitted(1).toInt
    val from     = splitted(3).toInt
    val to       = splitted(5).toInt
    Command(quantity, from, to)

  // TODO add regex to have a strong line validation
  private def isCommandLine(line: String) = line.startsWith("move")

  private def isStackLine(line: String) =
    line.split(" +").headOption.map(first => first matches "\\[[A-Z]\\]").getOrElse(false)

  private def parseStackLine(line: String) =
    StackInput(line)
