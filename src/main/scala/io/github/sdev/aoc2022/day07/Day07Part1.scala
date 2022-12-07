package io.github.sdev.aoc2022.day07

object Day07Part1:
  import Parser._

  def solution(input: List[String]) =
    val fileSystem = parse(input)
    fileSystem.root.allNodes().map(_.size).filter(_ < 100_000).sum

  case class FileSystem(root: Root)

  sealed trait FileSystemNode {
    def ls(): Unit

    def cd(directory: String): Option[Directory]

    def size: Int
  }
  case class Root(content: List[FileSystemNode]) extends FileSystemNode {
    def ls(): Unit = content.map(println)
    def cd(directory: String): Option[Directory] = content.collect {
      case d @ Directory(name, _) if name == directory => d
    }.headOption

    def size = content.map(_.size).sum

  }
  case class Directory(name: String, content: List[FileSystemNode]) extends FileSystemNode {
    def ls(): Unit = content.map(println)
    def cd(directory: String): Option[Directory] = content.collect {
      case d @ Directory(name, _) if name == directory => d
    }.headOption

    def size = content.map(_.size).sum
  }

  case class File(name: String, size: Int) extends FileSystemNode {
    def ls(): Unit                               = println(s"size: $size name: $name")
    def cd(directory: String): Option[Directory] = None
  }

  extension (root: Root) def allNodes(): List[FileSystemNode] = ???

  sealed trait Command
  case object Ls                   extends Command
  case class Cd(directory: String) extends Command

object Parser:
  import Day07Part1._

  // TODO
  def parse(input: List[String]): FileSystem = ???
