# Blockchain-Based File Integrity Logger

## About

This project stores log entries as a chain of blocks inside a JSON file, where each block is linked to the one before it through a SHA-256 hash. Rather than writing data as plain, disconnected lines, every new entry is hashed using its own data, the previous block's hash, and a timestamp. That hash is then stored as the block's `currHash`.

Because each block's hash depends on the data and hash of the block before it, the entries form a chain. If any value in any block is altered after the fact, the hashes no longer line up with what they should be, and this becomes detectable on verification.

## Core Idea

Each block contains:

- An index (its position in the chain)
- The data
- The previous block's hash
- A timestamp
- Its own hash, derived from the above three values

Verification works by recomputing each block's hash from its stored data, previous hash, and timestamp, then comparing the result against the hash that was saved when the block was written. A mismatch means something in the chain has changed since it was written.

## What It Does

- Creates a new JSON file to hold the blockchain
- Appends new data entries, automatically computing the index, previous hash, timestamp, and current hash for each one
- Verifies an existing file by walking through the chain and checking that every block's hash still matches its contents

## Why This Matters

This is a practical example of using chained hashes for tamper detection, the same principle that underpins blockchains and tamper-evident logs more broadly. It can serve as a basis for append-only records where it should be possible to confirm, after the fact, whether the data has been modified since it was written.