package com.rajeshkawali.concepts.blockchain;

import java.security.MessageDigest;
/**
 * @author Rajesh_Kawali
 *
 */
class Block {
	
	private int index;
	private String data;
	private String previousHash;
	private String hash;
	private long timestamp;

	public Block(int index, String data, String previousHash) {
		this.index = index;
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = System.currentTimeMillis();
		this.hash = calculateHash();
	}

	public String calculateHash() {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String input = this.index + this.previousHash + this.timestamp + this.data;
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int getIndex() {
		return this.index;
	}

	public String getData() {
		return this.data;
	}

	public String getPreviousHash() {
		return this.previousHash;
	}

	public String getHash() {
		return this.hash;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
}
/*
There are several benefits of using blockchain technology, including:-->

Decentralization: Blockchain is decentralized, meaning that it is not controlled by any single entity. This makes it resistant to tampering and censorship.

Security: Blockchain is secured using cryptography, making it difficult to alter the data stored on the blockchain.

Transparency: All participants in a blockchain network can view the data stored on the blockchain, making it transparent.

Immutability: Once data has been added to the blockchain, it cannot be altered, which makes it reliable and trustworthy.

Efficiency: Blockchain can help to streamline processes and reduce the need for intermediaries, which can save time and reduce costs.

Automation: Smart contracts, which are self-executing contracts with the terms of the agreement written into the code, can be used on the blockchain to automate processes.

Traceability: The ability to trace the history of an asset on the blockchain can help to improve supply chain management and increase transparency.

Interoperability: Blockchain can facilitate the exchange of data and value between different systems and organizations, improving interoperability.
*/