package classes
/*   OBJECT EXPRESSİON neden kullanırız;
    1- Class'ın içerisine birşey yazamıyorsak, ama bu class OPEN veya ABSTRACT class ise classtan üretilen
* INSTANCE'ın interface'e erişim sağlaması ve sadece kullanılan o ekranda o INTERFACE'i kullanabilir olur.

*   2- Class'a INTERFACE implement edilmiyorsa veya implement ediliyorsa bile o class'tan extend edilen yerlerde tekrar
*   implement etmek gerekmesini istemiyorsak sadece bu kullanılan alan için kullanırız.*/
/**
 *      OBJECT EXPRESSİON
 *      Oluşturduğumuz nesneye(instance aldığımız) İNTERFACE verme işlemidir(interface ekleme işlemi)
 *      Başka bir INTERFACE'i implement etmek istersek OBJECT EXPRESSİON işlemi ile bunu gerçekleştirebiliriz.
 *
 *          Bir class'a bir interface oluşturmak istersek ve bunun sadece kullanılan ekranda olmasını istiyorsak
 *      eğer;
 *
 *      1- Class'ımızı OPEN veya ABSTRACT olarak tanımlıyoruz.
 *      2-Class'ımızdan İNSTANCE alırken = 'in karşısına CLASS ismi , İNTERFACE'i yazarız. Başına da OBJECT yazarız.(bu
 *      işleme object expression denir). Sonrada Object'i implement edip interface içerisindeki metotları
 *      override ediyoruz.   -->
 *      val textView:TextView = object: TextView("abcd"),OnTextChanged {
override fun textChanged() {
}
 */

/*   open class TextView(text : String):OnTextChanged yani bu tarz class'a interface implement etme işleminin yerine
    ayrı anlam için sadece o ekranda kullanılsın başka yerde kullanmak zorunda kalmayalım diye INSTANCE oluştururken
    OBJECT ile interface'i expression eder ekleriz.
*/
/**
 *  -Değiştirilemeyen class'a interface implement ediyoruz.
 *  -Ve interface'i sadece kullanılacak ekranda implement ediyoruz. Eğer böyle implement işlemini yapmasaydık,
 *  interface'in kullanıldığı heryerde implement etmek gerektirebilir.
 */

open class TextView(text: String) {
    open val textSize: Int = text.length  //değişkenimizde open değişkense onu da aşağıda override edebiliriz.
}

interface OnTextChanged {
    fun textChanged()
}

//--------------------------------------------------------------------------------------------------------------------//

fun main() {

    val textMessage = "Codemy"

    val textView: TextView = object : TextView(textMessage), OnTextChanged {
        // TextSize 'ımızda OPEN değişken olduğu için burada onu da override edebiliyoruz.
        override val textSize: Int
            get() = textMessage.length + 1

        override fun textChanged() {

        }
    }

//-------------------------------------------------------------------------------------------------------------------//

    /*  OBJECT 'in 2. kullanımı ; */

    /* C++ daki stract yapısı şeklinde kullanılır. Bir class oluşturmadan sanki class varmış gibi gruplayabileceğimiz
     ifadeleri gruplayacak şekilde kullanım şeklidir. */


    val studentName = "Seher"
    val studentAge = 30

    val student = object {  // elimizdeki değişkenleri object içerisinde belirtip değişken içerisine attığımızda
        // o değişken üzerinde erişebiliriz.
        val name = "Seher"
        val age = 30

        val prepStudent = object {
            val name = "PrepStudent"
            val age = "07"
        }
    }

    student.name   // bu sekilde erişiriz.
    student.age

    student.prepStudent.name
}