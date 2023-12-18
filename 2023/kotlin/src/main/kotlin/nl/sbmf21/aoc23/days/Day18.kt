package nl.sbmf21.aoc23.days

import nl.sbmf21.aoc.common.Day
import nl.sbmf21.math.Vector2l
import nl.sbmf21.math.by

class Day18 : Day() {

    private val instructions = input
        .map { it.split(" ", limit = 3) }
        .map { (dir, num, hex) -> Instruction(Direction(dir[0]), num.toLong(), hex.substring(1, hex.length - 1)) }

    override fun part1() = solve().toInt()
    override fun part2() = solve(instructions.map(Instruction::real))

    private fun solve(instructions: List<Instruction> = this.instructions) = buildList {
        var start = 0L by 0L
        instructions.forEach { (direction, length) ->
            val line = Line(direction, start, length)
            start = line.end
            this += line
        }
    }.run { sumOf(Line::surface) / 2 + 1 }

    private data class Instruction(val direction: Direction, val length: Long, private val hex: String) {
        fun real() = Instruction(Direction(hex.substring(6, 7).toInt(16)), hex.substring(1, 6).toLong(16), hex)
    }

    private class Line(direction: Direction, start: Vector2l, length: Long) {
        val end: Vector2l = start + direction * length
        val surface: Long = start.x * end.y - start.y * end.x + length
    }

    private enum class Direction(val vec: Vector2l) {
        RIGHT(1L by 0L),
        DOWN(0L by 1L),
        LEFT(-1L by 0L),
        UP(0L by -1L);

        operator fun times(other: Long) = vec * other

        companion object {
            operator fun invoke(char: Char) = entries.first { it.name[0] == char }
            operator fun invoke(ordinal: Int) = entries[ordinal.mod(entries.size)]
        }
    }
}