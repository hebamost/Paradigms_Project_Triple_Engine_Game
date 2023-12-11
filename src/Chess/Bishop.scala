package Chess

import scala.util.control.Breaks.break

class Bishop(board: Drawer_Chess) extends Piece {
  override def validmoves(activeRow: Int, activeCol: Int, targetRow: Int, targetCol: Int): Boolean = {
    //var flag = true
    var dx = targetRow - activeRow
    var dy = targetCol - activeCol
    if (Math.abs(dy) - Math.abs(dx) == 0) {
     //top right
      if( dx > 0 && dy > 0){
        for( i <- activeRow + 1  until targetRow){
          for(j <- activeCol + 1 until  targetCol){
          if(!board.isEmptyspot(i, j)){
           // println("-position is invalid-")
            return false
            }
          }}
      }
      //top left
      else if( dx > 0 && dy < 0){
        for( i <- activeRow + 1 until targetRow){
          for(j <- activeCol - 1 until  (targetCol, (-1))){
            if(!board.isEmptyspot(i, j)){
              //flag=false
             // println("-position is invalid-")
              return false
            }}}}
      //bottom right
      else if( dx < 0 && dy > 0){
        for( i <- activeRow - 1  until (targetRow,-1)){
          for(j <- activeCol + 1 until  (targetCol)){
            if(!board.isEmptyspot(i, j)){
              //flag=false
             // println("-position is invalid-")
              return false
            }}}}
      //bottom left
      else if( dx < 0 && dy < 0){
        for( i <- activeRow - 1  until (targetRow,-1)){
          for(j <- activeCol - 1 until  (targetCol,-1)){
            if(!board.isEmptyspot(i, j)){
             // flag=false
             // println("-position is invalid-")
              return false
            }}}}
       if(board.isEmptyspot(targetRow,targetCol)||(board.returncolor(activeRow,activeCol)!=board.returncolor(targetRow,targetCol)))
           //board.change(activeRow,activeCol,targetRow,targetCol)
         return true
       else {
         //println("-position is invalid-")
         return false
       }
    }
     true
  }

}
