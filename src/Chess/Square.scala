package Chess

class Square (position:String,board:Drawer_Chess){
  var Col:Int=0  //try to get the number from file given
  var Row:Int=position.charAt(1)-48
  analysis_position()
def analysis_position():Int={
  position.charAt(0) match{
    case 'a' => Col=0
    case 'b' => Col=1
    case 'c' => Col=2
    case 'd' => Col=3
    case 'e' => Col=4
    case 'f' => Col=5
    case 'g' => Col=6
    case 'h' => Col=7
    case _ => Col=(-1)
  }
return Col
}


}
