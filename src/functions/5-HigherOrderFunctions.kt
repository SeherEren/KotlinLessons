package functions

import java.util.*
import kotlin.concurrent.schedule

fun main() {
    /**
     *      Fonksiyon'lar Kotlin'de "First Class Citizen"dır. Yani degiskenlere deger olarak atanabilir, baska fonksiyonlara
     *      parametre olarak verilebilir ya da bir fonksiyonunn geri donus degeri olabilir demektir.
     *
     *      Higher Order Function'lar basitce bir fonksiyona parametre olarak verilen fonksiyonlardır. Parametre olarak
     *      verilmekten kasit, fonksiyonun cagriminin parametre kisminda yapilmasi degil, fonksiyonun govdesinin (body)
     *      yani suslu parantezler arasinda kalan gorev alaninin baska bir fonksiyona parametre olarak verilmesidir.
     *
     *      Yapisal olarak;
     *
     *      fun foo(higherOrderFunction: (message: String) -> Unit){
     *          higherOrderFunction("Codemy")
     *      }
     *
     *      Cagrilirken ;
     *
     *      fun main(){
     *
     *          foo({ message ->
     *              println("Message : $message")
     *          })
     *      }
     */
/* -------------------------------------------------------------------------------------------------------------------*/

    // printUserInfo("Seher", 30)  // --> printUserInfo ya değer vererek çağırdık
    // printUserInfo(getName(), getAge())  // --> Get metodu ile değerleri verilen printUserInfo fonksiyonları çağırdık

    /* fun getName(): String{
    return "Seher"
}
fun getAge(): Int = 30

fun printUserInfo(name:String, age: Int){
    println("name: $name, age : $age")
}
*/

/* ----------------------------------------------------------------------------------*/

    /** NOT : HigherOrderFonksiyon tanımlarken fonksiyonun parametre kısmına parametre ismi yazmadan direk parametre tipini(tiplerini)
     *  yazarakta tanımlama yapabiliriz. Fakat bu karışık gelebilir bizlere  */


    /**
     *      Higher Order Function'lari tanimlamanin 3 yolu vardir.
     */

    //1. Bir degiskene atayarak Higher Order Function tanimlayabilirsiniz.
    // Bu durumda suslu parantezler yanina higher order function'in aldigi parametreler lambda okundan once aralarina virgul
    // koyularak yazilir. Higher Order Function tek parametre aliyorsa, bu parametreleri yazmak zorunda degilsinizdir.
    // Bu durumda higher order function size "it" kelimesi ile higher order function'in parametresi tipinde bir degisken verecektir.
    val higherOrderFunction = { surName: String ->
        "surName : $surName"
    }

    //2. Ismi olmayan "anonymous function" tanimlamalari da Higher Order Function olarak, normal bir fonksiyona parametre
    // olarak verilebilir.
    val anonymousFunction = fun(surName: String): String {
        return "surName : $surName"
    }

    // Anonymous Function'in expression kullanimini da yine Higher Order Function olarak normal bir fonksiyona parametre
    // olarak verilebilir.
    val anonymousFunction2 = fun(surName: String): String = "surName : $surName"

    // Higher Order Function'la ayni parametre sayisina sahip ve bu parametrelerin hepsinin tipleri Higher Order Function'in
    // parametre tipleri ile ayni ise, bu normal fonksiyon da Higher Order Function olarak normal bir fonksiyona parametre
    // olarak verilebilir. Bunu yapmak icin sadece basina :: isareti koymak yeterlidir. var olan bir fonksiyona higher order fonksşyonu
    // atamak için kullanılır.

    val news = News()  // KOTLİNDE = ile değer ataması yapıyoruz.  : ile değişken tipi veriliyor
    news.read(::print)

    //Kullanılırken fonksiyon, parametre olarak içeri alınıyor.
    printUserInfo(getName(), higherOrderFunction, getAge())
    printUserInfo(getName(), anonymousFunction, getAge())
    printUserInfo(getName(), fun(surName: String): String {
        return "surName : $surName"
    }, getAge())

    // Suslu parantezler (body) direkt olarak Higher Order Function'in parametre olarak beklendigi alana da yazilabilir.
    printUserInfo(getName(), {
        "surname : $it"
    }, getAge())

    //3.
    getItemClickListener({ buttonName ->
        println("$buttonName tıklandı..")
    })

/* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Eger bir fonksiyon parametreleri icerisinde bir Higher Order Function son parametre olarak tanimlandiysa veya
     *      tek bir parametre olarak tanımlanmışsa, bu durumda isteniyorsa, bu Higher Order Function,
     *      fonksiyon parametrelerinin disina da yazilabilir. Daha temiz bir kullanim yapmis oluruz.
     */
    val newsType = NewsType()
    news.getNewsFromServer("FoxTv", newsType, {
        println(this.toString())
    }) // Higher Order Function, fonksiyon parametrelerinin icerisinde tanimlanmistir.

    news.getNewsFromServer("FoxTv", newsType) {
        println(this.toString())
    } // Higher Order Function, fonksiyon parametrelerinin disinda tanimlanmistir.

/* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Higher Order Function birde fazla parametre iceriyorsa, aralarina virgul koyarak lambda isareti ile tanimlamak zorunlu.
     *      Tek parametreye sahipse bu durumda parametre ismi ve lambda isareti koyulmayabilir. Bu durumda ilgili parametre "it"
     *      kelimesi ile cagrilabilecektir.
     *      Eger bir fonksiyon, parametre olarak sadece Higher Order Function aliyorsa bu durumda fonksiyon parantezlerini hic yazmayabilirsiniz.
     */
    news.filterNews { filterType, getFilterName ->

    }
}

