USE  dnp;

CREATE TABLE country(
  Code CHAR(3) PRIMARY KEY,
  Name VARCHAR(52),
  Continent ENUM("Asia","Africa","Europe","North America","South America","Antarctica","Australia"),
  Region VARCHAR(26),
  SurfaceArea FLOAT,
  IndepYear SMALLINT,
  Population INT,
  LifeExpectancy FLOAT,
  GNP FLOAT,
  GNPOld FLOAT,
  LocalName VARCHAR(45),
  GovernmentForm VARCHAR(45),
  HeadOfState VARCHAR(60),
  Capital INT,
  Code2 CHAR(2)
);

CREATE TABLE City(
  ID INT(11) PRIMARY KEY,
  Name VARCHAR(35),
  CountryCode CHAR(3),
  FOREIGN KEY(CountryCode) references Country(Code),
  District VARCHAR(20),
  Population INT
);

CREATE TABLE CountryLanguage(
   CountryCode CHAR(3),
   FOREIGN KEY(CountryCode) references Country(Code),
   Language VARCHAR(30),
   IsOfficial ENUM('T','F') NOT NULL,
   Percentage FLOAT
);


INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, 
LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2)
VALUES
('USA', 'United States', 'North America', 'Northern America', 9372610, 1776, 331002651, 78.93,21137518, 20611800, 'United States', 'Federal Republic', 'Joe Biden', 3813, 'US'),
('CHN', 'China', 'Asia', 'Eastern Asia', 9596960, 1949, 1439323776, 76.91, 14140163, 13894800,'Zhongguo', 'Communist State', 'Xi Jinping', 1892, 'CN'),
('JPN', 'Japan', 'Asia', 'Eastern Asia', 377975, 660, 126476461, 84.63, 5064873, 4909000, 'Nihon','Constitutional Monarchy', 'Naruhito', 1534, 'JP'),
('DEU', 'Germany', 'Europe', 'Western Europe', 357114, 1955, 83166711, 81.33, 3845630, 3693200,'Deutschland', 'Federal Republic', 'Frank-Walter Steinmeier', 3068, 'DE'),
('BRA', 'Brazil', 'South America', 'South America', 8515767, 1822, 212559417, 75.88, 2055500, 2011780,'Brasil', 'Federal Republic', 'Jair Bolsonaro', 2110, 'BR'),
('IND', 'India', 'Asia', 'Southern Asia', 3287263, 1947, 1380004385, 69.73, 2875142, 2739850, 'Bharat', 'Federal Republic', 'Ram Nath Kovind', 1109, 'IN'),
('FRA', 'France', 'Europe', 'Western Europe', 551695, 843, 65273511, 82.66, 2715518, 2582500, 'France', 'Republic', 'Emmanuel Macron', 1234, 'FR'),
('RUS', 'Russia', 'Europe', 'Eastern Europe', 17098242, 1991, 145912025, 72.58, 1637891, 1537200, 'Rossiya', 'Federation', 'Vladimir Putin', 7890, 'RU'),
('ZAF', 'South Africa', 'Africa', 'Southern Africa', 1219090, 1910, 59308690, 63.4, 351432, 315800, 'South Africa', 'Republic', 'Cyril Ramaphosa', 9012, 'ZA'),
('ARG', 'Argentina', 'South America', 'South America', 2780400, 1816, 45195777, 76.67, 449663, 400200, 'Argentina', 'Federal Republic', 'Alberto Fernández', 5678, 'AR'),
('AUS', 'Australia', 'Australia', 'Australia', 7692024, 1901, 25499884, 82.9, 1392687, 1339754, 'Australia', 'Federal Parliamentary Constitutional Monarchy', 'Anthony Albanese', 8901, 'AU'),
('GBR', 'United Kingdom', 'Europe', 'Northern Europe', 243610, 1066, 67886011, 81.32, 2825208, 2702204, 'United Kingdom', 'Constitutional Monarchy', 'Charles III', 23456, 'GB');


INSERT INTO city (ID, Name, CountryCode, District, Population)
VALUES
(3813, 'Washington', 'USA', 'District of Columbia', 689545),
(1892, 'Beijing', 'CHN', 'Beijing', 21542000),
(1534, 'Tokyo', 'JPN', 'Tokyo', 13929286),
(3068, 'Berlin', 'DEU', 'Berlin', 3644826),
(2110, 'Brasília', 'BRA', 'Federal District', 3055149),
(1109, 'New Delhi', 'IND', 'Delhi', 31870000),
(1234, 'Paris', 'FRA', 'Île-de-France', 2148327),
(7890, 'Moscow', 'RUS', 'Moscow', 12506468),
(9012, 'Pretoria', 'ZAF', 'Gauteng', 741651),
(5678, 'Buenos Aires', 'ARG', 'Buenos Aires', 3075646),
(2345, 'Mumbai', 'IND', 'Maharashtra', 20411000),
(3456, 'Los Angeles', 'USA', 'California', 3979576),
(4567, 'Chicago', 'USA', 'Illinois', 2716000),
(5679, 'Paris', 'USA', 'Texas', 25000),
(6789, 'London', 'GBR', 'England', 8982000),
(7891, 'Birmingham', 'GBR', 'England', 1141816),
(8902, 'Cape Town', 'ZAF', 'Western Cape', 433688),
(9013, 'Rio de Janeiro', 'BRA', 'Rio de Janeiro', 6747815),
(9014, 'São Paulo', 'BRA', 'São Paulo', 12330000),
(8903, 'Sydney', 'AUS', 'New South Wales', 5230330);



