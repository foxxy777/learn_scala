//object type_data extends App {
object type_data {
  def main(args:Array[String]):Unit={
    var a = 1
    a = 2
    println(a)
    val b: Byte = 1
    val i: Int = 1
    val l: Long = 1
    val s: Short = 1
    val d: Double = 2.0
    val f: Float = 1
    val ff = 1.2f
    println(ff)
    //System.err.println("here is an error")
    val s1 = "abc"
    val s2 = "123"
    val cat1 = s"$s1$s2"
    println(cat1)
    val cat2 = s1+" "+s2
    println(cat2)
    println(s"1+1 = ${1+1}")

    val speech = """hi
what am i doing
i am typing"""
    println(speech)
  }
}

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
object HelloInteractive extends App {
  print("Enter your first name: ")
  val firstName = readLine()
  print("Enter your last name: ")
  val lastName = readLine()

  println(s"Your name is $firstName $lastName")
}
object array_type extends App{
  //val numbs = Array(1,2,3)
  var numbs = Array(1 to 3:_*)
  println(numbs)
  numbs = Array[Int](3,2,1)
  println(numbs)
}
object arraybuffer_type extends App{
  //easy ways to append and remove elements
  //val numbs = ArrayBuffer(1,2,3) //element type would be inferred as int rather than double
  val numbs = ArrayBuffer(1.0,2,3)
  //numbs +=1.5
  numbs +=1.5
  println(numbs)
  numbs -=1
  println(numbs)
}


object list_type extends App{
  val list1 = List(1,2,3)
  //list1(2) = 100
  println(list1)
  val a::rest = list1
  println(s"a : $a")
  println(s"rest : $rest")
}
object list__type extends App{
  val lista = List('a','b','c')
  println(lista)
  val list1 = List(1, 2, 3)
  println(list1)
  val list2 = 0::list1
  println(list2)
  //use ::: to concatenate 2 Lists
  val listconc = list2::lista
  println(listconc)
  val listconc2 = list2:::lista
  println(listconc2)
}
import scala.collection.mutable.ListBuffer
object listbuffer_type extends App{
  val listbuf = ListBuffer(1,2,3)
  listbuf += 4
  println(listbuf)
  listbuf(2) =100
  println(listbuf)
}
object vector_type extends App{
  val vector1 = Vector(1,2,3)
  //vector1(0) = 100 //vector, like list, is immutable
  val vector2 = 0 +: vector1 :+ 4
  println(vector2)
  val vector3 = vector2.map(n=>n*n)
  println(vector3)
}

object map_type extends App {
  val ratings = Map(
    "math"-> 5.0,
    "english"-> 4.0,
    "politics"-> 3.5
  )
  for((lesson,score)<-ratings){
    println(s"$lesson : $score")
  }
  ratings.foreach {
    case(lesson, score) => println(s"key: $lesson, value: $score")
  }
}

object mutable_set extends App{
  val set1 = scala.collection.mutable.Set[Int](1,2,3)
 set1 += 4
 println(set1)

  val set2 = scala.collection.immutable.Set[Int](1,2,3)
  //set2 += 2 //immutable: elements cant be changed
}

object seqence_method extends App{
  val vec1 = Vector(1,2,3)
  println(vec1)
  vec1.foreach(println)
  val filter = vec1.filter(_==2)
  println(s"filter:$filter")
  val map = vec1.map(_+3)
  println(s"map:$map")
  val reduce = vec1.reduce(_*_)
  println(s"reduce:$reduce")
  val head = vec1.head
  println(s"head:$head")
  val tail = vec1.tail
  println(s"tail:$tail")
  val take = vec1.take(2)
  println(s"take:$take")
  val takewhile = vec1.takeWhile(_<=2) // not much different with filter
  println(s"takewhile:$takewhile")
  val reverse = vec1.reverse
  println(s"reverse:$reverse")
}

object tuple_type extends App{
  class basic_info(var age:Int,var name:String)
  val syy = new basic_info(18,"SYY")
  val detailed_info = Tuple3(160,50,syy)
  println(detailed_info)
  println(detailed_info._3.age)
  println(detailed_info._3.name)
}

object if_flow extends App{
  val result = if(1<2) 1 else 2
  println(s"$result")

