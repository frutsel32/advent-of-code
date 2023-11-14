package nl.sbmf21.aoc21.days

import nl.sbmf21.aoc.common.ADay
import nl.sbmf21.aoc.common.mapToInts
import nl.sbmf21.aoc.common.prod

class Day9 : ADay() {

    private val map = input.fold(mutableListOf<List<Int>>()) { acc, s ->
        acc.add(s.toCharArray().map { it.toString() }.mapToInts()); acc
    }.toList()
    private val lowPoints = map.foldIndexed(mutableListOf<Pair<Int, Int>>()) { x, acc, ints ->
        ints.forEachIndexed { y, _ -> if (isLowPoint(x, y)) acc.add(Pair(x, y)) }; acc
    }.toList()

    override fun part1() = lowPoints.sumOf { 1 + map[it.first][it.second] }

    override fun part2(): Int {
        val checked = List(map.size) { i -> map[i].map { false }.toMutableList() }
        return lowPoints
            .map { count(checked, it.first, it.second) }
            .sortedDescending()
            .subList(0, 3)
            .prod()
    }

    private fun isLowPoint(x: Int, y: Int) = checkLower(x, y, x - 1, y)
        && checkLower(x, y, x + 1, y)
        && checkLower(x, y, x, y - 1)
        && checkLower(x, y, x, y + 1)

    private fun checkLower(x: Int, y: Int, cx: Int, cy: Int) = !bound(x, y) || !bound(cx, cy) || map[x][y] < map[cx][cy]
    private fun bound(x: Int, y: Int) = x in map.indices && y in map[x].indices

    private fun count(checked: List<MutableList<Boolean>>, x: Int, y: Int): Int = if (contains(checked, x, y)) 1 +
        count(checked, x - 1, y) +
        count(checked, x + 1, y) +
        count(checked, x, y - 1) +
        count(checked, x, y + 1)
    else 0

    private fun contains(checked: List<MutableList<Boolean>>, cx: Int, cy: Int) = when {
        !bound(cx, cy) || checked[cx][cy] -> false
        else -> {
            checked[cx][cy] = true; map[cx][cy] < 9
        }
    }
}