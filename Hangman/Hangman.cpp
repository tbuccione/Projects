#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>
#include <string>
#include "ctype.h"
#include "Hangman.h"
using namespace std;

namespace tb
{
	int tries = 6;
	int numChars{0};
	int guessIndex = 0;
	int m_length = 0;
	tb::Hangman::Hangman(const char* solution, const char* category)
	{
		
		if (solution)
		{
			m_length = strlen(solution);
			m_solution = new char[m_length + 1];
			strcpy(m_solution, solution);
			upperCase(m_solution);
			m_category = new char[strlen(category) + 1];
			strcpy(m_category, category);
			upperCase(m_category);
		}
	}

	void Hangman::buildHangman()
	{
		bool tOrF = false;
		system("CLS");
		cout << "Hangman 1.0" << endl << "-------------------" << endl;
		//draw hangman
		switch (tries)
		{
		case 6:
			cout << "      ___________" << endl;
			cout << "      |        | " << endl;
			cout << "               |" << endl;
			cout << "               |" << endl;
			cout << "               |" << endl;
			cout << "      _________|_" << endl;
			break;
		case 5:
			cout << "      ___________" << endl;
			cout << "      |        | " << endl;
			cout << "      O        |" << endl;
			cout << "               |" << endl;
			cout << "               |" << endl;
			cout << "      _________|_" << endl;
			break;
		case 4:       
			cout << "      ___________" << endl;
			cout << "      |        | " << endl;
			cout << "      O        |" << endl;
			cout << "      |        |" << endl;
			cout << "               |" << endl;
			cout << "      _________|_" << endl;
			break;
		case 3:
			cout << "      ___________" << endl;
			cout << "      |        | " << endl;
			cout << "      O        |" << endl;
			cout << "      |\\       |" << endl;
			cout << "               |" << endl;
			cout << "      _________|_" << endl;
			break;
		case 2:
			cout << "      ___________" << endl;
			cout << "      |        | " << endl;
			cout << "      O        |" << endl;
			cout << "     /|\\       |" << endl;
			cout << "               |" << endl;
			cout << "      _________|_" << endl;
			break;
		case 1:
			cout << "      ___________" << endl;
			cout << "      |        | " << endl;
			cout << "      O        |" << endl;
			cout << "     /|\\       |" << endl;
			cout << "    _/         |" << endl;
			cout << "      _________|_" << endl;
			break;
		case 0:
			cout << "      ___________" << endl;
			cout << "      |        | " << endl;
			cout << "      O        |" << endl;
			cout << "     /|\\       |" << endl;
			cout << "    _/ \\_      |" << endl;
			cout << "      _________|_" << endl;
		}
		cout << endl;
		//draw letters
		int counter{};
		for (int i = 0; i < m_length; i++)
		{
			tOrF = false;
			for (int j = 0; j < strlen(alreadyGuessed); j++)
			{
				if (m_solution[i] == alreadyGuessed[j])
				{
					cout << m_solution[i] << " ";
					tOrF = true;
					counter++;
				}

			}
			if (!tOrF)
				cout << "  ";

		}
		cout << endl;

		//draw spaces
		for (int i = 0; i < m_length; i++)
			m_solution[i] == ' ' ? cout << "  " : cout << (char)2500 << " ";

		cout << endl << endl << "CATEGORY: " << m_category << endl;

		if (alreadyGuessed[0])
		{
			m_guess ? cout << endl << "You guessed correctly! The letter \"" << m_letterGuess << "\" Is in the solution!" : cout << endl << "You guessed incorrectly.";
		}

		cout << endl << "Guessed letters so far: " << alreadyGuessed << endl << "Tries left: " << tries << endl;

		if (tries > 0)
			cout << "Guess a letter (or press 0 to solve the puzzle): ";

		//if all letters guessed correctly before solving
		if (counter == m_length)
		{
			solved = true;
			cout << endl;
			gameOver();
		}
	}

