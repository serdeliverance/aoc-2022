package io.github.sdev.aoc2022.day02

object Day02Part1:
  import GameParser._

  def solution(input: List[String]): Int =
    val games = parse(input)
    games.map(g => g.myMove.points + g.toGameResult().points).sum

enum Move(val points: Int):
  case Rock     extends Move(1)
  case Paper    extends Move(2)
  case Scissors extends Move(3)

enum GameResult(val points: Int):
  case Win  extends GameResult(6)
  case Draw extends GameResult(3)
  case Loss extends GameResult(0)

object GameEntity:
  import Move._
  import GameResult._

  case class Game(myMove: Move, opponentsMove: Move):
    def toGameResult() = (myMove, opponentsMove) match
      case (Rock, Scissors)     => Win
      case (Scissors, Paper)    => Win
      case (Paper, Rock)        => Win
      case (Scissors, Scissors) => Draw
      case (Paper, Paper)       => Draw
      case (Rock, Rock)         => Draw
      case (_, _)               => Loss

object GameParser:
  import GameEntity.Game
  import Move._

  def parse(input: List[String]): List[Game] =
    input
      .filter(line => line matches "[ABC] [XYZ]")
      .map(line => Game(convertToMove(line.charAt(2)), convertToMove(line.charAt(0))))

  private def convertToMove(c: Char): Move =
    c match
      case 'A' | 'X' => Rock
      case 'B' | 'Y' => Paper
      case 'C' | 'Z' => Scissors
      case _         => throw IllegalArgumentException()
