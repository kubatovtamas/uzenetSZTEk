# üzeneteSZTEk Projektterv 2020

## 1. Összefoglaló 
A megrendelő, Márkus András, gyakran fejezte ki aggódalmát, hogy a jelenlegi közösségi médiák tele vannak fölösleges részletekkel,
így a diákok képtelenek az anyagra koncentrálni anélkül, hogy közben egy-egy hírfolyamot böngésszenek vagy nyereményjátékokon vegyenek részt. Az üzeneteSZTEk webalkalmazás egy letisztult közösségi felületet nyújt a Szegedi Tudományegyetem hallgatói számára. A termék fő célja, hogy biztosítsa
a tanulók közötti információmegosztáshoz szükséges legfontosabb funkciókat, illetve hogy minden felesleges,
figyelemelterelő funkcionalitás terhe alól mentesítse a felhanszálóbázisát. Az alkalmazás lehetővé teszi a diákok számára személyes adataik kezelését,
tanulótársak felkutatását, illetve az így létrehozott tanulmányi kapcsolatok megerősítését a közös projektekhez szükséges legfontosabb eszköz biztosításával,
ami a hatékony információáramlás, azaz a kommunikáció.

## 2. Verziók
|   Verzió | Szerző(k)                                        |          Dátum | Státusz           | Megjegyzés                                            |
| :------: | :----------------------------------------------: | :------------: | :---------------: | :---------------------------------------------------: |
|      0.1 | Mindenki                                         |     2020-10-01 | Tervezet          | Projektterv elkészítés, munkafelosztás                |
|      0.2 | Mindenki                                         |     2020-10-03 | Előterjesztés     | Projektterv letisztítás, környezet kialakítása        |
|      1.0 | Kanyó József                                     |     2020-10-05 | Elfogadott        | Apróbb átszervezések                                  |
|----------|--------------------------------------------------|----------------|-------------------|-------------------------------------------------------|
|      1.1 | Kubatov Tamás, Pusztai Ágnes Anna                |     2020-10-10 | Tervezet          | UML és adatbázis tervek                               |
|      1.2 | Kubatov Tamás, Pusztai Ágnes Anna, Madarász Máté |     2020-10-15 | Előterjesztés     | Szükséges módosítások                                 |
|      2.0 | Madarász Máté, Kanyó József                      |     2020-10-19 | Elfogadott        | Módosított változat véglegesítése                     |
|----------|--------------------------------------------------|----------------|-------------------|-------------------------------------------------------|
|      2.1 | Kurai István, Zombori Tamás                      |     2020-11-25 | Tervezet          | Prototípus                                            |
|      2.2 | Madarász Máté, Kurai István                      |     2020-11-30 | Előterjesztés     | Módosítások                                           |
|      3.0 | Kanyó József, Zombori Tamás                      |     2020-11-02 | Elfogadott        | Módosított változat véglegesítése                     |
|----------|--------------------------------------------------|----------------|-------------------|-------------------------------------------------------|
|      3.1 | Zombori Tamás, Pusztai Ágnes Anna, Kurai István  |     2020-11-10 | Tervezet          | Végleges program, dokumentáció, új funkciók           |
|      3.2 | Madarász Máté, Kubatov Tamás                     |     2020-11-27 | Előterjesztés     | Szükséges módosítások                                 |
|      4.0 | Mindenki                                         |     2020-11-30 | Elfogadott        | Módosított változat véglegesítése                     |

Státusz osztályozás:
 - Tervezet: befejezetlen dokumentum
 - Előterjesztés: a projekt menedzser bírálatával
 - Elfogadott: a megrendelő által elfogadva

## 3. A projekt bemutatása
Ez a projektterv az üzeneteSZTEk projektet mutatja be, mely 2020-09-24-től 2020-11-30-ig tart. A projekt célja, hogy a felhasználók könnyedén meg tudjanak osztani oktatással kapcsolatos információkat,  segítséget tudjanak nyújtani és kérni az egyetemi kurzusokhoz, ezen felül szociális platformot nyújt a regisztrált tagoknak.

