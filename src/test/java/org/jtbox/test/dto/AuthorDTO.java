package org.jtbox.test.dto;

import java.util.Date;
import java.util.List;

/**
 * Test class
 * @author JordanTerri
 *
 */
public class AuthorDTO extends CommonDTO {

	private String name;

	private String firstname;

	private String comment;

	private List<BookDTO> written;

	private String nationnality;

	private Date birthDate;

	private Date deathDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<BookDTO> getWritten() {
		return written;
	}

	public void setWritten(List<BookDTO> written) {
		this.written = written;
	}

	public String getNationnality() {
		return nationnality;
	}

	public void setNationnality(String nationnality) {
		this.nationnality = nationnality;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthorDTO [name=" + name + ", forename=" + firstname + ", comment=" + comment + ", written=" + written
				+ ", nationnality=" + nationnality + ", birthDate=" + birthDate + ", deathDate=" + deathDate + "]";
	}

}
