#include <iostream>
#include <time.h>
#include <stdlib.h>
using namespace std;
string words[] = { "whizz", "pizza", "tizzy", "above", "admit", "pierce", "paint", "ratio", "offer", "media" };
int chances = 0;
string wordle;

void startUp()
{

	cout << "Hello and welcome to Wordle by Zee Thomas. This recreation is based on the viral game Wordle by the New York Times. I hope you enjoy!" << endl;
	int size = wordle.size();
	srand(time(0));
	int random = rand() % size;
	cout << random << endl;
}



int main()
{
	//start up game
	startUp();
}