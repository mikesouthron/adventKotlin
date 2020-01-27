package org.southy.advent

import java.lang.Exception

object IntCode {

    fun intCode(ints: MutableList<Int>, p: Int) : Int {
        when (ints[p]) {
            1 -> {
                ints[ints[p + 3]] = ints[ints[p + 1]] + ints[ints[p + 2]]
                return intCode(ints, p + 4)
            }
            2 -> {
                ints[ints[p + 3]] = ints[ints[p + 1]] * ints[ints[p + 2]]
                return intCode(ints, p + 4)
            }
            99 -> return ints[0]
        }
        throw Exception("Invalid Code")
    }

}