  val a =3
  if(a==1)
    println("a=1")
  else if (a!=1) {
    print("a=")
    println(s"$a")
  }
}

object for_foreach_print extends App{
  val map1 = Map(
    "syy" -> 160,
    "yxu" -> 178
  )
  for((a,b)<-map1){
    println(s"$a $b")
  }
  map1.foreach{case(a,b)=>println(s"$a $b")}
}
object for_create extends App {
  val numbs = Vector(1,2,3)
  println(numbs)
  val numbs2 = for(n<-numbs)yield {
    if(n%2==1) n else n*2
  }
  println(numbs2)
  //val numbs3 = numbs.map(
  //  if(_%2==1) _ else _*2
  //)
  val names = Vector("*yys","*yxu")
  println(names)
  val capnames = for (n<-names)yield {n.drop(1).capitalize}
  println(capnames)
}

object match_case extends App {
  val i = 3
  def match_week(i: Int){
    i match {
      case 3 => println("wednesday")
      case _ => println("not wednesday")
    }
  }
  match_week(i)

  def match_week_return_string(i: Int):String={
    i match {
      case 3 => "wednesday"
      case _ => "not wednesday"
    }
  }
  println(match_week_return_string(4))

  def evenorodd(int: Int): Unit ={
    int match {
      case x if x%2==0 =>println("even")
      case _ =>println("odd")
    }
  }
  evenorodd(3)

}



object method extends App{
  def y1(x1:Int, x2:Int) = {
    val sum = x1+x2
    val div = sum / 3
    sum
  }
  println(y1(1,2))
}

object method1 extends App {
  def y1(x1: Int, x2: Int) = {
    val sum = x1 + x2
    val div:Float = sum / 3
    div
  }
  println(y1(1, 2))

  val y2 = (x1:Int,x2:Int)=>(x1+x2)/3
  println(y2(1,2))

  val y3 :(Int,Int)=>Int =(x1:Int,x2:Int)=>(x1+x2)/3
  println(y3(1,2))

  val sendstring = ()=>"sendstring"
  println(sendstring())

  //val parameterize2 = (x1:Int=1,x2:Int=2)=>(x1+x2)/3
  def parameterize1(x1: Float=3, x2: Int=4) = {
    val sum = x1 + x2
    val div:Float = sum / 3
    div.formatted("%.2f")
  }
  val para2 = parameterize1 _
  println(para2(5,6))
  println(para2(10,11))
}

object Closures extends App{
  var ext =1
  val freevar =(x:Int) =>x+ext
  println(freevar(0))
  val snap = freevar(0)
  ext = 2
  println(freevar(0))
  println(snap)
}

object no_para extends App{
  var hight = 160f;
  var weight = 50f;
  var per = () =>hight/weight
  println(per)
  println(per())
  hight = 178f
  weight = 70f
  println(per)
  println(per())
}

object curly_braces extends App{
  def x_y_z_0 (x:Int,y:Int,z:Int)={x-y-z}
  def x_y_z (x:Int)(y:Int)(z:Int)={x-y-z}
  val one_y_z = x_y_z(1)_
  println(s"1-y1-z1:${one_y_z(2)(3)}")
  println(s"1-y2-z2:${one_y_z(4)(5)}")
  val one_two_z = x_y_z (1)(2)_
  println(s"1-2-z3:${one_two_z(10)}")
}

object class_test extends App{
  class indiv (var hight: Int = 155,var name: String = "sxj"){
    var age =28;
    //var food:String //must define other than merely declare
    println(indiv.this)
    println(indiv.this.hight)
    //println(indiv.this.food)
  }
  val p = new indiv(160,"yys")
  println(s"${p.name}:${p.hight}")
  val p1 =new indiv()
  println(p1.name + ":" + p1.hight)

  abstract class abstract_class {
    var food:String //must define
  }

}
object auxiliary_class_extension extends App{
  val defaultcolor = "black"
  val defaultmonth = 1
  class cat(var color:String,var month:Int){
    def this (specmonth:Int)={
      this(defaultcolor,specmonth)
    }
    def this()={
      this(defaultcolor,defaultmonth)
    }

  }
  val cat_need_month = new cat(6)
  val defualtcat = new cat()

}
trait eating{
  var food1:String
  var food2:String
  def can_tolerate_spice_or_not()={
    println("can not tolerate spice")
  }
}

