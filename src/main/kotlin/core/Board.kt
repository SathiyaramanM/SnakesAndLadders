package ai.sahaj.core

import ai.sahaj.enums.ElementType
import ai.sahaj.exceptions.InvalidLadderStartAndEndException
import ai.sahaj.exceptions.InvalidSnakeStartAndEndException
import ai.sahaj.exceptions.LadderSameStartAndEndException
import ai.sahaj.exceptions.SnakeSameStartAndEndException

class Board(val size: Int = 100) {
    private val laddersAndSnakes = mutableSetOf<GameElement>()

    fun addLadder(start: Int, end: Int) {
        if(start == end) {
            throw LadderSameStartAndEndException()
        }
        if(start > end) {
            throw InvalidLadderStartAndEndException()
        }
        laddersAndSnakes.add(GameElement(start, end, ElementType.LADDER))
    }

    fun addSnake(start: Int, end: Int) {
        if(start == end) {
            throw SnakeSameStartAndEndException()
        }
        if(start < end) {
            throw InvalidSnakeStartAndEndException()
        }
        laddersAndSnakes.add(GameElement(start, end, ElementType.SNAKE))
    }

    fun getLadders(): List<Pair<Int, Int>> {
        return laddersAndSnakes
            .filter { x -> x.type == ElementType.LADDER }
            .map { x -> Pair(x.start, x.end) }
    }

    fun getSnakes(): List<Pair<Int, Int>> {
        return laddersAndSnakes
            .filter { x -> x.type == ElementType.SNAKE }
            .map { x -> Pair(x.start, x.end) }
    }
}
