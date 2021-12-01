package nl.sbmf21.aoc20.days

import nl.sbmf21.aoc.common.ADay
import nl.sbmf21.aoc20.Aoc

class Day10(aoc: Aoc, number: Int) : ADay(aoc, number) {

    private val adapters = input.map { it.toInt() }.sortedBy { it }

    override fun part1(): Int {

        var last = 0
        var diff1 = 0
        var diff3 = 1

        adapters.toMutableList().forEach {
            when (it - last) {
                1 -> diff1++
                3 -> diff3++
            }

            last = it
        }

        return diff1 * diff3
    }

    override fun part2(): Long {

        val numbers = adapters.asReversed().toMutableList()
        numbers.add(0)

        val pathsList = mutableMapOf<Int, Long>(Pair(numbers[0], 1))

        for (i in 1 until numbers.size) {
            pathsList[numbers[i]] = pathsList
                .filter { (it.key - numbers[i]) <= 3 }
                .map { it.value }
                .sum()
        }

        return pathsList.map { it.value }.last()
    }
}
