package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc21.testDay
import org.junit.jupiter.api.Test

class Day13Test {

    @Test
    fun testInput() = testDay(Day13::class.java, 666, "CJHAZHKU")

    @Test
    fun testExample() = testDay(Day13::class.java, 17, "nil", true)
}