/*
    SONAR SWEEP
    https://adventofcode.com/2021/day/1
 */

fun main() {
    fun part1(input: List<String>): Int {
        val result = input.map { line -> line.split(' ') }.map { l -> Pair(l[0], l[1].toInt()) }
            .fold(Pair(0, 0)) { (hr, dr), (word, unit) ->
                when (word) {
                    "forward" -> Pair(hr + unit, dr)
                    "down" -> Pair(hr, dr + unit)
                    else -> Pair(hr, dr - unit)
                }
            }
        return result.first * result.second
    }

    fun part2(input: List<String>): Int {
        val result = input.map { line -> line.split(' ') }.map { l -> Pair(l[0], l[1].toInt()) }
            .fold(Triple(0, 0, 0)) { (hr, dr, ar), (word, unit) ->
                when (word) {
                    "forward" -> Triple(hr + unit, dr + (ar*unit), ar)
                    "down" -> Triple(hr, dr, ar + unit)
                    else -> Triple(hr, dr, ar - unit)
                }
            }
        return result.first * result.second
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
