package classes

/**
 *     INTERFACE ile ABSTRACT Class Arasındaki farklar;
 *
 *           INTERFACE
 *       Interface Class değildir. Implement edilir, extend edilmediğinden dolayı birden fazla interface'i bir class'a
 *     implement edebilir.
 *      Bir class'ın yapabileceği işlemleri fonksiyonları belirtir, yani sözleşme gibi birşeydir interface'ler uymak geekiyor
 *      İnterface'lerde metotun body'si yoksa override etmemiz gerekiyor, body'si varsa metodun override etmek zorunlu değildir
 *    super keyword'ü ile override edebiliriz.
 *      Final keyword'ü yazılmaz interface'lerde, çünkü implement işlemi oluşturuluyor interfacelerde
 *      Init ve constructor blokları yoktur.
 *      Blueprint yapılarda kullanılır.
 *      İnterface'lerinde state tutma özelliği vardır fakat badpractise'dir. Kullanımı önerilemez Garbage Collector'dan
 *      silinmesini sağlamak gerekir.
 *      İnterface'in metotlarının içerisinde "this" görürseniz eğer bu metodun interface'in hangi class'tan implement
 *      edildiyse o class'ı veriyor
 *
 *        ABSTRACT CLASS
 *      Interfacelerin yaptığı herşeyi yaparlar ve üzerine STATE tutma özelliğine sahiptirler.
 *      EXTEND edilirler ve bu yüzden bir class'a sadece bir tane class extend edilir.
 *      CLASS olduklarından dolayı init{} bloğu ve constructorları(primary ve secondary) vardır.
 *      Bir işin nasıl yapılması ile ilgili işlemleri kapsar, sahip olması gereken tüm detayları işler.
 *      ABSTRACT bir class'ın Abstract bir değişkeni, metodu varsa onu OVERRİDE etmemiz zorunludur.
 *      Instance alınmaz , nesnesi yaratılmaz
 *      FİNAL keyword'ü yazılmaz, çünkü extend(miras)  verme işlemi için , Default özelliği Open olmalıdır.
 *      Detay bilgi verilecek durumlarda ABSTRACT class kullanılır. Sebebide bir class'a sadece bir tane class extend
 *      işlemi yapıldığından dolayı.
 *
 *    BLUEPRİNT --> Şablon yapısı demektir.
 *    Yani bir class'ın neler yapacağını yeteneklerini(event,olay) değilde,  özelliklerini belirtmeye başladıksa
 *    ABSTRACT class'a geçiş yapıyoruz.
 *    Interface'lerde fonksiyonların belirtildiği yeteneklerin belirtildiği yerdri.
 *
 */
// interface tanımlarken final kullanılmıyor
interface AnimalEvent {

    //    init {    -- Interface'ler init yapısına izin vermezler
    //      }

    // İnterface'de bu şekilde değişken tanımlaması fazla yapılmaz böyle birşeye gerek duyulursa detaylar yazılması
//gerekirse ABSTRACT class kullanmaya geçmemiz gerekir.
    val animalName: String

    /**
    fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean = false, name : String ="" set(value) {field = value}) {
    şeklinde interface içerisinde field tanımlamasına değişkenle izin vermiyor bu da state tutamadığının göstergesidir.
     */
    // interface'lerde metotlarının parametrelerine default değer atamasına izin vardır. (Boolean = false)
    // Kotlinde simpleName vs. gibi class nesnelerine erişmek için ;
    //         this.javaclass.simpleName yada  ::  ile this::class.simpleName şeklinde erişebiliriz.

    fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean = false) {
        when (this::class.simpleName.toString()) {   // this :: class.simpleName -- bu yazım bize class'ın ismini verir.
            "Fish" -> {
                "Fish".log()
            }
            "Bird" -> {
                "Bird".log()
            }
            "Cats" -> {
                "Cats".log()
            }
        }
        println("Interface : isFly : $isFly, isSwim : $isSwim, isWalk : $isWalk")
        println("Interface : isFly : $isFly, isSwim : $isSwim, isWalk : $isWalk")
    }

    fun makeSound() {  // Metot'a body ekledik burada
        println("Make a sound")
    }

    fun eat(isCarnivorous: Boolean)

    // Bu metota body tanımlamazsak implement ettiğimiz yerlerde override edilmesi için kızmaya başlar interface,
// boş {} bir body eklesek bile animalevent'i implement ettiğimiz classlar kızmayı bıraktı ve istediğimiz  class'ta
// override etmeyi sağlıyor.
    fun isNeedOxygen() {}
}

fun String.log() {   //String'e extension yazdık,extension function oldu.
    println(this)
}

// ------------------------------------------------------------------------------------------------------------------ //
interface WalkEvent {
    fun slowSpeedWalk()
    fun fastSpeedWalk()
}

//------------------------------------------------------------------------------------------------------------------- //
/**
 *      Interface'ler implement edilirken  : ile class'lara implement edilirler java'daki gibi keywork kullanılmaz.
 *      Interface'ler implement edildiğinde içerisindeki bütün metotları implement etmemiz eklememiz gerekiyor(interface
 *      sözleşme olduğundan dolayı içerisindeki tüm metotlara uymak gerekiyor)
 *      Interface içerisindeki metota body tanımlarsak implement ettiğimizde override etmek zorunda değiliz. Override
 *      etmek istersekte super keyword'ü ile metot içerisindeki body'e erişebiliriz.
 */

//Tanımladığımız değişkenleri (animalName) override ettik
class Fish(override val animalName: String) : AnimalEvent {

// Interface metoduna body verirsek o zaman class içerisinde onu implement ederken override etmek zorunda değiliz.
// Yukarıda makeSound içerisine yazı yazdık override etmesekte burada kızmadı.

    // override fun makeSound() {
    // }

    override fun eat(isCarnivorous: Boolean) {
    }

}

/**  Eğer body'li bir metodumuz interfacede tanımlı ise ve classımız bu interface'in body metodunu override etmezsek
 *   default olarak  body'li metodu çalıştırır.
 *   Metodu override etmiş olsak bile(override edildiğine interface içerisindeki anlamı değişir) super cağırımı
 *   yapmadıysak eğer interface içerisindeki class ismini yazdırma kısmını  yapmaz body'si olmadığından dolayı body
 *   kısmına girmez.
 */

class Bird : AnimalEvent {
    override val animalName: String = "Bird"

    override fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean) {
        // super.move(isFly, isSwim, isWalk)--  bu şekilde super'ini çağırmadan move metodunu kullansakta yukarıda interface
        // içerisindeki class ismini yazdırma kısmını yapmaz body'si olmadığından burada body kısmına girmez.
    }

    //İnterface içindeki metotun body'si varsa implement ettiğimiz class içerisinde metodu override ederken body'i
// çağırmak SUPER keyword'ü metot'un body'sine erişebiliyoruz.
    override fun makeSound() {
        super.makeSound()
        println("Blop blop")
    }

    override fun eat(isCarnivorous: Boolean) {
    }
}

//------------------------------------------------------------------------------------------------------------------- //
/**
 *      Bir class birden fazla class'ı EXTEND edemez
 *      Bir class bşden fazla Interface'i Implement edebilir.
 *
 *      Interface'lerin constructor'ları olmadığından interface isminin yanında () olmaz. WalkEvent şeklinde yazılır.
 *      Class'ların cons. u olduğundan animal() şeklinde gösterilir bu şekilde ayırt ederiz class ile interface'i
 */
//class Cats : Animal(), Plant(), AnimalEvent, WalkEvent{   // birden fazla class extend edilemez.
class Cats : Animal(), AnimalEvent, WalkEvent {

