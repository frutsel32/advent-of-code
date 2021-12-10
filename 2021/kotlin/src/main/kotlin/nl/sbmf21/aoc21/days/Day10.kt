package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc.common.ADay

class Day10(input: List<String>) : ADay(input) {

    private val opening = listOf('(', '[', '{', '<')
    private val closing = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')

    override fun part1() = run({ it }, { null }).sorted()
        .fold(mutableMapOf(')' to 0, ']' to 0, '}' to 0, '>' to 0)) { acc, c -> acc[c] = acc[c]!! + 1; acc }
        .map { it.value * points(it.key, 3, 57, 1197, 25137) }
        .sum()

    override fun part2() = run({ null }, { it })
        .map { it.reversed().fold(0L) { acc, c -> acc * 5 + points(closing[c], 1, 2, 3, 4) } }
        .run { sorted()[size / 2] }

    private fun <C> run(c: (c: Char) -> C?, b: (b: List<Char>) -> C?): List<C> = input.map { line ->
        val blocks = mutableListOf<Char>()

        line.toCharArray().forEach { c ->
            if (opening.contains(c)) blocks.add(c)
            else if (closing[blocks.last()] == c) blocks.removeLast()
            else return@map c(c)
        }

        return@map b(blocks.toList())
    }.filterNotNull()

    private fun points(c: Char?, paren: Int, square: Int, curly: Int, angle: Int) = when (c) {
        ')' -> paren
        ']' -> square
        '}' -> curly
        '>' -> angle
        else -> 0
    }
}