A csapat 6 főből áll, a projekt 4 mérföldköves átadási struktúrában lesz megvalósítva.

### 3.1. Rendszerspecifikáció
A megrendelő kérései hogy kiszolgálja a felhasználók igényeit, illetve biztonságos felületet nyújtson az információk megosztására. A megvalósításhoz az alábbi felületeket szükséges létrehozni:

- Egy regisztrációs, illetve bejelentkezési felület
    - Átlátható, letisztult, felhasználóbarát
    - Biztonságos regisztráció és beléptetés, e-mailes visszaigazolási rendszerrel, jelszó visszaállítással
- Egy felület a belépett felhasználók beállításainak
    - Személyes adatok megadása
    - Megosztani kívánt adatok beállítása
    - Profilkép és becenév beállítása
- Egy felület ahol a felhasználók a különböző fórumokat olvashatnak, azokra feliratkozhatnak, hozzászólhatnak
    - A feliratkozott fórumok áttekintése
    - Hozzászólások írása
    - Hozzászólások értékelése (reakciók)
- Egy profil felület, ahol más felhasználók ismerősnek jelölhetnek, illetve a megosztani kívánt adatait, fényképeit elérhetik a felhasználónak
    - Ismerősnek jelölés
    - Adatok megtekintése
    - Privát üzenet írása
- Admin felület, ahol hozzáadni, módosítani, törölni lehet fórumokat, azokhoz érkezett hozzászólásokat moderálni.

Összességében egy olyan grafikus rendszer megvalósítása a feladat, hol egy egyszerű felületen, könnyedén tud különböző témákról olvasni, azokhoz hozzászólni egy felhasználó, illetve lehetőséget nyújt a felhasználóknak egymással való ismerettségek kialakítására.

### 3.2. Funkcionális követelmények
- A megrendelő részéről:
    - Adminisztrációs felület megvalósítása
    - A fórum moderációs funkciók megvalósítása

- A felhasználói részről:
    - Fórumok követése
    - Hozzászólások írása, azoknak a módosítása, törlése
    - Más felhasználók ismerősnek jelölése
    - Privát üzenetváltás más felhasználókkal
    - Képek feltöltése a profilra, illetve a választott fórumokra poszt formájában

### 3.3. Nem funkcionális követelmények
Online felületen fusson teljesen a szoftver, böngészőn kívül más programra ne legyen szükség a használatához. Legyen biztonságos a felhasználó kezelés. Mobilon és asztali környezetben is jól használható, letisztult kinézete legyen.

## 4. Költség- és erőforrás-szükségletek
Az erőforrásigényünk összesen kb. 126 személynap.

A rendelkezésünkre áll összesen 420 pont.

## 5. Szervezeti felépítés és felelősségmegosztás
A projekt megrendelője Márkus András. A üzeneteSZTEk projektet a projektcsapat fogja végrehajtani, amely tagjainak nevét, illetve szakmai tapasztalatait a következő felsorolás ismerteti:

- Pusztai Ágnes Anna --> backend, adatbázis, UML diagramok, JUnit
- Kubatov Tamás --> backend, adatbázis, UML diagramok, Vue.js
- Kurai István --> Java, C#, frontend, design
- Madarász Máté --> Java, JavaFx, C#, Spring, backend, adatbázis
- Zombori Tamás -> Java, backend, frontend, prezentáció
- Kanyó József --> dokumentáció, SASS, Flexbox

### 5.1 Projektcsapat
A projekt a következő emberekből áll:


