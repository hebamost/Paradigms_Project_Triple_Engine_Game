package Checkers

import java.awt.{Color, Dimension, Font, Graphics, GridBagLayout}
import javax.imageio.ImageIO
import javax.swing.{ImageIcon, JFrame, JLabel, JPanel, JTextField}

import scala.reflect.internal.util.NoFile.file

class Drawer_checkers extends JFrame with Abstract_Drawer {
  var frame = new JFrame                          //create a frame
  var BoardSquares=Array.ofDim[Square](100)
  var panel = Array.ofDim[JPanel](8, 8)  //cells
  var nonoPanels = new Array[JPanel](32)          //to put numbers and letters
  var nonoLabels = new Array[JLabel](32)          //numbers and letters
  var boxContainer = new JPanel                   //input
  var box = new JTextField
  var guideBox = new JPanel                       //guide box
  var guideText = new JTextField

  def drawFrame(): Unit = {
    frame.setTitle("Checkers Board")
    frame.setSize(480 + 15 , 480 + 39  + 80) //frame size

    //frame.setResizable(false);
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
    frame.getContentPane.setBackground(Color. BLACK)
    frame.setLayout(null)
    frame.setVisible(true) //make frame visible

    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    //create the cells
    var x = 15
    var y = 15
    for (i <- 0 until 8) {
      for (j <- 0 until 8) {
       // System.out.println(i+ " ppp :"+ j)
        var n=convert_real(i,j)
        var new_index_controller=(n(0).toString+n(1).toString).toInt
        BoardSquares(new_index_controller)=new Square((n(0).toString+n(1).toString).toInt)
        if((i%2==0 && j%2==0)||(i%2==1 &&j%2==1)){
          panel(i)(j) = new JPanel
          panel(i)(j).setBackground(Color.RED)
          panel(i)(j).setBounds(x, y, 50, 50)
          frame.add(panel(i)(j))
          BoardSquares(new_index_controller).SquareColourBlack=false
        }
      else{ panel(i)(j)=new JPanel
       panel(i)(j).setBackground(Color.BLACK)
        panel(i)(j).setBounds(x, y, 50, 50)
        frame.add(panel(i)(j))


          BoardSquares(new_index_controller).SquareColourBlack=true}
        x += 50
       // System.out.println("in drawerrrr :"+BoardSquares(new_index_controller).get_id)
      }
      x = 15
      y += 50
    }
    /*create numbers of cells inside
    * display numbers from 8 to 1 in right and left
    */
    var xnono = 0
    var ynono = 15
    var num = 0
    var cellNum = 8
    for (i <- 0 until 16) {
      nonoPanels(i) = new JPanel
      nonoLabels(i) = new JLabel
      nonoPanels(i).setBackground(Color.WHITE)
      nonoPanels(i).setBounds(xnono, ynono, 15, 50)
      nonoLabels(i).setText(String.valueOf({
        cellNum -= 1; cellNum + 1
      }))
      nonoPanels(i).setLayout(new GridBagLayout)
      nonoPanels(i).add(nonoLabels(i))
      frame.add(nonoPanels(i))
      ynono +=  50
      num += 1
      if (num == 8) {
        xnono = 415
        ynono = 15
        cellNum = 8
      }
    }
    /*
     * display letters from a to c up and down
     */ xnono = 15
    ynono = 0
    var cellLet = 'A'
    for (i <- 16 until 32) {
      nonoPanels(i) = new JPanel
      nonoLabels(i) = new JLabel
      nonoPanels(i).setBackground(Color.WHITE)
      nonoPanels(i).setBounds(xnono, ynono, 50, 15)
      nonoLabels(i).setText(String.valueOf({
        cellLet
      }))
      cellLet = ((cellLet+1).toInt).toChar
      nonoPanels(i).setLayout(new GridBagLayout)
      nonoPanels(i).add(nonoLabels(i))
      frame.add(nonoPanels(i))
      xnono += 50
      num += 1
      if (num == 24) {
        ynono = 415
        xnono = 15
        cellLet = 'A'
      }
    }
    frame.setVisible(true)
  }

  //draw the box of text field
  def drawBox(): Unit = {
    boxContainer.setBounds(0, 420 + 20 + 30, 200, 50)
    boxContainer.setBackground(Color.YELLOW)
    box.setPreferredSize(new Dimension(190, 40))
    boxContainer.add(box)
    frame.add(boxContainer)
    frame.setVisible(true)
  }//end of function