/* -------------------------------------------------------------------------------------------------------------------*/

// Normal Fonksiyon
fun getName(): String {
    return "Gökhan"
}

// Normal Fonksiyon, expression kullanima ornek
fun getAge(): Int = 29

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      2. parametre Higher Order Fonksiyon olarak tanimlanmistir.
 *      Higher Order Fonksiyonlar DEFAULT deger alabilirler. Bunun icin basitce suslu parantezler acmak yeterlidir.
 *      Dikkat edilmesi gereken konu bu suslu parantezler icine, Higher Order Function parametre bekliyorsa,
 *      bunlar verilmelidir. (alttaki örnekte string olduğu için geri dönüş değeri { "" } çift tırnak yazdık)
 */
fun printUserInfo(name: String, getSurName: (surName: String) -> String = { "" }, age: Int): Unit {
    println("name: $name , age : $age")

    println(getSurName("ÖZTÜRK"))
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Higher Order Function'a parametre tanimlarken sadece degisken tipini tanimlayarak da (degisken adi olmadan) kullanilabilir.
 */
fun getItemClickListener(onClick: (String) -> Unit) {

    println("Tiklama islemi baslatiliyor")

    Timer().schedule(3000) {

        // Bir higher order function, parametre olarak yazildiktan sonra, bu parametrenin normal fonksiyon icerisinde
        // cagirilmasi gerekmektedir. Aksi halde bu higher order fonksiyonu tanimlamak mantiksiz olur. Normal fonksiyonunun
        // cagrildigi alandaki higher order function'in body kismi hicbir zaman cagrilmaz demek olur.
        onClick("Login")

        println("Tiklama islemi bitti")
    }
}

/* -------------------------------------------------------------------------------------------------------------------*/

class News {
    fun getNewsType(newsType: NewsType): String {
        return when (newsType.toString()) {
            NewsType.breakingNews -> "Breaking"
            NewsType.urgent -> "Urgent"
            NewsType.local -> "Local"
            NewsType.global -> "Global"
            else -> "Normal"
        }
    }
}

class NewsType {
    companion object {
        val breakingNews = "BreakingNews"
        val urgent = "Urgent"
        val local = "Local"
        val global = "Global"
        val normal = "Normal"
    }
}

/**
 *      Bir Higher Order Function'ina parametre verirken Class ismi.() seklindde tanimlama yapilabilir.
 *      Bu sayede ilgili class da parametre parantezi icerisine yazilabilir.
 */
// Burada higherorderfonksiyon; NEWS class'ından extent(extension fnk.) edilerek ona
//  yeni bir fonksiyon atanarak oluşturulmuş fonksiyonun içinde oluşturuluyor */

fun News.getNewsFromServer(channelType: String, newsType: NewsType, getNews: NewsType.(Int) -> Unit) {
//getNews ten itibaren olan kısın higherorder. -- getNews fonks. Adı , NewsType.(Int) ile newstype extent edildi 2 parametreli hale geldi

    when (channelType) {
        "KanalD" -> {
            getNews(newsType, 1)
        }
        "ShowTv" -> {
            getNews(newsType, 2)
        }
        "Tv8" -> {
            getNews(newsType, 3)
        }
        "FoxTv" -> {
            getNews(newsType, 3)
        }
        "CNN" -> {
            getNews(newsType, 3)
        }
    }
}

/* -------------------------------------------------------------------------------------------------------------------*/

/* Not : bir fonksiyon extend edilebilir,
extend edilen fonksiyon infix hale getirilebilir.
infix entexd edilen fonksiyon bir parametre almak zorunda bu parametre higherorder fonksiyon olabilir.
HigherOrder fonksiyonun parametreleri higherOrder fonksiyon olabilir,
ve higherOrder fonksiyonun geri dönüş tipi de higherOrder fonksiyon olabilir....  */
/**
 *      Bir Higher Order Function'sın parametresi de yine Higher Order Function olabilir.
 */
infix fun News.filterNews(getFilter: (filterType: String, getFilterName: () -> String) -> Unit) {

    getFilter("filterName") {
        "String return label"
    }
}

fun News.read(readTitle: (String) -> Unit) {
    readTitle("Codemy is Awesome")

}


