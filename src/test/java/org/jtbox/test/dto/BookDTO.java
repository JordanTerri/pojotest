package org.jtbox.test.dto;

import java.util.Date;

/**
 * Test class
 * @author JordanTerri
 *
 */
public class BookDTO extends CommonDTO {

	private String comment;

	private int isbn;

	private String title;

	private Date creationDate;

	private AuthorDTO author;

	private boolean borrowed;
	
	private long wordCount;
	
	private double priceInEuro;
	
	private float priceInEthereum;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	/**
	 * @return the wordCount
	 */
	public long getWordCount() {
		return wordCount;
	}

	/**
	 * @param wordCount the wordCount to set
	 */
	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	/**
	 * @return the priceInEuro
	 */
	public double getPriceInEuro() {
		return priceInEuro;
	}

	/**
	 * @param priceInEuro the priceInEuro to set
	 */
	public void setPriceInEuro(double priceInEuro) {
		this.priceInEuro = priceInEuro;
	}

	/**
	 * @return the priceInEthereum
	 */
	public float getPriceInEthereum() {
		return priceInEthereum;
	}

	/**
	 * @param priceInEthereum the priceInEthereum to set
	 */
	public void setPriceInEthereum(float priceInEthereum) {
		this.priceInEthereum = priceInEthereum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookDTO [comment=" + comment + ", isbn=" + isbn + ", title=" + title + ", creationDate=" + creationDate
				+ ", author=" + author + ", borrowed=" + borrowed + ", wordCount=" + wordCount + ", priceInEuro="
				+ priceInEuro + ", priceInEthereum=" + priceInEthereum + "]";
	}

}