
# **JDBC**

**MySql**
Instalare instructiuni https://www.youtube.com/watch?v=-PguJeJoO4c

instalare my sql https://dev.mysql.com/downloads/installer/

Ca sa fie ca pe youtube, pentru Windows se alege mysql-installer-community-8.0.32.0.msi

![mysqlCreateDatabase.png](mysqlCreateDatabase.png)

**Oracle**
https://www.oracle.com/database/technologies/xe-downloads.html
Oracle Database 21c Express Edition for Windows x64

Ca sa poata fi vizualizata baza de date SQL developer https://www.oracle.com/database/sqldeveloper/

**Proiect nou cu JDBC:**

New Java Project -> se genereaza noul proiect

Go to File -> Project Structure -> ProjectSettings -> Modules -> In dreapta se apasa + pentru adaugare Jars or Directories

Add Library -> Java 

Intellij deja are jar uri in folderul jdcc-drivers:

C:\Users\lumpopescu\AppData\Roaming\JetBrains\IntelliJIdea2023.2\jdbc-drivers\MySQL ConnectorJ\8.2.0\com\mysql\mysql-connector-j\8.2.0\mysql-connector-j-8.2.0.jar

![JDBC_adaugareDriver1.png](JDBC_adaugareDriver1.png)

![JDBC_adaugareDriver2.png](JDBC_adaugareDriver2.png)

![JDBC_adaugareDriver3.png](JDBC_adaugareDriver3.png)

![JDBC_adaugareDriver4.png](JDBC_adaugareDriver4.png)

![MysqlConectat.png](MysqlConectat.png)

Conectare baza de date din aplicatia Java:

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root","parola");

sau

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo?" +
"user=root&password=parola");)

Aceasta conectare se face cu try with resources

    try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root","parola");){
        ...
    }catch(...){...}


Conectare DataSource in Intellij

![ConectareDataSourceInIntellij.png](ConectareDataSourceInIntellij.png)

![DataSourceAndScripts.png](DataSourceAndScripts.png)



### Intellij poate downloada Driver jar pentru baza de date dorita.

#### Cum gasesc locatia acestui driver jar:

In modulul din dreapta, Database, se apasa pe + apoi se alege Driver:
![Screenshot 2024-04-24 160147.png](Screenshot%202024-04-24%20160147.png)

In cazul in care driverul nu exista pe calculator, exista optiunea de download in dreapta:
Exemplu pentru un driver de MongoDB
![Screenshot 2024-04-24 161006.png](Screenshot%202024-04-24%20161006.png)

Gasire cale catre un driver de MySql existent pe masina:

Din lista din stanga cu drivere se alege MySql:
![Screenshot 2024-04-24 160417.png](Screenshot%202024-04-24%20160417.png)

Se selecteaza Add
![Screenshot 2024-04-24 160641.png](Screenshot%202024-04-24%20160641.png)

Se selecteaza Native Library Path
![Screenshot 2024-04-24 161308.png](Screenshot%202024-04-24%20161308.png)

In partea de sus se va vedea calea. Se expandeaza folderul jdbc-drivers si se va gasi calea catre driver jar ul dorit.