package at.badgateway.helloworld.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;
	private String lastname;

	@CreatedDate
	private Long createdDate;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private Long lastModifiedDate;

	@LastModifiedBy
	private String lastModifiedBy;

}
