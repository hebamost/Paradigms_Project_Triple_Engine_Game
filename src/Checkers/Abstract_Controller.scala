package Checkers

import java.util

trait Abstract_Controller {
   def validmove(to:Int, from: Int) :Unit //checking validation of the eneterd move
   def jumpMove() :Unit   //Checking the validation of jump if found
  def jumpHelper(opponentPieceIndex: Int,pieceColour: Boolean): Boolean
  //Validating the input into indices of board
  def validinput(to: String, from: String,Boardarray:Array[Square]): util.ArrayList[Square]

}
