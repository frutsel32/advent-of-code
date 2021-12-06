import nl.sbmf21.aoc20.Aoc
import nl.sbmf21.aoc20.days.Day7
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day7Test {

    private var day = Day7(Aoc(), 7)

    @Test
    fun testPart1Output() = assertEquals(112, day.part1())

    @Test
    fun testPart2Output() = assertEquals(6260, day.part2())
}
