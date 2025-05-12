#include <iostream>
#include <cmath>
#include <conio.h> // Include conio.h for _getch() function
#include <windows.h> //system
#include <stdio.h> //printf
using namespace std;

void displaySystemBanner() {
    system("cls"); // Clear the console screen
    cout << "**************************************************************************************" << endl;
    cout << "*                             CALCULATOR PROGRAM                                     *" << endl;
    cout << "*                          Developed by Mukti Jaenal                                 *" << endl;
    cout << "*                                 672023266                                          *" << endl;
    cout << "**************************************************************************************" << endl;
    cout << endl;
}

// Function to set cursor position
void gotoxy(int x, int y) {
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void loading1(){

    // Get the console screen buffer info
    CONSOLE_SCREEN_BUFFER_INFO csbi;
    GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi);
    int consoleWidth = csbi.srWindow.Right - csbi.srWindow.Left + 1;

    system("COLOR 06"); // Yellow text on black background
    system("cls");
    printf("\e[?25l");

    //Set ASCII to Print Special Char
    //Code Page 437
    SetConsoleCP(437);
    SetConsoleOutputCP(437);

    int bar1 = 177, bar2 = 219;

    // Calculate center position for the bar
    int barLength = 25;
    int barX = (consoleWidth - barLength) / 2;
    int barY = 10; // Y position for both the text and the bar

    // Set positions for text relative to the bar
    gotoxy(barX, barY - 2);
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

    // Change the color to blue text on black background after the animation
    system("COLOR 09");

    // Align the pause message to the left with the bar
    gotoxy(barX, barY + 2);
    cout << (char)1 << "!";
    system("Pause");
    
}



void performCalculation() {
    int operation;
    long long int num1, num2, result;

    displaySystemBanner();
    system("COLOR 06");

    cout << "Please select an operation:\n";
    cout << "1. Addition\n";
    cout << "2. Subtraction\n";
    cout << "3. Multiplication\n";
    cout << "4. Division\n";
    cout << "5. Modulus\n";
    cout << "6. Factorial\n";
    cout << "Enter your choice: ";
    cin >> operation;

    if (operation >= 1 && operation <= 5) {
        cout << "Enter number 1: ";
        cin >> num1;
        cout << "Enter number 2: ";
        cin >> num2;
    } else if (operation == 6) {
        cout << "Enter number: ";
        cin >> num1;
    } else {
        cout << "\nInvalid operation!" << endl;
        return;
    }

    switch (operation) {
        case 1:
            result = num1 + num2;
            cout << "\nResult: " << num1 << " + " << num2 << " = " << result << endl;
            break;
        case 2:
            result = num1 - num2;
            cout << "\nResult: " << num1 << " - " << num2 << " = " << result << endl;
            break;
        case 3:
            result = num1 * num2;
            cout << "\nResult: " << num1 << " * " << num2 << " = " << result << endl;
            break;
        case 4:
            if (num2 != 0) {
                result = num1 / num2;
                cout << "\nResult: " << num1 << " / " << num2 << " = " << result << endl;
            } else {
                cout << "\nError! Division by zero is not allowed." << endl;
                return;
            }
            break;
        case 5:
            result = num1 % num2;
            cout << "\nResult: " << num1 << " % " << num2 << " = " << result << endl;
            break;
        case 6:
            if (num1 < 0) {
                cout << "\nError! Cannot calculate factorial of a negative number." << endl;
                return;
            }
            result = 1;
            for (long long int i = 1; i <= num1; i++) {
                result *= i;
            }
            cout << "\nResult: " << num1 << "! = " << result << endl;
            break;
        default:
            cout << "\nInvalid operation!" << endl;
            return;
    }
}

int main() {
    char redo;

    do {
        loading1();
        performCalculation();

        cout << "\nDo you want to perform another calculation?" << endl;
        cout << "1. Yes\n2. No\nEnter your choice: ";
        cin >> redo;
    } while (redo == '1');

    cout << "\nThank you for using the Calculator program!\n";
    cout << "Press any key to Exit" << endl;
    getch(); // Wait for user input before exiting

    return 0;
}