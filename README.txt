Word Guessing Game (Console-Based)

This is a simple console-based Word Guessing Game built using core Java.
The project focuses on clean logic, readable code, and basic object-oriented
principles without using any external libraries or frameworks.

Features
- Randomly selects a word from a predefined list
- Allows the user to guess one letter at a time
- Reveals correctly guessed letters in their positions
- Limits the number of incorrect attempts
- Ends the game when the word is guessed or attempts are exhausted

Code Structure
- Word.java  
  Stores the actual word and maintains the current revealed state of each letter.

- GameService.java  
  Handles the main game logic such as selecting the word, validating guesses,
  updating attempts, and checking win/loss conditions.

- Main.java  
  Acts as the entry point of the application. Displays instructions, accepts user
  input, and runs the game loop until completion.

Concepts Used
- Core Java
- Object-Oriented Programming (Encapsulation)
- Arrays and loops
- Conditional statements
- String and character manipulation
- Scanner for user input

How to Run (Using VS Code)
1. Open the project folder in Visual Studio Code.
2. Open `Main.java`.
3. Click the Run button in the editor.
4. Follow the on-screen instructions in the terminal to play the game.

Sample Gameplay
- The game displays the hidden word using underscores.
- Each correct guess reveals matching letters.
- Incorrect guesses reduce the remaining attempts.
- The game ends with a win or loss message.

Time Complexity
- Checking a guessed letter against the word: O(n), where n is the length of the word.
- Overall gameplay depends on the number of guesses made.

Future Improvements
- Allow users to choose difficulty levels
- Track previous guesses to prevent duplicate inputs
