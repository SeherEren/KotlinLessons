package classes

/**
 *      SEALED CLASS--> Enum class'ların özelleştirilmiş halidir. Bizlere sınırlandırılmış bir class hiyerarşisi sunar.
 *
 *      Sealed keyword'ü ile tanımlanır.
 *     Enumlarla aynı işlemlerde kullanılırlar enumlar Primitive tipler için kullanılırlar.
 *     Sealed class'ların içerisinde İSE ; enum kullanımı gibi class'ların kullanma işlemini yapıyoruz.
 */


// Elimizde birden fazla class varsa , biz bunları bir yerde toplayabiliyorsak SEALED class tanımlayarak içerisinde
// bu classları belirtiyoruz kullanacağımız class'ları

sealed class Fruit {      // Fruit class'ını APPLE ve BANANA ile sınırlandırıyoruz. Fruit class'ından extend ediyoruz...
    class Apple : Fruit()
    class Banana : Fruit()

/*  Enumlarla aynı işlemi yapıyor extra olarak birden fazla instance oluşturmayı sağlıyor. */

    object GetFruit : Fruit() {
        fun getFruit(): Fruit {
            return Apple()
        }
    }
}

//--------------------------------------------------------------------------------------------------------------------//

fun main() {

    /**
     *      ENUM'larla aynı şekilde kullanımı vardır.Extra olarak birden fazla INSTANCE oluşturmamızı sağlar. Fakat
     *      SEALED Class'dan nesne yaratılmasına izin vermez. Sealed class kendisini default'ta ABSTRACT class yapmış
     *      olur.
     */

    /*  Sealed classlarda class'ın kendisinden nesne oluşturmaya izin vermez, sealed class'ın ismi yazılıp sonra class'ın
* adı yazılarak INSTANCE oluşturulur. */

//    val fruit = Fruit()    // Sealed class'tan INSTANCE alınmaz.
//    val apple2 = Apple()

    val apple = Fruit.Apple()    // Sealed class'larda bu şekilde INSTANCE alınır.
    val banana = Fruit.Banana()

    val getFruit = Fruit.GetFruit

    printFruit(apple)
    printFruit(banana)
    printFruit(getFruit)
}


//------------------------------------------------------------------------------------------------------------//
/**
 *      WHEN fonksiyonu yazarken "ELSE" case'ine gerek yoktur. Sınırlama içerisindeki SEALED değerlerinin
 *      alabileceği değerler bellidir.
 */
fun printFruit(fruit: Fruit) {
    when (fruit) {
        is Fruit.Apple -> {
            println("Apple")
        }
        is Fruit.Banana -> {
            println("Banana")
        }
        Fruit.GetFruit -> {
            print("Apple + Banana")
        }
    }
}

