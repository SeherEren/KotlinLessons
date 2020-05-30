package classes

/**
 *      Özünde type olarak kullanabildiğimiz sınırlı yapıdaki gruplayabileceğimiz sınırlı sayıdaki
 *      elemanları barındırdığımız class'lara ENUM CLASS denir.
 *      Name ve ordinal attribute'leri vardır.
 *
 *      Özelleştirmek istersek string metodunu override ederiz default'undan ( yazılım sekli için vs.)
 *
 *      ve extra katacağımız özellikleri ABSTRACT fun olarak yazarak metodu her enum içerisinde override ederek yeni
 *      özellikler ekleyebiliriz. ( Abstract metod tanımlanır, normal metot tanımlanmaz)
 *
 *
 */

//enum class DirectionType2{
//    EAST, WEST, NORTH, SOUTH
//}
//
//DirectionType2.NORTH  -- kullanımı

//--------------------------------------------------------------------------------------------------------------------//

// name ve ordinal degiskenleri default olarak final oldugu icin override edilemezler.
// Enum class' lar; open bir class'ı miras almaya (extend) izin verilmez, ancak bir interface'i implement edebilirsiniz.
// Enum class' lar; abstract, open, sealed, inner ve data keywordleri alarak bu classlardan olamazlar.

enum class DirectionType(val code: Int, val ordinals: Int) : AnimalEvent {

//    EAST, WEST, NORTH, SOUTH

    /**
     *      Enum değerlerini büyük küçük yazımı E büyük geri kalan küçük olarak çalışmasını da sağlasın istersek
    enum değişkeninin herbirinin toString() metodunu override edip döneceği değeri yazarız.
    Ve kullanırken TOSTRİNG() metodu ile kullanırız.--->>
    setDirection(DirectionType.EAST.toString(), DirectionType.EAST.ordinal)

    Eğer enum'ımız farklı bir değer taşısın istersekte bu değerleri constructor içerisine istediğimiz
    kadar değişken ekleyip tiplerini belirtiyoruz  ve enum değerlerinin yanında değerleri yazıyoruz. -->>
    enum class DirectionType(val code: Int, val ordinals: Int)
     */
    EAST(100, 1) {
        override fun toString(): String {
            return "East"              // tostring'i override ederek isimlendirmeyi istediğimiz gibi yapabiliriz.
        }

        override fun printFullValue() {
            println("name : ${EAST.name}, position : ${EAST.ordinal}")
        }

        //------Burası IMPLEMENT edilen Interface 'in override edilmesi gereken metotları ----------//
        override val animalName: String
            get() = ""

        override fun eat(isCarnivorous: Boolean) {
        }
        //----------------------------------------------------//

    },
    WEST(200, 2) {
        override fun toString(): String {
            return "West"
        }

        override fun printFullValue() {
            println("name : ${WEST.name}, position : ${WEST.ordinal}")
        }

        override val animalName: String
            get() = ""

        override fun eat(isCarnivorous: Boolean) {
        }
    },
    SOUTH(300, 3) {
        override fun toString(): String {
            return "South"
        }

        override fun printFullValue() {
            println("name : ${SOUTH.name}, position : ${SOUTH.ordinal}")
        }

//        override fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean) {
//            super.move(isFly, isSwim, isWalk)
//        }

        override val animalName: String
            get() = ""

        override fun eat(isCarnivorous: Boolean) {
        }
    },
    NORTH(400, 4) {
        override fun toString(): String {
            return "North"
        }

        override fun printFullValue() {
            println("name : ${NORTH.name}, position : ${NORTH.ordinal}")
        }

        override val animalName: String
            get() = ""

        override fun eat(isCarnivorous: Boolean) {
        }
    };

    //    fun printFullValue()
//    open fun printFullValue(){
//
//    }

    /**
     *  enum ismi ve pozisyonlarını birlikte yazdırmak istersek;
     *  Abstract bir class tanımlayarak her enum değişkeni içerisindende onu override edip
     *
     *     override fun printFullValue() {
    println("name : ${NORTH.name}, position : ${NORTH.ordinal}")
    }     şeklinde .

     *   Daha sonrada kullanırken ;   DirectionType.NORTH.printFullValue()   şeklinde kullanarak 2 değeri birlikte
     *   gösterebiliriz.
     */
    abstract fun printFullValue()
}

