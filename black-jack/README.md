# Blackjack Game ♠️♥️♣️♦️

A simple command-line **Blackjack** game implemented in **Java**. The program simulates a casino-style round where a single player competes against the dealer. It handles card dealing, turn-based play (hit / stand), Blackjack detection, and winner determination.

---

## Features
- Interactive text-based gameplay (console input/output)  
- Standard Blackjack rules: card values, Ace as 1 or 11, dealer hits until 17+  
- Automatic deck generation and shuffle (52 unique cards)  
- Immediate Blackjack detection on initial deal  
- Clear end-of-round evaluation: player win, dealer win, push (tie), busts

---

## Key Concepts Applied
- **Object-Oriented Design**: `Card`, `Deck`, `Player`, `Dealer`, `Game` classes  
- **Encapsulation & Abstraction**: clear separation of responsibilities between model and controller  
- **Testability**: logic separated into small methods (e.g., hand evaluation, Blackjack check) for unit testing  
- **Clean Code Practices**: readable methods, small functions, and documented assumptions

---

## Tools & Technologies
- **Language:** Java  
- **Build:** (optional) Maven  
- **IDE:** IntelliJ IDEA (recommended) or any Java-capable editor  
- **JDK:** Java 17+ recommended