  //draw a box to display the turn
  def guide(): Unit ={
    guideBox.setBounds(220, 420 + 20 + 30, 200, 50)
    guideBox.setBackground(Color.YELLOW)
    guideText.setPreferredSize(new Dimension(190, 40))
    guideText.setForeground(Color.RED)
    guideText.setText("Player 1 turn")
    guideBox.add(guideText)
    frame.add(guideBox)
    frame.setVisible(true)
  }
  def writeInGuide( error: Boolean,errorText:String,turn:Boolean): Unit ={

    guideText.setText("")
    if(!error) {
      if (turn) {

        guideText.setText("Player 1 turn")
      }
      else {
        guideText.setText("Player 2 turn")
      }
    }
    else{
        guideText.setText(errorText)
      }
  }

  def draw_circle(turn: Int, i: Int, j: Int): Unit = {
    val label = new JLabel
    if (turn == 0) { //turn=0 ->player1 ->dark grey ->piece(false)
      var n=convert_real(i,j)
      var new_index_controller=(n(0).toString+n(1).toString).toInt
      BoardSquares(new_index_controller).putPiece(false)

    //  System.out.println(BoardSquares(new_index_controller).get_id)
       label.setText("●")
      label.setSize(60,60)

      label.setFont(new Font("Calibri", Font.BOLD, 70))
      label.setForeground(Color.darkGray)
    }
    else { // turn=1 ->player2 ->light grey ->piece(true)

      var n=convert_real(i,j)
      var new_index_controller=(n(0).toString+n(1).toString).toInt
      BoardSquares(new_index_controller).putPiece(true)

      System.out.println(BoardSquares(new_index_controller).get_id)
    //  label.add(new panel())
     // label.setForeground(Color.magenta)
      label.setText("●")
      label.setSize(60,60)

      label.setFont(new Font("Calibri", Font.BOLD, 70))
      label.setForeground(Color.lightGray)
    }

    panel(i)(j).setLayout(new GridBagLayout) //to put the text in the center
   // System.out.println("INSIDE DRAW XXOOO:"+ i+ j)

    panel(i)(j).add(label)

    panel(i)(j).repaint()
    frame.add(panel(i)(j))
    //frame.validate()
    //frame.repaint()
    //frame.pack()
    frame.setVisible(true)


  }
  def Initialize(): Unit ={

    var x=3
    for (i <- 0 until 8) {
      for (j <- 0 until 8) {

        if((i%2==0 && j%2==1) ||( i%2==1 && j%2==0)){
          if(i==0||i==1||i==2){
            var n=convert_real(i,j)
            var new_index_controller=(n(0).toString+n(1).toString).toInt
            BoardSquares(new_index_controller).putPiece(true)//player2 lightgrey

           // System.out.println(BoardSquares(new_index_controller).get_id)
            draw_circle(1,i,j)
          }else if(i==5||i==6||i==7){
            var n=convert_real(i,j)
            var new_index_controller=(n(0).toString+n(1).toString).toInt
            BoardSquares(new_index_controller).putPiece(false)//player1 darkgrey

          //  System.out.println(BoardSquares(new_index_controller).get_id)
          draw_circle(0,i,j)}
        }

      }
      }
  }
//pattern matching
  def convert_real(i: Int ,j:Int): Array[Int] ={
    //indices in board to indices created in controller
    val index = new Array[Int](2)
    i match {

      case 7 =>
        index(1) = 1

      case 6 =>
        index(1) = 2
      case 5 =>
        index(1) = 3

      case 4 =>
        index(1) = 4

      case 3 =>
        index(1) = 5

      case 2 =>
        index(1) = 6

      case 1 =>
        index(1) = 7

      case 0 =>
        index(1) = 8

    }
    j match {
      case 7 =>
        index(0) = 8

      case 6 =>
        index(0) = 7
      case 5 =>
        index(0) = 6

      case 4 =>
        index(0) = 5

      case 3 =>
        index(0) = 4

      case 2 =>
        index(0) = 3

      case 1 =>
        index(0) = 2

      case 0 =>
        index(0) = 1

    }
    return index
  }

