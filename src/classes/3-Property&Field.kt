package classes

import java.util.*

/**
 *  BYTECODE' a dönüştürme;
 *   CTRL + SHİFT + A
 *   Show Kotlin ByteCode yaz (makina kodunu açar )
 *   Sonra DECOMPİLE  basınca kodlar compile ediliyor. Ve JAVA koduna dönüştürülüyor.Bu şekilde java'daki
 *   halini görüp kodları karşılaştırabiliriz.
 *
 */
//--------------------------------------------------------------------------------------------------------- //
/**
 * ENCAPSULATİON --> Herhangi bir nesnenin (class mesela) metotlarını, verilerini değişkenlerini diğer nesnelerden saklamak.
 * Değişkenlerimiz Private,  bu değişkenlere erişen hallerinin PUBLİC olmasıdırr.
 *
 *  Asıl field'ler private, bunları geri dönen GETTER () VE SETTER() yani property'leri public'tir.
 *
 *  Eğer değişkenler private yapılırsa ; field'lere erişilemez yani getter,
 *  setterları yok olur.
 *
 *  Kotlin'de yapılan erişim işlemleri değişkenin kendisi üzerinden yapılmaz get ve set metodları ile
 *  yapıyoruz.
 *  Kotlin'de yazılan herbir değişken FİELD değil, PROPERTY'dir. Çünkü onları JVK çevrildiğinde
 *  GETTER ve Setter 'ı vardır arka planda.
 */
class AwesomeCodemy {
    open val name = "Codemy"

    var website = "Codemy.Live" // get degisemiyor.
        private set   // Değişkenin burada Set'i kapattık.

    var twitterAccount: String = ""
        set(value) {
            field = value.toLowerCase(Locale("tr", "TR"))
        }
}
//---------------------------------------------------------------------------------------------------------------- //
/**
 *  Final --> Java'da değişkene final demek değişkeni değiştirilemez anlamına getiriyor. Kotlin'de VAL 'ın
 *  yerine geçiyor.
 *
 *  KOTLİN'de değişkene final ataması yapılamaz. Class'lara final verilir. O da extend edilemez anlamına gelir (Open işleminin tersi)
 */
// ------------------------------------------------------------------------------------------------------ //
/**
 *   JAVA'da
 *   private String name ="Codemy"  --> Field( değişken) deniyor.
 *      Property
 *      public String getName(){
 *          return name;
 *          }
 *     public void setName(String name) {
 *      this.name = name;
 *      }
 *
 *   KOTLİN'de  ;
 *   val name ="Codemy"  --> sebebi ByteCode'a dönüştürdüğümüzde private değişkenlerini oluşturur ve get,set metotlarını oluşturur.
 */

//--------------------------------------------------------------------------------------------------------------//

/**
 *  Değişkeni Private yaparsak; var 'ın da get() ve set() ini , val'ın da sadece get() işlemi olduğundan sadece get()inin işlemlerini yapmaz.
 *
 *      Class'ın içindeki değişkenin PUBLİC yazılması durumunda, VAL ise GETter'ı , VAR değişken ise GETTER, SETTER yazılır.
 *  Çünkü VAL değişkenlere SET işlemi yapılamadığından dolayı.
 *
 *  KOTLİN'de değişkenleri public yaparsak, set'ini kapatmak istersek PRİVATE yaparak set kısmını VAL ' a çeviririz.
 */
fun main() {
    val awesomeCodemy = AwesomeCodemy()

    awesomeCodemy.name
//   awesomeCodemy.website = "google.com"

    /**
     *   Java yazmış olsaydık get ve set'ini bu şekilde yazacaktık
    awesomeCodemy.getName()
    awesomeCodemy.SetWebsite ="google.com"
     */

    println(awesomeCodemy.twitterAccount)

    awesomeCodemy.twitterAccount = "@CodemyLive"

    println(awesomeCodemy.twitterAccount)
}