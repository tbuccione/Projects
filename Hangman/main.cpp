#include <iostream>
#include "Hangman.h"
using namespace std;
using namespace tb;

int main() {
	//Enter the solution and category below
	Hangman One("pie", "food");

	for (int i = 0; tries > 0 && !One.getSolved(); i++)
	{
		if (tries == 6)
			One.buildHangman();
		
		cin >> One;
		if (!One.getSolved())
		{
			One.check();
			One.buildHangman();
		}
	}

	if (tries == 0)
		cin >> One;
	
	return 0;
}