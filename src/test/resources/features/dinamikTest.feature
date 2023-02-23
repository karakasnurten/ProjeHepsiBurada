
@t105
  Feature: Google Doviz Test

    Scenario Outline: test1

      Given Kullanici "url" sayfasina gider
     # Then  Kullanici cookies i kabul eder
      Then  Kullanici arama yapmak istedigi "<aranacakPara>" birimleri girer
      Then  Para birimlerinin karsilastirmasini alir
      Then  Verilen degerlerin iki den kucuk oldugunu dogrular
      And   Kullanici sayfayi kapatir

      Examples:
        | aranacakPara |
        | aranacakPara2|
        | aranacakPara3 |
        | aranacakPara4 |