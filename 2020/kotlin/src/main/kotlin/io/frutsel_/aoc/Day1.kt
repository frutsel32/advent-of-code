package io.frutsel_.aoc

class Day1 : Day() {
    override fun number(): Number = 1

    override fun part1(): Number {
        val numbers = numbers()

        for (a in numbers)
            for (b in numbers)
                if (a + b == 2020)
                    return a * b

        return 0
    }

    override fun part2(): Number {
        val numbers = numbers()

        for (a in numbers)
            for (b in numbers)
                for (c in numbers)
                    if (a + b + c == 2020)
                        return a * b * c

        return 0
    }

    private fun numbers(): List<Int> = input().toArray().mapToInt()
}
