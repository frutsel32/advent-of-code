package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc21.testDay
import org.junit.jupiter.api.Test

class Day19Test {

    @Test
    fun testInput() = testDay(Day19::class.java, 342, 9668)

    @Test
    fun testExample() = testDay(Day19::class.java, 79, 3621, true)
}