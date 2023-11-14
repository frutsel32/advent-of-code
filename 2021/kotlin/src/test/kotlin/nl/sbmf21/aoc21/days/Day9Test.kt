package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc21.testDay
import org.junit.jupiter.api.Test

class Day9Test {

    @Test
    fun testInput() = testDay(Day9::class.java, 600, 987_840)

    @Test
    fun testExample() = testDay(Day9::class.java, 15, 1134, true)
}