//--------------------------------------------------------------------------------------------------------------------//

fun main() {
    setDirection("East", 1)
    setDirection("West", 2)
    setDirection("North", 3)
    setDirection("South", 4)

    println()

// name --> attribute ile ENUM' ların string değerlerini alıyoruz.
// ORDİNAL --> Enum sıralamasında position(pozisyon) değerlerini verir "Int" olarak. Pozisyon olarak tanımlanır ,
//  çağırırken ORDİNAL attribute şle çağırılır. Enumlar 0(sıfır) dan başlar.

    setDirection(DirectionType.EAST.name, DirectionType.EAST.ordinal)
    setDirection(DirectionType.WEST.name, DirectionType.WEST.ordinal)
    setDirection(DirectionType.NORTH.name, DirectionType.NORTH.ordinal)
    setDirection(DirectionType.SOUTH.name, DirectionType.SOUTH.ordinal)

    println()

    /** TOSTRİNG() metodu override edilen enum' ın kullanımı; setDirection(DirectionType.EAST.toString()  */
    setDirection(DirectionType.EAST.toString(), DirectionType.EAST.ordinal)
    setDirection(DirectionType.WEST.toString(), DirectionType.WEST.ordinal)
    setDirection(DirectionType.NORTH.toString(), DirectionType.NORTH.ordinal)
    setDirection(DirectionType.SOUTH.toString(), DirectionType.SOUTH.ordinal)

    println()

// ENUM ların ismini ve position değerlerini birlikte gösterir.Yukarıda Oluşturulan abstract class'ın
// enum içerisinde override edilmesi sayesinde.
    DirectionType.EAST.printFullValue()
    DirectionType.WEST.printFullValue()   // bu şekilde çağırılıyor. enum class'ın ismi + enum ismi + funct,on ismi
    DirectionType.NORTH.printFullValue()
    DirectionType.SOUTH.printFullValue()

    println()

// burada bu şekilde constructor içerisinde tanımladığımız değerleri çağırıyoruz fun main içerisinde
    DirectionType.EAST.code.log()
    DirectionType.WEST.code.log()
    DirectionType.NORTH.code.log()
    DirectionType.SOUTH.code.log()

    DirectionType.EAST.ordinals.logOrdinal()
    DirectionType.WEST.ordinals.logOrdinal()
    DirectionType.NORTH.ordinals.logOrdinal()
    DirectionType.SOUTH.ordinals.logOrdinal()

//-------------------------------------------------------------------------------------------------------------------//

    /**
     *  WHEN ' in Expression Kullanımı;
     *
     *  WHEN' in expression kullanımı ENUM class'ımızdaki type ları vererek yaptıysak eğer
     *  ELSE bloğunu yazmamıza gerek olmaz çünkü IDE enum sayımızı bildiğinden dolayı;
     *
     *  Ama enum değerini yazarak when expression yazarsak ELSE bloğunu yazmamızı ister bizden IDE
     */

    val directionType = DirectionType.NORTH
    val redirectionType = when (directionType) {
        DirectionType.EAST -> {
            DirectionType.EAST.toString()
        }
        DirectionType.WEST -> {
            DirectionType.WEST.toString()
        }
        DirectionType.NORTH -> {
            DirectionType.NORTH.toString()
        }
        DirectionType.SOUTH -> {
            DirectionType.SOUTH.toString()
        }
    }

//-------------------------------------------------------//

    val directionType2 = "North"
    val redirectType2 = when (directionType2) {
        "East" -> {
            "EAST"
        }
        "West" -> {
            "WEST"
        }
        "North" -> {
            "NORTH"
        }
        "South" -> {
            "SOUTH"
        }
        else -> {
            "Else"
        }
    }
}

//Not : bu altlardaki şekilde yazım best practise yani güzel kod yazma şeklidir. Elemelerde tercih edilmesi daha yüksek böyle kod yazanın.
fun setDirection(direction: String, postion: Int) {
    println("direction $direction, postion $postion")
}

fun Int.log() {
    println("Direction Code : $this")
}

fun Int.logOrdinal() {
    println("Ordinal : $this")
}