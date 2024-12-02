package je.bouk.aoc24.days

import je.bouk.aoc24.days.day2.Compare
import je.bouk.aoc24.days.day2.Report
import nl.sbmf21.aoc.common.Day
import nl.sbmf21.aoc.common.splitToInts

class Day2 : Day() {

    private companion object {
        val DOWN: Compare = { left, right -> left - right }
        val UP: Compare = { left, right -> right - left }
    }

    private val reports = input.map { it.splitToInts(" ") }

    override fun part1() = reports.count(::isSave)

    override fun part2() = reports.count { report ->
        isSave(report) || (((index(report, DOWN) ?: index(report, UP)) == true))
    }

    private fun index(report: Report, compare: Compare): Boolean? {
        if (check(report, 1, compare)) return true
        for (index in report.indices) {
            if (isValid(report[index], report[index + 1], compare)) continue
            return if (doesRemovingFix(report, index, compare)) true else null
        }
        return null
    }

    private fun doesRemovingFix(report: Report, index: Int, compare: Compare) = index == report.lastIndex - 1
        || checkCurrent(report, index, compare)
        || checkAhead(report, index, compare)

    private fun checkCurrent(report: Report, index: Int, compare: Compare) = index - 1 >= 0
        && isValid(report[index - 1], report[index + 1], compare)
        && check(report, index + 1, compare)

    private fun checkAhead(report: Report, index: Int, compare: Compare) = index + 2 <= report.lastIndex
        && isValid(report[index], report[index + 2], compare)
        && check(report, index + 2, compare)

    private fun isSave(report: Report): Boolean {
        return check(report, compare = DOWN)
            || check(report, compare = UP)
    }

    private fun check(report: Report, start: Int = 0, compare: Compare): Boolean {
        for (i in start..<report.lastIndex) if (!isValid(report[i], report[i + 1], compare)) return false
        return true
    }

    private fun isValid(left: Int, right: Int, compare: Compare): Boolean {
        val diff = compare(left, right)
        return diff in 1..3
    }
}