import ai.sahaj.ai.sahaj.core.exceptions.InvalidLadderStartAndEndException
import ai.sahaj.ai.sahaj.core.exceptions.LadderSameStartAndEndException
import ai.sahaj.core.Board
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
}