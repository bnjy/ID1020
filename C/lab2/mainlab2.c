/***********************************************************
 * ID1020 Lab 2 - Problem 5
 *
 * This is the lab task 'Problem 5' of Lab 2 in course ID1020 at KTH.
 *
 * Function sortInts orders the elements in an array so that all negative elements come before the positive.
 *
 * Example execution:
 *
 * array = {1,5,-6,4,3,10,-20,-11,7,9}
 *
 * Prints the array:
 * -6, -20, -11, 1, 5, 4, 3, 10, 7, 9,
 *
 ****************************************************/

#include <stdio.h>

/* function declaration */
void sortInts(int array[], int length);

int main() {

    int length = 10;
    int array[10] = {1,5,-6,4,3,10,-20,-11,7,9};

    sortInts(array, length);

    return 0;
}

/* function that orders the elements in an array so all negative elements come before the positive
 * and then prints the array.
 */
void sortInts(int array[], int length)
    {
        int current;
        int j;

        for(int i = 0; i < length; i++) {
            current = array[i];
            if (current > 0)
                continue;               //loop again if the current element isn't negative

            j = i - 1;

            while(array[j] > 0){        //pushes all positive numbers one element to the right
                array[j + 1] = array[j];
                j--;
            }

         array[j + 1] = current;
    }

       for(int i = 0; i < length; i++){
            printf("%d", array[i]);
            printf(", ");
        }
}