|                                            |        Név        |  E-mail cím (stud-os) |
|:------------------------------------------:|:-----------------:|:---------------------:|
|                  Megrendelő                | Márkus András     |markusa@inf.u-szeged.hu|
|               Projekt menedzser            |  Madarász Máté    |h984188@stud.u-szeged.hu|
| Adatbázisért és adatkapcsolatokért felelős |  Kubatov Tamás    |h665398@stud.u-szeged.hu|
|      Felhasználói felületekért felelős     |  Kurai István     |h983940@stud.u-szeged.hu|
|   A rendszer működési logikájáért felelős  |Pusztai Ágnes Anna |h984944@stud.u-szeged.hu|
|           Dokumentációért felelős          |  Zombori Tamás    |h986217@stud.u-szeged.hu|
|           Prezentációért felelős           |  Kanyó József     |h658542@stud.u-szeged.hu|

## 6. A munka feltételei
### 6.1. Munkakörnyezet
A projekt a következő munkaállomásokat fogja használni a munka során:
 - Pusztai Ágnes anna: Lenovo ThinkPad x230 CPU: Dual Core Intel Core i5-3320M (-MT MCP-) speed/min/max: 1269/1200/3300 MHz Kernel: 5.8.6-1-MANJARO x86_64 Mem: 7778.6 MiB Storage: 352.14 GiB (SSD)
 - Kubatov Tamás: Lenovo Legion 5 OS: Manjaro Linux / Windows 10 Home Resolution 1920x1080 CPU: AMD Ryzen 7 4800H GPU: NVIDIA GeForce GTX 1650Ti Mobile Memory: 8GB 
 - Kanyó József : Huawei Matebook X Pro CPU: Intel Core i7-8550U Memory: 16GB 512GB SSD GPU: Intel UHD Graphics 620 Resolution: 3000x2000 OS: Windows 10 Home
 - Kurai István : Huawei Matebook 13 CPU: 10th Generation Intel Core i5-10210U Memory: 1×8 GB DDR4 Resolution:2160 x 1440 GPU: Intel UHD Graphics 620 512GB SSD OS: Windows 10 Home
 - Zombori Tamás: PC: GPU: 1050ti  Memory: 16gb CPU: ryzen 5 2400g 256GB SSD OS: Windows 10 Pro Resolution: 1920x1080
 - Madarász Máté: CPU: Intel Core i5-5300U GPU: Mesa Intel HD Graphics 5500 128GB SSD Resolution: 1920x1080 OS: Kali Linux

### 6.2. Rizikómenedzsment
 - Rizikótényező (hatás):
- Koronavírus miatti kihagyás (valószínűsége: alacsony, hatása: kicsi, kezelése: otthoni munkavégzés lehetséges, legrosszabb esetben az adott feladatot más végzi el )
- Internetszolgáltató miatti kiesés (Valószínűsége: közepes, hatása: közepes, kezelése: többi napokon többet foglalkozik a projekttel az illető, előre megbeszélten)
- Influenza/megfázás miatti késés: (Valószínűsége: közepes, hatása: kicsi, kezelése: otthoni munkavégzés lehetséges)
- Hardver meghibásodás miatti kihagyás: (Valószínűsége: alacsony, hatása: nagy, kezelése: eloszlanak a feladatai a többi csapattag között, esetleges megoldásig)
- Családi okból eredő kiesés/késés: (Valószínűsége: közepes, hatása: kicsi, kezelése: többi napokon többet foglalkozik a projekttel az illető, előre megbeszélten)

## 7. Jelentések
### 7.1. Munka menedzsment
A munkát Kanyó József koordinálja. Ő felelős a dokumentációval és adminisztrációval kapcsolatos szervezési feladatokért, míg a Projektmenedzser: Madarász Máté a projekt megvalósításával kapcsolatos, technikai jellegű szervezési feladatokat látja el.


### 7.2. Csoportgyűlések

A csapat minden hónapban 3-4 alkalommal ülésezik. Ezeken az üléseken történik meg azon föbb problémák, öteletek és feladatok átbeszélése, melyek megoldásához az írásbeli kommunikáció nem volt elégséges eszköz.
A megbeszélésekről feljegyzés készül, melyet a megbeszélés elején kijelölt moderátor rögzít és tölt fel a projektkönyvtárba.

