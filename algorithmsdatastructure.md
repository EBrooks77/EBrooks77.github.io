# Algorithms and Data Structure

The artifact I selected for the algorithms and data structure prompt was my final project from an introduction to java course taken in the computer science program. This particular project was a pseudocode for a system login program. I selected this project because of the use of loops and incorporation of additional files to produce a functional outcome.

Working from the pseudocode gave me the chance to start the code over from the beginning. I started with a simple login function with a universal limit that counted down failed attempts until it locked. It also reads login credentials from another file to compare to the input from the user. This allows for user input to be matched to an already formatted credentials file in order to better maintain a permissions file.

Moving forward I am going to continue to update the code to specifically look at the permissions for a specific user within the same file and log the user in to a particular file, as well as provide logout options. The permissions will make the authentication system very specific. The logout option will allow for file security. 

In the code review, I had also suggested the possibility of adding a timer to do an automatic logout after a set amount of time. I am still considering adding this function but am uncertain if it should be a set time or bring in an additional function to watch for activity and log out after a set amount of inactive time.

[Authentication Code](https://github.com/EBrooks77/EBrooks77.github.io/blob/main/ErinBrooks_CS499_AlgorithmsDataStructure/ErinBrooks_CS499_AuthenticationCode.java)
