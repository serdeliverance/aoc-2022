package io.github.sdev.aoc2022.day07

import java.io.File
import java.nio.file.FileSystemNotFoundException

object Day07Part1:

  def solution(input: List[String]) = ???

  sealed trait FileSystemCommand
  case class Cd(directory: String) extends FileSystemCommand
  case object Ls                   extends FileSystemCommand
