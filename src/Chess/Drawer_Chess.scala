package Chess

class Drawer_Chess {
  //def clear() = print("\u001b[2J")

  var board = Array(
    Array('R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'),
    Array('P', 'P', 'P', 'P','P', 'P', 'P', 'P'),
    Array(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
    Array(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
    Array(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
    Array(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
    Array('p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'),
    Array('r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'))
  var letters = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
  var pawn = new Pawn( Drawer_Chess.this)
  var knight = new Knight( Drawer_Chess.this)
  var king = new King( Drawer_Chess.this)
  var rook = new Rook( Drawer_Chess.this)
  var bishop = new Bishop( Drawer_Chess.this)
  var queen = new Queen( Drawer_Chess.this)
  def change(r1: Int, c1: Int, r2: Int, c2: Int): Unit = {
    var temp = ' '
    if(!isEmptyspot(r2,c2)){
      board(r2)(c2)=' '
    }
    temp = board(r1)(c1)
    board(r1)(c1) = board(r2)(c2)
    board(r2)(c2) = temp
  }

  def printBoard(board: Drawer_Chess): Unit = {
    var i=7
    for (j <- 0 to 7) {
      print(board.letters(j) + " |")
    }
    println("\n------------------------")
    while (i>(-1)) {
      for (j <- 0 to 7) {
        print(board.board(i)(j) + " |")
      }
      print("\n")
      i-=1
    }
  }

  def returnsquare(targetRow: Int, targetCol: Int): Char = {
    board(targetRow)(targetCol)
  }

  //make sure if it is white it not
  //white is true
  def returncolor(targetRow: Int, targetCol: Int): Boolean = {
    board(targetRow)(targetCol).isLower
  }

  def setsquare(oldROw: Int, oldCOL: Int, targetRow: Int, targetCol: Int): Unit = {
    board(oldROw)(oldCOL) = board(targetRow)(targetCol)
  }

  def isEmptyspot(targetRow: Int, targetCol: Int): Boolean = {
    board(targetRow)(targetCol) == ' '
  }
}