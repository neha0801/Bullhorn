package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BULLHORN database table.
 * 
 */
@Entity
@Table(name="Bullhorn",schema="TESTDB")
@NamedQuery(name="Bullhorn.findAll", query="SELECT b FROM Bullhorn b")
public class Bullhorn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="POST_ID")
	private long postId;

	private String post;

	public Bullhorn() {
	}

	public long getPostId() {
		return this.postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

}