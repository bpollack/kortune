package com.bitquabit.kortune

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Random

object Kortune {
    private fun loadFortunes(resourceName: String): List<String> {
        val fortunes = mutableListOf<String>()

        val reader = BufferedReader(InputStreamReader(
                Kortune::class.java.getResourceAsStream(resourceName)))
        val sb = StringBuilder()
        reader.forEachLine { line ->
            if (line == "%") {
                fortunes.add(sb.toString())
                sb.setLength(0)
            } else {
                sb.append(line)
                sb.append("\n")
            }
        }
        fortunes.add(sb.toString())

        return fortunes
    }

    private fun loadFortunes(vararg resourceNames: String): List<String> {
        val fortunes = mutableListOf<String>()
        for (resourceName in resourceNames) {
            fortunes.addAll(loadFortunes(resourceName))
        }
        return fortunes
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val fortunes = loadFortunes("/offensive.fortunes", "/freebsd.fortunes")
        val random = Random()
        println(fortunes[random.nextInt(fortunes.size)])
    }
}
