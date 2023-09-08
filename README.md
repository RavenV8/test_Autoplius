# test_Autoplius

## Login function

First test checks the login to the autoplius.lt website function. It performs the following steps:

Positive test:
1. Opens the autoplius.lt website: [https://autoplius.lt/](https://autoplius.lt/)
2. Clicks the "Prisijungti" button
3. Clicks on the "TEL. NUMERIS ARBA EL. PAŠTAS" tab
4. Writes the email address: `cadxmwmyvbdfnoyepd@ckptr.com`
5. Clicks the "Tęsti" button
6. Clicks on the "Slaptažodis" tab
7. Writes the password: `Slaptazodi`
8. Clicks the "Prisijungti" button

Negative tests data:
1. {"asdafddsf@gmail.com", "Slaptazodi", "FAILED. Incorrect email."},
2. {"", "Slaptazodi", "FAILED. Incorrect email."},
3. {"cadxmwmyvbdfnoyepd@ckptr.com", "QWERT", "FAILED. Incorrect password."},
4. {"cadxmwmyvbdfnoyepd", "", "FAILED. Incorrect email."},
5. {"", "", "FAILED. Incorrect email."},

## Search function

Second test checks the search for cars option in the autoplius.lt website. It performs the following steps:

Positive test:
1. Opens the autoplius.lt website: [https://m.autoplius.lt/](https://m.autoplius.lt/)
2. Click the "Markė" bar
3. Choose brand "Audi"
4. Choose model "A4"
5. Click the "Metai" bar
6. Choose year from as "2008"
7. Choose year to as "2020"
8. Click the "Kaina" bar
9. Choose price from as "1000"
10. Choose price to as "10000"
11. Click the "Kuro tipas" bar
12. Choose checkbox "Dyzelinas"
13. Click "Pasirinkti"
14. Click the "Pavarų dėžė" bar
15. Choose transmission as "Automatinė"
16. Click the "Kėbulo tipas" bar
17. Choose checkbox "Sedanas"
18. Click "Pasirinkti"
19. Click "Ieškoti"

Tests data:
1. {"Audi", "A4", "2008", "2020", "1000", "10000", "Benzinas", "Automatinė", "Sedanas"},
2. {"Renault", "Megane", "2011", "2011", "500", "4000", "Dyzelinas", "Mechaninė", "Hečbekas"},
3. {"Mazda", "CX-5", "2016", "2023", "10000", "12000", "Benzinas", "Automatinė", "Visureigis"},
4. {"Mazda", "Visi Mazda", "", "2023", "10000", "12000", "Benzinas", "Automatinė", "Sedanas"},
5. {"BMW", "Visi BMW", "", "2023", "3000", "", "Benzinas", "Mechaninė", "Universalas"},
6. {"BMW", "Visi BMW", "", "", "3000", "", "", "", "Universalas"},
7. {"", "", "", "", "3000", "", "", "", "Universalas"},
8. {"", "", "", "", "", "", "", "", ""},

## Search function

Second test checks the search for cars option in the autoplius.lt website. It performs the following steps:

Positive test:
1. Opens the autoplius.lt website: [https://m.autoplius.lt/](https://m.autoplius.lt/)
2. Click the "Markė" bar
3. Choose brand "Audi"
4. Choose model "A4"
5. Click the "Metai" bar
6. Choose year from as "2008"
7. Choose year to as "2020"
8. Click the "Kaina" bar
9. Choose price from as "1000"
10. Choose price to as "10000"
11. Click the "Kuro tipas" bar
12. Choose checkbox "Dyzelinas"
13. Click "Pasirinkti"
14. Click the "Pavarų dėžė" bar
15. Choose transmission as "Automatinė"
16. Click the "Kėbulo tipas" bar
17. Choose checkbox "Sedanas"
18. Click "Pasirinkti"
19. Click "Ieškoti"

Tests data:
1. {"Audi", "A4", "2008", "2020", "1000", "10000", "Benzinas", "Automatinė", "Sedanas"},
2. {"Renault", "Megane", "2011", "2011", "500", "4000", "Dyzelinas", "Mechaninė", "Hečbekas"},
3. {"Mazda", "CX-5", "2016", "2023", "10000", "12000", "Benzinas", "Automatinė", "Visureigis"},
4. {"Mazda", "Visi Mazda", "", "2023", "10000", "12000", "Benzinas", "Automatinė", "Sedanas"},
5. {"BMW", "Visi BMW", "", "2023", "3000", "", "Benzinas", "Mechaninė", "Universalas"},
6. {"BMW", "Visi BMW", "", "", "3000", "", "", "", "Universalas"},
7. {"", "", "", "", "3000", "", "", "", "Universalas"},
8. {"", "", "", "", "", "", "", "", ""},

## Create sell function

Third test checks the create sell for cars function in the autoplius.lt website. It performs the following steps:

Positive test:
1. Opens the autoplius.lt website: [https://m.autoplius.lt/](https://m.autoplius.lt/)
2. Click the "Dėti skelbimą" button
3. Choose "Automobiliai"
4. Click the "Markė" button
4. Choose brand "Audi"
4. Choose model "A4"
5. Click the "Pirmos registracijos data" bar
6. Choose year as "2008"
7. Choose month as "Liepa"
8. Click the "Benzinas" on "Kuro tipas" tab
9. Click the "Sedanas" on "Kėbulo tipas" tab
10. Click the "Automatinė" on "Pavarų dėžė" tab
9. Choose "4/5" on "Durų skaičius" tab
11. Click on "Rida" bar
12. Write "100000"
13. Click on "Kaina" bar 
14. Write "5000"
13. Click on "Telefonas pasiteirauti" bar
14. Write "+37060000000"
15. Click on "Elektroninis paštas" bar
16. Write "cadxmwmyvbdfnoyepd@ckptr.com"
17. Click on "Miestas" bar
18. Choose country as "Lietuva"
19. Choose city as "Vilnius"
20. Click "Toliau"

Tests data:
1. {"Audi", "A4", "2008", "Liepa", "Benzinas", "Sedanas", "Automatinė", "4/5", "100000", "5000", "+37060000000", "cadxmwmyvbdfnoyepd@ckptr.com", "Lietuva", "Vilnius", "Audi A4, sedanas"}, 
2. {"Renault", "Megane", "2011", "Kovas", "Dyzelinas", "Visureigis", "Mechaninė", "2/3", "250", "500", "+37060000000", "cadxmwmyvbdfnoyepd@ckptr.com", "Vokietija", "Kita", "Renault Megane, visureigis"}, 
3. {"Tesla", "Model 3", "2020", "Gruodis", "Elektra", "Sedanas", "Automatinė", "4/5", "2000000", "250000", "+37060000000", "cadxmwmyvbdfnoyepd@ckptr.com", "Lietuva", "Vilnius", "Tesla Model 3, sedanas"}, 
4. {"", "", "", "", "Benzinas / dujos", "", "", "", "10000", "", "", "cadxmwmyvbdfnoyepd@ckptr.com", "", "", "Užpildėte ne visus privalomus laukus"}, 
5. {"", "", "", "", "", "", "", "", "", "", "", "cadxmwmyvbdfnoyepd@ckptr.com", "", "", "Užpildėte ne visus privalomus laukus"},

## Used tools
1. java 20.0.2 2023-07-18
2. Google chrome Version 115.0.5790.102 (Official Build) (arm64)
3. Intellij IDEA CE
