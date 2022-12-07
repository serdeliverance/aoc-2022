package io.github.sdev.aoc2022.day07

import Day07Part1._

class Day07Part1Spec extends munit.FunSuite {

  test("file size calculation") {
    val input = File("file.txt", 2)

    val result = input.size

    assertEquals(result, 2)
  }

  test("directory with just files size calculation") {
    val input = Directory("parent", List(File("file1.txt", 10)))

    val result = input.size

    assertEquals(result, 10)
  }

  test("directory with nested directory size calculation") {

    val input = Directory("parent", List(File("file1.txt", 10), Directory("nested", List(File("file2.txt", 10)))))

    val result = input.size

    assertEquals(result, 20)
  }

  test("root directory size calculation") {

    val directory = Directory("parent", List(File("file1.txt", 10), Directory("nested", List(File("file2.txt", 10)))))
    val input     = Root(List(File("bigFile.txt", 1000), directory))

    val result = input.size

    assertEquals(result, 1020)
  }
}
