<!--
Repository name suggestion: othello-ai-java
1-line description: Java Othello with human/AI players (Random & Greedy) plus simulation and analysis.
-->

# Othello AI (Java)

A Java Othello (Reversi) implementation with human and AI players (Random & Greedy), plus automated simulations and analysis of game fairness.

---

## ✨ Features

- **Human vs Human**, **Human vs AI**, and **AI vs AI** matchups
- Two AI strategies:
  - **Random** — picks a random legal move
  - **Greedy** — picks the move that maximizes immediate flips
- **Modular controllers** to easily swap matchup types
- **Batch simulation** to study fairness (e.g., Random vs Random, 10,000 games)
- Clean separation of **board state**, **players**, and **controllers**

---

## 🗂️ Project Structure

├── pom.xml

├── Othello.java # Main entry + orchestrator (select controller here)

├── OthelloBoard.java # Board state, move validation, flips

├── Move.java # Simple (row, col) move representation

├── PlayerHuman.java # Human player via console

├── PlayerRandom.java # Random AI agent

├── PlayerGreedy.java # Greedy AI agent

├── OthelloControllerHumanVSHuman.java # Human vs Human

├── OthelloControllerHumanVSRandom.java # Human vs Random AI

├── OthelloControllerHumanVSGreedy.java # Human vs Greedy AI

├── OthelloControllerRandomVSRandom.java # Random AI vs Random AI (simulation)

├── OthelloControllerRandomVSGreedy.java # Random AI vs Greedy AI

└── randomVsRandomReport.txt # Notes + results from large simulations

---

## ⚙️ Requirements

- **Java 22+** (matches `pom.xml`)
- **Maven 3.9+** (optional but recommended)

---

## 🚀 Getting Started

### Option A — Run with Maven (compile + run)


# build classes into target/classes
mvn -q clean package

# run the main class (default package)
java -cp target/classes Othello

# if you added a package, e.g., package app;
java -cp target/classes app.Othello

### Option B — Run with javac only
# compile all .java files into ./out
mkdir -p out
javac -d out *.java

# run (default package)
java -cp out Othello

# or, with a package (example)
java -cp out app.Othello

🎮 How to Play (Console)

The active controller prompts moves as row col (check prompts for 0- or 1-indexing).

If a player has no legal moves, their turn is skipped automatically.

Game ends when neither player can move; the board is counted and the side with more tiles wins.

🔄 Switching Matchups

Select which controller to run inside Othello.java:

OthelloControllerHumanVSHuman

OthelloControllerHumanVSRandom

OthelloControllerHumanVSGreedy

OthelloControllerRandomVSRandom

OthelloControllerRandomVSGreedy

Keep controller constructors simple (board + player instances) so you can swap strategies without touching core logic.

🧠 AI Strategies

Random: Baseline policy that picks uniformly from the legal moves.

Greedy: Heuristic policy that picks the move producing the largest immediate flip count (no lookahead).

📊 Simulation & Findings (Random vs Random)

From 10,000 automated games:

P1 win rate: ~45.358%

P2 win rate: ~50.405%

Conclusion: Under this random-play setup, Player 2 showed a slight advantage → reject H₀ (no advantage).

See randomVsRandomReport.txt for notes and hypothesis framing.

🧱 Design Notes

Separation of Concerns

OthelloBoard — rules, legal moves, flips, terminal checks

Player* — decision policy (user input vs AI)

OthelloController* — turn sequencing, I/O, and match orchestration

Data Object

Move — minimal, readable (row, col) value object

Testability

Logic in OthelloBoard and Player* enables unit tests for move validity, flip counts, and AI choices.
