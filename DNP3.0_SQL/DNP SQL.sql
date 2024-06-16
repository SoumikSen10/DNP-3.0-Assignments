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
('USA', 'United States', 'North America', 'Northern America', 9372610, 1776, 331002651, 78.93, 
21137518, 20611800, 'United States', 'Federal Republic', 'Joe Biden', 3813, 'US'),
('CHN', 'China', 'Asia', 'Eastern Asia', 9596960, 1949, 1439323776, 76.91, 14140163, 13894800, 
'Zhongguo', 'Communist State', 'Xi Jinping', 1892, 'CN'),
('JPN', 'Japan', 'Asia', 'Eastern Asia', 377975, 660, 126476461, 84.63, 5064873, 4909000, 'Nihon', 
'Constitutional Monarchy', 'Naruhito', 1534, 'JP'),
('DEU', 'Germany', 'Europe', 'Western Europe', 357114, 1955, 83166711, 81.33, 3845630, 3693200, 
'Deutschland', 'Federal Republic', 'Frank-Walter Steinmeier', 3068, 'DE'),
('BRA', 'Brazil', 'South America', 'South America', 8515767, 1822, 212559417, 75.88, 2055500, 2011780, 
'Brasil', 'Federal Republic', 'Jair Bolsonaro', 2110, 'BR');


INSERT INTO city (ID, Name, CountryCode, District, Population)
VALUES
(3813, 'Washington', 'USA', 'District of Columbia', 689545),
(1892, 'Beijing', 'CHN', 'Beijing', 21542000),
(1534, 'Tokyo', 'JPN', 'Tokyo', 13929286),
(3068, 'Berlin', 'DEU', 'Berlin', 3644826),
(2110, 'Brasília', 'BRA', 'Federal District', 3055149);


INSERT INTO countrylanguage (CountryCode, Language, IsOfficial, Percentage)
VALUES
('USA', 'English', 'T', 82.1),
('USA', 'Spanish', 'F', 13.5),
('CHN', 'Chinese', 'T', 92.0),
('JPN', 'Japanese', 'T', 99.0),
('DEU', 'German', 'T', 95.0),
('BRA', 'Portuguese', 'T', 98.0),
('BRA', 'Spanish', 'F', 1.0);

#SELECT * FROM country;
#SELECT * FROM city;
#SELECT * FROM countrylanguage;

# Query 1
SELECT Name FROM Country WHERE Continent = "Asia";

# Query 2
SELECT Name, Population FROM City ORDER BY population  DESC LIMIT 5;

# Query 3
SELECT NAME, Population FROM Country WHERE Population > 100000000;

# Query 4
SELECT Language FROM countryLanguage WHERE CountryCode = 'JPN';

# Query 5
# Find the capital city of the country with the largest surface area.
SELECT City.Name AS CapitalCity FROM country JOIN city ON country.Capital = city.ID ORDER BY country.SurfaceArea DESC LIMIT 1;

# Query 6
# List all cities in Japan.
SELECT Name FROM city WHERE CountryCode = 'JPN';

# Query 7
# Find the average life expectancy of countries in Europe
SELECT AVG(LifeExpectancy) AS AverageLifeExpectancy FROM country WHERE Continent = 'Europe' ;

# Query 8
# Find the number of official languages spoken in each country
SELECT CountryCode,COUNT(Language) FROM countrylanguage WHERE IsOfficial = 'T' GROUP BY CountryCode;

# Query 9
# List countries with a life expectancy greater than the world average.
SELECT Name,LifeExpectancy FROM country WHERE LifeExpectancy >  (SELECT AVG(LifeExpectancy) FROM country) ;

# Query 10
# Find the total population of all cities in India.
SELECT SUM(Population) FROM city WHERE CountryCode = 'IND';

# Query 11
# List the names of all capital cities along with their country's name.
SELECT city.Name AS City ,country.Name AS Country FROM city JOIN country ON city.CountryCode=country.Code;

# Query 12
# Find the names of countries where the official language is 'Spanish'.
SELECT country.Name FROM country JOIN countrylanguage ON country.Code=countrylanguage.CountryCode WHERE countrylanguage.IsOfficial='T' AND countrylanguage.Language='Spanish';

# Query 13
# List the top 10 countries by population density (Population/SurfaceArea).
SELECT Name,(Population/SurfaceArea) AS PopulationDensity FROM country ORDER BY (Population/SurfaceArea) DESC LIMIT 10;

# Query 14
# Find the names and populations of cities in countries with a life expectancy greater than 75 years.
SELECT city.Name,city.Population FROM city JOIN country ON country.Code=city.CountryCode WHERE country.LifeExpectancy>75;

