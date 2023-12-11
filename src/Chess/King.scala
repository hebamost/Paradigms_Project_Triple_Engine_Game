package Chess



class King(board: Drawer_Chess) extends Piece {
  var track_pos_white = Array(0, 4)
  var track_pos_black = Array(7, 4)

  override def validmoves(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Boolean = {
    var flag = true
    val dx = targetRow - activeRow
    val dy = targetCol - activeCol
    if (Math.abs(dx) <= 1 && Math.abs(dy) <= 1) {
      //  if (board.board(activeRow)(activeCol) == 'K') {
      if (board.isEmptyspot(targetRow, targetCol)) {
        board.change(activeRow, activeCol, targetRow, targetCol)
        track_king(activeRow, activeCol, targetRow, targetCol)
      }
      else if (board.board(targetRow)(targetCol) == 'k' || board.board(targetRow)(targetCol) == 'K') {
        printf("king cannot eat the opponent king")
      }
      else if (board.returncolor(activeRow, activeCol) != board.returncolor(targetRow, targetCol)) {
        board.change(activeRow, activeCol, targetRow, targetCol)
        track_king(activeRow, activeCol, targetRow, targetCol)
      }
      else {
        printf("invalid place ! TRY AGAIN")
        flag = false
      }

    }
    return flag
  }

  def track_king(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Unit = {
    if (!board.returncolor(activeRow, activeCol)) {
      track_pos_white(0) = targetRow
      track_pos_white(1) = targetCol
    }
    else {
      track_pos_black(0) = targetRow
      track_pos_black(1) = targetCol
    }
  }
}
