package Connect_4

import java.awt.event.ActionEvent
import java.awt.{Color, Dimension, Font, Graphics}
import javax.swing.{AbstractAction, JButton, JFrame, JLabel, JPanel, JTextField}


class Drawer_Connect4 extends Abstract_Drawer {
  var frame = new JFrame
  var panels = Array.ofDim[JPanel](6, 7)
  var button = new JButton("submit")
  var textBox = new JTextField
  var next=0

  class panel extends JPanel {
    override def paint(g: Graphics): Unit = {
      g.setColor(Color.white)
      g.fillOval(33, 70, 80, 70)
    }
  }
  class panelW extends JPanel {
    override def paint(g: Graphics): Unit = {
      g.setColor(Color.white)
      g.fillOval(33+(6*90), 70+(5*80), 80, 70)
    }
  }

  class panel2 extends JPanel {
    override def paint(g: Graphics): Unit = {
      g.setColor(Color.white)
      g.fillRect(298, 5, 90, 50)
    }
  }


  def circles(): Unit = {
    var x = 0
    var y = 0
    for (i <- 0 until 6) {
      for (j <- 0 until 7) {
        panels(i)(j) = new panel()
        panels(i)(j).setBackground(new Color(255, 255, 255))
        panels(i)(j).setBounds(x, y, 150, 150)
        frame.add(panels(i)(j))
        x += 90
      }
      x = 0
      y += 80
    }
  }

  def labels(): Unit = {
    val label = new JLabel
    label.setText("        a          b         c         d         e          f          g  ")
    label.setForeground(Color.DARK_GRAY)
    label.setFont(new Font("times new roman", Font.BOLD, 30))
    label.setVerticalAlignment(3)
    frame.add(label)
  }

  def input(): Unit = {
    val p = new panel2()
    textBox.setPreferredSize(new Dimension(80, 40))
    p.add(textBox)
    frame.add(p)
    frame.setVisible(true)
  }

  def Drawer() {
    frame.setTitle("Connect-4")
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
    frame.setResizable(false)
    frame.setSize(700, 620)
    frame.getContentPane.setBackground(new Color(10, 125, 255))
    frame.setVisible(true)
    labels()
    input()
    frame.setVisible(true)
    circles()
    frame.setVisible(true)
    var last = new panelW()
    frame.add(last)
    frame.setVisible(true)

  }

  def play(turn: Int, row: Int, col: Int): Int= {
    class panelR extends JPanel {
      override def paint(g: Graphics): Unit = {
        g.setColor(Color.red)
        g.fillOval(33+(90*col), 470-(80*row), 80, 70)
      }
    }
    class panelY extends JPanel {
      override def paint(g: Graphics): Unit = {
        g.setColor(Color.yellow)
        g.fillOval(33+(90*col), 470-(80*row), 80, 70)
      }
    }

    if (turn == 0) {
      panels(row)(col)= new panelR
      // panels(row)(col).setBounds(row*70,col*90,150,150)
      frame.add(panels(row)(col))

      next = 1
    }
    else {
      panels(row)(col)=new panelY()
      frame.add(panels(row)(col))
      next = 0
    }
    frame.setVisible(true)
    return next
  }

}