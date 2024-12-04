package nl.sbmf21.aoc20.days

import nl.sbmf21.aoc.testing.testDay
import kotlin.test.Test

class Day18Test {

    @Test
    fun testInput() = testDay(Day18::class.java, 510_009_915_468, 321_176_691_637_769)

    @Test
    fun testExample() = testDay(Day18::class.java, 26_457L, 694_173L, true)
}