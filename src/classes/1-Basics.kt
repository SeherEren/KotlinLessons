package classes
/* Bir CLASS'ın içerisinde bulunanlar...Class'ın üye nesneleri ;
    - Primary - Secondary constructors
    - Priperty - Field , val-var nasıl kullanılır
    - Init bloğu
    - Inner yada Nesned Class
    - Object Declaration
*/
/**  Class'lar ilk çalıştığında var olan durumlara göre;
 *  ilk property'ler ,değişkenler çalışır
 *  sonra init bloğu
 *  en son secondary diye ilerler...
 * */

// ---------------------------------------------------------------------------------------------------------------//
/**  Değer ataması yaparken Primary constructor'ın değer atamalarını 3 şekilde yapabiliriz,
1- init bloğu içerisinde yapabiliriz,
2- Değişkenin kendisini yazarken yazabiliriz -->  var carColor: String = ""   ,   var carType2: String
3-  constructor içindeki değişkene VAL  veya VAR ifadesi vererek yaparız.(class Car2 constructor(val paramCarType : String))
Ve bunlar sayesinde içeride kullanımına izin verir.
(üye değişken yaparız değişkeni ve içeriden erişime izin verir)

bu atamalar sayesinde içeriden değişkene erişim sağlanır...
 */
class Car2 constructor(val paramCarType: String) {

    var carType: String = paramCarType
    var carColor: String = ""
    var carType2: String

    init {
        this.carType = paramCarType
        this.carColor = ""
        this.carType2 = "Cartype"
        /** Üye değişkene değer ataması yapacaksak eğer init bloğunda yaparsak değişken
        tanımlarken(yukarıda) değer beklemez o zaman. Değişken tipini yukarıda val veya var yapsak farketmez. Val'da yapabiliriz orada
        çünkü değer ataması init içinde olacak o zaman
         */
    }

    //this.değişken olarak yazarsak üye değişkene işaret eder.
    constructor(carType: String, carColor: String) : this(carType) { // secondary const. val ya da var tanimi yapilamaz.
        this.carType = carType
        this.carColor = carColor
        this.carType2 =
            "Cartype" // init blogunda atama olmazsa bu degiskene secondary const. icersinde deger atanmasina izin verilmez.
    }

    // class içerisindeki bir fonksiyondan değişkene erişmek istersek;
    fun printTypeAndColor() {
        println("carType : ${this.carType} , carColor : $carColor")
        println("carType : $paramCarType , carColor : $carColor")
    }
}

//---------------------------------------------------------------------------------------------------------------//

/**  Primary constructor ve Secondary constructor arasındaki farklar;
 *  Secondary const. ın {} parantezleri vardır ve bunların içerisinde herhangi bir ek işlem yapabiliyoruz.
 *  Primary const. da {} olmadığından dolayı bunu init{} ile yaparız.
 * */

/**     İNİT {} bloğu , Primary constructor' a başka kodlar eklenmez fakat bunun önüne geçmez için init{} bloğunu kullanırız.
 *      İçine diğer başka kodları burada yazabiliriz.Primary const. çalıştığı zaman init'in içerisi çalışır.
 *
 *      Birden fazla init{} bloğu yazarsak hepsi çalışır daha sonra secondary constructor çalışır. İnit bloklarından da
 *      öncelik sırası üste yazılan önce alttan yazılan daha sonra çalışır.Sebebi kod yukarıdan aşağıya okunduğundan dolayı.
 *
 *  */

/*  Eğer Primary constructor'ımız hiç yoksa secondary constructor'da THİS{} kullanmamıza gerek yoktur.
    Default primary constructor arka planda üstü kapalı oluşturulmasına rağmen this yazmıyoruz.
*/
class Car3 {  // primary constructor yok burada

    init {
        println("initialize 2")
    }

    constructor(carType: String, carColor: String) {    // this kullanmadık
        println("secondaryconst")
    }

    init {
        println("initialize 1")
    }
}

