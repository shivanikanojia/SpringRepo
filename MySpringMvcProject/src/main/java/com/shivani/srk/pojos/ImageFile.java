package com.shivani.srk.pojos;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "images")

public class ImageFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aFILE_ID", unique = true, nullable = false)
	private long fileId;
	
	@Column(name = "image_name")
    private String fileName;
    
	@Lob
	@Column(name = "image_file")
	private Blob file;
	
//	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne( targetEntity = UserDetails.class)
	@JoinColumn(name = "user_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
	private UserDetails user;


/*	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}*/

	public long getFileId() {
		return fileId;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "ImageFile [fileId=" + fileId + ", fileName=" + fileName + ", file=" + file + ", user=" + user + "]";
	}

 
     
}
