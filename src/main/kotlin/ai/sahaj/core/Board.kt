package ai.sahaj.core

import ai.sahaj.ai.sahaj.core.exceptions.InvalidLadderStartAndEndException
import ai.sahaj.ai.sahaj.core.exceptions.LadderSameStartAndEndException

class Board(val size: Int = 100) {
    private val ladders = mutableMapOf<Int, Int>()

    fun addLadder(start: Int, end: Int) {
        if(start == end) {
            throw LadderSameStartAndEndException()
        }
        if(start > end) {
            throw InvalidLadderStartAndEndException()
        }
        ladders[start] = end
    }

    fun getLadders(): List<Pair<Int, Int>> {
        return ladders.map { x -> Pair(x.key, x.value) }
    }

}
