package model;

import java.util.ArrayList;

public class ManagerStudentModel {
	private ArrayList<StudentModel> listStudent;
	private String select;
	private String fileName;

	public ManagerStudentModel() {
		this.listStudent = new ArrayList<StudentModel>();
		this.select = "";
		this.fileName = "";
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public ManagerStudentModel(ArrayList<StudentModel> listStudent) {
		this.listStudent = listStudent;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<StudentModel> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<StudentModel> listStudent) {
		this.listStudent = listStudent;
	}

	public void insert(StudentModel student) {
		this.listStudent.add(student);
	}

	public void delete(StudentModel student) {
		this.listStudent.remove(student);
	}

	public void update(StudentModel student) {
		this.listStudent.remove(student);
		this.listStudent.add(student);
	}

	public boolean checkExist(StudentModel st) {
		for (StudentModel studentModel : listStudent) {
			if (studentModel.getIdStudent() == st.getIdStudent()) {
				return true;
			}
		}
		return false;
	}

}