### 7.3. Minőségbiztosítás
Az elkészült terveket a terveken nem dolgozó csapattársak közül átnézik, hogy megfelel-e a specifikációnak és az egyes diagramtípusok összhangban vannak-e egymással. A meglévő rendszerünk helyes működését a prototípusok bemutatása előtt a tesztelési dokumentumban leírtak végrehajtása alapján ellenőrizzük és összevetjük a specifikációval, hogy az elvárt eredményt kapjuk-e. További tesztelési lehetőségek: unit tesztek írása az egyes modulokhoz vagy a kód közös átnézése (code review) egy, a vizsgált modul programozásában nem résztvevő csapattaggal. Szoftverünk minőségét a végső leadás előtt javítani kell a rendszerünkre lefuttatott kódelemzés során kapott metrikaértékek és szabálysértések figyelembevételével.
Az alábbi lehetőségek vannak a szoftver megfelelő minőségének biztosítására:
- Specifikáció és tervek átnézése (kötelező)
- Teszttervek végrehajtása (kötelező)
- Unit tesztek írása (választható)
- Kód átnézése (választható)

### 7.4. Átadás, eredmények elfogadása
A projekt eredményeit Márkus András fogja elfogadni. A projektterven változásokat csak maga Márkus András, illetve írásos kérés esetén Márkus András engedélyével lehet tenni. A projekt eredményesnek bizonyul, ha specifikáció helyes és határidőn belül készül el. Az esetleges késések pontlevonást eredményeznek.
Az elfogadás feltételeire és beadás formájára vonatkozó részletes leírás Kertész Attila fő gyakorlatvezető honlapján olvasható.

### 7.5. Státuszjelentés
Minden leadásnál a projektmenedzser jelentést tesz a projekt haladásáról, és ha szükséges változásokat indítványoz a projektterven. Ezen kívül a megrendelő felszólítására a menedzser 3 munkanapon belül köteles leadni a jelentést. A gyakorlatvezetővel folytatott csapatmegbeszéléseken a megadott sablon alapján emlékeztetőt készít a csapat, amit a következő megbeszélésen áttekintenek és felmérik az eredményeket és teendőket. Továbbá gazdálkodnak az erőforrásokkal és szükség esetén a megrendelővel egyeztetnek a projektterv módosításáról.

## 8. A munka tartalma
### 8.1. Tervezett szoftverfolyamat modell és architektúra
Inkrementális modellt követve fogjuk előállítani a prototípust és a végterméket. Azért ezt választottuk, mert így a főbb funkciókra tudunk fókuszálni, és időben elkészíteni egy működő prototípust. Mivel inkremensekre lesznek bontva egyes részek, így azok magukban is működőképesek lesznek. 

Architektúrának webes applikációt választottunk, Spring Boot,Java, MySQL, JavaScript, HTML, CSS nyelveket szeretnénk alkalmazni a megvalósításához. A programban fontos szerepet játszanak majd a:
-adatbázistáblák
-grafikus felület
-logikai kapcsolat

### 8.2. Átadandók és határidők
A főbb átadandók és határidők a projekt időtartama alatt a következők:


| Szállítandó |                 Neve                |   Határideje  |
|:-----------:|:-----------------------------------:|:-------------:|
|      D1     |       Projektterv és útmutató       |  2020-10-05   |
|      D2     | UML és adatbázis tervek és bemutató |  2020-10-19   |
|    P1+D3    |      Prototípus I. és bemutató      |  2020-11-02   |
|    P2+D4    |      Prototípus Ii. és bemutató     |  2020-11-30   |

## 9. Feladatlista

Az üzeneteSZTEk projekt 2020. szeptember 24-én indult. A következőkben a tervezett feladatok részletes összefoglalása található:

### 9.1. Projektterv (1. mérföldkő)
Ennek a feladatnak az a célja, hogy elkészítsük a projekttervet, mely a szoftverfejlesztési modellel együtt a alkalmazás elkészítésének alapkövét jelenti.

