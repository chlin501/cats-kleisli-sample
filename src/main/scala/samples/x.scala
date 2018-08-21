package samples

import cats.data.Kleisli
import cats.implicits._

object x {

  val stringToInt: Kleisli[Option, String, Int] =  Kleisli(
    str => if(str.matches("-?[0-9]+")) Some(str.length) else None
  )

  val intToDouble: Kleisli[Option, Int, Double] = Kleisli(
    int => if(0 != int)  Some(2.0/int) else None
  )

  val stringToDouble = stringToInt andThen intToDouble

  def main(args: Array[String]) {
    println(stringToDouble.run("123"))
    println(stringToDouble.run(""))
  }

}
