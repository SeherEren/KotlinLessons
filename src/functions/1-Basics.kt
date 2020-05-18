package functions

/**
 *      fun keyword'u ile fonksiyonlar baslar.
 *      fonksiyon ismi verilir.
 *      parametre parantezleri acilir ve parantezler girilir.
 *      : operatoru ve geri donus degeri yazilir.
 *      fonksiyon body'si acilir ve kapatilir.
 *      Geri donus degeri olmayan ,verilmeyen fonksiyonlar Unit tipini geri dondurur.Unit yazarız yada bişey yazmasakta olur
 *      Geri dönüş değeri olacaksa eğer tipi ne ise onu yazarız (String vs.)
 * **/

//Eğer yazdığımız kod bloğu birden fazla yerde yazılıyorsa ve kod karmaşasını azaltmak istiyorsak func. yazıp tekrar tekrar kullanabiliriz farklı yerlerde.

fun main() {

    // val numberOne = getValue("Sayi1'i giriniz :")
    // val numberTwo = getValue("Sayi2'yi giriniz :")


    // Fonksiyon cagirilirken ismi ve parametreleri kullanilir.
    // Eger bir geri donusu varsa bir degiskene atabilir.

    calculateArea(2, 3)  // şeklinde fonksiyon çağırılır
//-------------------------------//
    takeSquare(2)
    val squareValue = takeSquare(2)


    /* -------------------------------------------------------------------------------------------------------------------*/

    //  Bir class'in fonksiyonunu cagirirken ise nokta isaretini kullaniriz.
    Math.pow(2.0, 3.0)

/* -------------------------------------------------------------------------------------------------------------------*/

    // Default degeri olan parametrelere sahip bir fonksiyon cagirilirken, default degeri olan parametrelere deger atamak
    // sart degildir. Default degeri olan bu parametreler opsiyonel parametrelerdir.
    // Default degeri olan parametrelere deger atanmadan fonksiyon cagirilacaksa bu durumda parametre sirasi degisir.
    // Ide'ye hangi parametreye deger atadiginizi soylemek icin Named Arguments'leri kullanmaniz gerekir.
    reformatMessage("Message", true, 7, "tr")
    reformatMessage("Message", size = 7, lang = "tr")
    reformatMessage("Message", true, 7)
    reformatMessage("Message", size = 7)

/* -------------------------------------------------------------------------------------------------------------------*/

    //vararg kullanimina ornek. key = 3'den onceki parametreler vararg parametresine denk gelir.
    getUserInfo("Seher", "EREN", "Istanbul", "Turkiye", "", "", "", key = 3)

    // vararg parametresi olarak arrayOf kullanilmak istenirse * operatoru eklenmelidir. (spread operatoru)
    // bu operator diger dillerdeki pointer kullanimi anlamina gelmez. Kotlinde pointerlar yoktur.
    getUserInfo(*arrayOf("Seher", "EREN", "Istanbul", "Turkiye"), key = 4)

    // vararg 'ın T generic type türünde kullanımı
    // getUserInfo2("2", 3, true, 'c', "Ahmet")

    //NOT : Any veri tipleri NULL değişken tipi kabul etmez. Eğer any tiplere null değer ataması yapacaksak Any? şeklinde tanımlamamız gerekiyor
}


