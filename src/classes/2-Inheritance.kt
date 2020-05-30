package classes

/**
 *  Kotlin'de bir class'ın inheritance edilebilmesi için;
 *   Miras alınacak class'ın başına " OPEN " keyword'ü yazarız.(inherit almaya açık)
 *   Miras alan class'a  :(iki nokta) ile miras verilen class yazılır.
 *   Java'da " EXTENDS" keyword'ü + miras alınacak class ismi şeklinde inheritance yapılır.
 *   Java'da class'lar default olarak publictir miras alımında başına birşey koyulmaz.Miras alınabilir durumdadır yanı.
 *
 *   -- Class'ların içindeki fonksiyonların, değişkenleriv vs. başında da OPEN yazıyorsa bu override edileceği anlamına gelir.
 *
 *   FİNAL --> Bir class'ın EXTEND( miras verilmesi) edilmesin istersek class'ın başına FİNAL
 *   yazılır. Final yazılırsa o class'tan miras alınamaz.
 */

// KOTLİN'de bütün classlar default olarak "public" olarak görülür.


//abstract class Shape{
//    fun draw(){
//
//    }
//
//    fun fill(){
//
//    }
//}

open class Shape {
    open val shape: String = "Empty"
    open val color: String = "Blue"

    // get() = super.color  // val olduğu için değişken get metodu var
    open var edge = 0

    open fun draw() {
        println(shape)
    }

    fun fill() {

    }
}

/**
 *      Extend edilen class'ın fonksiyonları üzerinde değişiklik yapmak istersek miras alan class içinde
 *      OVERRİDE işlemi yaparız. Override işlemi için metodun başına OVERRİDE yazarız.
 */
class Rectangle : Shape() {

//    init {
//        draw()    // miras aldığımız için shape'in metotlarını çağırabiliyoruz.
//    }

    override val shape: String
        get() = """
                *********
                *       *
                *********
        """.trimIndent()

    /* SUPER çağırımı ; eğer override ettiğimiz miras aldığımız yerdeki işlemi yapmak için çağırıyoruz
    *  Bir üst yerdeki(miras aldığı) yerdeki işlemi yapar. (Miras alırken kullanılan kalıp, üst class'ın metodunu çağırır) */

    override fun draw() {   // draw fonksiyonunu yukarıda open yaptığımızdan dolayı burada override ettik
        super.draw()   // burada super keyword'ü ile üstteki class'ın değerini alıyoruz.
        println("Rectangle created.")
    }
}


class Triangle : Shape() {

//    init {
//        fill()
//    }

    override val shape: String
        //        get() = super.shape
        get() = """
                *
               ***
              *****
        """.trimIndent()

}

class Square : Shape()   // shape ten extend ettik

// ------------------------------------------------------------------------------------------------------------------ //

/**
 *      Değişkeni override ederken class'ın bodysinde yapmak zorunda değiliz. Override ettiğimiz class'ın constructor'ın
 *      da da override edebiliriz. Fonksiyonları bu şekilde override edemeyiz ama.
 *
 *      VAL  ise değişken keyword'ü,  get metodu var demektir set metodu yok demektir. Çünkü READONLY(okunabilir) değişkendir.
 *      VAR  türündeki değişkenin hem get'i hemde set 'i vardır.
 */

/**
 *   Override işlemi yaparken üst class ta VAL olarak tanımlanan değişken altta override ederken VAR'a çevirilebilir
 *   Ama üst class ta var olan değişken aşağıda override ederken val' a çevrilemez.
 *   Sebebi üst class'taki Set metodu açıkta kalacağından dolayı orada set metodu da olduğundan dolayı
 */
open class Daire constructor(override val shape: String) : Shape() {

    protected var number: Int = 3

    override val color: String = "Black"
    //  final override val color: String = "Black"

    override var edge: Int      // var tanımlandığı için get ve set metodu kullanılıyor.
        get() = super.edge
        set(value) {}

//    fun fill(){
//
//    }
}

// ------------------------------------------------------------------------------------------------------------------- //
/**
 *      Miras alınan bir class başka bir class'a miras veriliyorsa(dede-baba-torun ilişkisi gibi) en üstteki miras verilen
 *      class'ın özelliklerini miras olarak alabiliriz.(shape-daire-circle şeklinde, shape 'in özelliklerini circle alabilir)
 *
 *      Ama bu şekilde alt class özelliği almasın istersek kısıtlamak için kullanmasını istemediğimiz özelliğin,
 *      fonksiyonun önüne FİNAL keyword'ü koyarız o metod extend edilmez(Sealed (mühürleme) işlemi gibi).
 *      (Kullanımı kısıtlarız.(daire içindeki color 'a bak final var başında)
 */

class Circle : Daire("Circle") { // extend edilen class private ise extend etmeye izin verilmez

    private val dede1 =
        Daire("asdasd")  // class private iken aynı dosya icerisinde farklı bir class'da instance yaratmaya izin veriliyor.
    // Ancak bu instance'ın kendisi de private olmak zorunda

    override val color: String
        get() = super.color

    fun printColor() {
        println(color)
        number = 4
    }
}

//-----------------------------------------------------------------------------------------------------------------------//
/**
 *      Kotlinde class'lar default olarak final'dır
 *      Final olan , Open yazılmayan bir class'ın içerisine override edebileceğimiz open bir değişken tanımlarsak
 *      değişkeni override edemeyiz daha sonra. Çünkü class'a miras alınamaz diye koruma verdik.
 */
class FinalShape {

    open val name: String = ""

//   override val name : String = "asdasd"  // class final olduğundan değişkeni override edemezyiz.
}

// class Hexagon : FinalShape()  // FinalShape'in tipi final olduğu için extend edilmez.

// ------------------------------------------------------------------------------------------- //

// Get metodu -> İlgili değişkeni çağırıyorsak sadece get metodudur. -->  daire.color gbi
// Set metodu -> İlgili değişken eşittir atama yapıyorsak set metodudur.  -->  daire.color ="..."
fun main() {

    val triangle = Triangle()   // triangle ve rectangle den instance aldık.
    val rectangle = Rectangle()
    val square = Square()
    val daire = Daire("O") // aynı dosyada olmak şartıyla, main içinde public nesne olusturmaya izin veriliyor.
    val circle = Circle()

//    daire.number

    triangle.draw()    // Override ettiğimiz DRAW metodlarını çağırdık
    rectangle.draw()
    square.draw()      // burada direk shape deki draw'ın değerini alıyor override etmediğimiz için
    println(daire.color)
    circle.printColor()
}