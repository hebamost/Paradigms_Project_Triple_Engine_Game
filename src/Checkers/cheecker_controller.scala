package Checkers

import java.util

class checker_controller extends Abstract_Controller {
  var error:String=null
  var ErrorCheck:Int=0
  var SquaresArr = Array.ofDim[Square](100);  //Array of squares

  val cols = Set('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H')

  val rows =Set('1', '2', '3', '4', '5', '6', '7', '8')

  var to_ID: Int = 0;
  var from_ID = 0;
  var col_to =0;

  var row_to=0
  var col_from =0;
  var row_from=0;

  var jump=false

  var Capturedindex=0;

  val m = Map('A' -> 1, 'B' -> 2, 'C' -> 3, 'D' -> 4, 'E' -> 5,
    'F' -> 6, 'G' -> 7, 'H' -> 8);
  var player_counter = 0;  //in case its even player1 plays, odd IT's player2's turn ..iits incremented after we make sure its a valid move
  def validinput(to: String, from: String,Boardarray:Array[Square]): util.ArrayList[Square] = {
    if(to==null || from==null){System.out.println("Write the input in correct way")
      this.ErrorCheck=1
    this.error="Input should be formatted A1, B2."
    return null}
    var SquaresUpdate = new util.ArrayList[Square]();
    if (cols.contains(to.charAt(0))&&cols.contains(from.charAt(0)) &&rows.contains(to.charAt(1))&& rows.contains(from.charAt(1))){
     // System.out.println("TO IN VALID INPUT"+to+ "FROM IN VALID INPUT "+from)
      this.SquaresArr=Boardarray map(identity)

      convertToID(to,from);
      System.out.println("TO IN VALID INPUT1 "+this.SquaresArr(to_ID).get_id+ "FROM IN VALID INPUT "+this.SquaresArr(to_ID).get_id)
      validmove(to_ID,from_ID);
      //  val SquaresUpdate : java.util.List[java.util.List[Square]] = new java.util.ArrayList[java.util.List[Square]]()
      var SquaresUpdate = new util.ArrayList[Square]();

      SquaresUpdate.add(SquaresArr(from_ID));


      SquaresUpdate.add(SquaresArr(to_ID))


      if(jump){
        SquaresUpdate.add(SquaresArr(this.Capturedindex))
      }

      return SquaresUpdate;


    }else {
      System.out.println("NOT A VALID INPUT");
      this.ErrorCheck=1
      this.error="Input is out of board range"
      return null;
    }
  }





