import io.frutsel_.aoc.Aoc
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class Expectation(val part1: Number, val part2: Number)

class AocTest {

    private val expectations = listOf(
        /* Day 1 */ Expectation(1019904, 176647680),
        /* Day 2 */ Expectation(515, 711)
    )

    @Test
    fun outputs() {
        Aoc().findDays().forEach { day ->
            assertTrue(day.number() <= expectations.size)

            val expectation = expectations[day.number() - 1]

            assertEquals(expectation.part1, day.part1())
            assertEquals(expectation.part2, day.part2())
        }
    }

    @Test
    fun names() {
        Aoc().findDays().forEach { day ->
            assertEquals("Day${day.number()}", day.javaClass.simpleName)
        }
    }
}