//--------------------------------------------------------------------------------------------------//
fun calculateArea(numberOne: Int, numberTwo: Int): Double {
    val result = when (readLine()!!) {
        "+" -> numberOne + numberTwo
        "-" -> numberOne - numberTwo
        "*" -> numberOne * numberTwo
        "/" -> numberOne / numberTwo
        else -> 0
    }
    return result.toDouble()    //Geri dönüş tipi Double olan fonksiyon
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *    @param number degisken tanimlanir gibi tanimlanir.
 *    Fonksiyon parametresi tanimlanirken, val var gibi betimleyiciler kullanilmaz.
 * **/
fun takeSquare(number: Int): Int {
    return 2 * number
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      = ile fonksiyonlara default deger verilebilir. (Default Argument)
 *      Default deger atamasi yapmak function overload islemi yapmanizi saglar.
 *      Tekrar tekrar ayni fonksiyonun farkli varyasyonlarini yazmak durumunda kalmayiz.
 *      Default argument olarak belirttiğimiz değişkenleri yazmasakta varsayılan olarak o değerleri alacak overloads işleminde
 *      (isUpperCase: Boolean = false, lang: String = "tr" ) deki gibi. Çağırma işlemi yaparken default değerleri yazmazsak
 *      diğer değişkenlerin sıralaması farklı olacağından dolayı değişken isimlerini yazmamız gerekiyor.
 ** **/

fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {

}

// Default arguments sayesinde asagidaki fonksiyonlari yazmak zorunda kalmayiz.

//fun reformatMessage(message: String, size: Int, lang: String = "tr") {
//
//}
//fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int) {
//
//}
//
//fun reformatMessage(message: String, size: Int) {
//
//}

/**
 *      Default degeri olan parametrelere sahip bir fonksiyon Java siniflarindan cagrilacaksa eger,
 *      Bu fonksiyona @JvmOverloads annotation'i verilmelidir. Boylece yazilan kod Jvm'e hazir hale getirilirken,
 *      ilgili fonksiyonun tum varyasyonlari yazilir (overload edilir)
 *      = ile (message: String = "Message") böyle değer verilmesi Default(varsayın) argumenttir.
 * **/
@JvmOverloads
fun print(message: String = "Message") {
    println(message)
}

/**
 *      Extend edilebilir bir sinif, yavru (child) sinif tarafindan miras (inherit) alinirsa
 *      ve bu sinifin override edilebilir open bir methodu varsa, bu method default argument'e sahip olursa,
 *      bu sinifi miras alan sinifda method override edilirse, override edilen methodun parametresine default argument tanimlanamaz.
 *      Ust sinifin method'undaki default argument gecerli olur.
 * **/
open class A {
    open fun foo(i: Int = 10) { /*...*/
    }
}

class B : A() {
    override fun foo(i: Int) { /*...*/
    }  // no default value allowed
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Cok uzun sayida parametreniz olacaksa "variable number of arguments" - VARARG tanimlanabilir.
 *      Bu sayede fonksiyon tek bir parametre aliyor gibi gozukurken kendisine cok miktarda degisken atanabilir.
 *      Bu degiskenlere array'e erisir gibi erisebilirsiniz. [index] ya da .get(index) seklinde
 *
 *      vararg tek ya da son parametre olarak yazilirsa, Jvm'e hazirlanirken, Java'daki "String..." gibi ayni kod derlenir.
 *      Ancak vararg param birden fazla tanimlanirken ortada ya da basta yer alirsa, Jvm'e hazirlanirken, Array'e donusturulur.
 *      Bu da performans farki olusturur demektir.Bu yüzden varang kullanırken son parametre olarak vermeye dikkat ediniz.
 ** **/
fun getUserInfo(vararg userInfo: String, key: Int) {
    userInfo[3]
    userInfo.get(3) // Çağırırken
}

/**
 *      Ayni fonksiyon icersinde birden fazla vararg tanimi yapilmasina izin verilmez, Kotlin ve Java'da.
 *      Calismaz. Comment'i kaldir kontrol et istersen...
 * **/
//fun getUserInfo(vararg userInfo: String, vararg userInfo2: String) {
//    userInfo[3]
//}

/**
 *  Vararg ' ın tipini String vs. değilde T türünde verilsek bütün değişken tiplerinde değerler verebiliriz içerisine
 *  Generic type belirttiğimizden dolayı
 *  **/

//fun <T> getUserInfo2(vararg userInfo: T) {
//    userInfo[2]
//}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Bir fonksiyona = koyularak da return edecegi deger yazilabilir. (Single-Expression kullanimi)
 * **/
val userList = arrayOfNulls<String>(5)

fun getListCount(): Int =
    userList.size  // Bu kullanıma expression kullanım deniyor. Diğer yukarıdaki kullandığımız yöntemler state kullanımdır.