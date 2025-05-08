README.txt file for CPSC-231 assignment MP3B at Chapman University 

AUTHOR INFO
Full name: Asiyah Speight 
Student ID: 2357167
Chapman Email: aspeight@chapman.edu 
Course number and section: CPSC-231-01
Assignment or exercise number: MP 3B - Card Game

ERRORS 
A description of any known compile or runtime errors, code limitations, or deviations
from the assignment specification (if applicable)
E.g. the flour is not calculated accurately 

I ran into getting an infinite loop after running the program a few times. This was dealt with by the following (all fixes were done with the help of CPSC 231 student Kevin Orpeza + the LLM ChatGPT):
- currentPlayerIndex (Found in the Game class). 
if (currentPlayerIndex == players.size()) {
	currentPlayerIndex = 0; // Reset to the first player
}   
	- These updates will ensure that the game doesn't run into an infinite loop, even when players are removed. The currentPlayerIndex is always updated correctly, even if a player is removed at the end of the game loop.


SOURCES
A list of all references used to complete the assignment, including peers (if applicable)
LLM ChatGPT, was used as a guide to ensure the code ran smoothly with no issues. Gemini was attempted, but didn't give the best results as ChatGPT did, therefore it was not referenced in my code as I did not use any of the suggestions it gave me. Lecture material was used as a guide, specifically the lecture on classes, as ThreadsAccount class that was built in class was used as a guide, the driver for the class, as well as the second class was built using the same class that was built in class. Student Kevin Orpeza, was also of some help, as he helped with stating the static methods as well as what the output must look like. 

Side Note: I appologize in advanced if this is not reflected in the code.

