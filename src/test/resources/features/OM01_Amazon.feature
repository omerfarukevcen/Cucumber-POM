Feature: Amazon ürün arama
  Amazon üzerinde 10 farklı ürün arayarak doğru sonuçların geldiğini doğrular.


  Scenario Outline: Farklı ürünlerin aranması
    Given Kullanıcı Amazon ana sayfasında
    When Kullanıcı arama çubuğuna "<aranacak_urun>" yazar ve arama yapar
    And Kullanıcı 2 saniye bekler
    Then Arama sonuçları "<aranan_urun>" kelimesini içermelidir
    And Kullanıcı 2 saniye bekler
    And Kullanıcı ilk ürünü sepete ekler
    And Kullanıcı 2 saniye bekler
    Then Kullanıcı ürünün sepete eklendiğini kontrol eder
    And Kullanıcı 3 saniye bekler
    And Kullanıcı sayfayı kapatır

    Examples:
      | aranacak_urun | aranan_urun  |
      | telefon       | telefo       |
      | laptop        | laptop       |
      | kulaklık      | kulaklık     |
      | fön makinesi  | fön makinesi |
      | hoparlör      | hoparlör     |
      | buzdolabı     | buzdolabı    |
      | televizyon    | televizyon   |
      | kamera        | kamera       |
