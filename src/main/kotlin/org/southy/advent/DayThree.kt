package org.southy.advent

import java.io.File
import java.nio.charset.StandardCharsets

data class Vector(val x: Int, val y: Int, val steps: Int)

fun main() {
    val f = File("C:/Development/advent/day3.txt")
    val lines = f.readLines(StandardCharsets.UTF_8)
    val firstWire = calculateWire(lines[0].split(","))
    val secondWire = calculateWire(lines[1].split(","))

    var steps = 0

    for (first in firstWire) {
        for (second in secondWire) {
            if (first.x == second.x && first.y == second.y) {
                if (steps == 0 || (first.steps + second.steps) < steps) {
                    steps = first.steps + second.steps
                }
            }
        }
    }

    println(steps)
}

fun calculateWire(dirs: List<String>) : List<Vector> {
    val wire = mutableListOf<Vector>()
    var x = 0
    var y = 0
    var steps = 0
    for (dir in dirs) {
        for (i in IntRange(0, dir.substring(1).trim().toInt() - 1)) {
            when (dir[0]) {
                'R' -> x += 1
                'L' -> x -= 1
                'U' -> y += 1
                'D' -> y -= 1
            }
            steps += 1
            wire.add(Vector(x, y, steps))
        }
    }
    return wire
}