#include <iostream>
#include <windows.h> //system
#include <stdio.h> //printf
using namespace std;

// Function to set cursor position
void gotoxy(int x, int y) {
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void loading(){

    system("COLOR 06");
    system("cls");
    printf("\e[?25l");

    //Set ASCII to Print Special Char
    //Code Page 437
    SetConsoleCP(437);
    SetConsoleOutputCP(437);

    int bar1 = 177, bar2 = 219;

    // Set the coordinates for the loading text and bar
    int loadingTextX = 16; // X position for "Loading..."
    int barX = 16; // X position for the loading bar
    int barY = 10; // Y position for both the text and the bar

    gotoxy(loadingTextX, barY - 2);
    cout << "Loading...";

    gotoxy(barX, barY);

    for (int i = 0; i < 25; i++)
        cout << (char)bar1;
        gotoxy(barX, barY);
        cout.flush(); // Ensure all output is written

    for (int i = 0; i < 25; i++) {
        gotoxy(barX + i, barY);
        cout << (char)bar2;
        Sleep(150);
    }

    gotoxy(barX + 26, barY);
    cout << "\n\t\t\t\t" << (char)1 << "!";
    system("Pause");

}

int main(){
    loading();

    return 0;
}
