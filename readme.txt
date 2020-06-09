
DROP TABLE IF EXISTS CLUB;

CREATE TABLE CLUB (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    District VARCHAR(4) DEFAULT NULL,
    Division VARCHAR(2) DEFAULT NULL,
    Area VARCHAR(2) DEFAULT NULL,
    Club VARCHAR(10) DEFAULT NULL,
    Clubname VARCHAR(50) DEFAULT NULL,
    Clubest VARCHAR(11) DEFAULT NULL, //datetime
    Clubaddr1 VARCHAR(50) DEFAULT NULL,
    Clubaddr2 VARCHAR(50) DEFAULT NULL,
    Clubcity VARCHAR(20) DEFAULT NULL,
    Clubstate VARCHAR(15) DEFAULT NULL,
    Clubzip VARCHAR(10) DEFAULT NULL,
    Clubcountry VARCHAR(15) DEFAULT NULL,
    Clubphone VARCHAR(14) DEFAULT NULL,
    Clubday_o VARCHAR(14) DEFAULT NULL,
    Clubtime_o VARCHAR(14) DEFAULT NULL,
    Clubday VARCHAR(10) DEFAULT NULL,
    Clubtime VARCHAR(10) DEFAULT NULL,
    Clublen VARCHAR(4) DEFAULT NULL,
    Clubfreq VARCHAR(4) DEFAULT NULL,
    Clubopen VARCHAR(4) DEFAULT NULL,
    Cluburl1 VARCHAR(100) DEFAULT NULL,
    Cluburl2 VARCHAR(100) DEFAULT NULL,
    Clubwebstat1 VARCHAR(20) DEFAULT NULL,
    Clubwebstat2 VARCHAR(100) DEFAULT NULL,
    Clubemail VARCHAR(100) DEFAULT NULL,
    Clubadvanced VARCHAR(10) DEFAULT NULL
);


INSERT INTO TBL_EMPLOYEES
    (first_name, last_name, email)
VALUES
    ('Lokesh', 'Gupta', 'abc@gmail.com'),
    ('Deja', 'Vu', 'xyz@email.com'),
    ('Caption', 'America', 'cap@marvel.com');


{
        "District": "92",
        "Division": "A",
        "Area": "01",
        "Club": "4113936",
        "Clubname": "Infinera Toastmasters",
        "Clubest": "2014-08-11",
        "Clubstatus": "Active",
        "Clubaddr1": "Infinera India Office",
        "Clubaddr2": "Prestige Solitaire, 6 Brunton Road",
        "Clubcity": "Bangalore",
        "Clubstate": "KRN",
        "Clubzip": "560025",
        "Clubcountry": "India",
        "Clubphone": "+91 80667 31300",
        "Clubday_o": "Wednesday",
        "Clubtime_o": "4:00PM to 5:00PM",
        "Clubday": "Wed",
        "Clubtime": "16:00:00",
        "Clublen": "60",
        "Clubfreq": "W1",
        "Clubopen": "E",
        "Cluburl1": "",
        "Cluburl2": "www.facebook.com/groups/118304765458151/",
        "Clubwebstat1": "None",
        "Clubwebstat2": "Facebook",
        "Clubemail": "ngupta@infinera.com",
        "Clubadvanced": ""
    }

