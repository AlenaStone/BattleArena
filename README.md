# 🗡️ Battle Area - Java Console Game

Welcome to **Battle Area** – a simple text-based fighting game in Java!  
Create your characters, choose their types, and battle until only one remains standing.

---

## 🎮 How to Play

1. **Launch the game** — the menu will guide you.
2. Choose how many players (2, 3, or 4).
3. For each player:
   - Enter a name.
   - Choose a class:
     - 🧙 Mage — balanced fighter (Power: 10, Speed: 10, HP: 100)
     - 🪓 Warrior — strong and tough (Power: 5, Speed: 5, HP: 200)
     - 🏹 Archer — fast attacker (Power: 15, Speed: 15, HP: 80)
4. The fight begins! Players attack based on their speed.  
   Each hit reduces HP. When a fighter's HP reaches 0, they're out.
5. Last player standing wins! 🏆

---

## 📦 Project Structure

```bash
src/
├── at.fhj.msd/
│   ├── FightSimulation.java   # Main game logic
│   ├── Fighter.java           # Abstract base class
│   ├── Mage.java              # Mage class
│   ├── Warrior.java           # Warrior class
│   ├── Archer.java            # Archer class
```


## ✅ Features

- Menu navigation system
- Player name and type selection
- Turn-based fight simulation with random targets
- Sorted attack order by speed
- Console-based UI with clear formatting

## 🧪 Requirements

- Java 11 or higher
- No external libraries needed

## 🚀 Run

```bash
javac at/fhj/msd/*.java
java at.fhj.msd.FightSimulation
```

## 📜 License
MIT License – use freely, modify, and learn!

## 🤝 Contributing
Pull requests welcome!
Feel free to suggest improvements or new character classes.