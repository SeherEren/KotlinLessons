package functions

fun main() {

    /**
     *      Daha okunakli kodlar yazmak icin kullanilir.
     *      . (nokta) kullanimi kaldirir.
     *      Bir fonksiyonu infix hale getirebilmek icin 5 sart vardir.
     *      1. infix keywordu ile baslar.
     *      2. fonksiyon bir uye fonksiyon olmalidir. (bir sinifa ait olmalidir)
     *      3. ya da bir EXTENSİON fonksiyon olmalidir.
     *      4. Mecburi olarak sadece bir parametre almalidir. Bu parametre vararg olamaz. Bi cakal sizsiniz :)
     *      5. infix method'un parametresi default deger alamaz.
     *
     *      Yapisal olarak;
     *
     *      infix fun infixMethod(justOneParam : AwesomeParam) : Whatever{
     *
     *      }
     * **/

    val isStudent = false
    val isMale = true

    /**
     *      and, or, xor gibi onlarca infix method vardir.
     * **/
    if (!isStudent and isMale) {
        print("Öğrenci Olmayan Erkek")
    }

    /* if (isStudent && isMale){
         print("Öğrenci Olmayan Erkek")
     }*/

    // infix kullanimi( çağırımı )
    isStudent and isMale

    /** class'in içerisindeki bir infix metoda dışarıdan erişeceksek class'ın instance ını alıp
    nesnesi boşluk infix metod boşluk parametre şeklinde çağırıyoruz
     */
    val awesomeInstance = AwesomeClass()   //nesne yaratma instance alma
    // infix kullanimi
    awesomeInstance downloadImage "www.google.com.tr"


    /* -------------------------------------------------------------------------------------------------------------------*/

    val number = 5
    // matematiksel operatorlerin, tip donusumlerin (type conversion), range kullanimin, infix methodlara karsi islem onceligi vardir.
    if (number + number - 2 * (awesomeInstance specialPlus 4) == 5) {

    }

/* -------------------------------------------------------------------------------------------------------------------*/

    // infix methodlarin da mantik operatorlerine gore onceligi vardir.
    if (number == 3 && number < 5 || awesomeInstance specialPlus 4 == 5) {

    }
}
/* -------------------------------------------------------------------------------------------------------------------*/

class AwesomeClass {

    // İnfix'te DEFAULT değer ataması yapılmaz. Calismaz. Comment'i kaldir kontrol et istersen
//    infix fun downloadImage(imageUrl : String = "Ahmet"){
//
//    }
/* -------------------------------------------------------------------------------------------------------------------*/

    infix fun downloadImage(imageUrl: String) {

    }

    /** matematiksel işlemlerle birlikte infix metot kullanıyorsak öncelik sırasına göre önce matematiksel işlemler
     * daha sonra(en son) infix metot yapılır
     * Mantıksal operatörler ile infix metot kullanırsak ilk önce infix metot sonra matıksal
     * operatörler işlem yapar
     */
    infix fun specialPlus(number: Int): Int {  //specialPlus içine (number:Int) parametre aldı 1 tane
        return 4
    }

    /* -------------------------------------------------------------------------------------------------------------------*/

    // Vararg kullanımına izin vermez, Calismaz. Comment'i kaldir kontrol et istersen
//    infix fun <T> downloadImage2(vararg mageUrl : T){
//
//    }

/* -------------------------------------------------------------------------------------------------------------------*/
    // infix metodu bulunduğu class'ın içerisindeki farklı metottan çağıracaksak eğer;
    // bir sinifin(classın) icindeyken this kullanimi size bulundugu sinifi isaret eder. class'ın dışarısında this ile class'ı belirtemeyiz.Instance almamız gerekir.
    // asagidaki kullanimda AwesomeClass().downloadImage(imageUrl) kullanimi olusur aslinda. (implicit)

    fun logWhenImageDownloaded(imageUrl: String) {
        downloadImage(imageUrl) // infix metodu bulunduğu class'ın içerisindeki farklı metottan çağıracaksak ya normal metod çağırımı yapıcaz
        this downloadImage imageUrl  // yada "this" ile bulunduğumuz class'ı belirtip infix metod ve nesne şeklinde kullanabiliriz.
    }
}

/* -------------------------------------------------------------------------------------------------------------------*/

// bir sinifin disindayken infix method cagirimi yapilirsa this kullanilamaz.

//fun logWhenImageDownloaded(imageUrl: String){
//    this downloadImage imageUrl
//}


