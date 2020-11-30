# Tesztjegyzőkönyv

## 1. Teszteljárások (TP)

### 1.1. Weblap megjelenítése funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Weblap megjelenítése funkció tesztelése
    0. Nyissuk meg a böngészőt
    1. lépés: Nyissuk meg az alkalmazást a fooldalra
    2. lépés: Ellenorizzuk. Elvárt eredmény: A fooldalt kéne látnunk.

### 1.2. Főoldal posting button tesztelése 
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Főoldal posting button tesztelése
    0. lépés: Nyissuk meg a böngészőt
    1. lépés: Nyissuk meg az alkalmazást a főoldalra
    2. lépés: kattintsunk a Posting... gombra
    3. lépés: ellenőrizzük az eredményt. Elvárt eredmény: meg kell jelenjen a postoláshoz szükéges input, textarea, file upload és submit gomb.
    3. lépés: miután lenyílt a postoláshoz szükséges tartalom, újra kattintsunk a Posting... gombra
    4. lépés: ellenőrizzük az eredményt. Elvárt eredmény: el kell tűnjön az input, textarea, file upload és submit gomb.
            
### 1.3 Dark/White mode button tesztelése

- Azonosító: TP-03
- Tesztesetek: TC-01, TC-02, TC-03, TC-04, TC-05, TC-06, TC-06, TC-07
- Leírás: Főoldal posting button tesztelése
    0. lépés: Nyissuk meg a böngészőt
    1. lépés: Nyissuk meg az alkalmazást az egyik oldalon
    2. lépés: kattintsunk a jobb felső sarokban található képre
    3. lépés: ellenőrizzük az eredményt. Elvárt eredmény: az egész oldal át kell váltson white mode színeire.
    4. lépés: kattintsunk a jobb felső sarokban található képre
    5. lépés: ellenőrizük az eredményt. Elvárt eredmény: az oldal vissza kell álljon dark mode színeire
    6. lépés: váltsunk vagy frissítsük az oldalt 
    7. lépés: ellenőrizük az eredményt. Elvárt eredmény: a beállítasaink meg kell, hogy maradjanak, akár white akár dark modeban maradunk
   
### 1.4 Topic névre kattintva elnavigál a topicdetailsre

- Azonosító: TP-04
- Tesztesetek: TC-01
- Leírás: Topic névre kattintva navigáció tesztelése
    0. lépés: Nyissuk meg a böngészőt
    1. lépés: Nyissuk meg az alkalmazást a topic oldalon
    2. lépés: kattintsunk a topic nevére
    3. lépés: ellenőrizzük az eredményt. Elvárt eredmény:át e navigált minket a kívánt oldalra
    
## 2. Teszesetek (TC)

### 2.1. Weblap megjelenítése funkció tesztelése 

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Weblap megjelenítése funkció tesztelése
- Bemenet: `localhost:8080`
- Elvárt kimenet: A fooldalt kéne latnunk

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: Weblap megjelenítése funkció tesztelése
- Bemenet: `localhost:8080/nemletezooldal`
- Elvárt kimenet: A hiba oldal megjelenítése

### 2.2 Főoldal posting button tesztesetei

#### 2.2.1 TC-01

- TP: TP-02
- Leírás: Posting gomb tesztelése
- Művelet: nyomjuk meg a `Posting...` gombot
- Elvárt kimenet: Postolási lehetőség megjelenítése
- Művelet: nyomjuk meg a `Posting...` gombot még egyszer
- Elvárt kimenet: Postolási lehetőség eltüntetése

### 2.3 Dark/White mode button tesztesetei

#### 2.3.1 TC-01

- TP: TP-03
- Leírás: Dark/White mode tesztelése
- Művelet: Nyomjuk meg a jobb felső sarokban található gombot, ha átváltott navigáljunk el másik oldalra és ellenőrizzük hogy meg e maradt a kiválasztott mód
- Elvárt kimenet: Megmarad a kiválasztott mód és bármikor visszakapcsolhatjuk

#### 2.3.2 TC-02

- TP: TP-03
- Leírás: Dark/White mode tesztelése
- Művelet: Nyomjuk meg a jobb felső sarokban található gombot, ha átváltott navigáljunk el másik oldalra és ellenőrizzük hogy meg e maradt a kiválasztott mód
- Elvárt kimenet: Megmarad a kiválasztott mód és bármikor visszakapcsolhatjuk

#### 2.3.3 TC-03

- TP: TP-03
- Leírás: Dark/White mode tesztelése
- Művelet: Nyomjuk meg a jobb felső sarokban található gombot, ha átváltott navigáljunk el másik oldalra és ellenőrizzük hogy meg e maradt a kiválasztott mód
- Elvárt kimenet: Megmarad a kiválasztott mód és bármikor visszakapcsolhatjuk

#### 2.3.4 TC-04

- TP: TP-03
- Leírás: Dark/White mode tesztelése
- Művelet: Nyomjuk meg a jobb felső sarokban található gombot, ha átváltott navigáljunk el másik oldalra és ellenőrizzük hogy meg e maradt a kiválasztott mód
- Elvárt kimenet: Megmarad a kiválasztott mód és bármikor visszakapcsolhatjuk

#### 2.3.5 TC-05

