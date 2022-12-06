package io.github.sdev.aoc2022.day05

import scala.collection.mutable.Stack
import scala.util.Try
import scala.util.Success
import scala.collection.mutable.Queue
import scala.util.Failure

// TODO exercise variant: refactor to use a pure functional programming approach (no mutable state)
object Day05Part1:
  import Parser.parse

  case class Command(quantity: Int, from: Int, to: Int)

  extension (s: Stack[Char])
    def pullN(n: Int): List[Char] =
      def doPullN(s: Stack[Char], n: Int, pulledElements: List[Char]): List[Char] =
        if (n == 0 || s.isEmpty) pulledElements.reverse
        else {
          val removed = s.pop()
          doPullN(s, n - 1, removed :: pulledElements)
        }
      doPullN(s, n, List.empty)

  def solution(input: List[String]) =
    val (stackList, cmdList) = parse(input)

    while (!cmdList.isEmpty) {
      val cmd    = cmdList.dequeue()
      val crates = stackList(cmd.from - 1).pullN(cmd.quantity)
      crates.foreach(c => stackList(cmd.to - 1).push(c))
    }
    buildOutput(stackList)

  private def buildOutput(stackList: Array[Stack[Char]]) =
    stackList
      .map(stack => Try(stack.pop()))
      .collect { 
        case Success(top) => top
      }
      .mkString

object Parser:
  import Day05Part1.Command

  private val WHITESPACE_REGEX = " +"

  sealed trait Input
  case class StackInput(line: String)                        extends Input
  case class StackCount(count: Int)                          extends Input
  case object NonInput                                       extends Input
  case class CommandInput(quantity: Int, from: Int, to: Int) extends Input

  def parse(input: List[String]): (Array[Stack[Char]], Queue[Command]) =
    val eof = input.size - 1
    var i   = 0

    var stackCount = 0

    var stackInput   = Stack[String]()
    var commandQueue = Queue[Command]()

    while (i <= eof) {
      val line = parseLine(input(i))
      line match
        case StackInput(line)                 => stackInput.push(line)
        case StackCount(count)                => stackCount = count
        case CommandInput(quantity, from, to) => commandQueue.enqueue(Command(quantity, from, to))
        case NonInput                         => ()

      i += 1
    }

    (buildStackArraysFromInputs(stackInput, stackCount), commandQueue)

  private def buildStackArraysFromInputs(stackInput: Stack[String], size: Int): Array[Stack[Char]] =
    var arrayOfStacks = Array.fill(size) { Stack[Char]() }
    stackInput.foreach(println)
    while (!stackInput.isEmpty) {
      val input = stackInput.pop()
      (0 until size - 1).toList.foreach { i =>
        {
          val idx = if (i == 0) 1 else 1 + (i - 1) * 4
          if (idx < input.length()) {
            val maybeChar = input.charAt(idx)
            if (maybeChar.isLetter) {
              arrayOfStacks(i).push(maybeChar)
            }
          }
        }
      }
    }
    arrayOfStacks

  private def printStack(s: Stack[Char]): Unit =
    s.toList.foreach(println)

  private def parseLine(line: String): Input =
    val trimmedLine = line.trim()
    if (isHeaderLine(trimmedLine)) parseHeader(trimmedLine)
    else if (isStackLine(line)) parseStackLine(line)
    else if (isCommandLine(trimmedLine)) parseCommandLine(trimmedLine)
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
    CommandInput(quantity, from, to)

  // TODO add regex to have a strong line validation
  private def isCommandLine(line: String) = line.startsWith("move")

  private def isStackLine(line: String) =
    line.trim().split(" +").headOption.map(first => first matches "\\[[A-Z]\\]").getOrElse(false)

  private def parseStackLine(line: String) =
    StackInput(line)
