package TTT;
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

object mainTTT {
  //def main(args: Array[String]): Unit = {

    var objD = new DrawerTTT
    var objC = new ControllerTTT

    objD.drawFrame()
    objD.drawBox()
    objD.guide()

    objC.turn = 0    //X turn => 0, Y turn => 1
    var flag = false //to determine if the input is valid or not

    val action = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit = {
        objC.input = objD.box.getText //input

        if(!objC.valid_input(objC.input)){
          println("invalid input")
          flag = true
        }
        else {
          val arr = objC.InputToIndex(objC.input) //index
          if (objC.valid_cell(arr)) {
            flag = false
            if (objC.turn == 0) {                 //X turn
              objC.cell(arr(0))(arr(1)) = 'X'
              objD.draw_X_O(objC.turn, arr(0), arr(1))
              objC.turn = 1
            }
            else {                               //O turn
              objC.cell(arr(0))(arr(1)) = 'O'
              objD.draw_X_O(objC.turn, arr(0), arr(1))
              objC.turn = 0
            }
          }
          else {
            flag = true;
          }
        }
        objD.wtiteInGuide(objC.turn, flag)
        objD.box.setText("")
      }
    }
    objD.box.addActionListener(action)
 // }
}
