import nl.sbmf21.aoc15.Aoc;
import nl.sbmf21.aoc15.days.Day1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test {

    private final Day1 day = new Day1(new Aoc(), 1);

    @Test
    public void testPart1Output() {
        assertEquals(138, (int) day.part1());
    }

    @Test
    public void testPart2Output() {
        assertEquals(1771, (int) day.part2());
    }
}
