package io.github.sdev.aoc2022.day02

import io.github.sdev.aoc2022.day02.Move._
import io.github.sdev.aoc2022.day02.GameResult._
import io.github.sdev.aoc2022.day02.GameEntity.Game
import io.github.sdev.aoc2022.day02.Day02Part2.GameStrategy

object Day02Part2:
  import StrategyParser._

  case class GameStrategy(opponentMove: Move, expectedResult: GameResult):
    def getMyExpectedMove() = (opponentMove, expectedResult) match
      case (Rock, Win)     => Paper
      case (Rock, Loss)    => Scissor
      case (Paper, Win)    => Scissor
      case (Paper, Loss)   => Rock
      case (Scissor, Win)  => Rock
      case (Scissor, Loss) => Paper
      case (_, Draw)       => opponentMove

  def solution(input: List[String]): Int =
    val games = parse(input)
      .map(strategy => Game(strategy.getMyExpectedMove(), strategy.opponentMove))
    games.map(g => g.myMove.points + g.toGameResult().points).sum

object StrategyParser:
  import GameParser.convertToMove

  def parse(input: List[String]): List[GameStrategy] =
    input
      .filter(line => line matches "[ABC] [XYZ]")
      .map(line => GameStrategy(convertToMove(line.charAt(0)), convertToGameResult(line.charAt(2))))

  private def convertToGameResult(c: Char) = c match
    case 'X' => Loss
    case 'Y' => Draw
    case 'Z' => Win
    case _   => throw IllegalArgumentException()
