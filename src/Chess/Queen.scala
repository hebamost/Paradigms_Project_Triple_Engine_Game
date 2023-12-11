package Chess

class Queen (board: Drawer_Chess) extends Piece{
  var Rook=new Rook(board)
  var bishop=new Bishop(board)
  override def validmoves(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Boolean = {
  if(Rook.validmoves(activeRow,activeCol,targetRow,targetCol)||bishop.validmoves(activeRow,activeCol,targetRow,targetCol)) return true
  else false
  }
}
