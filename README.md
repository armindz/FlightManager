# Flight management system project

### *Project description & abilities*

**Flight management system** is a flight booking engine that provides flight ticket booking to the customers. It is not uset only to make flight reservations, but it's also being important to help and assist with different airline management tasks in order to meet customers needs.



**User can**:
- **Create** airline,
-	**Create** airport 
-	**Create** flight,
-	**List** all created airlines, airports and flights data stored in easily accessible database
-	**Check** if seat is available based on entered flight ID or list all available seats at specific flight.
-	**Book** a seat on a flight.

### *Installation*

*Software required to run this project:*

- **[JAVA 8](https://www.java.com/en/download/)**  / [Installation instructions](https://www.java.com/en/download/help/ie_online_install.xml)
- **[Eclipse](https://www.eclipse.org/downloads/)**  / [Installation instructions](https://www.eclipse.org/downloads/packages/installer) 
or 
- **[Intellij IDEA](https://www.jetbrains.com/idea/download/)** / [Installation instructions](https://www.jetbrains.com/help/idea/installation-guide.html)  

- **[MySQL](https://dev.mysql.com/downloads/)** / [Installation instructions](https://www.sitepoint.com/how-to-install-mysql/#:~:text=Step%201%3A%20download%20MySQL,a%20tool%20such%20as%20fsum.)  


### *Usage*

Validation mechanism is very important when it comes to customer's input data.

-	 An airport must have a name consisting of exactly three alphabetical characters. No two airports can have the same name.
-	 An airline has a name that must have less than **6 alphabetic characters**. No two airlines can have the same name.
-	 Each flight consists of seats organized in rows. Each row is labeled with ("**A**" , "**B**" , "**C**" , "**D**" , "**E**" , or "**F**"). Each row has number of seats in row.
-	 Every flight has an airport, airline, origin destination and seats.


Using keyboard numbers you should navigate trough menu. 
In **menu** you can :

-	Press **1** to create airline; 

-	Press **2** to create airport;

-	Press **3** to create flight;

-	Press **4**  to book a flight;

-	Press **5** to list all airlines stored in database;

-	Press **6** to list all airports stored in database;

-	Press **7** to list all flights stored in database;

-	Press **8** to check if seat is available based on entered flight ID;

-	Press **9** to list all available seats for specific flight;

-	Press **0** to EXIT.
