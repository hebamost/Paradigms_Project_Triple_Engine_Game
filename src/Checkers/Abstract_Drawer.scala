package Checkers

trait Abstract_Drawer {
   def drawFrame():Unit   //Drawing game board of checkers
    def drawBox():Unit     //drawing the frame containing the game
    def guide():Unit       //Informing the player whats going on
  def draw_circle(turn: Int, i: Int, j: Int): Unit   //Drawing pieces on board
  def remove_drwan(squareColor:Boolean,i:Int,j:Int): Unit //drawn piece removal from place to another
}
