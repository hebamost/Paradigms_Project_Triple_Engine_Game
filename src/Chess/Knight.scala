package Chess

class Knight (board: Drawer_Chess) extends Piece{
  override def validmoves(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Boolean = {
    val dx = targetRow-activeRow
    val dy = targetCol-activeCol
    if((Math.abs(dx)==1 && Math.abs(dy)==2) || (Math.abs(dx)==2 && Math.abs(dy)==1)){
      /* If the space is empty */
      if(board.isEmptyspot(targetRow, targetCol)){
        //board.change(activeRow,activeCol,targetRow,targetCol)
        return true
      }
      else if(board.isEmptyspot(targetRow,targetCol)!=board.isEmptyspot(activeRow,activeCol)){
      //  println("-position is invalid-")
        return false
      }
    }
  return true
  }
}
