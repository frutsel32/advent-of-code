package io.frutsel_.aoc.days

import io.frutsel_.aoc.ADay
import io.frutsel_.aoc.Aoc

@Suppress("unused")
class Day1(aoc: Aoc) : ADay(aoc) {

    private val numbers = input.map { it.toInt() }

    override fun number(): Int = 1

    override fun part1(): Number {
        for (a in numbers)
            for (b in numbers)
                if (a + b == 2020)
                    return a * b

        return 0
    }

    override fun part2(): Number {
        for (a in numbers)
            for (b in numbers)
                for (c in numbers)
                    if (a + b + c == 2020)
                        return a * b * c

        return 0
    }
}
