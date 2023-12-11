package Checkers

class Piece (inSquareid:Int,Iswhite:Boolean){


  //var Iswhite: Boolean = false

  // private var inSquareid =null

  private var pawn=1 //pawn=1 -piece is pawn - ..pawn=0 -piece is king-


  def get_pieceLocation(): Int = {
    return this.inSquareid

  }

  def get_piececolour(): Boolean = {
    return this.Iswhite;

  }


  /* def set_piececolour(white: Boolean): Unit = {
      this.Iswhite = white;

    }*/



}
