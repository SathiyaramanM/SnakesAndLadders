package ai.sahaj.core

import ai.sahaj.ai.sahaj.core.exceptions.InvalidLadderStartAndEndException
import ai.sahaj.ai.sahaj.core.exceptions.InvalidSnakeStartAndEndException
import ai.sahaj.ai.sahaj.core.exceptions.LadderSameStartAndEndException
import ai.sahaj.ai.sahaj.core.exceptions.SnakeSameStartAndEndException

class Board(val size: Int = 100) {
    private val ladders = mutableMapOf<Int, Int>()
    private val snakes = mutableMapOf<Int, Int>()

    fun addLadder(start: Int, end: Int) {
        if(start == end) {
            throw LadderSameStartAndEndException()
        }
        if(start > end) {
            throw InvalidLadderStartAndEndException()
        }
        ladders[start] = end
    }

    fun addSnake(start: Int, end: Int) {
        if(start == end) {
            throw SnakeSameStartAndEndException()
        }
        if(start < end) {
            throw InvalidSnakeStartAndEndException()
        }
        snakes[start] = end
    }

    fun getLadders(): List<Pair<Int, Int>> {
        return ladders.map { x -> Pair(x.key, x.value) }
    }

    fun getSnakes(): List<Pair<Int, Int>> {
        return snakes.map { x -> Pair(x.key, x.value) }
    }
}
