package Connect_4

import java.awt.event.ActionEvent
import javax.swing.AbstractAction

object MainC4 {


    var draw = new Drawer_Connect4
    draw.Drawer()
    var control = new Controller_Connect4
    var player = control.turn
    var flag = false // true if invalid input

    val action = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit = {
        control.input = (draw.textBox.getText).charAt(0)//input
        if (!control.input_Validation(control.input) || !((draw.textBox.getText).length==1) ){
          println("invalid input! you should enter an alphapet from a to g")
          flag = true
        }
        else{
          var myBoard = control.board
          var col = control.convToNum(control.input)
          var row = control.rowPosition(control.convToNum,control.input,myBoard)
          if(row != 10){
            player= draw.play(player,row, col)
            println("VALID")
          }
          else{
            flag = true
            println("invalid input! the column is full")
          }
        }
        draw.textBox.setText("")
      }
    }
    draw.textBox.addActionListener(action)

}