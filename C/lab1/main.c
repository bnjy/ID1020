/***********************************************************
 * ID1020 Lab 1 - Problem 1
 *
 * This is the lab task 'Problem 1' of Lab 1 in course ID1020 at KTH.
 *
 * Shows methods of recursion and iteration.
 *
 * The main class runs the methods charsInReverseRecursive and
 * charsInReverseIterative and takes input from the user.
 *
 ***********************************************************/

#include <stdio.h>

/* function declaration */
void charsInReverseRecursive();
void charsInReverseIterative(char array[]);

int main() {
    char array[10];

    charsInReverseRecursive();
    charsInReverseIterative(array);

    return 0;
}

/* function that reads chars and returning in reverse order recursive, without an array */
void charsInReverseRecursive() {
    char c = getchar();

    if (c == '\n') { return; }
    else {
        charsInReverseRecursive();
        putchar(c);
    }
}

/* function that reads chars and returning in reverse order iterative */
void charsInReverseIterative(char* array){
    char c = getchar();
    int count = 0;

    while(c != '\n') {
        array[count] = c;
        ++count;
        c = getchar();
    }

    while (count > 0) {
        putchar(array[count-1]);
        --count;
    }
}