//--------------------------------------------------------------------------------------------------------------//

/**
 *  - Primary const. yoksa THİS{} kullanmamız gerekmiyor,
 *  - Primary constructor varsa içerisindeki tüm parametrelerin default değer atamış olsak bile
 *  secondary constructor'da this{} i kullanmamız gerekiyor. THİS ile primary const. belirtmemiz gerekiyor,
 *  mecbur şekilde çağırmamız gerekiyor. En fazla this{} içini boş bırakabiliyoruz.
 */

class Car(type: String = "Default value") {     //burası primary constructor ve default değer aldı
    /**     Also --> herhangi bir değişkene değer ataması yaptıktan sonra extra bir işlem yapmak istediğimiz durumlarda
     *      kullanılır.
     */
    val carType: String = "Metal".also {
        println(it)
    }

    constructor(type: String, color: String) : this() {   //secondary constructor yazımı bu
        println("type : $type, color : $color")
    }

    /** Default olarak bir değer atandığı zaman;  type: String = "23213"
     *  çağırırken argümentleri belirterek yazarsak ; val carInsance4 = Car(color ="blue", count =  5)
     *  içeride default bir değer atandığı anlaşılır, koda daha sonra bakanlar tarafından
     *  */
    //this(type) buradaki type secondary const.'dan alınan type değeri yazılır
    constructor(type: String = "23213", color: String, count: Int) : this(type) {
        println("primary const. type : $type")
    }

    init {
        println("primary const. type : $type")
    }
}


// -------------------------------------------------------------------------------------------------------------//
/**     Bir class'ın instance oluşturulmasını istemiyorsak eğer 2 şekilde yapabiliriz;
 *      1- Class'ın var olan bütün constructor'larını PRİVATE yapmamız lazım. Bu şekilde erişilemez olur.
 *        Secondary constructor'ları da Private yapmamız gerekiyor. Class'tan instance oluşturulmaması için.
 *        Bu şekilde yaparsak dışardan instance oluşmaz fakat içeride class'ın içerisinde instance alınır.
 *      2- Class 'ı ABSTRACT class olarak tanımlamamız lazım ki instance 'ı alınmasın
 *      */

class DontCreateInstanceFromMe private constructor() { // class'i private yapmak instance'nin yaratilmasina engel degil.
    //constructor'ı private yapmak gerekir.

    val instance = DontCreateInstanceFromMe()     // class içinde instance

    private constructor(number: Int) : this()
}

abstract class DontCreateInstanceFromMeAbstract {

//    val instance = DontCreateInstanceFromMeAbstract()
}

/** Not : Eğer secondary constructor'da this(type) ile primary constructor'ı belirttiysek; secondary çalışırken önce
primary constructor'ın init bloğu çalışır sonra secondary constructor çalışır. Çünkü this ile primary 'i referans alıyoruz */

fun main() {
//    val carInsance = Car()   // primary const. boş olan değerle çalışır.Default value yazar
//    val carInsance2 = Car("MiniCooper")    // Primary const init bloğu olan kısım çalışır.(primary const. type:minicooper) yazar
//    val carInsance3 = Car("MiniCooper", "blue")   // secondary const. çalışır.
//    val carInsance4 = Car(color ="blue", count =  5)  // secondary const. çalışır.Aama içinde belirtilen parametrelerini verir.

//    val carInstance = Car3("MiniCooper", "blue")

    val charInstance = Car2("MiniCooper")
    val charInstance2 = Car2("MiniCooper", "blue")

    charInstance.printTypeAndColor()
    charInstance2.printTypeAndColor()
//------------------------------------------------------------------------//
//    val dontCreateInstanceFromMe = DontCreateInstanceFromMe()  // constructorları PRİVATE yaparsak instance alınmaz
//    val dontCreateInstanceFromMeAbstract = DontCreateInstanceFromMeAbstract()  // abstract class tanımlarsak instance yaratılmaz

    //  val daire = Daire("O")
}