  def validmove(to: Int, from: Int): Unit = {

    //needs first to check the turn -not implemented yet-

    //System.out.println("from id IN VALID MOVE  :"+this.from_ID)
    //player 1 play first -the player who has coins in rows1/2/3- it will move its coins up
    System.out.println("to : "+SquaresArr(this.to_ID).IsEmpty +"from :"+ SquaresArr(this.from_ID).IsEmpty +"to colour: "+SquaresArr(to_ID).SquareColourBlack +"from color: "+SquaresArr(from_ID).SquareColourBlack)
    if (SquaresArr(to_ID).IsEmpty && (!SquaresArr(from_ID).IsEmpty)&&SquaresArr(to_ID).SquareColourBlack&&SquaresArr(from_ID).SquareColourBlack) { //first check if fromsquare has a piece and to square is empty&&and both squares are black
      if (player_counter % 2 == 0) {//even player turn //moves up
        System.out.println("kkkkk :"+row_to+row_from)
        if (row_to > row_from) { //moves up

          //1-can move to the right or to the left
          if (row_to-row_from==2&&math.abs(col_to-col_from)==2) {
            jumpMove()
            //jump move
          } else if(Math.abs(col_to-col_from)==1)  {
            //simplemove//go to the next row diagonally
            simplemove(); //its called after we check this move is valid and this piece is going upppp
          }
        } else{ System.out.println("Player one should move up ")
          this.ErrorCheck=1
          this.error="Player 1 should move up"
        }
      } else if (player_counter % 2 == 1) {  //player2 is odd
        if(row_to<row_from){ //move down
          if (row_from-row_to==2&&math.abs(col_to-col_from)==2) {
            jumpMove()
            //jump move
          } else if(Math.abs(col_to-col_from)==1) {
            //simplemove//go to the next row diagonally
            simplemove(); //its called after we check this move is valid and this piece is going upppp
          }


        }

      }
    }else {System.out.println("Your input isn't valid")
     this.ErrorCheck=1
    this.error="Invalid Move"}
  }
  def simplemove():Unit={
    //in case we wanna move the piece to the right
    if(math.abs(row_to-row_from)==1){
      SquaresArr(from_ID).clearSquare() //location of fromSquare is clear
      val movedpieceColour:Boolean=SquaresArr(from_ID).piece.get_piececolour()
      SquaresArr(to_ID).putPiece(movedpieceColour) //put the piece in the to Square
      //it was a valid move so know counter with the other player
      player_counter =player_counter+1;

    }else {
      System.out.println("invalidmove");
      this.ErrorCheck=1
      this.error="That Move isn't allowed"
    }

  }
  def jumpMove():Unit={
    //jumpMove so we first need to check if there is a piece of the opponent
    if (player_counter % 2 == 0) { //its even turn
      //jumpMove so we first need to check if there is a piece of the opponent
      //opponent is white
      //there are two squares might have the opponent piece if its a valid move-on the right or on the left-
      //on the right
      var i1 = (row_from + 1).toString; //row
      var R1 = (col_from + 1).toString //col to test the diagonal right square
      var L = (col_from - 1).toString; //col to test the diagonal right square
      if (col_to - R1.toInt == 1) {
        jumpHelper((R1 + i1).toInt,false) //check diagonal right square
      } else if(col_to-L.toInt== -1){
        jumpHelper((L+i1).toInt,false)//check diagonal left square
      }
    }else if (player_counter % 2 == 1){ //player2 //which has white pieces //it moves down
      var i1 = (row_from - 1).toString; //row
      var R= (col_from + 1).toString //col to test the diagonal right square
      var L = (col_from - 1).toString; //col to test the diagonal right square
      if (col_to - R.toInt == 1) {
        jumpHelper((R + i1).toInt,true) //check diagonal right square
      } else if(col_to-L.toInt== -1){
        jumpHelper((L+i1).toInt,true)//check diagonal left square
      }

    }


  }

  def jumpHelper(opponentPieceIndex: Int,pieceColour: Boolean): Boolean ={

    if( !SquaresArr(opponentPieceIndex).IsEmpty && SquaresArr(opponentPieceIndex).piece.get_piececolour()!=pieceColour){  //check diagonal right square
      SquaresArr(opponentPieceIndex).clearSquare();  //remove the opponent piece
      SquaresArr(from_ID).clearSquare() //clear the from square
      SquaresArr(to_ID).putPiece(pieceColour) // put piece on the to square
      player_counter =player_counter+1;
      this.jump=true;
      this.Capturedindex=opponentPieceIndex;
      System.out.println("JUMP CAPTURED :   "+this.Capturedindex)
      return true;
    }
    return false;
  }
  def convertToID(tO: String, from: String): Unit = {
    var i1 = m(from.charAt(0)).toString;
    var j1 = (from.charAt(1).asDigit).toString;
    val Strid = i1 + j1;
    this.from_ID =Strid.toInt;

    this.col_from=i1.toInt
    this.row_from=j1.toInt
    var i2 = m(tO.charAt(0)).toString;
    var j2 = (tO.charAt(1).asDigit).toString;
    val Strid2 = i2 + j2;
    this.to_ID = Strid2.toInt;
    System.out.println("from id"+this.from_ID)

    System.out.println("to id"+this.to_ID)
    this.col_to=i2.toInt
    this.row_to=j2.toInt

  }


}