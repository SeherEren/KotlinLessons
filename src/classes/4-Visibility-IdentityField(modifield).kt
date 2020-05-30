package classes

/**
private, public ,internal

PUBLİC --> Bu class'lar heryerden görünüyor erişilebiliyor
PRİVATE --> Bu class'ın  modül farketmeksizin heryere kapalıdır. Sadece aynı dosya içerisindekiler erişilebilir.
İNTERNAL --> Bulundukları package (modül) içerisinde görünebiliyor oluyor, dışarıdan erişime kapalı oluyor.
PROTECTED --> Classımız extend edilebilir bir class ise sadece extend edilen class'larda görülebilir olmasını sağlar. ( İlgili değişkenlere Chield classtan görünürler )

JAVA
- Default olarak önüne birsey belirtmezsek PRİVATE'dir
- Java'da TabLevel tanımlamalar; private, protected, public' dir.(toplevel class'ın yanına gelen identityfieldiler)
-


KOTLİN
- Class'ların default değeri PUBLİC'tir.
- tab level tanımlamalar ; public , private, internal kodlinde .
- 4 tane Identityfield vardır. ama protected toplevel'da kullanılmaz. PROTECTED extend edilen yerlerde kullanılır.

-Protected ; class içindeki değişkene, constructor'a protected verilir ama class'a verilmez.

open class Daire protected constructor(override val shape : String ) : Shape() {
protected val number : Int = 3

 */


/**
 *      NOT :
 *      Class PRİVATE iken aynı dosya içerisinde farklı bir class'ta instance yaratmaya izin veriliyor.
 *       extend edilen class private ise extend etmeye izin verilmez
 *      Yalnız instance'ın kendisi de PRİVATE olması geerekiyor...
 *      aynı dosyada olmak şartıyla, main içinde public nesne olusturmaya izin veriliyor.
 */


/**
class'ın önündeki visibility ile constructor onündeki visibility aynı değildir.
class'ın instance'ı alınmasını istemezsek constructor'ını private yapmamız lazım. class'ı da private yapsak instance alınmaz
ama doğru yöntem diğeridir.
 */