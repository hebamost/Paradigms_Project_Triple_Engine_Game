import Checkers.main_Checkers
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

import java.awt.{BorderLayout, Color, Dimension, FlowLayout, Font, GridBagLayout, GridLayout}
import javax.swing.{AbstractAction, JFrame, JLabel, JPanel, JTextField}
import scala.sys.exit

object MainEngine {
  def main(args: Array[String]){
    new UI
    var input:Int=0
    println("\nEnter the number of the game or 5 to quit:")
    println("1)Chess Game\n2)Checkers Game\n3)Tic Tac Toe\n4)Connect 4\n")
    try {
       input = scala.io.StdIn.readInt()
      //user input accepted from the command line

      processInput(input) // input process and the board altered
    }catch{
      case e: Exception => println("Invalid Input.\n")
    }

    while(input != 5){ //while loop that continues to accept user input. Ends when Q is entered
      println("\nEnter the number of the game or 5 to quit:")
      input = scala.io.StdIn.readInt()
      println("1)Chess Game\n2)Checkers Game\n3)Tic Tac Toe\n4)Connect 4\n")
      processInput(input.toInt)
    }
  }
  //Using pattern matching in input entered
  def processInput(INPUT: Int): Unit =  INPUT match {
      case 1 =>
        Chess.CHESS_GAME
      case 2 =>
        Checkers.main_Checkers
      case 3 =>
        TTT.mainTTT
      case 4=>
        Connect_4.MainC4
      case 5 =>
        exit(0)
    }
  class UI extends JFrame {
    var frame = new JFrame()
    frame.setTitle("Triple Game Engine")
    frame.setSize(500, 500) //frame size
    var lab = new JLabel()
    lab.setText("\nEnter  number of the game or 5 to quit:\n")
    lab.setForeground(Color.BLUE)
    lab.setFont(new Font("Times New Roman", Font.BOLD, 25))
    lab.setBounds(0, 0, 50, 20)
    var l = new JLabel()
    var o = new JLabel()
    var k = new JLabel()
    var d = new JLabel()
    l.setText("\n1)Chess Game")
    d.setText("  \n2)Checkers Game")
    o.setText("\n3)Tic Tac Toe")

    k.setText("\n4)Connect 4\n")

    l.setFont(new Font("Comic Sans MS", Font.PLAIN, 40))
    d.setFont(new Font("Comic Sans MS", Font.PLAIN, 40))
    o.setFont(new Font("Comic Sans MS", Font.PLAIN, 40))
    k.setFont(new Font("Comic Sans MS", Font.PLAIN, 40))
    l.setBounds(20, 20, 200, 30)
    d.setBounds(20, 30, 200, 30)
    o.setBounds(20, 40, 200, 30)
    k.setBounds(20, 50, 200, 30)
    var f = new JPanel()
    var boxContainer = new JPanel                   //input
    var text = new JTextField
    boxContainer.setBounds(0, 480 + 20 + 30, 100, 50)
    boxContainer.setBackground(Color.BLACK)
    text.setPreferredSize(new Dimension(80, 40))
    boxContainer.add(text)
    frame.add(boxContainer)
    frame.setVisible(true)
    f.setLayout(new FlowLayout())
    f.add(lab)
    f.add(l)
    f.add(d)
    f.add(o);
    f.add(k);

   f.add(boxContainer)
    f.setBackground(Color.LIGHT_GRAY)
   // frame.add(boxContainer)
    frame.add(f)

    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
    frame.setVisible(true) //make frame visible
    val action = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit = {
        var t = text.getText //input
        try {
          processInput(t.toInt) // input process and the board altered
        } catch {
          case e: Exception => println("Invalid Input.\n")
            var b=new JFrame()
            b.setTitle("Invalid Input")
        }
        text.setText("")
      }
    }
    text.addActionListener(action)
  }
}
