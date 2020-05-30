package basictypes

fun main() {
    /**
     *      3 farkli sekilde for tanimlayabilirsiniz.
     *      value in list                       seklinde value degerlerini alabilirsiniz.
     *      index in list.indices               seklinde index degerlerini alabilirsiniz.
     *      (index,value) in list.withIndex()   seklinde index,value degerlerini alabilirsiniz.
     * **/

    for (value in 1..10) {
        println("$value")
    }

    val countryCodeArray = arrayOf("tr", "az", "en", "fr")

    for (value in countryCodeArray) {
        print("$value")
    }

    for (index in countryCodeArray.indices) {
        println("\n$index . değeri : ${countryCodeArray[index]}")
    }

    //Bu yapı desturcturing declaration yapısıdır.(data class özelliği)
    for ((index, value) in countryCodeArray.withIndex()) {
        println("\n$index . değeri : $value")
    }

/* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      repeat(size) seklinde herhangi bir listeye ihtiyac duymadan tekrarlayan isler yapabilirsiniz.
     * **/

    repeat(10) {
        print("\nDaha çok blog yazmam lazım!")
    }

/* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      return kullanarak ilgili sart saglanirsa, donguden cikabilirsiniz.
     *      continue kullanarak ilgili sart saglanirsa, donguye o degeri atlayarak devam edebilirsiniz.
     * **/

    for (value in 1..50) {
        if (value % 2 == 1) {
            continue
        }
        print("\n$value")
    }


    /**
     *      Iç içe for donguleri kullaniyorsak bir ustteki for'a degil de iki ustteki uc ustteki for'a donmek istiyorsak
     *      label kullanabiliriz.bunun icin labelname@ ifadesini ilgili for'un onune yazip, return ya da continue yapacagimiz
     *      yere ise @labelname seklinde yazmamiz yeterlidir.
     * **/

    returnLabel@ for (value in 1..50) {  // returnLabel yerine farklı bir isimde verebiliriz.
        for (value2 in 0..10) {
            if (value2 == 5) {
                continue@returnLabel
            }
        }
    }
}