package classes;
/**
 * Class içerisinde 1 tane instance yaratmak, dışarıdan hiç instance oluşturulmasın istiyorsak; class'ın başına
 * ya ABSTRACT yazacağız ya da tüm constructorlarını, constructor yoksa DEFAULT CONSTRUCTOR'ının
 * başına PRİVATE yazacağız.
 */

import kotlin.jvm.Synchronized;
import kotlin.jvm.Volatile;

/**
 *      Java'da bir class'a STATİC ise ; Class'ın değişkenlerine, metotlarına İnstance
 *      oluşturmadan dışarıdan erişimi çağrılmayı sağlıyor.
 */

/**
 *      JAVA'da SİNGLETON Pattern Kullanımı ;
 *
 *      1- Dışarıdan erişim için class ya Abstract yapılacak yada constructorlarını hiç constructor'ı yoksa
 *      Default constructor(Parametresiz constructorı) PRİVATE olacak.
 *      2-Bu class'ın nesnesini private static olarak yapıp, instance oluştur
 *      3-Bu private static instance'ı geri dönen public static olan GET metodunu yazıyoruz
 *
 *      Çağırırken ;
 *      class'ın ismi . metodun ismi() . static olmayan değişkenini yazarak değer atayabilir yada değer okuyabiliriz.
 *      --->  SingletonJava.getNewInstance().color = "red";
 *
 *      - Uygulamayı oluştururken; tüm uygulama kullanım süresince olması gereken nesnelerde ihtiyaç duyarız
 *      Singleton pattern'i kullanmaya
 */

/* NOT : Bir objeyi veya değişkeni static yaparsak Garbage collect,on silme işlemini otomatik olrak yapmaz artık.
Uygulama çalıştığı sürece oluşan değişken, fonksiyon çalışır ve bu da RAM' de gereksiz yer kaplar.*/

class SingletonJava {
    /* Java'da değişkene aynı anda bir kişi ulaşsın dersek; birden fazla yapı oluşmasın istiyorsak SYNCHONİZED ve VOLATİLE
     * yapısını kullanmalıyız.*/
    /**
     *  SYNCHRONİZED --> Yazılan alana aynı anda sadece 1 treed'in girişine izin veriyor.
     *
     *  VOLATİLE --> Multithreading için kullanılır. Aynı anda 1 kişinin değişim yapmasına izin veriyor metodumuz üzerinde.
     *
     *  MULTİTHREAD --> Birden fazla kişinin aynı işe gitmesine denir.
     *
     *  outoff memory -> Memory demek, memorylink.
     */

    /* NOT : Class'ta STATİC kullanırsak eğer;
Singleton pattern'i yanlış kullanırsak ANTİPATTERN yapmış oluruz. (Memory'de silemediğimiz bir alan oluşturur bize).  */

    /* TÜYO : Singleton Pattern ; uygulama içerisinde heryerde kullanmamız gereken sürekli açık olması gereken bir nesne
     * kullanıyorsak SİNGLETON olarak bu nesneyi(değişkeni) tanımlayıp kullanmalıyız.*/

    @Volatile
    private static SingletonJava newInstance = null;  //1- burada null olan bir newInstance oluşturuyoruz.Private olarak
    public String color = "";

    // Bir class'tan içerde tek birkez instance almak istersek, dışardan erişilmesin istersek class'ın contructorlarını
    // Private yapmamız yeterlidir. class'ı abstract yapmaya geek yok çünkü abstract yaparken hiç instance oluşturulmaz
    private SingletonJava() {

    }

    @Synchronized
    //2- sonra burada null ise newInstance yeni instance oluşturacak ve onu getirecek.Burada böyle bir obje varsa
    // yeniden oluşturma deniyor. (Instance kontrolü yapıldı burada)
    public static SingletonJava getNewInstance() {

        if (newInstance == null) {
            newInstance = new SingletonJava();
        }

        return newInstance;
    }

    //--------------------------------------------------------------------------------------------------------------------//
    public void getMemoryObject() {
        for (int i = 0; i < 1000000; i++) {
            int number = i;
            int number2 = i + 1;
            int number3 = i + 1;
            int number4 = i + 1;
            int number5 = i + 1;
        }
    }
}
