package at.badgateway.osgi.integration.mongodb.domain;

import java.util.Set;

import lombok.Data;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Data
public class User {
	
	@Id
	private ObjectId id;
	
	
	private String firstname;
	private String lastname;
	private byte[] image;

	private Set<String> tags;
	
	@CreatedDate
	private DateTime created; 
	
	@LastModifiedDate
	private DateTime modified; 
	
	@CreatedBy
	private String creator; 
	
	@LastModifiedBy
	private String modifiedBy;
}