Részfeladatai a következők:

#### 9.1.1. Projektterv kitöltése

Felelős: Mindenki

Tartam:  7 nap

Erőforrásigény:  6 személynap


#### 9.1.2. Bemutató elkészítése

Felelős: Zombori Tamás

Tartam:  3 nap

Erőforrásigény:  1 személynap

### 9.2. UML és adatbázis tervek (2. mérföldkő)
Ennek a feladatnak az a célja, hogy elkészítsük a fejlesztési folyamathoz, illetve a követelmények validálásához szükséges diagramokat

Részfeladatai a következők:

#### 9.2.1. Use Case diagram

Felelős: Pusztai Ágnes Anna, Zombori Tamás

Tartam:  3 nap

Erőforrásigény:  4 személynap

#### 9.2.2. Class diagram

Felelős: Madarász Máté, Kanyó József

Tartam:  4 nap

Erőforrásigény:  5 személynap

#### 9.2.3. Sequence diagram

Felelős: Madarász Máté, Kanyó József

Tartam:  4 nap

Erőforrásigény:  5 személynap

#### 9.2.4. Egyed-kapcsolat diagram adatbázishoz

Felelős: Kubatov Tamás, Zombori Tamás, Pusztai Ágnes Anna

Tartam:  5 nap

Erőforrásigény:  8 személynap

#### 9.2.5. Package diagram

Felelős: Madarász Máté, Kubatov Tamás, Kanyó József

Tartam:  5 nap

Erőforrásigény:  3 személynap

#### 9.2.6. Képernyőtervek

Felelős: Kurai István

Tartam:  7 nap

Erőforrásigény:  6 személynap

#### 9.2.7. Bemutató elkészítése

Felelős: Pusztai Ágnes Anna, Zombori Tamás

Tartam:  2 nap

Erőforrásigény:  4 személynap

### 9.3. Prototípus I. (3. mérföldkő)
Ennek a feladatnak az a célja, hogy elkészítsünk egy működőképes rendszert, mely biztosítja majd a lehetőséget arra, hogy a 4. mérföldkő során optimalizáljuk az alkalamzás működésést.

Részfeladatai a következők:

#### 9.3.1.  Statikus weblapok elkészítése (frontend)

Felelős: Kurai István, Kanyó József, Zombori Tamás

Tartam:  7 nap

Erőforrásigény:  7 személynap

#### 9.3.2.  Üzleti logika kifejlesztése (backend)

Felelős: Pusztai Ágnes Anna, Madarász Máté, Kurai István

Tartam:  5 nap

Erőforrásigény:  5 személynap

#### 9.3.3.  Adatbázis felállítása, feltötlése adatokkal

Felelős: Madarász Máté, Kubatov Tamás, Kanyó József

Tartam:  7 nap

Erőforrásigény:  7 személynap

#### 9.3.4. Tesztelési dokumentum

Felelős: Pusztai Ágnes Anna, Zombori Tamás

Tartam:  5 nap

Erőforrásigény:  3 személynap

#### 9.3.5. Bemutató elkészítése 

Felelős: Kubatov Tamás

Tartam:  2 nap

Erőforrásigény:  2 személynap

### 9.4. Prototípus II. (4. mérföldkő)
Ennek a feladatnak az a célja, hogy kifejlesszük a végső terméket, és azt az összes dokumentációval együtt képesek legyünk átadni a mgerendelőnek.

Részfeladatai a következők:

#### 9.4.1. Dokumentációk, tervek az új funkciókhoz

Felelős: Kanyó József, Kurai István, Kubatov Tamás

Tartam:  7 nap

Erőforrásigény:  15 személynap

#### 9.4.2. Javított minőségű prototípus új funkciókkal

Felelős: Mindenki

Tartam:  18 nap

Erőforrásigény:  28 személynap

#### 9.4.3. Tesztelési dokumentum az új funkciókhoz

