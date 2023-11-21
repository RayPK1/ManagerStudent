package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StudentModel implements Serializable {
	private int idStudent;
	private String nameStudent;
	private ProvinceModel hometown;
	private Date birth;
	private boolean sex;
	private float grade1,grade2,grade3;
	public StudentModel() {
	}
	public StudentModel(int idStudent, String nameStudent, ProvinceModel hometown, Date birth, boolean sex,
			float grade1, float grade2, float grade3) {
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.hometown = hometown;
		this.birth = birth;
		this.sex = sex;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getNameStudent() {
		return nameStudent;
	}
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}
	public ProvinceModel getHometown() {
		return hometown;
	}
	public void setHometown(ProvinceModel hometown) {
		this.hometown = hometown;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public float getGrade1() {
		return grade1;
	}
	public void setGrade1(float grade1) {
		this.grade1 = grade1;
	}
	public float getGrade2() {
		return grade2;
	}
	public void setGrade2(float grade2) {
		this.grade2 = grade2;
	}
	public float getGrade3() {
		return grade3;
	}
	public void setGrade3(float grade3) {
		this.grade3 = grade3;
	}
	@Override
	public String toString() {
		return "StudentModel [idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", hometown=" + hometown
				+ ", birth=" + birth + ", sex=" + sex + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3="
				+ grade3 + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(birth, grade1, grade2, grade3, hometown, idStudent, nameStudent, sex);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentModel other = (StudentModel) obj;
		return Objects.equals(birth, other.birth) && Float.floatToIntBits(grade1) == Float.floatToIntBits(other.grade1)
				&& Float.floatToIntBits(grade2) == Float.floatToIntBits(other.grade2)
				&& Float.floatToIntBits(grade3) == Float.floatToIntBits(other.grade3)
				&& Objects.equals(hometown, other.hometown) && idStudent == other.idStudent
				&& Objects.equals(nameStudent, other.nameStudent) && sex == other.sex;
	}
	
	
}