    override val animalName: String
        get() = "Cats"

//      Aynı isme sahip ve aynı değişken sayısına sahip bir metot hem extend ettiğimiz classta(animal class) , hemde
//  implement ettğimiz(animalEvent interface) interface te varsa 2 sini de aynı class'a verirsek interface bize override
//  etmek zorunda bırakmıyor.İstersek override edebiliyoruz. Sebebi miras aldığımız(extend) class'ta olduğundan dolayı.

    /*override fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean){
        super.move(isFly, isSwim, isWalk)
    }*/

    //---------------------------------------------------------------//

//    Aynı isme sahip, aynı değişkene sahip ve body'si olan metot tanımladığımız zaman, implement ve extend ederken
//  body'e erişmek için super'inin önüne super<Animal> şeklinde arayiüzde class veya interface adını hangisi olduğunu
//  yazarız ki o body'e gitmesi gerektiğini gösteririz.(Hangi super'e gideceğimizi gösterir).
//  Yada super çağrımı olmayacak diye boş bırakıp super çağrımı da yapmayız.

    override fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean) {
        super<Animal>.move(isFly, isSwim, isWalk)  // bu move' a tıkladığında classtakine gider
        super<AnimalEvent>.move(isFly, isSwim, isWalk)  // bu move' a tıkladığında interfacetekine gider
        println("Bodysiz kullanım")
    }

    override fun eat(isCarnivorous: Boolean) {
    }

    override fun slowSpeedWalk() {
    }

    override fun fastSpeedWalk() {
    }
}

// abstract class open ile oluşturuldu
open class Animal {

    // open fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean=false) {  --> Interface içerisindeki metodun
    //  default değeri tanımlanmışsa çağırdığımız yerde 2. bir default değer tanımlaması yapılamaz.Ama çağırdığımız yerde
    // değişkeni yazmamıza gerek yoktur.
    open fun move(isFly: Boolean, isSwim: Boolean, isWalk: Boolean) {
        println("Class : isFly : $isFly, isSwim : $isSwim, isWalk : $isWalk")
    }
}

open class Plant

// ------------------------------------------------------------------------------------------------------------------ //
fun main() {
    val cats = Cats()
    val bird = Bird()
    val fish = Fish("Fish")
    cats.move(false, false, true)
    bird.move(true, false)  // isWalk'ın default değeri olduğu için çağırırken yazmamıza gerek olmaz.
    fish.move(false, true, false)
}

// Abstract class'ların nesnesi yaratılmaz instance'ı alınamaz.
//    val baseAnimal = BaseAnimal()

// Interface'lerin bu şekilde  OBJECT:   keyword'ü ile beraber değişkene ataması yapılabiliyor.
val animalEvent = object : AnimalEvent {
    override val animalName: String
        get() = ""

    override fun eat(isCarnivorous: Boolean) {
    }
}

//--------------------------------------------------------------------------------------------------------//
/**
 *      Abstract class'ın Abstract değişkenleri varsa zorunlu olarak override etmek gerekiyor.
 */
abstract class BaseAnimal {
    //    abstract val name : String = "Kangal"   --> Default değer atamaya izin vermez
    abstract val name: String
    open var animalType: String = ""
    val animalColor = "blue"    // bunu override etmek zorunda değiliz

    // Abstract class'larda da event verilebilir. zorunlu olarak override edilmesi gerekir.
    abstract fun printName()

    // Abstract class içerisine abstract olmayan metotlarda tanımlanabilir ve override etmek zorunlu değildir.
    open fun printName2() {

    }
}

class SivasKangali(override val name: String) : BaseAnimal() {
    // animalType değişkeni open ile tanımlandığından override ediyoruz ve var ile tanımlandığından
//  get'ini ve set'ini oluşturdu.
    override var animalType: String
        get() = super.animalType
        set(value) {}

    // eventi override ettik. Override etmek zorunludur.
    override fun printName() {
    }

    // Abstract olmayan metotları override etmek isteğe bağlıdır.
    override fun printName2() {
        super.printName2()
        print("abcd")
    }
}