Felelős: Mindenki

Tartam:  18 nap

Erőforrásigény:  12 személynap

#### 9.4.4. Bemutató elkészítése 

Felelős: Madarász Máté

Tartam:  3 nap

Erőforrásigény:  5 személynap



## 10. Részletes időbeosztás
![Gantt Diagram][Gantt]

[Gantt]: ./diagrams/Gantt/Gantt_kep.png "Gantt Diagram"

## 11. Projekt költségvetés

### 11.1. Részletes erőforrásigény (személynap)

|                     Név                    | 1. leadás - Projektterv | 2. leadás - UML és adatbázis | 3. leadás - Prototípus I. | 4. leadás - Prototípus II. | Összesen |
|:------------------------------------------:|:----------------------:|:--------------------------:|:-----------------------:|:------------------------:|:---------:|
|                     Kanyó József           |           2            |             5              |           4             |            10            |    21     |
|                     Kubatov Tamás          |           1            |             4              |           5             |            11            |    21     |
|                     Kurai István           |           1            |             6              |           3             |            11            |    21     |
|                     Madarász Máté          |           1            |             7              |           3             |            10            |    21     |
|                     Pusztai Ágnes Anna     |           1            |             7              |           4             |            9             |    21     |
|                     Zombori Tamás          |           1            |             6              |           5             |            9             |    21     |

### 11.2. Részletes feladatszámok

|                     Név                    | 1. leadás - Projektterv | 2. leadás - UML és adatbázis | 3. leadás - Prototípus I. | 4. leadás - Prototípus II. | Összesen |
|:------------------------------------------:|:----------------------:|:--------------------------:|:-----------------------:|:------------------------:|:---------:|
|                     Kanyó József           |           1            |             3              |           2             |            3             |    9      |
|                     Kubatov Tamás          |           1            |             2              |           2             |            3             |    8      |
|                     Kurai István           |           1            |             1              |           2             |            3             |    7      |
|                     Madarász Máté          |           1            |             3              |           2             |            3             |    9      |
|                     Pusztai Ágnes Anna     |           1            |             3              |           2             |            2             |    8      |
|                     Zombori Tamás          |           1            |             3              |           2             |            2             |    8      |

### 11.3. Részletes költségvetés

|                     Név                    | 1. leadás - Projektterv | 2. leadás - UML és adatbázis | 3. leadás - Prototípus I. | 4. leadás - Prototípus II. | Összesen |
|:------------------------------------------:|:----------------------:|:--------------------------:|:-----------------------:|:------------------------:|:---------:|
|    Maximálisan pontszám %-ban              |         10% (7)        |           30% (21)         |         40% (28)        |            30% (21)      | 100% (70) |
|                     Kanyó József           |           7            |             18             |           26            |            19            |     70    |
|                     Kubatov Tamás          |           4            |             17             |           28            |            21            |     70    |
|                     Kurai István           |           5            |             19             |           25            |            21            |     70    |
|                     Madarász Máté          |           4            |             21             |           24            |            21            |     70    |
|                     Pusztai Ágnes Anna     |           4            |             21             |           26            |            19            |     70    |
|                     Zombori Tamás          |           4            |             19             |           28            |            19            |     70    |

### 11.4. Átvétel
A projektet a megrendelő a következő eredménnyel vette át:

|                     Név                    | 1. leadás - Projektterv | 2. leadás - UML és adatbázis | 3. leadás - Prototípus I. | 4. leadás - Prototípus II. | Összesen |
|:------------------------------------------:|:----------------------:|:--------------------------:|:-----------------------:|:------------------------:|:------:|
|                                            |                        |                            |                         |                          |        |
|                                            |                        |                            |                         |                          |        |
|                                            |                        |                            |                         |                          |        |
|                                            |                        |                            |                         |                          |        |
|                                            |                        |                            |                         |                          |        |

Szeged, 2020-10-05.

#### &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Az átadó részéről &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Az átvevő részéről 



