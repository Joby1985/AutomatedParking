****** Automatic Parking System Problem:****** 

The purpose of this exercise is to demonstrate TDD and come up with a solution to the problem
given below. Working unit tests will be sufficient as a solution, but you may provide a simple user
interface to demonstrate your codes capability if you desire.
Cars are placed on a 15 by 15 grid at particular co-ordinates heading north, and the simple
commands Left, right and forward are transmitted to them. The commands must be executed and
the final position calculated.


Input: "5,5:RFLFRFLF"
Output should be  "7,7"

Input: "6,6:FFLFFLFFLFF"
Output should be "6,6"

Input: "5,5:FLFLFFRFFF"
Output should be "1,4" (What s is given in assignment is 4,1.. I see that it should be 1,4.. )


****** Implementation****** 
 
I have used regular expression to parse input and find out the starting position and the command input.

Invalid input is flagged as exception. Also boundary conditions are checked for out of index.

****** Build using maven ****** 

mvn clean package

****** Run the program using the jar ****** 

cd target
java -jar AutomatedParking-1.0.jar <The Input>
