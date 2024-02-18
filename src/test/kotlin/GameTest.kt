import ai.sahaj.core.Board
import ai.sahaj.core.Game
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTest {
    @Test
    fun `should create a game using an already configured board`() {
        val board = Board()
        board.addLadder(start = 5, end = 21)
        board.addSnake(start = 25, end = 17)
        val game = Game(board)
        assertEquals(board, game.board)
    }
}