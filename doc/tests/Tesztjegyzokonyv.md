# Tesztjegyzőkönyv

## 1. Teszteljárások (TP)

### 1.1. Weblap megjelenítése funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Weblap megjelenítése funkció tesztelése
    0. Nyissuk meg a böngészot
    1. lépés: Nyissuk meg az alkalmazást a fooldalra
    2. lépés: Ellenorizzuk. Elvárt eredmény: A fooldalt kéne látnunk.

### 1.2. Belépés funkció tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: belépés funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, és navigáljunk el a belépés felülétre
    1. lépés: Az `E-mail` szövegbeviteli mezőbe írjunk be az `e-mail cimet`
    2. lépés: A `Password` szövegbeviteli mezőbe írjunk be a `jelszot`
    2. lépés: Nyomjuk meg a `Login` gombot 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: A felhasznalo sajat fooldalanak megjelenítése

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

### 2.2. Belépés funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: belépés funkció tesztelése
- Bemenet: `E-mail` = testuser@testing.com  `Password` = titkosjelszososemtudodmeg
- Művelet: nyomjuk meg az `Login` gombot 
- Elvárt kimenet: A felhasznalo sajat fooldalanak megjelenítése

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: belépés funkció tesztelése
- Bemenet: `E-mail` = testuser@testing.com  `Password` = wrong_pasword 
- Művelet: nyomjuk meg az `Login` gombot 
- Elvárt kimenet: A hiba oldal megjelentítése

#### 2.2.3. TC-03
- TP: TP-02
- Leírás: belépés funkció tesztelése
- Bemenet: `E-mail` = notauser@notexistantmailserver.com  `Password` = titkosjelszososemtudodmeg
- Művelet: nyomjuk meg az `Login` gombot 
- Elvárt kimenet: A hiba oldal megjelentítése

## 3. Tesztriportok (TR)

### 3.1. Weblap megjelenítése funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    0. lépés: localhost:8080-at beírtam
    1. lépés: helyes eredményt kaptam (a fooldal)
    
#### 3.1.2. TR-01 (TC-02)
- TP: TP-01
    0. lépés: localhost:8080/nemletezooldal-t beírtam
    1. lépés: helyes eredményt kaptam (hiba oldal)

### 3.2. Belépés funkció tesztriportjai 

#### 3.2.1. TR-02 (TC-01)
- TP: TP-02
    1. lépés: testuser@testing.com-t beírtam
    2. lépés: titkosjelszososemtudodmeg-t beírtam 
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (a felhasznalo fooldala)

#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: testuser@testing.com-t beírtam
    2. lépés: wrong_password-t beírtam 
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (hiba oldal)
    
#### 3.2.3. TR-02 (TC-03)
- TP: TP-02
    1. lépés: notauser@notexistantmailserver.com-t beírtam
    2. lépés: titkosjelszososemtudodmeg-t beírtam 
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (hiba oldal)
