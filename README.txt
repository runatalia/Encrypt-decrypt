Encryption/decryption

Encryption and decryption in two ways: the Caesar cipher and using the dial. 
Entering text for encryption / decryption is possible from the console or from a file. 
Output of encrypted / decrypted text is possible to the console or to the specified file.

For example in console or in file:

input: -mode enc -key 5 -data "Hi! I am Natalia!" -alg unicode
output: Mn&%N%fr%Sfyfqnf&

input: -key 5 -alg unicode -data "Mn&%N%fr%Sfyfqnf&" -mode dec
output: Hi! I am Natalia!

input: -key 5 -alg shift -data "Hi! I am Natalia!" -mode enc
output: Mn! N fr Sfyfqnf!

input: -key 5 -alg shift -data "Mn! N fr Sfyfqnf!" -mode dec
output: Hi! I am Natalia!