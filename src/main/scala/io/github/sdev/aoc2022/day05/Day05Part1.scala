package io.github.sdev.aoc2022.day05

import scala.collection.mutable.Stack
import scala.util.Try
import scala.util.Success
import scala.collection.mutable.Queue

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

    sealed trait InputType
    case class StackInput(line: String) extends InputType
    case class StackCount(count: Int) extends InputType
    case object SectionSeparator extends InputType
    case class Command(quantity: Int, from: Int, to: Int) extends InputType

    def parse(input: List[String]): (Array[Stack[String]], List[Cmd]) =
        var processingCommands = false
        val eof = input.size - 1
        var i = 0

        var stackCount = 0

        var stackInput = Queue[String]()

        while(i <= eof) {
            val line = parseLine(input(i))
            line match
                case StackInput(line) => stackInput.enqueue(line)
                case StackCount(count) => stackCount = count
                case SectionSeparator => ()     // do nothing
                case Command(quantity, from, to) => // TODO push commands to a queue        
        }

        (null, null)
    
    // TODO
    private def parseLine(line: String): InputType = ???

    // TODO
    private def parseHeader(line: String): List[Int] = ???