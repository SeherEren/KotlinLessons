package basictypes

fun main() {

    /**
     *      if else case'lerinden sonra suslu parantez acilir ve kapanir.
     *      Ancak bu suslu parantezler arasina tek satir kod yazacaksak, suslu parantez kullanmak zorunda degiliz.
     *      If - else case'lerinin state ve expression olmak uzere 2 kullanimi vardir. Basitce;
     *      State kullanimi sadece if else kullanarak sartli durumlarimizi kodlamaktir.
     *      Expression kullanimi ise bir value'ya deger olarak esitligin karsi tarafina if else kodlarini yazmaktir.
     *      Expression olarak yapilan kullanimda, if else case'leri icin yazilmis parantezlerin son satiri value olarak atanir.
     *      Expression kullanımında else değeri yazmamız gerekiyor değişkene değer atandığından dolayı. State kullanımında yazmaya gerek yoktur.
     * **/

    /** KOTLİN'de Ternary Operatörü kullanımı yoktur.
     * Zaten kotlinde EXPRESSİON'dır.
     * Yani if' ler değişken içine atılarak expression operatörlerde kullanılıyor ve varsayılan olarak var olduğundan dolayı*/

    print("Öğrenci misin?")
    val answer = readLine()!!

    //Add State kullanimi
    if (answer.contains("Evet", ignoreCase = true)) {
        println("Öğrenci")
    } else {
        println("Öğrenci değil")
    }

    // expression kullanimi. {} icerisindeki son satir, deger olarak degiskene atanir.
    val result: String = if (answer == "Evet") {
        "Öğrenci"
    } else {
        "Öğrenci Değil"
    }
    println(result)


    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Kotlin'de if else'lerin Expression kullanimindan oturu ternary operatoru yoktur.
     *      Ternary yerine asagidaki gibi kullanim yapabilirsiniz.
     * **/

    val isStudent = false
    val name = if (isStudent) "true" else "false"
    // String name2 = isStudent ? "true" : "false" ternary operator java'daki

    println("Notunuzu Giriniz : ")
    val grade = readLine()!!.toDouble()

    if (grade <= 100 && grade >= 85) {
        println("AA")
    } else if (grade < 85 && grade >= 70) {
        println("BB")
    } else if (grade < 70 && grade >= 55) {
        println("CC")
    } else if (grade < 55 && grade >= 40) {
        println("DD")
    } else {
        print("Sen okulu birak :)")
    }

    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      2 farkli tipteki number degiskenler karsilastirilirken equals fonksiyonu once tiplerini karsilastirdigi icin
     *      eger tipler uyusmuyorsa, ide hata verecektir. Implecity type conversion olmadığından dolayı kotlinde.
     * **/
//    if(10 == 10L){    // Calismaz.İnt ve Long ifade karşılaştırmalar yapılırken karşılaştırılmaz.
//
//    }

    // Bunun yerine bu şekilde kullanabiliriz.
    if (10 == 10L.toInt()) {
        println("true")
    }

    if (10.toLong() == 10L) {
        println("true")
    }

    // Expression vs. statement
    val number = if (isStudent) {
        println("true")
        43
    } else {
        23
    }
    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Birden fazla sartli durumunuz varsa bunlarin her birini, asagidaki gibi, ayri ayri if seklinde yazmak
     *      if else seklinde yazmaktan daha kotu performans almaniza yol acar. Zira if else durumlarinda dogru case
     *      bulunursa, diger case'ler kontrol edilmez. Ancak asagidaki durumda dogru case bulunsa bile tum case'ler
     *      kontrol edilir.
     * **/

    if (grade <= 100) {

    }

    if (grade >= 85) {

    }

    if (grade <= 84) {

    }

    if (grade >= 70) {

    }

    if (grade <= 69) {

    }

    if (grade >= 55) {

    }


    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Bazi durumlarda if else yazmaktansa, if case'ini yazip return ya da throw gibi kodun devam etmesini bozacak
     *      ifadelerle kodu sonlandirabilirsiniz. Kod calisirken bu if case'ine girmezse devam eden kod blogu calisir ki
     *      bu da pratikte else case'i demek olur. Bu sekilde yazim kodu biraz daha temiz gosterecektir.
     * **/

    /** Alttaki if döngüsü ile aynı koddur. Fakat 2. if tercih edilir yazım olarak. Burada if sartı sağlansa bile
     * döngü dewam eder ve "otherMethod" un içerisine de girer fakat 2. de girmez metoda **/
    if (isStudent) {
        println("Student")
    } else {
        otherMethod()
    }

    /** Clean code yazarken bu şekilde kod yazılır. Çünkü if şartı sağlanınca return edip decam etmeyecek kod
    "OtherMethod" a hiç girmeyecek
     **/
    if (isStudent) {
        println("Student")
        return
    }

    otherMethod()
}

private fun otherMethod() {

}