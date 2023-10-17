#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// List of 30 names
char **arry;

// Function that return random name from the list
char* get_name(){

	int index = rand() % 30;
	return arry[index];
}


// Function that return a converted string from lower case strings in to uper case
char* conver_up(char str[]){
	
	for(int i = 0; str[i]; i++){
        	if(str[i] >= 97 && str[i] <= 122){
        		str[i] -= 32;
		}
 	}
	return str;

}

// Function that check if all the names in the list are diffrent
int check_input(char str[]){

	char *ptr_of_string, copy_of_string_in_arry[20], copy_of_str[20];
	int counter = 0, len = strlen(str);
	for(int i = 0; i < 30; i++){
 		if(arry[i] == NULL){
			return 0;
		}
		
		if(len == strlen(arry[i])){
		
			// Pointer to a name in the list
			ptr_of_string = arry[i];

			// Saving the original name	
			strcpy(copy_of_str, str);
			strcpy(copy_of_string_in_arry, arry[i]);
		
			// Converting in to upre case
			str = conver_up(str);
			arry[i] = conver_up(arry[i]);

			// Check the both name are diffrent
			for(int j = 0; j < len; j++){
				if(ptr_of_string[j] == str[j]){
					counter++;	
				}
			}
		
			// Updates the name to the original name
			strcpy(arry[i], copy_of_string_in_arry);
			strcpy(str, copy_of_str);
		
			// return 1 == there is a same name
			if(counter == len){
				return 1;
			}
		}
		counter = 0;

	}
	
	// return 0 == there is not a same name
	return 0;

}


int main()
{
	// Part of the random function
	srand(time(NULL));
	

	char string[20];
	
	arry = (char**)malloc(30 * sizeof(char*));
	
	printf("Enter 30 names: \n");
	
	for(int i = 0; i < 30; i++){
		// Input of the names
		scanf("%s", string);
		
		// Adds the name in to the list if it is not there yet
		if(check_input(string) == 0){ 
			arry[i] = (char*)malloc(20 * sizeof(char));
			strcpy(arry[i], string);
		}
		// There is the same name in the list
		else{
			printf("ERRO\n");
			return 0; 
		}
	}
	
	// Output of all the names
	printf("The names are: \n");
	for(int t = 0; t < 30; t++)
		printf("%2d. %s\n", t + 1, arry[t]);
	
	// Output of the 10 random names
	printf("The ten rundom names are: \n");
	for(int j = 0; j < 10; j++)
		printf("%2d. %s\n", j + 1, get_name());

	
	return 0;
	
}

