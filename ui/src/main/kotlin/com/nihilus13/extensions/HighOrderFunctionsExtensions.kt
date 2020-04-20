package com.nihilus13.extensions

inline fun <R> R?.orElse(block: () -> R): R = this ?: block()