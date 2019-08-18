package com.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="research")
public class ResearchModel {
	
	@Id
	@Column(name="research_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int researchid;
	
	@Column(name="research_title")
	private String researchTitle;
	
	@Column(name="research_authors")
	private String researchAuthors;
	
	@Column(name="publication_year")
	private String publicationYear;
	
	@Column(name="publication_journal")
	private String publicationJournal;
	
	@Column(name="research_description")
	private String researchDescription;
	
	@Column(name="research_citation")
	private String researchCitation;
	
	@Column(name="research_domain")
	private String researchDomain;

	public int getResearchid() {
		return researchid;
	}

	public void setResearchid(int researchid) {
		this.researchid = researchid;
	}

	public String getResearchTitle() {
		return researchTitle;
	}

	public void setResearchTitle(String researchTitle) {
		this.researchTitle = researchTitle;
	}

	public String getResearchAuthors() {
		return researchAuthors;
	}

	public void setResearchAuthors(String researchAuthors) {
		this.researchAuthors = researchAuthors;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublicationJournal() {
		return publicationJournal;
	}

	public void setPublicationJournal(String publicationJournal) {
		this.publicationJournal = publicationJournal;
	}

	public String getResearchDescription() {
		return researchDescription;
	}

	public void setResearchDescription(String researchDescription) {
		this.researchDescription = researchDescription;
	}

	public String getResearchCitation() {
		return researchCitation;
	}

	public void setResearchCitation(String researchCitation) {
		this.researchCitation = researchCitation;
	}

	public String getResearchDomain() {
		return researchDomain;
	}

	public void setResearchDomain(String researchDomain) {
		this.researchDomain = researchDomain;
	}
}
