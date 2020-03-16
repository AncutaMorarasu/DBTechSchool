
public class Student {
	private String lastName;
	private String firstName;
	private String email;
	private Integer credits;
	private Double average;


public Student (String lastName, String firstName, String email, int credits, double average) {
	this.lastName = lastName;
	this.firstName = firstName;
	this.email = email;
	this.credits = credits;
	this.average = average;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		 this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		 this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
	@Override
    public String toString() {
        return this.getLastName() + ", " + this.getFirstName() + ", " + this.getEmail() + ", " + this.getCredits()+ ", " + this.getAverage() + "; \n";
        }
}