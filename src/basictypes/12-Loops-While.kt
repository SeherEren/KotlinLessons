package basictypes

fun main() {
    /**
     *      Degisen hic bir sey yok. Diger dillerde nasil kullaniyorsaniz Kotlin'de de ayni sekilde kullaniyoruz.
     *      Eger bir donguye ihtiyaciniz varsa ve bu dongu sirasinda if else ile bir sartli duruma ihtiyaciniz varsa
     *      bu durumda for + if else kullanmak yerine while kullanabilirsiniz.
     * **/

    var number = 0

    //Aşağıdaki alttaki for ile aynı işlemi yapıyor while

    while (number < 5) {
        println(number)
        number++
    }

    for (value in 0..6) {
        if (value < 5) {
            println(value)
        } else {
            return
        }
    }
}