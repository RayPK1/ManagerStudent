package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

import model.ProvinceModel;
import model.StudentModel;
import view.ManagerStudentView;

public class ManagerStudentController implements ActionListener{
	public ManagerStudentView view;
	
	public ManagerStudentController(ManagerStudentView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Insert")) {
			this.view.DelForm();
			this.view.managerStudentModel.setSelect("Insert");
		}else if (command.equals("Save")) {
			try {
				this.view.addStudent();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}else if (command.equals("Edit")) {
			this.view.showStudentSelected();
		}else if (command.equals("Delete")) {
			this.view.deleteSelectedStudent();
		}else if (command.equals("Cancel")) {
			this.view.DelForm();
		}else if (command.equals("Find")) {
			this.view.search();
		}else if (command.equals("Reset")) {
			this.view.resetSearch();
			this.view.DelSearch();
		}else if (command.equals("About me!")) {
			this.view.showAbout();
		}else if (command.equals("Exit")) {
			this.view.exit();
		}else if (command.equals("Save as")) {
			this.view.actionSave();
		}else if (command.equals("Open")) {
			this.view.actionOpen();
		}
	}

}
