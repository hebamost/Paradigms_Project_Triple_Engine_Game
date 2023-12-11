package Chess

import sun.rmi.transport.Target

class Pawn(board: Drawer_Chess) extends Piece {

  //get color =white-capital (false), true black-small
  override def validmoves(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Boolean = {
    //two moves either small or big number
    //var flag = true;
    if ((targetRow == activeRow - 2 && targetCol == activeCol && board.returncolor(activeRow, activeCol) && activeRow == 6)
      || ((targetRow == activeRow + 2 && targetCol == activeCol && !board.returncolor(activeRow, activeCol)) && activeRow == 1)) {
      if (board.isEmptyspot(targetRow, targetCol) && (board.isEmptyspot(activeRow - 1, activeCol) || board.isEmptyspot(activeRow + 1, activeCol))) {
        //board.change(activeRow, activeCol, targetRow, targetCol)
        return true
      }
      else {
      //  println("-position is invalid-")
         return false
      }
    }
    /*(targetRow == activeRow - 1 && targetCol == activeCol - 1) for Capital pawn */
    else if ((targetRow == activeRow - 1 && targetCol == activeCol - 1) ||
      (targetRow == activeRow + 1 && targetCol == activeCol + 1) ||
      (targetRow == activeRow + 1 && targetCol == activeCol - 1) ||
      (targetRow == activeRow - 1 && targetCol == activeCol + 1)) {
      if (board.returncolor(targetRow, targetCol) == board.returncolor(activeRow, activeCol)) {
        //println("*position is invalid")
        return false
      }
      else if (board.returncolor(targetRow, targetCol) != board.returncolor(activeRow, activeCol)) {
       // board.change(activeRow, activeCol, targetRow, targetCol)
        //promotion(activeRow, activeCol, targetRow, targetCol)
        return true
      }

      else {
       // println("Pawn cannot move in that direction")
         return false
      }
    }

    //one move
    else if ((targetRow == activeRow - 1 && targetCol == activeCol) ||
      (targetRow == activeRow + 1 && targetCol == activeCol)) {
      if (board.isEmptyspot(targetRow, targetCol)) {
       // board.change(activeRow, activeCol, targetRow, targetCol)
        //promotion(activeRow, activeCol, targetRow, targetCol)
        return true
      }
      else {
       // println("-position is invalid")
        return false
      }
    }
    else {
      //println("invalid -position")
      return  false
    }
    return true

  }

  def promotion(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Unit = {
    /*false=white, true=black*/
    //CAPITAL
    if (!(board.returncolor(activeRow, activeCol)) && targetRow == 7) {
      print("Which Piece You want (Q - N - R - B) : ")
      val a = scala.io.StdIn.readChar()
      board.board(activeRow)(activeCol) = a
    }
    else if (board.returncolor(activeRow, activeCol) && targetRow == 0) {
      print("Which Piece You want (q - n - r - b) : ")
      val a = scala.io.StdIn.readChar()
      board.board(activeRow)(activeCol) = a
    }
  }

}
