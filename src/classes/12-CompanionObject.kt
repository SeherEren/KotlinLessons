package classes

// CONST --> Değişkenin başına yazınca değişmeyen sabit anlamına getiriyor değişkeni.Const değişkenler büyük harfle yazarız.
const val name = "codemy"

class Photo {

//    const val name = "codemy"

    val photoUrl1 = "${BASE_URL}ç2rujf9834guj8239djk890guj23d-fjıogu37o4f3ı809g34hjf"
    val photoUrl2 = "${BASE_URL}655u6n56j435hw6j7y56m7uy656mu656u56u56um5u5u56un56b"
    val photoUrl3 = "${BASE_URL}ç2ru5y56j67ıöo9l78k67ı76uj56uh6565867l87y8j768j68hjf"
    val photoUrl4 = "${BASE_URL}56j6579o87ş0ç89ırhfyjmöçpoıhbdftjlöşljçlşkşljhjbtyjbj"

    fun printAll() {
        photoUrl1.log()
        photoUrl2.log()
        photoUrl3.log()
        photoUrl4.log()
    }
    /**
     *      OBJECT kullanımı class'ın kendi propert'ine instance almadan erişim sağlar.
     */
    /* COMPAİN OBJECT tanımlama;
    *  Class'ın başına COMPANİON OBJECT yazıyoruz.
    *  Companion objectlerde, Class ismi yazmamıza gerek yoktur. Compain object bir tane oluşturulur.
    *
    * Çağırırken;
    * class imi . compain'in ismi ( compain sözcüğü ile çağırıyoruz.)
    * */

    /**
     *  NOT: Genelde CONST değişken tanımlamalarda kullanıyoruz.
     */

    /**
     * Özünde obje gibi davranıyor, bize class'ını statik yapıyor. Instance'ını veriyor ve @JVMStatic sayesinde GET()
     * ve SET() İNE ERİŞEBİLİYORUZ jAVA'da.
     */

/*  JVM STATİC --> Bu kullanımı yazdığımız zaman Java tarafından çağrılırken Java'da arkaplanda bize GET() ve SET() ini
* oluşturuyor propertinin.
*
*   @JVM STATİC yazdığımız zaman COMPAİN OBJECT classını çağırmadan kullanabiliriz.
*
*   @JVM OVERLOAD --> Default argüment tanımlayarak aynı isimde birden fazla metot yazmamız gerekmiyor.Overload işlemine
* gerrek kalmıyor. Javada default argument olmadığı için yazılması gereken diğer overload metotlarında yazılması gerekiyor.
* O yüzden JVM Overload bunu yapıyor. */

    companion object {

        const val NAME = "codemy"  // CONST değişkenleri büyük harfle yazarız.

        var BASE_URL = "www.google.com.tr/"

        @JvmStatic
        var BASE_URL2 = "www.google.com.tr/"   // değişkenin başına JVMStatic yazdığımız zaman değişkenin
        // get() ve set() ini static  olarak geri dönen bir metot verir.

        fun print() {
//            photoUrl2.log()

        }
    }

//    companion object {
//
//        var BASE_URL = "www.google.com.tr/"
//
//        fun print() {
////            photoUrl2.log()
//
//        }
//    }
}

//--------------------------------------------------------------------------------------------------------------------//

fun main() {

    val photo = Photo()
    photo.printAll()

    Photo.BASE_URL = "www.yandex.com.tr/"
    Photo.BASE_URL2 = "www.yandex.com.tr/"

    val photop2 = Photo()
    photop2.printAll()
}

