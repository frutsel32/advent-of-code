package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc.testing.testDay
import org.junit.jupiter.api.Test

class Day18Test {

    @Test
    fun testInput() = testDay(Day18::class.java, 3981, 4687)

    @Test
    fun testExample() = testDay(Day18::class.java, 4140, 3993, true)
}