package org.southy.advent

import java.io.File
import java.nio.charset.StandardCharsets
import java.util.stream.IntStream

fun main() {
    val f = File("C:/Development/advent/day2.txt")
    val s = f.readText(StandardCharsets.UTF_8)
    val ints = s.split(",").map { it.trim() } .map { it.toInt() }

    for (noun in IntStream.rangeClosed(0, 99)) {
        for (verb in IntStream.rangeClosed(0, 99)) {
            val updatedInts = ints.toMutableList()
            updatedInts[1] = noun
            updatedInts[2] = verb
            val output = IntCode.intCode(updatedInts, 0)
            if (output == 19690720) {
                print(100 * noun + verb)
                return
            }
        }
    }
}

