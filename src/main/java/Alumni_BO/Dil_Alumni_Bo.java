package Alumni_BO;

public class Dil_Alumni_Bo {

	
	public Dil_Alumni_Bo( String reg_no, String name, String email, String mob, String aadhar, String stream,
			String course, String join_year, String passout_year, String profession, String gender) {
		super();
	
		Reg_no = reg_no;
		Name = name;
		Email = email;
		Mob = mob;
		Aadhar = aadhar;
		Stream = stream;
		Course = course;
		Join_year = join_year;
		Passout_year = passout_year;
		Profession = profession;
		Gender = gender;
	}
	public Dil_Alumni_Bo() {
		super();
		
	}
	private int ID;
	 private String Reg_no;
	 private String Name;
	 private String Email;
	 private String Mob;
	 private String Aadhar;
	 private String Stream;
	 private String Course;
	 private String Join_year;
	 private String Passout_year;
	 private String Profession;
	 private String Gender;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getReg_no() {
		return Reg_no;
	}
	public void setReg_no(String reg_no) {
		Reg_no = reg_no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMob() {
		return Mob;
	}
	public void setMob(String mob) {
		Mob = mob;
	}
	public String getAadhar() {
		return Aadhar;
	}
	public void setAadhar(String aadhar) {
		Aadhar = aadhar;
	}
	public String getStream() {
		return Stream;
	}
	public void setStream(String stream) {
		Stream = stream;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getJoin_year() {
		return Join_year;
	}
	public void setJoin_year(String join_year) {
		Join_year = join_year;
	}
	public String getPassout_year() {
		return Passout_year;
	}
	public void setPassout_year(String passout_year) {
		Passout_year = passout_year;
	}
	public String getProfession() {
		return Profession;
	}
	public void setProfession(String profession) {
		Profession = profession;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	
	
	public String toString() 
	{
		return "Dil_Alumni_Bo [ID=" + ID + ", Reg_no=" + Reg_no + ", Name=" + Name + ", Email=" + Email + ", Mob=" + Mob
				+ ", Aadhar=" + Aadhar + ", Stream=" + Stream + ", Course=" + Course + ", Join_year=" + Join_year
				+ ", Passout_year=" + Passout_year + ", Profession=" + Profession + ", Gender=" + Gender + "]";
	}
	 
	 
	 
}