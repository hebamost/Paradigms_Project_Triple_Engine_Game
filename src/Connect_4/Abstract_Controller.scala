package Connect_4

trait Abstract_Controller {
  // to check if the input within letters from (a to g) or not
  def input_Validation(alpha: Char): Boolean

  // to convert the input to integer from (0 to 6)
  def convToNum(alpha: Char): Int

  // to get the first empty cell in the desired column
  def rowPosition(col: Char=> Int, alpha:Char, array :Array[Array[Int]]): Int
}