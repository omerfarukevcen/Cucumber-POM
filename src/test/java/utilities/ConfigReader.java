package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties; /*Java’nın java.util paketinden gelen bir sınıftır ve .properties dosyalarıyla
                                           çalışmak için kullanılır. */

    static {
        String path = "configuration.properties"; //.properties dosyasının bulunduğu dosya yoludur.
        try {
            FileInputStream fis = new FileInputStream(path); //Belirtilen dosya yolundan verileri okumak için kullanılır.
            properties = new Properties(); //Boş bir Properties nesnesi oluşturur.
            properties.load(fis);
            //FileInputStream üzerinden okunan dosyadaki anahtar-değer çiftlerini Properties nesnesine yükler.

        }catch (IOException e) {
            throw new RuntimeException(e);/*Eğer dosya okunamazsa veya başka bir hata oluşursa, bu hata bir
                                            RuntimeException ile fırlatılır. Bu, hatanın programın akışını kesmesini
                                            sağlar ve kullanıcıya hatanın ne olduğunu bildirir.*/
        }

    }
    public static String getProperty (String key){
        return  properties.getProperty(key);
    }
}