- TP: TP-03
- Leírás: Dark/White mode tesztelése
- Művelet: Nyomjuk meg a jobb felső sarokban található gombot, ha átváltott navigáljunk el másik oldalra és ellenőrizzük hogy meg e maradt a kiválasztott mód
- Elvárt kimenet: Megmarad a kiválasztott mód és bármikor visszakapcsolhatjuk

#### 2.3.6 TC-06

- TP: TP-03
- Leírás: Dark/White mode tesztelése
- Művelet: Nyomjuk meg a jobb felső sarokban található gombot, ha átváltott navigáljunk el másik oldalra és ellenőrizzük hogy meg e maradt a kiválasztott mód
- Elvárt kimenet: Megmarad a kiválasztott mód és bármikor visszakapcsolhatjuk

#### 2.3.7 TC-07

- TP: TP-03
- Leírás: Dark/White mode tesztelése
- Művelet: Nyomjuk meg a jobb felső sarokban található gombot, ha átváltott navigáljunk el másik oldalra és ellenőrizzük hogy meg e maradt a kiválasztott mód
- Elvárt kimenet: Megmarad a kiválasztott mód és bármikor visszakapcsolhatjuk

### 2.4 Topic névre kattintva elnavigálás tesztelése

#### 2.4.1 TC-01

- TP: TP-04
- Leírás: Topic nevére kattinva elnavigálás 
- Művelet: Kattintsunk a Topic nevére
- Elvárt kimenet: Egy másik oldalra navigál minket ahol bővebb információt kapunk a topicról és postjairól

## 3. Tesztriportok (TR)

### 3.1. Weblap megjelenítése funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    0. lépés: localhost:8080-at beírtam
    1. lépés: helyes eredményt kaptam (a fooldal)
    
#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    0. lépés: localhost:8080/nemletezooldal-t beírtam
    1. lépés: helyes eredményt kaptam (hiba oldal)
    
### 3.2. Főoldal posting button tesztelés tesztriportja

#### 3.2.1 TR-01 (TC-01)

- TP: TP-02
    1. lépés: megnyitottam a főoldalt
    2. lépés: rákattintottam a `Posting...` gombra
    3. lépés: lenyílt a postolási lehetőség
    4. lépés: újra rákattintottam a `Posting...` gombra
    5. lépés: eltűnt a postolási lehetőség
    6. lépés: minden rendben működött
    
### 3.3 Dark/White mode button tesztriportja

#### 3.3.1 TR-01 (TC-01)

- TP: TP-03 
    1. lépés: megnyitom a főoldalt
    2. lépés: megnyomom a dark/white mode váltó gombját
    3. lépés: átváltott white modera
    4. lépés: elnavigálok egy másik oldalra
    5. lépés: megmaradt a kiválasztott mode
    6. lépés: minden rendben működött

#### 3.3.2 TR-02 (TC-02)

- TP: TP-03 
    1. lépés: megnyitom a profile-t
    2. lépés: megnyomom a dark/white mode váltó gombját
    3. lépés: átváltott white modera
    4. lépés: elnavigálok egy másik oldalra
    5. lépés: megmaradt a kiválasztott mode
    6. lépés: minden rendben működött

#### 3.3.3 TR-03 (TC-03)

- TP: TP-043
    1. lépés: megnyitom a topicot
    2. lépés: megnyomom a dark/white mode váltó gombját
    3. lépés: átváltott white modera
    4. lépés: elnavigálok egy másik oldalra
    5. lépés: megmaradt a kiválasztott mode
    6. lépés: minden rendben működött

#### 3.3.4 TR-04 (TC-04)

- TP: TP-03 
    1. lépés: megnyitom a topicdetailst
    2. lépés: megnyomom a dark/white mode váltó gombját
    3. lépés: átváltott white modera
    4. lépés: elnavigálok egy másik oldalra
    5. lépés: megmaradt a kiválasztott mode
    6. lépés: minden rendben működött

#### 3.3.5 TR-05 (TC-05)

- TP: TP-03 
    1. lépés: megnyitom a usert
    2. lépés: megnyomom a dark/white mode váltó gombját
    3. lépés: átváltott white modera
    4. lépés: elnavigálok egy másik oldalra
    5. lépés: megmaradt a kiválasztott mode
    6. lépés: minden rendben működött

#### 3.3.6 TR-06 (TC-06)

- TP: TP-03 
    1. lépés: megnyitom az errort
    2. lépés: megnyomom a dark/white mode váltó gombját
    3. lépés: átváltott white modera
    4. lépés: elnavigálok egy másik oldalra
    5. lépés: megmaradt a kiválasztott mode
    6. lépés: minden rendben működött

#### 3.3.7 TR-07 (TC-07)     

- TP: TP-03 
    1. lépés: megnyitom a signt
    2. lépés: megnyomom a dark/white mode váltó gombját
    3. lépés: átváltott white modera
    4. lépés: elnavigálok egy másik oldalra
    5. lépés: megmaradt a kiválasztott mode
    6. lépés: minden rendben működött
    
### Topic névre kattintva elnavigálás tesztriportja

#### 3.4.1 TR-01 (TC-01)     

- TP: TP-04 
    1. lépés: megnyitom a topic oldalt
    2. lépés: rákattintok a topic nevére
    3. lépés: elnavigál a topicdetailsre
    4. lépés: minden rendben működött