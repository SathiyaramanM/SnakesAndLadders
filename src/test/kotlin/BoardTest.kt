import ai.sahaj.core.Board
import ai.sahaj.exceptions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class BoardTest {
    @Test
    fun `should create a board with default size of 100`() {
        val board = Board()
        val size = board.size
        assertEquals(100, size)
    }

    @Test
    fun `should create a board with any custom size`() {
        val board = Board(size = 150)
        val size = board.size
        assertEquals(150, size)
    }

    @Test
    fun `should be able to add ladders to the board`() {
        val board = Board()
        board.addLadder(start = 12, end = 27)
        val ladders = board.getLadders()
        assert(ladders.any { x -> x.first == 12 && x.second == 27 })
    }

    @Test
    fun `should throw an exception when ladder has same start and end cell`() {
        val board = Board()
        assertThrows<LadderSameStartAndEndException> {
            board.addLadder(start = 12, end = 12)
        }
    }

    @Test
    fun `should throw an exception when ladder start is greater than ladder end`() {
        val board = Board()
        assertThrows<InvalidLadderStartAndEndException> {
            board.addLadder(start = 12, end = 8)
        }
    }

    @Test
    fun `should throw an exception when another ladder already starts from the same start`() {
        val board = Board()
        board.addLadder(start = 21, end = 60)
        assertThrows<LadderAlreadyExistsWithSameStartException> {
            board.addLadder(start = 21, end = 41)
        }
    }

    @Test
    fun `should throw an exception when a snake already starts from the same start`() {
        val board = Board()
        board.addSnake(start = 21, end = 9)
        assertThrows<SnakeAlreadyExistsWithSameStartException> {
            board.addLadder(start = 21, end = 41)
        }
    }

    @Test
    fun `should be able to add snakes to the board`() {
        val board = Board()
        board.addSnake(start = 24, end = 10)
        val snakes = board.getSnakes()
        assert(snakes.any { x -> x.first == 24 && x.second == 10 })
    }

    @Test
    fun `should throw an exception when snake starts and ends at same cell`() {
        val board = Board()
        assertThrows<SnakeSameStartAndEndException> {
            board.addSnake(start = 12, end = 12)
        }
    }

    @Test
    fun `should throw an exception when snake start is lesser than snake end`() {
        val board = Board()
        assertThrows<InvalidSnakeStartAndEndException> {
            board.addSnake(start = 12, end = 27)
        }
    }

    @Test
    fun `should throw an exception when another snake already starts from the same start`() {
        val board = Board()
        board.addSnake(start = 60, end = 21)
        assertThrows<SnakeAlreadyExistsWithSameStartException> {
            board.addSnake(start = 60, end = 41)
        }
    }

    @Test
    fun `should throw an exception when a ladder already starts from the same start`() {
        val board = Board()
        board.addLadder(start = 60, end = 74)
        assertThrows<LadderAlreadyExistsWithSameStartException> {
            board.addSnake(start = 60, end = 41)
        }
    }
}