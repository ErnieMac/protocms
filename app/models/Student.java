package models;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

import play.data.validation.Required;
import play.modules.morphia.Model;


/* this class has Student related details */
@Entity
public class Student extends Model {
	
	@Id
	public ObjectId objectId;
	
	// User details, user details are fetched as Student.user.userId; 
	@Required
	@Embedded
	public User user;	
	
	// personalDetails
	@Embedded
	public PersonalDetails personalDetails;
	
	// enrolment details
	@Embedded
	public EnrolmentDetails enrolmentDetails;

	// scores of the student
	@Embedded
	public List<Scores> scores;
	
	// Course details - Reference, not embedded - Nope. just _id
	public ObjectId currentCourse;
	
//	public ObjectId [] previousCourses;
	
	//overridden methods, required for Play-Morphia
	String name;	
	@Override public Object getId() {return objectId;}
    @Override protected void setId_(Object id) {}
    protected static Object processId_(Object id) {return id;}
	

}
