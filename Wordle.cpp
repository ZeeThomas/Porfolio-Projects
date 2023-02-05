#include <iostream>
#include <time.h>
#include <vector>
#include <stdlib.h>
using namespace std;
string words[] = { "whizz", "pizza", "tizzy", "above", "admit", "pierce", "paint", "ratio", "offer", "media" };
int chances = 6;
string wordle;
string word;
vector<char> foundLetters;
char guessedWord[5];
bool isWinner = false;

void startUp()
{
	//finds a random word from list of words and then place chose wordle to wordle variable
	cout << "Hello and welcome to Wordle by Zee Thomas. This recreation is based on the viral game..." << endl;
	cout<<"Wordle by the New York Times.I hope you enjoy!" << endl;
	int size = words->size();
	//cout << size << endl;
	srand(time(0));
	int random = rand() % size;
	//wordle found and placed
	wordle = words[random];
	//cout << wordle << endl;
}
void checkPlacement()
{
	for (int i = 0; i < 5; i++)
	{
		if (wordle[i] == word[i])
		{
			cout << word[i];
			guessedWord[i] = word[i];
		}
		else
		{
			cout << "-";
		}
	}
	cout << endl;
}
void checkLetters()
{
	bool found = false;
	for (int i = 0; i < 6; i++)
	{
		for (int h = 0; h < 4; h++)
		{
			if (word[i] == wordle[h])
			{
				for (int p = 0; p < 5; p++)
				{
					if (word[i] == guessedWord[p])
					{
						found = true;
					}
				}
				if (found == false)
				{
					foundLetters.push_back(word[i]);
				}

			}

		}
		
	}
	cout << "Letters Found: ";
	for (int k = 0; k < foundLetters.size(); k++)
	{
		
		cout << foundLetters[k] << " ";
	}
	cout << endl;
}

void getWord()
{
	chances--;
	cout << "-----" << endl;
	cout << "Type in a 5 letter word" << endl;
	cin >> word;
	checkPlacement();
	checkLetters();
}


void checkWin()
{
	//check to see if user won
	if (guessedWord == wordle)
	{
		isWinner = true;
		cout << "You Won!" << endl;
	}
}

void lost()
{
	cout << "You lost...The word was: " << wordle << endl;
}

int main()
{
	//start up game
	startUp();
	while(chances > 0 && isWinner == false)
	{
		cout << "Chances: " << chances << endl;
		getWord();
		checkWin();
	}
	if (isWinner == false)
	{
		lost();
	}
}