object class_whit_trait extends App{
  class indiv (var hight: Int = 155,var name: String = "sxj")extends eating{
    var age =28;
    var food1: String = "pancake"
    override var food2: String = _
    override def can_tolerate_spice_or_not()={
      println("can tolerate spice")
    }
  }
  val ind = new indiv()
  println(ind.food1)
  println(ind.food2)
  ind.can_tolerate_spice_or_not()
}


object caseclass extends App{
  abstract class fuit{
    val name:String
    val flavor:String
  }
  case class watermelon() extends fuit{
    val name: String = "watormelon"
    val flavor: String = "sweat"
  }
  case class grape() extends fuit{
    val name: String = "grape"
    val flavor: String = "sour"
  }
  val fruit1 = watermelon
  val fruit2 = watermelon
  fruit1 match {
    case watermelon=>println("got a watermelon")
    case grape=>println("got a grape")
    case _ =>println("what is it?")
  }
}

object companion_object extends App{
  class kid(var age:Int = 6, var name:String = "kiddo"){
    println(kid.hight)
  }
  object kid {
    var hight:Int = 10
  }
  val kiddo = new kid
}

object variance_not_good_example extends App{
  class fruit
  class watermelon (var weight:Float = 0.5f )extends fruit{
    println(this.weight)
  }
  val melon1 = new watermelon()
  val melon2 = new watermelon(1f)
  //covariance ==> in lib:List[+T]
  val fruitlist : List[fruit] = List(melon1,melon2)
  //contravariance
  class weight_a_thing[-T]{
    def print_weighting_obj(ele:T) = {
      println(s"weighting:$ele")
    }
  }
  val result1 = new weight_a_thing[watermelon]
  result1.print_weighting_obj(melon1)
}


object data_inherent extends App{
  val ele_any_val:AnyVal = 1f
  val list_any : List[Any] = List(
    ele_any_val,
    "1",
    1,
    1d,
    true
  )
  list_any.foreach(x=>println(x))
}

object casting extends App {
  val int_val:Int = 233
  val float_val:Float = int_val
  val double_val:Double = 233.0
  //val float_val2:Float = double_val
  val string_val:String = int_val.toString
  println(string_val)
  val string_val_2:String = float_val.toString
  println(string_val_2)
}


object generic extends App {
  class class1[T](vari:T){
    def printfunc = {
      println(vari)
    }
  };
  val int_class1 = new class1(3)
  int_class1.printfunc

  val float_class1 = new class1(3f)
  float_class1.printfunc

  class A{ val a =1 }
  class B extends A{ val b = 2.33f }
  class C extends B{ val c = 4.56d }
  class generic[T <:B](vari:T){
    def print_funct() = {println(vari.b)}
  }
  //val aa = new A
  //val g1 = new generic(aa)
  //g1.print_funct()

  val cc = new C
  val g2 = new generic(cc)
  g2.print_funct()

  class generic2[T >:B](vari:T){
    def print_funct() = {println(vari.toString)}
  }

}

object covariance extends App{
  class animal{
    val animal_name = "animal"
  }
  class cat extends animal{
    val cat_name = "cat"
  }
  class cub[+T<:animal](vari:T){
    def print_func = {println(vari.animal_name)}
  }
  val animal = new animal
  val cub_of_animal = new cub(animal)
  val cat = new cat
  val cub_of_cat = new cub(cat)

  val cub_of_animal2:cub[animal] = cub_of_cat
  cub_of_animal2.print_func
  //val cub_of_cat2:cub[cat] = cub_of_animal
}
//implicit 实际上就是吧写默认参数的过程提取到了函数外面
object ImplicitParameters {

  implicit val name: String = "default"  // 定义隐式变量
  log("init")

  def log(msg: String)(implicit name: String): Unit = println(s"[$name] $msg")

  def process(): Unit = {
    implicit val name: String = "process"
    log("doing something")
  }

  def main(args: Array[String]): Unit = {
    implicit val name: String = "main"
    log("start")
    process()
    log("end")("custom name")
  }
}
