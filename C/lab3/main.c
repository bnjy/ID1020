#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

FILE *text;
FILE *filterText;

int main(void) {

    int c;
    char *filename = "text.txt";                //declare text file name
    text = fopen(filename,"r");                 //opens file for reading
    filterText = fopen("newtextfile.txt","w");  //creates empty file for writing

    if(text == NULL){                           //if no file found, error message.
        printf("could not open file");
        return 1;
    }

    while(!feof(text)) {                        //checks if end-of-file. if not, proceed.
        c = fgetc(text);
        if (!isalpha(c) && !(c == ' ') && !(c == '\n')) {       //checks if c is non-alpha, blank and newline
            fprintf(filterText, " ");                           //replace non-alpha, blank and newline to new txt file
        } else {
            fprintf(filterText, "%c", c);                       //if c is a word, put in new txt file
        }
    }

    fclose(text);

    return 0;
}