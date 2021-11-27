package nl.sbmf21.aoc20.days

import nl.sbmf21.aoc.common.ADay
import nl.sbmf21.aoc20.Aoc

class Day1(aoc: Aoc) : ADay(aoc) {

    private val numbers = input.map { it.toInt() }

    override fun number() = 1

    override fun part1(): Int {
        for (a in numbers)
            for (b in numbers)
                if (a + b == 2020)
                    return a * b

        return 0
    }

    override fun part2(): Int {
        for (a in numbers)
            for (b in numbers)
                for (c in numbers)
                    if (a + b + c == 2020)
                        return a * b * c

        return 0
    }
}
