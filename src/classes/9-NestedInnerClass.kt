package classes

/**
 *      Class içerisine class yazarsak bu yazıma Nested Class diyoruz.
 *
 *      Nested classtan nesne üretirken (instance alırken);
 *      önce dıştaki (outer class) class  . (nokta) içerideki class'ı yazıyoruz--> val lawSchool = School.LawSchool()
 *
 *      Eğer class içerisindeki class'ı INNER keyword'ü ile tanımlarsak INNER Class tanımlamış oluruz.
 *
 *      INNER Classtan nesne üretirken;
 *      outer class () . inner class() -->   val medSchool = School().MedSchool()
 *
 *      KOTLİNde multiple inheritance(birden fazla miras alma) yapılamıyor. Fakat INNER Class, Outher class'ın bütün
 *      değişkenlerine eriştiği için onun extend ettiği class'a erişir özelliklerini alır ve ayriyetten INNER Class
 *      kendisi de başka bir class'ı extend edebilir. Ve bu şekilde INNER Class'ta multiple interihance yapılabilir.Ama
 *      bunu yaparken hem outher class'ın hem onun extend ettiği class'ın hem inner class'ın hemde onun extend ettiği
 *      class'ı memory de yaratmış olduk (School , Shape() , MedSchool, Daire() bunlar memory'de yaratıldı )
 *
 */
// Inner class ta outer class ın değişkenlerini kullanabiliyoruz.
// Nested class kullanırken Outer class ın nesnesini yaratnmak zorunda değiliz.Ama inner class kullanıyorsak İnner
// class a erişirken outer class'ın nesnesini oluşturmamız gerekiyor.
// Inner class outer classın referansını tutar ve değişkenlerine ve üye fonksiyonlarına erişilebilir. Nesnesi
// oluşturulurkende Outer class'ın nesnesi yaratılır. Nested class; outer class'ın referansını tutmadığından dolayı
// değişkenlerine ve üye fonksiyonlarına erişemez ve instance oluşturulurken outer class'ın nesnesi oluşturulmaz '

//--------------------------------------------------------------------------------------------------------------------//

// Not : Outer class , inner class RAM'den silinmeden silinmiyor.Bu da memorylink oluşturuyor.
// Çünkü inner class oluştururken, outer class'ın bir referansı oluşturuluyor arka planda, inner class garbage collector
// inner class'ı silmeden outher class silmez bu da Ram de çalışma hızında değişim olur düşer.

class School : Shape() {      //dıştaki class (outer class)    // Shape'den extend edildi

    private val schoolName = "Codemy"
    val schoolType = "Online"

    // Nested Class class içerisine normal class tanımlandığından dolayı
    class LawSchool {
        val studentCount: Int = 5000

        fun printOuterName() {
//            println("Outher School Name : $schoolName")   // Nested class'tan outher class'ın değişkenine erişilemiyor
//            println("Outher School Type : $schoolType")
        }
    }
/* Kotlinde multiple inheritance yoktur. Fakat outher class'ın özelliklerine eriştiği için onun extend ettiği class'a da
* erişir ve kendisi de başka bir class'ı extend edebildiği için multiple extend yapılır. Ama bütün class'lar memoryde
* oluşturulur bu yüzden bu da gereksiz memory kullanımına sebep olur.*/

    // INNER Class , inner keyword'ü ile tanımlandığından dolayı
    inner class MedSchool : Daire("Daire") {    // Daire class'ından extend edildi

        val studentCount: Int = 5000

        /** INNER Class'ın NESTED Class'tan fark olarak artısı OUTER Class'ın değişkenine kendi üye fonksiyonu içerisinden
         * erişebilmesini sağlıyor. */

        fun printOuterName() {
            println("Outher School Name : ${schoolName}") // Inner class'tan outher class'ın değişkenine erişiliyor.
            println("Outher School Type : ${schoolType}")
            println("Shape $shape")
        }

        inner class TechSchool : Shape()   // inner class, burada inner class içerisine inner class oluşturuldu
    }
}

//-----------------------------------------------------------------------------------------------------------//

fun main() {
// Nested class cağırma
    val lawSchool = School.LawSchool()   // instance alma dıştaki class + içteki class
    lawSchool.printOuterName()
    lawSchool.studentCount

// Inner class cağırma
    val medSchool = School().MedSchool()
    medSchool.studentCount
    medSchool.printOuterName()

    // inner class içerisindeki inner class'tan Instance alırken
    val techSchool = School().MedSchool().TechSchool()

}