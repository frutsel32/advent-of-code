package nl.sbmf21.aoc20.days

import nl.sbmf21.aoc20.testDay
import org.junit.jupiter.api.Test

class Day17Test {

    @Test
    fun testInput() = testDay(Day17::class.java, 286, 960)

    @Test
    fun testExample() = testDay(Day17::class.java, 112, 848, true)
}