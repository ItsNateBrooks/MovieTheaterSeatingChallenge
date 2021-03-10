# MTSC

MTSC (or MovieTheaterSeatingChallenge) is a java program designed to accomodate and keep customers safe
by assigning seating with approproate public saftey precautions (3 seats and/or 1 row at a minimum)

## Build Instructions (Windows 10)

Make sure the most recent JDK version (current version: Java SE Development Kit 15) is installed to the 
current machine. Navigate to the directory in which the file is stored, an example command would be as follows;

Ex:	cd C:\Users\nayj9\Downloads\MovieTheaterSeatingChallenge

Once the correct directory is opened the file can be run, be sure to have the accompanying input file prepared 
for the program to read from. NOTICE, The input file MUST be a ".txt" file.
Now run the file with the following syntax;

Ex:	java -jar MTSC.jar <inputFileName> <outputFileName>

Do not use the file extension in the command as it is assumed the file is a .txt

Once this command is run you have successfully generated an output file with the assigned seats for the customers

## Assumptions

1. The input file will be a .txt and the generated output file is expected to be a .txt as well
2. "assume that a buffer of three seats and/or one row is required." this is interpreted as exclusive, 
or having 3 empty spaces and/or 1 empty row between any groups of people

Ex: A1 and A2 are full so the next available spot is A6 for row A and no one can be sitting in anywhere in row B as 
this interferes with being 1 empty row between any groups 

3. There is no criteria stating to design the algorithim in a way that forces the theater to be as full as possible,
the program is to fit people into the theater in a way that is both safe and satisfactory to the customers

4."Safe" means fitting the people in that obeys the requirement stated in assumption 2 and "satisfactory" means that 
groups are not seperated 

## Contributions
This program was made by Nathaniel Brooks
