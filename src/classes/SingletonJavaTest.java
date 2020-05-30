package classes;

public class SingletonJavaTest {

    public static void main(String[] args) {

        SingletonJava.getNewInstance().color = "blue";
        System.out.println(SingletonJava.getNewInstance().color);

        SingletonJava.getNewInstance().color = "red";
        System.out.println(SingletonJava.getNewInstance().color);

        SingletonJava.getNewInstance().getMemoryObject();

        Photo photo = new Photo();

        photo.printAll();

        /*  COMPANİON OBJECT'i javadan çağırma şekilleri ;    */

        Photo.Companion.getBASE_URL();
        Photo.Companion.getBASE_URL2();   // companion objeyi javada çağırırken böyle çağırıyoruz.
        Photo.getBASE_URL2();  /*burada companion objedeki base_url 'e JVMSTATİC kullandığımız için companion objenin
        ismini yazmadan çağırabiliyoruz */
    }
}
