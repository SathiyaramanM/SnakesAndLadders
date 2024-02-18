package ai.sahaj.core

import ai.sahaj.enums.ElementType
import ai.sahaj.exceptions.*
import ai.sahaj.models.GameElement

class Board(val size: Int = 100) {
    private val laddersAndSnakes = mutableSetOf<GameElement>()

    fun addLadder(start: Int, end: Int) {
        if(start < 0 || end < 0 || start > size || end > size) {
            throw LadderOutOfRangeException()
        }
        if(start == end) {
            throw LadderSameStartAndEndException()
        }
        if(start > end) {
            throw InvalidLadderStartAndEndException()
        }
        val existingGameElement = laddersAndSnakes.firstOrNull { x -> x.start == start}
        if(existingGameElement != null) {
            if (existingGameElement.type == ElementType.LADDER) {
                throw LadderAlreadyExistsWithSameStartException()
            }
            if (existingGameElement.type == ElementType.SNAKE) {
                throw SnakeAlreadyExistsWithSameStartException()
            }
        }
        laddersAndSnakes.add(GameElement(start, end, ElementType.LADDER))
    }

    fun addSnake(start: Int, end: Int) {
        if(start < 0 || end < 0 || start > size || end > size) {
            throw SnakeOutOfRangeException()
        }
        if(start == end) {
            throw SnakeSameStartAndEndException()
        }
        if(start < end) {
            throw InvalidSnakeStartAndEndException()
        }
        val existingGameElement = laddersAndSnakes.firstOrNull { x -> x.start == start}
        if(existingGameElement != null) {
            if (existingGameElement.type == ElementType.LADDER) {
                throw LadderAlreadyExistsWithSameStartException()
            }
            if (existingGameElement.type == ElementType.SNAKE) {
                throw SnakeAlreadyExistsWithSameStartException()
            }
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
