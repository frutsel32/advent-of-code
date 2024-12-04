package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc.testing.testDay
import kotlin.test.Test

class Day14Test {

    @Test
    fun testInput() = testDay(Day14::class.java, 2233, 2_884_513_602_164)

    @Test
    fun testExample() = testDay(Day14::class.java, 1588, 2_188_189_693_529, true)
}