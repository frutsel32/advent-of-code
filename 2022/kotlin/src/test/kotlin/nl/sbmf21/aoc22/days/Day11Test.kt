package nl.sbmf21.aoc22.days

import nl.sbmf21.aoc.testing.testDay
import kotlin.test.Test

class Day11Test {

    @Test
    fun testInput() = testDay(Day11::class.java, 120756L, 39109444654L)

    @Test
    fun testExample() = testDay(Day11::class.java, 10605L, 2713310158L, true)
}