	bool Hangman::solve() const
	{
		bool tOrF = false;
		string solve;

		if (tries)
		{
			cout << "Enter your answer: ";
			cin.ignore(2000, '\n');
		}
		else
			cout << endl << "No more letter guesses available! You must try to solve the puzzle: ";

		getline(cin, solve);

		for (int i = 0; i < solve.length(); i++)
		{
			if (islower(solve.c_str()[i]))
				solve[i] = toupper(solve.c_str()[i]);
		}

		strcmp(m_solution, solve.c_str()) != 0 ? tOrF = false : tOrF = true;

		return tOrF;
	}

	bool Hangman::getSolved() const
	{
		return solved;
	}

	//Hangman& Hangman::getSolution()
	//{
	//	cout << "Enter the solution: ";
	//	string sol;
	//	getline(cin, sol);
	//	m_length = strlen(sol.c_str());
	//	delete[] m_solution;
	//	m_solution = new char[m_length + 1];
	//	strcpy(m_solution, sol.c_str());
	//	for (int i = 0; i < m_length; i++)
	//	{
	//		if (islower(m_solution[i]))
	//			m_solution[i] = toupper(m_solution[i]);
	//	}
	//	return *this;
	//}

	//Hangman& Hangman::getCategory()
	//{
	//	cout << "Enter the category: ";
	//	string cat;
	//	getline(cin, cat);
	//	int catLength = strlen(cat.c_str());
	//	delete[] m_category;
	//	m_category = new char[catLength + 1];
	//	strcpy(m_category, cat.c_str());
	//	for (int i = 0; i < catLength; i++)
	//	{
	//		if (islower(m_category[i]))
	//			m_category[i] = toupper(m_category[i]);
	//	}
	//	return *this;
	//}

	void Hangman::upperCase(char* source)
	{
		for (int i = 0; i < strlen(source); i++)
		{
			if (islower(source[i]))
				source[i] = toupper(source[i]);
		}
	}

	tb::Hangman::~Hangman()
	{
		delete[] m_solution;
		m_solution = nullptr;
		delete[] m_category;
		m_category = nullptr;
	}
	void Hangman::gameOver()
	{
		char playAgain{};
		bool flag = false;
		!solved && numChars != strlen(m_solution) ? cout << endl << "YOU DIED!" << endl << "The correct answer was: " << m_solution << endl : cout << endl << "CORRECT! YOU WIN!" << endl;

			cout << endl << "GAME OVER!" << endl;
	}

	bool Hangman::check()
	{
		bool tOrF = false;

		//check if letter already guessed
		for (unsigned i = 0; i < strlen(alreadyGuessed); i++)
		{
			if (alreadyGuessed[i] == m_letterGuess)
			{
				cout << "You already guessed that letter! Try again: ";
				m_letterGuess = '\0';
				i = -1;
				cin >> *this;
			}

		}
		//check if letter is in solution
		for (int i = 0; i < m_length && !tOrF; i++)
		{
			if (m_letterGuess == m_solution[i])
			{
				alreadyGuessed[guessIndex] = m_letterGuess;
				guessIndex++;
				tOrF = true;
				m_guess = true;
			}
			else
				m_guess = false;
		}
		if (m_guess == false)
		{
			alreadyGuessed[guessIndex] = m_letterGuess;
			guessIndex++;
			tries--;
		}
		
		return tOrF;
	}

	istream& Hangman::read(istream& is)
	{
		bool tOrF = false;

		while (!tOrF)
		{
			bool flag2 = false;

			if (tries)
				is >> noskipws >> m_letterGuess;

			if (m_letterGuess == '0' || !tries)
			{
				if (solve())
				{
					solved = true;
					tOrF = true;
					gameOver();
				}
				else if (tries)
				{
					cout << "INCORRECT! Enter a letter guess or press 0 to try solving again: ";
					//is.ignore(2000, '\n');
					flag2 = true;
				}
				else
				{
					tOrF = true;
					gameOver();
				}
			}
			if (!tOrF && !flag2)
			{
				if (!isalpha(m_letterGuess) || is.get() != '\n')
				{
					is.clear();
					is.ignore(2000, '\n');
					cout << "Please only enter a single letter: ";
				}
				else
					tOrF = true;

				if (islower(m_letterGuess))
					m_letterGuess = toupper(m_letterGuess);
			}
		}

		return is;
	}

	std::istream& operator>>(std::istream& istr, Hangman& src)
	{
		return src.read(istr);
	}
}
