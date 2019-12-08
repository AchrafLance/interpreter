# Java / SpringBoot NoteBook Server Projet
software i used: 
- IDE: IntelliJ IDEA
- [Postman](https://www.getpostman.com/) Platforme for testing
- [Jython](https://www.jython.org/download.html) standalone API as a python interpreter

Sample Input: 
--
![input](https://github.com/AchrafLance/interpreter/blob/master/sample_input.png)

Sample Output:
--
![output](https://github.com/AchrafLance/interpreter/blob/master/sample_output.png)



>**Task1**: 
used spring web dependency to setup my spring boot environment

>**Task2**: 
used Jython interpreter to execute the parsed JSON entry and an outputStream to capture the result 

>**Challenge1**: 
just made sure only one instance of the python interpreter is handling all the subsequente requests 

>**Challenge2**: 
created a hashmap that stores an instance of the python interpreter and a sessionID, so each 
request either create a new python interpreter instance ( if the sessionID is new ) or call an existing one.
