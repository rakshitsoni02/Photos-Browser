package com.rax.core.extensions

import java.math.RoundingMode

private const val CENTS = 100f

fun Long.doubleAmount() = (this / CENTS).toDouble()

fun Double.longAmount() = (this * CENTS).toLong()

fun Double.roundToDisplay(): Double {
    return this.toBigDecimal().setScale(2, RoundingMode.FLOOR).toDouble()
}