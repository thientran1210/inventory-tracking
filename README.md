# inventory-tracking
Inventory Tracking System

Step to run:
1. Clone this git repository
1. Create MySQL database:
    * execute 'mysql -u username -p < dbscript.sql'
1. Build project using maven:
    * Change directory to 'inventory-tracking' folder in the clone repository
    * Change username and password of MySQL database in src/main/resources/hibernate.cfg.xml
    * Execute 'mvn install assembly:single -Ddir=.' - This will create a jar file named 'inventory-tracking-0.0.1-SNAPSHOT-jar-with-dependencies.jar' in current directory
1. Execute 'java -jar inventory-tracking-0.0.1-SNAPSHOT-jar-with-dependencies.jar' to run the program
    
