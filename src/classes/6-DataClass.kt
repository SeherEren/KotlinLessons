package classes

/**
 *   Özünde data saklamak için kullandığımız classlardır.
 *   Data classlar değişkenleri olan GETTER ve SETTER ile değişkenlerde veri taşıma işlemi yapan değişkenlerdir.
 *
 *   DATA CLASS oluşturmak için;
 *   - Class'ın başına DATA keywordü yazarız.
 *   - Class'a primary constructor oluşturmamız gerekiyor ve içerisine en az 1 tane değişken vermemiz gerekiyor.
 *   - Devamında bir PRİMARY CONSTRUCTOR oluşturur ve bu primary constructor'ın içine de "VAL" ve "VAR" keywordu
 *   ile tanımlanmış en az bir değişken vermek gerekiyor.(val ve var ile tanımlamamızın nedeni diğer yerlerden yapılacak
 *   işlemlerde erişim sağlayabilmek için)
 *
 *   bu şartların sebebi de özelleştirilmiş 4 fonksiyonu vardır.
 *   COPY, EQUALS, TOSTRİNG, HASHCODE  bu özellikler sadece primary constructorlar için çalışır.
 *
 *   Diğer bir özelliği de DESTURCTURİNG DECLARATİON özelliğidir.
 *
 */

/**
 *      COPY --> Data classlar için kullanılan özelleştirilmiş fonksiyondur. Primary constructorların içerisindeki hangi
 *      değeri değiştirirseniz, copy ettiğiniz Instance' ın birebir aynısını sadece değiştirmiş olduğunuz değerle
 *      beraber oluşturur. Bu constructor' ın dışında geri kalan instanceleri neyden copy yapıyorsak oradan kopyalar.Ama
 *      primary constructor'ın dışında class- üye değişkenleri varsa, o üye değişkenleri DEFAULT değerleri ne ise o
 *      değerleri alır.
 *
 *      TOSTRİNG --> Bir yapının class mı değil mi diye yapısını veriyor. Class ise  classes.Account  şeklinde ;
 *      class ve class adını veriyor.
 */
// DATA CLASS' lar abstract, open, sealed, inner class olamaz.
// DATA CLASS' lara Herhangi bir class miras(extend) alinabilir,ve interface implement edilebilir.
data class AccountData(
    val accountName: String = "",
    val accountSurname: String = "",
    val accountType: String = "Default Value",
    val brancName: String = "Default Value",
    val branchCode: String = "Default Value",
    val brancNumber: String = "Default Value"
) {
    fun printLog() {
        accountName
    }
}

data class AccountData2(val accountName: String) {
    var accountType = "Default Value"
    var brancName = "Default Value"
    var branchCode = "Default Value"
    var brancNumber = "Default Value"

    fun printLog() {
        accountName
    }
}

// Normal düz bir class'ta COPY metodu yoktur.
class AccountNonData(val accountName: String) {
    var accountType = "Default Value"
    var brancName = "Default Value"
    var branchCode = "Default Value"
    var brancNumber = "Default Value"


    fun printLog() {
        accountName
    }

    /* Aşağıdaki toString()nmetodunun override edilme şekli, DATA CLASS ları kullandığımız zaman
           TOSTRİNG() metodunu override etmeye  ve COPY metodu  yazmaya gerek kalmıyor... */
//    override fun toString(): String {
//        return super.toString()
//    }

//    fun copy(){
//
//    }
}

// -------------------------------------------------------------------------------------------------------------------//

