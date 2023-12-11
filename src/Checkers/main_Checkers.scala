package Checkers

import java.awt.event.ActionEvent
import javax.swing.{AbstractAction, JLabel, JPanel}

object main_Checkers {


    var objD = new Drawer_checkers

    var objE=new checker_controller
    objD.drawFrame()
    objD.drawBox()
    objD.Initialize()
    var flag = false
    objD.guide()

    val action = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit = {
        objD.input = objD.box.getText //input
        var d=objD.extract_ORIG_DEST(objD.input)
        System.out.println(objD.input)
        //val arr = objC.InputToIndex(d(0)) //index
        var returned_position=objE.validinput(d(1),d(0),objD.BoardSquares)
        if(objE.ErrorCheck==0){ objD.writeInGuide(false,null,returned_position.get(0).getPieceColour())
        if(returned_position.get(0).IsEmpty){
          if(objE.jump==false){
          var f= returned_position.get(0).get_id.toString
          var first_index=f.charAt(0).toInt
          var second_index=f.charAt(1).toInt
          var board_indices=objD.convert_indices_controller(first_index,second_index)
          //System.out.println("MAINTTTTTT :"+board_indices(0)+board_indices(1))
          objD.remove_drwan(returned_position.get(0).getSquareColour(),board_indices(0),board_indices(1))

          var H= returned_position.get(1).get_id.toString
          var firs_index=H.charAt(0).toInt
          var secon_index=H.charAt(1).toInt
          var board_index=objD.convert_indices_controller(firs_index,secon_index)
          System.out.println("MAINTTTTTT kkkk :"+board_index(0)+board_index(1))
          var pieceC=returned_position.get(1).getPieceColour()

          if (pieceC==false){
          objD.draw_circle(0,board_index(0),board_index(1))}
          else{
            objD.draw_circle(1,board_index(0),board_index(1))
          }
        }else{ System.out.println("ana fe jummppp")
            var f= returned_position.get(0).get_id.toString
            var first_index=f.charAt(0).toInt
            var second_index=f.charAt(1).toInt
            var board_indices=objD.convert_indices_controller(first_index,second_index)
            System.out.println("MAINTTTTTT :"+board_indices(0)+board_indices(1))
            objD.remove_drwan(returned_position.get(0).getSquareColour(),board_indices(0),board_indices(1))

            var H= returned_position.get(1).get_id.toString
            var firs_index=H.charAt(0).toInt
            var secon_index=H.charAt(1).toInt
            var board_index=objD.convert_indices_controller(firs_index,secon_index)
            System.out.println("MAINTTTTTT kkkk :"+board_index(0)+board_index(1))
            var pieceC=returned_position.get(1).getPieceColour()
            System.out.println("piece colour "+pieceC)
            if (pieceC==false){

            //  objD.panel(board_index(0))(board_index(0))=new JPanel()
              objD.draw_circle(0,board_index(0),board_index(1))}
            else{
              objD.draw_circle(1,board_index(0),board_index(1))
            }
            if(returned_position.size()>2){
              System.out.println("size >2" + returned_position.size())
            var UU= returned_position.get(2).get_id.toString
            var first_O=UU.charAt(0).toInt
            var second_O=UU.charAt(1).toInt
            var board_ind=objD.convert_indices_controller(first_O,second_O)
            System.out.println("MAINTTTTTT :"+board_ind(0)+board_ind(1))
              objD.remove_drwan(returned_position.get(2).getSquareColour(),board_ind(0),board_ind(1))
              }
          }}}
        else{
          objD.writeInGuide(true,objE.error,false)
        }

        objD.box.setText("")
      }
    }
    objD.box.addActionListener(action)

}

