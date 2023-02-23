
@test
Feature: US ISMI

  Background: arama yapilincaya kadar olusan islemler
    Given Kullanici google sayfasina gider
   # Then  Kullanici cookies i kabul eder

  Scenario: Test Case

    Then  Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
    Then  Para birimlerinin karsilastirmasini alir
    And   Verilen degerlerin iki den kucuk oldugunu dogrular
    And   Kullanici sayfayi kapatir

  Scenario: Test Case

    Then  Arama Kutusuna Dollar to Euro karsilastirma yapmak istedigi para birimlerini girer
    Then  Para birimlerinin karsilastirmasini alir
    And   Verilen degerlerin iki den kucuk oldugunu dogrular
    And   Kullanici sayfayi kapatir