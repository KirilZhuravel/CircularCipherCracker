# Circular Graph Cipher Cracker

## 📜 Project Description
This project implements a cryptanalytic tool designed to solve **Circular Graph Transposition Ciphers** without a known key (Ciphertext Only Attack).

The core goal is to demonstrate the **Space-Time Tradeoff** principle by comparing two algorithmic approaches:
1.  **Brute Force:** Exhaustive search of the graph permutations ($O(N!)$).
2.  **Rainbow Tables (Precomputed Inverse Tables):** A memory-intensive approach that drastically reduces runtime complexity to near $O(1)$ per segment lookup.

## 🚀 Key Features
* **Graph Modeling:** Java implementation of a cyclic graph topology.
* **Rainbow Table Generation:** Efficient preprocessing and storage of state permutations.
* **Heuristic Analysis:** English frequency analysis (Unigrams/Bigrams) to validate decrypted text.
* **Performance Benchmarking:** Real-time comparison between Brute Force and Lookup Table strategies.

## 🛠️ Tech Stack
* **Language:** Java 17+
* **Architecture:** OOP, Model-View-Controller (MVC)
* **Key Algorithms:** DFS/Recursion (Brute Force), Hashing (Rainbow Tables), Trie (Dictionary Lookup).