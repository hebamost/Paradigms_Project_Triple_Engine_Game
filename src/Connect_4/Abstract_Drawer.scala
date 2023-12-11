package Connect_4

trait Abstract_Drawer {
  // drawing the cells
  def circles(): Unit

  // drawing the alphabet which points to the columns
  def labels(): Unit

  // drawing the text box to write the desired column in it
  def input(): Unit

  // draw the coins in the cells starting with red player
  def play(turn: Int, row: Int, col: Int): Int

}
