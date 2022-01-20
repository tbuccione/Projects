#pragma once
#ifndef _TB_HANGMAN
#define _TB_HANGMAN
namespace tb
{

	extern int tries;
	extern int numChars;

	class Hangman
	{
		char* m_solution{};
		char* m_category{};
		char m_letterGuess{};
		char alreadyGuessed[27]{};
		bool m_guess = false;
		bool solved = false;
	public:
		Hangman(const char* = nullptr, const char* category = "NOT ENTERED");
		Hangman(const Hangman&) = delete;
		Hangman& operator=(const Hangman&) = delete;
		virtual void buildHangman();
		bool solve()const;
		bool getSolved()const;
		void upperCase(char*);
		virtual ~Hangman();
		void gameOver();
		bool check();
		std::istream& read(std::istream&);
	};
	std::istream& operator>>(std::istream&, Hangman&);

}
#endif

