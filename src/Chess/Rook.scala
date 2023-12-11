package Chess

class Rook(board: Drawer_Chess) extends Piece{
  override def validmoves(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Boolean ={
    val dx = targetRow - activeRow
    val dy = targetCol - activeCol
    /*vertical*/
    if(Math.abs(dy) > 0 && dx == 0){
      if(dy > 0){ //right
        for( i <- activeCol + 1  until  targetCol){
          if(!board.isEmptyspot(targetRow, i)){
           // println("-position is invalid-")
            return false
          }
        }
      }
      //left
      if(dy < 0){
        for( i <- activeCol - 1   until  (targetCol,-1)){
          if(!board.isEmptyspot(targetRow, i)){
            //println("-position is invalid-")
            return false
          }
        }
      }
    }
    else if(Math.abs(dx) > 0 && dy == 0){
      if(dx > 0){ //right
        for( i <- activeRow + 1  until  targetRow){
          if(!board.isEmptyspot(i, targetCol)){
            //println("-position is invalid-")
            return false
          }
        }
      }
      //left
      if(dx < 0){
        for( i <- activeRow - 1   until  (targetRow,-1)){
          if(!board.isEmptyspot(i, targetCol)){
           // println("-position is invalid-")
            return false
          }
        }
      }
    }
    if(board.isEmptyspot(targetRow,targetCol)||(!board.isEmptyspot(targetRow,targetCol)&&board.returncolor(activeRow,activeCol)!=board.returncolor(targetRow,targetCol))) {
      //board.change(activeRow,activeCol,targetRow,targetCol)
       return true
    }
    else {
     // println("-position is invalid-")
       false
    }
  }

}
