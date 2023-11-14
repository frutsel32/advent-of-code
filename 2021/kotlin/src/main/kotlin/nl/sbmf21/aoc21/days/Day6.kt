package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc.common.ADay
import nl.sbmf21.aoc.common.mapToInts

class Day6 : ADay() {

    private val fish = input[0].split(",").mapToInts()

    override fun part1() = shuffleFish(80)

    override fun part2() = shuffleFish(256)

    private fun shuffleFish(days: Int): Long {
        val fish = longArrayOf(0, catch(1), catch(2), catch(3), catch(4), catch(5), 0, 0, 0).toMutableList()

        for (d in 0 until days) {
            val newFish = fish[0]
            for (i in 0..7) fish[i] = fish[i + 1]
            fish[6] += newFish
            fish[8] = newFish
        }

        return fish.sum()
    }

    private fun catch(age: Int) = fish.count { it == age }.toLong()
}