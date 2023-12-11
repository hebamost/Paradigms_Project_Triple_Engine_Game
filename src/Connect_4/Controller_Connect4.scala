package Connect_4

import scala.Array.ofDim


class Controller_Connect4 extends Abstract_Controller {
  var num = 0
  var board = ofDim[Int](6, 7)
  var turn =0
  var i =0
  var j =0
  var input: Char ='a'
  for( i <- 0 to 5){
    for( j <- 0 to 6){
      board(i)(j)=0
    }
  }

  def input_Validation(alpha: Char): Boolean = {
    if(alpha=='a' || alpha=='b' || alpha=='c'|| alpha=='d'|| alpha=='e'|| alpha=='f'|| alpha=='g'){
      return true
    }else{
      return false
    }
  }

  def convToNum(alpha: Char): Int = {
    alpha match {
      case 'a' => num = 0
      case 'b' => num = 1
      case 'c' => num = 2
      case 'd' => num = 3
      case 'e' => num = 4
      case 'f' => num = 5
      case 'g' => num = 6
    }
    return num
  }
  def rowPosition(col: Char=> Int, alpha:Char, array :Array[Array[Int]]): Int ={
    var k = 0;
    var n=col(alpha)
    while (k <6) {
      if (array(k)(n) == 0) {
        array(k)(n)=1
        return k
      }
      k=k+1
    }
    return 10
  }

}