  def convert_indices_controller(i: Int ,j:Int): Array[Int] ={
    //indices in board to indices created in controller
    val index = new Array[Int](2)
    i match {
      case '8' =>
         index(1) = 7

      case '7' =>
        index(1) = 6

      case '6' =>
        index(1) = 5
      case '5' =>
        index(1) = 4

      case '4' =>
        index(1) = 3

      case '3' =>
        index(1) = 2

      case '2' =>
        index(1) = 1

      case '1' =>
        index(1) = 0

    }
    j match {
      case '8' =>
        index(0) = 0

      case '7' =>
        index(0) = 1

      case '6' =>
        index(0) = 2
      case '5' =>
        index(0) = 3

      case '4' =>
        index(0) = 4

      case '3' =>
        index(0) = 5

      case '2' =>
        index(0) = 6

      case '1' =>
        index(0) = 7
    }
    return index
  }
  def remove_drwan(squareColor:Boolean,i:Int,j:Int): Unit ={
      //panel(i)(j)=new JPanel()
    if(squareColor==true)

    { // panel(i)(j).removeAll()
      //panel(i)(j).revalidate()
      panel(i)(j).setForeground(Color.BLACK)
      panel(i)(j).setBackground(Color.BLACK)
     panel(i)(j).setBounds(i, j, 50, 50)
    //frame.add(panel(i)(j))

    var controller_indices=convert_real(i,j)
    var total_index=(controller_indices(0).toString+controller_indices(1).toString).toInt
    BoardSquares(total_index).clearSquare()

    }
    else

  { //panel(i)(j).removeAll()
    //panel(i)(j).setForeground(Color.RED)
    panel(i)(j).setBackground(Color.RED)
    panel(i)(j).setBounds(i, j, 50, 50)
    frame.add(panel(i)(j))
    var controller_indices=convert_real(i,j)
    var total_index=(controller_indices(0).toString+controller_indices(1).toString).toInt
    BoardSquares(total_index).clearSquare()

  }

  }
  def draw_again(turn:Int,i:Int,j:Int): Unit ={

   // panel(i)(j).removeAll()
    val label = new JLabel
    if (turn == 0) { //turn=0 ->player1 ->dark grey ->piece(false)
      var n=convert_real(i,j)
      System.out.println("aggagagagag")
      var new_index_controller=(n(0).toString+n(1).toString).toInt
      BoardSquares(new_index_controller).putPiece(false)

      System.out.println(BoardSquares(new_index_controller).get_id)
      label.setText("●")
      label.setSize(60,60)
      label.setBackground(Color.WHITE)
      label.setFont(new Font("Calibri", Font.BOLD, 70))
      label.setForeground(Color.BLUE)
      label.setVisible(true)
    }
    else { // turn=1 ->player2 ->light grey ->piece(true)

      var n=convert_real(i,j)
      var new_index_controller=(n(0).toString+n(1).toString).toInt
      BoardSquares(new_index_controller).putPiece(true)

      System.out.println(BoardSquares(new_index_controller).get_id)
      //  label.add(new panel())
      // label.setForeground(Color.magenta)

      label.setText("●")
      label.setSize(60,60)
      label.setVisible(true)
      label.setFont(new Font("Calibri", Font.BOLD, 70))
      label.setForeground(Color.lightGray)
    }

    panel(i)(j).setLayout(new GridBagLayout) //to put the text in the center
    System.out.println("INSIDE DRAW XXOOO:"+ i+ j)


    panel(i)(j).add(label)

    //panel(i)(j).repaint()
    frame.add(panel(i)(j))
    frame.setVisible(true)


  }
  var input: String = null
  def extract_ORIG_DEST(in: String): Array[String]={
    val index = new Array[String](2)
    try {
      var split = in.split(", ")
      var split1 = split(0).toCharArray
      var split2 = split(1).toCharArray
      var origin = (split1(0),split1(1).asDigit)
      var destination = (split2(0),split2(1).asDigit)

      index(0)=split1(0).toString + split1(1).toString

      index(1)=split2(0).toString +split2(1).toString
    }
    catch {
      case e: Exception => println("Invalid Input.\nInput should be formatted A1, B2.\nDon't forget the space.")
    }
    System.out.println("from:" +index(0) +"To: "+ index(1))
    return index
  }
}