fun main() {

    /* Data class oluştururken default değer ataması yaparsak JSON vs. ileride işlemler yaparken , dataclass üzerinden
        boş constructor oluşturabilmemize olanak sağlar
    */
    val emptyConstrcutorSample = AccountData()     // dataclass'tan boş constructor oluşturma

//AccountData class'tan oluşturduğumuz 1.instance
    val accountDataInstance1 = AccountData(
        "Gökhan",
        "ÖZTÜRK",
        "BankAccount",
        "Kadıköy",
        "0024",
        "325235"
    )

//AccountData class'tan oluşturduğumuz 2.instance; sadece ismi değiştirdik
    val accountDataInstance2 = AccountData(
        "Ayşe",
        "ÖZTÜRK",
        "BankAccount",
        "Kadıköy",
        "0024",
        "325235"
    )

    /** DATA CLASS'larda copy metodu ile class içerisindeki sadece bir yeri, bir değişkeni değiştirme işlemini yapabiliyoruz.
     * diğer değiişkenler  aynı şekilde kalarak bir kopyasını oluşturduk.(accountName değişti,
     * diğerlerinin accountType, branchName,branchCode,branchNumber default değerleri ile  aynı kalıyor)
     */
// instance1'in accountName ini değiştirerek copy metodu ile yazdığımız zaman instance2 ile aynı olur sadece instance1'in
// isim kısmını değiştirir diğer değişken değerleri aynı kalır.
    var copyAccountDataInstance1: AccountData = accountDataInstance1.copy("Ayşe")

/* -------------------------------------------------------------------------------------------------------------------*/

    val accountData2Instance1 = AccountData2("Gökhan")
    accountData2Instance1.accountType = "Bank Account"
    accountData2Instance1.brancName = "Kadıköy"
    accountData2Instance1.branchCode = "0024"
    accountData2Instance1.brancNumber = "325235"

    val accountData2Instance2 = AccountData2("Ayşe")
    accountData2Instance2.accountType = "Bank Account"
    accountData2Instance2.brancName = "Kadıköy"
    accountData2Instance2.branchCode = "0024"
    accountData2Instance2.brancNumber = "325235"

    var copyAccountData2Instance1: AccountData2 = accountData2Instance1.copy("Ayşe")


    val accountNonData = AccountNonData("Mehmet Emin Yılmaz")
    accountNonData.accountType = "BankAccount"
    var copyAccount2: AccountNonData

    accountDataInstance1.equals(accountDataInstance2)
    accountNonData.equals(accountNonData)

    println(accountDataInstance1.hashCode())
    println(accountNonData.hashCode())

    println(accountDataInstance1.toString())
    println(accountNonData.toString())

//--------------------------------------------------------------------------------------------------------------------//

    /**
     *   Birden fazla değişken atama işlemleri için;
     *    PAİR --> Değer , value mantığı gibi, 2 değer atama işlemlerinde kullanılır.
     *
     *    TRİPLE --> 3 tane değişkene oluşturmak için kullanılan hazır değişken ataması yapan data classtir.
     */
    val pair = Pair<String, Int>("Gökhan", 29)
    pair.first
    pair.second

    val triple = Triple<String, String, Int>("Gökhan", "ÖZTÜRK", 29)
    triple.first
    triple.second
    triple.third

// triple ve pair içerisindeki değişkenleri liste oluşturup FOR ve FOREACH içerisine alıp döngü oluşturabilir.
    val tripList = arrayOf(
        Triple("Gökhan", "ÖZTÜRK", 29),
        Triple("Gökhan", "ÖZTÜRK", 29),
        Triple("Gökhan", "ÖZTÜRK", 29),
        Triple("Gökhan", "ÖZTÜRK", 29)
    )


    tripList.forEach {
        it.first
    }

//--------------------------------------------------------------------------------------------------------------------//

    /**
     *  componentN function() , desturcturing declaration   -->  2 isimde aynı işlemi yapıyor
     *
     *  Bir fonksiyonun değerinin 2 değişkene, 3 değişkene birden atanabilir olmasında DATA class'lar içerisinde sağlarlar.
     *  Bunun en güzel örneği Koop-For da kullanırız.
     *
     *  desturcturing declaration oluştururken dikkat etmek gereken eşittiğin diğer tarafında Data class olması gerekiyor
     *  ve data class'ın constructor'ının içerisindeki değişken sayısı kadar değer alıyor
     *
     *  (accountName2, accountSurname2, accountType2, brancName2, branchCode2, brancNumber2) --> buradaki değer tipi atamaları
     *  accountData (dataclass) üzerinden gelecek.
     */
    // desturctTuring declaration value
    val (accountName2, accountSurname2, accountType2, brancName2, branchCode2, brancNumber2) = AccountData(
        "Gökhan",
        "ÖZTÜRK",
        "BankAccount",
        "Kadıköy",
        "0024",
        "325235"
    )

// bu şekilde data class içerisindeki accountName i yazdırıyoruz kullanırken
    // data class değerleri desturctturing ile bu şekilde  alıyoruz

    val (accountName, accountSurname, accountType, brancName, branchCode, brancNumber) = accountDataInstance1
//    val accountName = accountDataInstance1.accountName    --> bu üstteki tanımlama ile aynı işi yapıyor
//    val accountSurname2 = accountDataInstance1.accountSurname
//    val accountType = accountDataInstance1.accountType
    println("accountName : $accountName")
}