package nl.sbmf21.aoc22.days

import nl.sbmf21.aoc.testing.testDay
import kotlin.test.Test

class Day7Test {

    @Test
    fun testInput() = testDay(Day7::class.java, 1_583_951, 214_171)

    @Test
    fun testExample() = testDay(Day7::class.java, 95_437, 24_933_642, true)
}