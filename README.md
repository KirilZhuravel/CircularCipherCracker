# Circular Graph Cipher Cracker

![Java](https://img.shields.io/badge/Language-Java-orange)![Build](https://img.shields.io/badge/Build-Passing-brightgreen)

## 📄 Project Description
**Circular Cipher Cracker** is a cryptanalysis research project designed to explore vulnerabilities in ciphers based on circular graph topology.

The primary goal of this project is to demonstrate the classic Computer Science concept of **Space-Time Tradeoff** by comparing two distinct cracking methods:
1. **Brute Force:** A CPU-intensive, time-consuming exhaustive key search.
2. **Rainbow Tables:** An instant cracking method utilizing pre-computed data stored on disk (In Development).

## 🚀 Current Features (Stages 1-4)

### 1. Encryption Core (`cipher.logic.CipherEngine`)
- Implemented a polyalphabetic substitution algorithm based on the `CircularGraph` model.
- Supports cyclic shifts and modular arithmetic to emulate an "infinite" ring structure.
- High performance achieved by using primitive arrays (`char[]`) instead of heavy collections.

### 2. Heuristic Analysis (`cipher.logic.FitnessCalculator`)
- Automated English text recognition system.
- Utilizes **Frequency Analysis** and **Chi-Square** scoring to evaluate decryption quality.
- Enables the software to distinguish between meaningful text and random gibberish.

### 3. Brute Force Attack (`cipher.logic.BruteForceCracker`)
- Implemented a Monte Carlo method for randomized key search.
- Includes a benchmarking system: demonstrates key iteration speeds (~800k keys/sec) and proves the infeasibility of cracking long keys via brute force in reasonable time.

### 4. Data Infrastructure (`cipher.model` & `cipher.utils`)
- **Persistence:** Implemented a system for saving and loading objects (`FileIO`) using Java Serialization.
- **Candidate Model:** Data structure designed to store, rank, and sort potential decryption candidates.

---

## 🛠 Tech Stack
* **Language:** Java (Core)
* **Architecture:** Modular (Model-Logic-Utils)
* **Build System:** IntelliJ IDEA Native
* **Algorithms:** Graph Theory, Probability Theory, Monte Carlo method.

---

## 📂 Project Structure

```text
src/main/java/cipher
├── logic/                  # Algorithmic Core
│   ├── BruteForceCracker   # Logic for brute force attacks
│   ├── CipherEngine        # Encryption and decryption mechanisms
│   ├── FitnessCalculator   # Text scoring (frequency analysis)
│   └── RainbowTableManager # (In Dev) Table generation
├── model/                  # Data Structures
│   ├── CircularGraph       # The Graph Key model
│   ├── Candidate           # Decryption result container
│   └── TrieNode            # Prefix tree nodes (Dictionary)
├── utils/                  # Utilities
│   ├── FileIO              # File system operations
│   └── TextUtils           # String processing and sanitization
└── Main.java               # Entry point and integration tests
