package Checkers

class Square (strID:Int ) {

  private var id = this.strID
  var IsEmpty: Boolean = true
  var SquareColourBlack:Boolean = true
  var piece=new Piece(0,true)


  val m = Map('A' -> 1, 'B' -> 2, 'C' -> 3, 'D' -> 4, 'E' -> 5,
    'F' -> 6, 'G' -> 7, 'H' -> 8);
  def getSquareColour():Boolean={
    return this.SquareColourBlack //if black =true
  }
 def getPieceColour():Boolean={
  return this.piece.get_piececolour() //player1==false (dark grey)
 }
  def get_id: Int = this.id
  def clearSquare(): Unit = {

    this.IsEmpty=true;

  }

  def putPiece(piececolour :Boolean): Unit = {
    //dark grey is player 1==false
    //lightgrey is player 2==true
    this.IsEmpty=false;
    this.piece=new Piece(this.id,piececolour);


  }



}