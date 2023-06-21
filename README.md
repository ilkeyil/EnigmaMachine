# EnigmaMachine

## Overview
This Java code is a simulation of an Enigma machine, a cryptographic device used during World War II for encryption and decryption of secret messages. 
The Enigma machine had a series of rotating 'rotors' that scrambled plain text input into encrypted cipher text, and vice versa.
This simulator and its rotors represents an M3 machine.

## Classes
The program contains the following classes:

### Pair: 
This class represents a simple pair of integers (key and value). Each Pair object can be thought of as a mapping from one integer to another.

### Rotor: 
This class represents a rotor in the Enigma machine. It contains a method to rotate the rotor, to reset it back to its original configuration, and to find or locate key-value pairs.

### Machine: 
This class represents the entire Enigma machine, including its left, middle, right and reference rotors. It provides methods to update the machine's configuration, set the start position of a rotor, and encrypt a single letter or a string of input.

### Translate: 
This class converts strings of English letters to and from arrays of integers, which are used internally by the Machine and Rotor classes.

### PlugBoard: 
This class represents a plugboard in the Enigma machine. However, in the provided code it seems to be unused and could be removed or further implemented.

### Main: 
This class contains the main method for the application, where the various rotors and the Machine object are initialized. The example rotors provided simulate the different rotor configurations that were possible in the real Enigma machine.

## Architecture & Design
The Enigma machine's working principle is well represented by the Machine and Rotor classes. 
Each Rotor has an array of Pair objects, which represent the wiring of the rotor. The rotation of the rotor is simulated by shifting the pairs in the array.
The Machine class represents the set of rotors and provides methods for their manipulation, thus encapsulating the workings of the Enigma machine. 
The use of a separate Translate class for translation between character and integer representations is a good example of separation of concerns.
The design is quite flexible, allowing for easy adjustment of the number and configuration of the rotors. Each rotor is an instance of the Rotor class and can be configured independently, which matches the physical design of the Enigma machine.

## Potential Improvements
### PlugBoard implementation: 
The PlugBoard class is currently incomplete. In a real Enigma machine, the plugboard was used to swap pairs of characters before and after they were processed by the rotors. 
Implementing this feature would make the simulation more accurate.

### Other types of Enigmas:
This implementation only simulates an Enigma M3. There are several more Enigma machines. In the future the user will be able to chose a desired type of Enigma.



