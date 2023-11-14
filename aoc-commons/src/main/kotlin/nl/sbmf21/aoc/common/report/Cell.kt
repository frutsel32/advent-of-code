package nl.sbmf21.aoc.common.report

import nl.sbmf21.aoc.common.report.Align.LEFT

internal class Cell {
    var text = ""
    var align = LEFT
    var colspan = 1
        set(value) {
            if (value < 1) error("Colspan cannot be lower than 1")
            field = value
        }
}