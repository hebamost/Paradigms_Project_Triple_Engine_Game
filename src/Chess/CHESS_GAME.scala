package Chess

object CHESS_GAME {

    var draw = new Drawer_Chess()
    draw.printBoard(draw)
    var lock_1 = false
    var lock_2 = false
    var turn = new Controller_Chess(lock_1, lock_2, draw)
    var play = 1

    //player 1
    while (play == 1) {
      while (turn.TurnCapital) {
        turn.player1
        draw.printBoard(draw)
      }
      print(turn.TurnCapital)
      //player2
      while (!turn.TurnCapital) {
        turn.player2
        draw.printBoard(draw)
      }
    }


}