# Query 15
# List all countries and their corresponding languages, sorted by country name.
SELECT country.Name,countrylanguage.Language FROM country JOIN countrylanguage ON countrylanguage.CountryCode = country.Code ORDER BY country.Name;

# Query 16
# Find the countries that have a city named 'Paris'.
SELECT country.Name FROM country JOIN city ON country.Code = city.CountryCode WHERE city.Name = 'Paris';


# Query 17
# List the names of the countries that have more than 5 official languages
SELECT country.Name
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.IsOfficial = 'T'
GROUP BY country.Name
HAVING COUNT(countrylanguage.Language) > 5;


# Query 18
# Find the total population of each continent.
SELECT Continent,SUM(Population) AS TotalPopulation FROM country GROUP BY Continent;


# Query 19
# List the countries where the capital city's population is more than 10% of the country's total population.
SELECT country.Name FROM country JOIN city ON city.CountryCode = Country.Code WHERE city.Population > 0.1*country.Population;


# Query 20
# Find the average life expectancy for each continent
SELECT Continent,AVG(LifeExpectancy) AS AverageLifeExpectancy FROM country GROUP BY Continent;


# Query 21
# List the cities that are capitals of countries in South America
SELECT city.Name FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Continent = 'South America';


# Query 22
# Find the countries that do not have any cities with a population over 1 million.
SELECT country.Name AS CountryName,city.Name AS CityName,city.Population AS cityPopulation FROM country JOIN city ON city.CountryCode = country.Code WHERE city.Population < 1000000;

# ---------------------------------------------------------------------------------------------
# Query 23
# List the countries where the sum of the populations of all cities is more than the country's population
#SELECT country.Name AS CountryName FROM country JOIN city ON city.CountryCode = country.Code WHERE SUM(city.Population) > country.Population;

SELECT c.Name AS CountryName
FROM country c
JOIN (
    SELECT CountryCode, SUM(Population) AS TotalCityPopulation
    FROM city
    GROUP BY CountryCode
) AS city_population ON c.Code = city_population.CountryCode
WHERE city_population.TotalCityPopulation > c.Population;
#-----------------------------------------------------------------------------------------------------------------------

# Query 24
# Find the country with the highest number of cities.
SELECT country.Name As Country,COUNT(city.ID) FROM country JOIN city ON city.CountryCode = country.Code GROUP BY country.Name ORDER BY COUNT(city.ID) DESC LIMIT 1;


# Query 25
# List the countries where the official language is not English but is spoken by more than 50% of the population.
SELECT country.Name As Country FROM country JOIN countrylanguage ON country.Code = countrylanguage.CountryCode WHERE countrylanguage.Language!='English' AND countrylanguage.IsOfficial='T' AND countrylanguage.Percentage > 50;


# Query 26
# Classify countries into population size categories: 'Small' (population < 1 million), 'Medium' (1 million <= population < 10 million), 
# and 'Large' (population >= 10 million).

SELECT Name,
       Population,
       CASE
           WHEN Population < 1000000 THEN 'Small'
           WHEN Population >= 1000000 AND Population < 10000000 THEN 'Medium'
           ELSE 'Large'
       END AS PopulationSizeCategory
FROM country;


# Query 27
# Determine the continent's GDP category: 'Low' (GNP < 100 billion), 'Medium' (100 billion <= GNP 
# < 1 trillion), and 'High' (GNP >= 1 trillion).

SELECT Continent,GNP,
	             CASE 
                     WHEN GNP <100000000000 THEN 'Low'
                     WHEN GNP >=100000000000 AND GNP<1000000000000 THEN 'Medium'
                     ELSE 'High'
                     END AS GDPCategory
FROM country;  


# Query 28
#  Label cities as 'Small' (population < 100,000), 'Medium' (100,000 <= population < 1 million), or 
#  'Large' (population >= 1 million)     

SELECT Name,Population,
	             CASE 
                     WHEN Population <10000 THEN 'Small'
                     WHEN Population >=100000 AND Population<1000000 THEN 'Medium'
                     ELSE 'High'
                     END AS PopulationLevel
FROM city; 


# Query 29
# Classify countries based on life expectancy: 'Low' (life expectancy < 50), 'Average' (50 <= life 
# expectancy < 75), and 'High' (life expectancy >= 75)       

SELECT Name,LifeExpectancy,
                   CASE
                        WHEN LifeExpectancy<50 THEN 'Low'
                        WHEN LifeExpectancy>=50 AND LifeExpectancy<75 THEN 'Average'
                        ELSE 'High'
                        END AS LifeExpectancyMeasure
FROM country;                        

