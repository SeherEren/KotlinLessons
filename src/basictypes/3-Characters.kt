package basictypes

fun main() {

    /**
     *      Tek tirnaklarin arasina, harf, sayi, escape char ya da unicode yazarak kullanilir.
     *      Cift tirnak icerisine yazilirsa String olur, Char olmaz.
     * **/

    val firstCharOfName: Char = 'S'
    // val firstCharOfName :Char ="S"  // String ifadedir "" arasında olduğundan
    val charNumber: Char = '6'

    /*----------------------------------------------------------------------------------------------*/

    /**
     *      Number deger alan bir Char degisken Int'e cevirilirken, gercek sayisal degerini almaz.
     *      Alacagi deger ASCII tablosundaki o sayisal degerin karsiligi olacaktir.
     * **/
    val convertedCharNumber = charNumber.toInt()  // char ifadeyi number'a dönüştürünce ASCII kod karşılığını alır

    println("charNumber:" + charNumber)
    println("charNumber:" + convertedCharNumber)      // charNumber: 54

    val totalValue =
        charNumber.toInt() * convertedCharNumber  // Burada char ifadeyi int e çevirdik(54 oldu) ve onun karesi alındı
    println("totalValue :" + totalValue)   // totalValue: 2916


    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Kacis(Escape) karakterlerini de tanimlamak icin kullanilabilir.
     * **/

    val escapeCharT: Char = '\t' // tab birakmak icin.
    val escapeCharN: Char = '\n' // alt satir icin.
    val escapeCharB: Char = '\b' // backspace icin
    val escapeCharR: Char = '\r' // satir basi
    val escapeChar1: Char = '\'' // ' ozel karakterini kullanmak icin.
    val escapeChar2: Char = '\"' // " ozel karakterini kullanmak icin
    val escapeCharSlash: Char = '\\' // \ ozel karakterini kullanmak icin
    val escapeCharDolar: Char = '\$' // $ ozel karakterini kullanmak icin

    val loremImpsum = "Lorem ImpsumT " + escapeCharT +
            "escapeCharN  " + escapeCharN +
            "Lorem ImpsumB " + escapeCharB +
            "Lorem ImpsumR " + escapeCharR +
            "Lorem ImpsumChar1 " + escapeChar1 +
            "Lorem ImpsumChar2 " + escapeChar2 +
            "Lorem ImpsumSlash " + escapeCharSlash +
            "Lorem ImpsumDolar " + escapeCharDolar +
            "Lorem ImpsumEnd"

    println(loremImpsum)

/* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Unicode karakterlerini de tanimlamak icin kullanilabilir.
     * **/
    val uniCode = '\uFF00'

    println("uniCode" + uniCode)

}

