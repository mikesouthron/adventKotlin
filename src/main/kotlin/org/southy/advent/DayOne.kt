package org.southy.advent

import java.io.File
import kotlin.math.floor

fun main() {
    val f = File("C:/Development/advent/day1.txt")
    val acc = f.readLines()
            .map { it.toInt() }
            .map { calcMass(it, 0) }
            .sumBy { it }
    print(acc)
}

tailrec fun calcMass(input: Int, acc: Int) : Int {
    val mass = (floor(input / 3.0) - 2).toInt()
    return if (mass <= 0) {
        acc
    } else {
        calcMass(mass, acc + mass)
    }
}