package Chess

trait Piece {
 def validmoves(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Boolean
}
