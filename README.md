# proje-yonetim-sistemi
Java spring MVC

Öncelikle bizi bir login ekranı karşılıyor kayıtlı değilsek kayıt olabilir ve giriş yapabiliriz. Şifremi unuttum ve Mail aktivasyon ise şuanlık gerçeklenmemiştir.
![login](https://user-images.githubusercontent.com/27950192/127588952-0479ff97-44f5-4367-90f1-b10761eea140.jpg)


Kayıt ol'a tıkladığımızda bizi karşılayan ekran aşağıdaki gibidir. İsterleri doldurup kayıt ola bastığımızda textboxlardaki bilgiler veritabanına kaydedilir. Görüntünün ise path değişkeni kaydedilir.

![yeniKayıt](https://user-images.githubusercontent.com/27950192/127588999-a63271b1-3129-4957-94d4-0af3084299ed.png)

Spring security ile bazı butonlara ve yan menü itemlerine erişim engellenmiştir.
Admin rolüne sahip kullanıcı ile giriş yapıldığında karşımıza çıkan ekran:

![anasayfa](https://user-images.githubusercontent.com/27950192/127589015-6bb9b7ad-eabd-4878-a3ce-9a41bdbcf136.png)


Kullanıcı rolüne sahip kullanıcı ile giriş yapıldığında karşımıza çıkan ekran:
![adminolmayan](https://user-images.githubusercontent.com/27950192/127589097-04df4084-59f8-44cf-ba05-4985dfac0e20.png)


Admin rolüne sahip kullanıcı proje,ülke ve partner için de güncelleme,silme ve ekleme işlemleri yapabilir.
![ülke](https://user-images.githubusercontent.com/27950192/127589115-b2051318-2b29-45a2-a63d-23f4647b7743.png)


![adminolmayanulke](https://user-images.githubusercontent.com/27950192/127589125-0ce73226-fae2-474c-9406-f93a2a3ded09.png)


![Partner](https://user-images.githubusercontent.com/27950192/127589195-1d4c0ec3-8190-41e6-b45d-2b68b0e38c4e.png)


![partnerguncelleme](https://user-images.githubusercontent.com/27950192/127589209-c943e0f5-9407-4232-adb1-45189db8b874.png)


![ProjeEkle](https://user-images.githubusercontent.com/27950192/127589215-405dbd34-d0a6-4008-8369-438e424e7d7d.png)

Proje detay ekranında partnerler listesinde bulunan partnerler ve ülkelerin isimleri gözükür ve proje açıklamasını görebiliriz.
![ProjeDetay](https://user-images.githubusercontent.com/27950192/127589219-a9c3315b-93b7-4687-9c10-cf5c83f8f055.png)


Admin kayıtlı kullanıcıları da görebilmektedir. Kullanıcıların rollerini değiştirebilir.
![kullanıcı](https://user-images.githubusercontent.com/27950192/127589225-38c174a2-3cc6-4354-8e9c-5f603110ecc0.png)



ER Diyagramı
![image](https://user-images.githubusercontent.com/27950192/127637362-26c265ad-e808-41a6-a83f-f1a1c0450474.png)

