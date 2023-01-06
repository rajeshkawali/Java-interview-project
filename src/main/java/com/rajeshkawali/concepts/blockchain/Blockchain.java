package com.rajeshkawali.concepts.blockchain;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
public class Blockchain {
	/*
	Blockchain is a decentralized, distributed digital ledger that is 
	used to record transactions across a network of computers. 
	It is often used to securely and transparently record financial transactions, 
	but it can also be used to store other types of data, such as contracts and records.
	*/
	private List<Block> chain;

	public Blockchain() {
		this.chain = new ArrayList<>();
		this.chain.add(createGenesisBlock());
	}

	public Block createGenesisBlock() {
		return new Block(0, "Genesis block", "0");
	}

	public Block getLatestBlock() {
		return this.chain.get(this.chain.size() - 1);
	}

	public void addBlock(Block block) {
		block.setPreviousHash(getLatestBlock().getHash());
		block.setHash(block.calculateHash());
		this.chain.add(block);
	}

	public boolean isChainValid() {
		for (int i = 1; i < this.chain.size(); i++) {
			Block currentBlock = this.chain.get(i);
			Block previousBlock = this.chain.get(i - 1);
			if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
				return false;
			}
			if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Blockchain blockchain = new Blockchain();
		blockchain.addBlock(new Block(1, "Transaction 1", blockchain.getLatestBlock().getHash()));
		blockchain.addBlock(new Block(2, "Transaction 2", blockchain.getLatestBlock().getHash()));
		blockchain.addBlock(new Block(3, "Transaction 3", blockchain.getLatestBlock().getHash()));

		System.out.println("Is blockchain valid? " + blockchain.isChainValid());

		blockchain.getLatestBlock().setData("Tampered transaction");
		System.out.println("Is blockchain valid? " + blockchain.isChainValid());
	}
}
/*
A blockchain is a way of storing data in a secure and transparent manner. 
It consists of a series of blocks, each of which contains a list of transactions. 
Once a block is added to the chain, the transactions it contains cannot be altered.

Each block in the chain also contains a unique code, called a hash, which is generated 
using the data in the block and the hash of the previous block. This creates a 
chain of blocks that is secured using cryptography, making it difficult to alter the data in any of the blocks.

New transactions are added to the blockchain through a process called mining, 
in which network participants compete to solve a cryptographic puzzle. 
The first participant to solve the puzzle is rewarded with a new block 
added to the chain, and this process ensures the integrity and security of the blockchain.

The decentralized nature of the blockchain means that it is not controlled 
by any single entity, and this makes it resistant to tampering and censorship. 
It is also transparent, as all participants in the network can view the contents 
of the blockchain. This makes it an attractive technology for a wide range of 
applications, including financial transactions, supply chain management, and voting systems.
*/