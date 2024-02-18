package ai.sahaj.core

import ai.sahaj.models.Player

class Game(val board: Board) {
    private val players = mutableListOf<Player>()

    fun addPlayer(player: Player) {
        players.add(player)
    }

    fun getPlayers(): List<Player> = players
}
