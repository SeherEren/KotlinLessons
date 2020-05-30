package classes

/** OBJECT DESCRATİON = SİNGLETON */

// outoff memory -> Memory demek, memorylink.
// KOTLİN'de Singleton yaparken oluşturduğumuz oblect kullanımı, OBJECT DESCRATİON işlemidir.
/**
 *   OBJECT keyword'ü ile tanımlıyoruz kotlin'de Singleton kullanımını.
 *
 *   Object keyword'ü ile oluşturduğumuz class'ın içerisine değişken veya metotlarda tanımlayabiliyoruz.
 *
 *   Kotlin'de OBJECT keyword'ü kullandığımız zaman arka planda static bir kullanımı yapmış oluyoruz.
 *   Ve bu şekilde memory'den silinmeyen bir alan oluşturmuş olduğumuzdan rastgele kullanmamamız gerekiyor
 */

/**
 * NOT : Eğer uygulama içerisinde 1 dk'lık bir süre içinde kullanılacaksa değişken yanlış kullanım olur. Ama uygulama
 * boyunca veya uygulamanın heryerinde kullanılan bir değişken tanımlıyorsak o zaman SİNGLETON kullanırız.
 *
 * NOT 2 : Singleton ile MEMORY'de sadece 1 tane instance yapılır yanı birkez değişken tanımlanır, oluşturulur.
 */

/* Singleton; memory'de sadece bir kere değişken oluşturup alan kaplar uygulama kapanana kadar Garbage collector'den
silinmez*/

/* Singleton tasarım patterdir. Aynı zamanda ANTİ PATTERN'dir. Eğer gereksiz ve yanlış yerde kullanırsak
memory'de gereksiz yer kaplayacağından dolayı, memoryLink oluşturur ve diğer çalışmalarımızın yerini sınırlayacağı için
uygulamamızın çalışmasını yavaşlatır*/

object SingletonKotlin {
    var color: String = "blue"

    fun printColor() {
        println("color $color")
    }
}

//----------------------------------------------------------------------------------------------//


fun main() {
    SingletonKotlin.color = "red"      // Singleton kullanımı bu şekilde yapılıyor
    SingletonKotlin.printColor()
}