INSERT INTO countrylanguage (CountryCode, Language, IsOfficial, Percentage)
VALUES
('USA', 'English', 'T', 82.1),
('USA', 'Spanish', 'F', 13.5),
('CHN', 'Chinese', 'T', 92.0),
('JPN', 'Japanese', 'T', 99.0),
('DEU', 'German', 'T', 95.0),
('BRA', 'Portuguese', 'T', 98.0),
('BRA', 'Spanish', 'F', 1.0),
('IND', 'Hindi', 'T', 44.0),
('IND', 'English', 'F', 12.0),
('FRA', 'French', 'T', 100.0),
('RUS', 'Russian', 'T', 99.0),
('ZAF', 'Afrikaans', 'T', 13.5),
('ZAF', 'English', 'T', 9.6),
('ARG', 'Spanish', 'T', 98.0),
('ARG', 'Italian', 'F', 2.5),
('AUS', 'English', 'T', 78.5),
('GBR', 'English', 'T', 98.0);



#Q1
SELECT Name FROM country
WHERE Continent = 'Asia';


#Q2
SELECT Name, Population 
FROM city 
ORDER BY Population DESC 
LIMIT 5;


#Q3
SELECT Name, Population
FROM country
WHERE Population > 100000000;



#Q4
SELECT Language 
FROM countrylanguage 
WHERE CountryCode = 'JPN'
GROUP BY Language;



#Q5
SELECT city.Name AS CapitalCity, country.Name AS CountryName, country.SurfaceArea
FROM city
JOIN country ON city.ID = country.Capital
ORDER BY country.SurfaceArea DESC 
LIMIT 1;


#Q6
SELECT Name, CountryCode, District
FROM city
WHERE CountryCode = 'JPN';



#Q7
SELECT AVG(LifeExpectancy) AS Average_Life_Expectancy
FROM country
WHERE Continent = 'Europe';



#Q8
SELECT CountryCode, COUNT(Language) AS Number_Of_Official_Languages
FROM countrylanguage
WHERE IsOfficial = 'T'
GROUP BY CountryCode;



#Q9
SELECT Name, LifeExpectancy
FROM country
WHERE LifeExpectancy > (SELECT AVG(LifeExpectancy) FROM country);



#Q10
SELECT SUM(Population) AS Total_Population_Of_Cities_In_India
FROM city
WHERE CountryCode = 'IND';




#Q11
SELECT city.Name AS Capital, country.Name AS Country_Name
FROM city
JOIN country ON city.CountryCode = country.Code;




#Q12
SELECT country.Name as Country_Name
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.Language = 'Spanish' AND countrylanguage.IsOfficial = 'T'
GROUP BY country.Name;


#Q13
SELECT Name AS CountryName, Population / SurfaceArea AS PopulationDensity
FROM country
ORDER BY PopulationDensity DESC
LIMIT 10;




#Q14
SELECT city.Name AS City, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.LifeExpectancy > 75;




#Q15
SELECT country.Name AS CountryName, countrylanguage.Language
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
ORDER BY country.Name;



#16
SELECT country.Name
FROM country
JOIN city ON country.Code = city.CountryCode
WHERE city.Name = 'Paris';



#17
SELECT country.Name
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.IsOfficial = 'T'
GROUP BY country.Name
HAVING COUNT(countrylanguage.Language) > 5;



#Q18
SELECT Continent, SUM(Population) AS Total_Population
FROM country
GROUP BY Continent;




#Q19
SELECT country.Name
FROM country
JOIN city ON country.Capital = city.ID
WHERE city.Population > (country.Population * 0.10);




#20
SELECT Continent, AVG(LifeExpectancy) AS Average_Life_Expectancy
FROM country
GROUP BY Continent;




#21
SELECT city.Name
FROM city
JOIN country ON city.ID = country.Capital
WHERE country.Continent = 'South America';




#22
SELECT country.Name
FROM country
WHERE NOT EXISTS (
    SELECT 1
    FROM city
    WHERE city.CountryCode = country.Code AND city.Population > 1000000
);




#23
SELECT country.Name
FROM country
JOIN (
    SELECT CountryCode, SUM(Population) AS TotalCityPopulation
    FROM city
    GROUP BY CountryCode
) AS city_totals ON country.Code = city_totals.CountryCode
WHERE city_totals.TotalCityPopulation > country.Population;





#24
SELECT country.Name, COUNT(city.ID) AS NumberOfCities
FROM country
JOIN city ON country.Code = city.CountryCode
GROUP BY country.Name
ORDER BY NumberOfCities DESC
LIMIT 1;




#25
SELECT country.Name
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.IsOfficial = 'T'
AND countrylanguage.Language != 'English'
AND countrylanguage.Percentage > 50;



#26
SELECT Name,
       Population,
       CASE
           WHEN Population < 1000000 THEN 'Small'
           WHEN Population >= 1000000 AND Population < 10000000 THEN 'Medium'
           ELSE 'Large'
       END AS PopulationSizeCategory
FROM country;



#27
SELECT Continent,
       SUM(GNP) AS TotalGNP,
       CASE 
           WHEN SUM(GNP) < 100000000000 THEN 'Low'
           WHEN SUM(GNP) >= 100000000000 AND SUM(GNP) < 1000000000000 THEN 'Medium'
           ELSE 'High'
       END AS GDPCategory
FROM country
GROUP BY Continent;



#28
SELECT Name,
       Population,
       CASE
           WHEN Population < 100000 THEN 'Small'
           WHEN Population >= 100000 AND Population < 1000000 THEN 'Medium'
           ELSE 'Large'
       END AS CitySizeCategory
FROM city;



#29
SELECT Name,
       LifeExpectancy,
       CASE
           WHEN LifeExpectancy < 50 THEN 'Low'
           WHEN LifeExpectancy >= 50 AND LifeExpectancy < 75 THEN 'Average'
           ELSE 'High'
       END AS LifeExpectancyCategory
FROM country;