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

## Used tools
1. java 20.0.2 2023-07-18
2. Google chrome Version 115.0.5790.102 (Official Build) (arm64)
3. Intellij IDEA CE
