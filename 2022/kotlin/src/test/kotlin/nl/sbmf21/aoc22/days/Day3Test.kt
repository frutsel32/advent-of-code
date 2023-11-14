package nl.sbmf21.aoc22.days

import nl.sbmf21.aoc22.testDay
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun testInput() = testDay(Day3::class.java, 7727, 2609)

    @Test
    fun testExample() = testDay(Day3::class.java, 157, 70, true)
}