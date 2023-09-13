/*
    SONAR SWEEP
    https://adventofcode.com/2021/day/1
 */

fun main() {
    fun part1(input: List<String>): Int {
        return input.zipWithNext().filter { (a, b) -> a.toInt() < b.toInt() }.size
    }

    fun part2(input: List<String>): Int {
        return input.map { a -> a.toInt() }.windowed(3).zipWithNext().filter {(a, b) -> a.sum() < b.sum()}.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
