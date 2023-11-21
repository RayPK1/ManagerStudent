package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ManagerStudentModel;
import model.ProvinceModel;
import model.StudentModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.ManagerStudentController;

import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;

public class ManagerStudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public ManagerStudentModel managerStudentModel;
	private JTextField textField_nameSearch;
	private JTable table;
	public JTextField textField_id, textField_grade3, textField_grade2, textField_grade1, textField_name,
			textField_date;
	public JComboBox comboBox_province_1;
	private JComboBox comboBox_province;
	public ButtonGroup btn_sex;
	private JLabel label_total;
	private JRadioButton RadioButton_female, RadioButton_male;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ManagerStudentView frame = new ManagerStudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerStudentView() {
		setTitle("Quản lý sinh viên");
		setFont(new Font("Arial", Font.PLAIN, 16));
		this.managerStudentModel = new ManagerStudentModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 825);

		ActionListener action = new ManagerStudentController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Arial", Font.PLAIN, 18));
		menu.add(menuOpen);

		JMenuItem menuClose = new JMenuItem("Save as");
		menuClose.addActionListener(action);
		menuClose.setFont(new Font("Arial", Font.PLAIN, 18));
		menu.add(menuClose);

		JSeparator separator = new JSeparator();
		menu.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Arial", Font.PLAIN, 18));
		menu.add(menuExit);

		JMenu about = new JMenu("About");
		menuBar.add(about);

		JMenuItem menuAbout = new JMenuItem("About me!");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		about.add(menuAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Provice = new JLabel("BirthPlace");
		Provice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Provice.setBounds(10, 14, 89, 51);
		contentPane.add(Provice);

		JLabel Idstudent = new JLabel("Name Student");
		Idstudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Idstudent.setBounds(263, 14, 89, 51);
		contentPane.add(Idstudent);

		textField_nameSearch = new JTextField();
		textField_nameSearch.setColumns(10);
		textField_nameSearch.setBounds(350, 14, 89, 51);
		contentPane.add(textField_nameSearch);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(action);
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFind.setBounds(475, 14, 89, 51);
		contentPane.add(btnFind);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(action);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(575, 14, 89, 51);
		contentPane.add(btnReset);

		comboBox_province = new JComboBox();
		ArrayList<ProvinceModel> list = ProvinceModel.getListProvince();
		comboBox_province.addItem("___");
		for (ProvinceModel province : list) {
			comboBox_province.addItem(province.getNameProvince());
		}
		comboBox_province.setBounds(92, 11, 157, 51);
		contentPane.add(comboBox_province);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 90, 665, 10);
		contentPane.add(separator_1);

		JLabel lblListStudent = new JLabel("ListStudent");
		lblListStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListStudent.setBounds(10, 90, 109, 51);
		contentPane.add(lblListStudent);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID Student", "Name", "BirthPlace", "Date", "Sex", "Grade 1", "Grade 2", "Grade 3" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(6).setPreferredWidth(76);
//		table.setBounds(10, 153, 664, 288);
//		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(11, 135, 664, 288);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 434, 665, 10);
		contentPane.add(separator_1_1);

		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInformation.setBounds(10, 434, 109, 51);
		contentPane.add(lblInformation);

		JPanel jPanel_info = new JPanel();
		jPanel_info.setBounds(10, 475, 665, 203);
		contentPane.add(jPanel_info);
		jPanel_info.setLayout(new GridLayout(0, 4, 10, 10));

		JLabel info_id = new JLabel("ID");
		info_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_id);

		textField_id = new JTextField();
		textField_id.setColumns(10);
		jPanel_info.add(textField_id);

		JLabel info_grade1 = new JLabel("Grade 1");
		info_grade1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_grade1);

		textField_grade1 = new JTextField();
		textField_grade1.setColumns(10);
		jPanel_info.add(textField_grade1);

		JLabel info_name = new JLabel("Name");
		info_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_name);

		textField_name = new JTextField();
		textField_name.setColumns(10);
		jPanel_info.add(textField_name);

		JLabel info_grade2 = new JLabel("Grade 2");
		info_grade2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_grade2);

		textField_grade2 = new JTextField();
		textField_grade2.setColumns(10);
		jPanel_info.add(textField_grade2);

		JLabel info_province = new JLabel("BirthPlace");
		info_province.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_province);
		comboBox_province_1 = new JComboBox();
		comboBox_province_1.addItem("");
		for (ProvinceModel province : list) {
			comboBox_province_1.addItem(province.getNameProvince());
		}
		jPanel_info.add(comboBox_province_1);

		JLabel info_grade3 = new JLabel("Grade 3");
		info_grade3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_grade3);

		textField_grade3 = new JTextField();
		textField_grade3.setColumns(10);
		jPanel_info.add(textField_grade3);

		JLabel info_date = new JLabel("Date");
		info_date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_date);

		textField_date = new JTextField();
		textField_date.setColumns(10);
		jPanel_info.add(textField_date);

		JLabel info_gradeTotal = new JLabel("Total");
		info_gradeTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_gradeTotal);

		label_total = new JLabel("");
		label_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(label_total);

		JLabel info_sex = new JLabel("Sex");
		info_sex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel_info.add(info_sex);

		btn_sex = new ButtonGroup();
		JPanel panel_sex = new JPanel();
		jPanel_info.add(panel_sex);

		RadioButton_male = new JRadioButton("Male");
		RadioButton_male.setActionCommand("Male");
		panel_sex.add(RadioButton_male);
		RadioButton_male.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_sex.add(RadioButton_male);

		RadioButton_female = new JRadioButton("Female");
		RadioButton_female.setActionCommand("Female");
		panel_sex.add(RadioButton_female);
		RadioButton_female.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_sex.add(RadioButton_female);

		JPanel panel_btn = new JPanel();
		panel_btn.setBounds(20, 702, 643, 40);
		contentPane.add(panel_btn);
		panel_btn.setLayout(new GridLayout(1, 0, 20, 0));

		JButton btn_insert = new JButton("Insert");
		btn_insert.addActionListener(action);
		btn_insert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_btn.add(btn_insert);

		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(action);
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_btn.add(btn_delete);

		JButton btn_edit = new JButton("Edit");
		btn_edit.addActionListener(action);
		btn_edit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_btn.add(btn_edit);

		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(action);
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_btn.add(btn_save);

		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(action);
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_btn.add(btn_cancel);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 689, 665, 10);
		contentPane.add(separator_1_1_1);

	}

	public void DelForm() {
		textField_id.setText("");
		textField_name.setText("");
		textField_date.setText("");
		textField_grade1.setText("");
		textField_grade2.setText("");
		textField_grade3.setText("");
		label_total.setText("");
		comboBox_province_1.setSelectedIndex(-1);
		btn_sex.clearSelection();
	}

	public void DelSearch() {
		textField_nameSearch.setText("");
		comboBox_province.setSelectedIndex(-1);
	}

	public void addStudent(StudentModel sm) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		model_table.addRow(new Object[] { sm.getIdStudent(), sm.getNameStudent(), sm.getHometown(),
				simpleDateFormat.format(sm.getBirth()).toString(), (sm.isSex()) ? "Male" : "Female", sm.getGrade1(),
				sm.getGrade2(), sm.getGrade3() });
	}

	public void insertOrUpdateStudent(StudentModel st) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.managerStudentModel.checkExist(st)) {
			this.managerStudentModel.insert(st);
			this.addStudent(st);
		} else {
			this.managerStudentModel.update(st);
			int countRow = model_table.getRowCount();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (int i = 0; i < countRow; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(st.getIdStudent() + "")) {
					model_table.setValueAt(st.getIdStudent() + "", i, 0);
					model_table.setValueAt(st.getNameStudent() + "", i, 1);
					model_table.setValueAt(st.getHometown() + "", i, 2);
					model_table.setValueAt(simpleDateFormat.format(st.getBirth()).toString(), i, 3);
					model_table.setValueAt((st.isSex()) ? "Male" : "Female", i, 4);
					model_table.setValueAt(st.getGrade1() + "", i, 5);
					model_table.setValueAt(st.getGrade2() + "", i, 6);
					model_table.setValueAt(st.getGrade3() + "", i, 7);
				}
			}
		}
	}

	public StudentModel getStudent(int i_row) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.getValueAt(i_row, 0);

		int idS = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String nameS = model_table.getValueAt(i_row, 1) + "";
		ProvinceModel province = ProvinceModel.getProvinceByName(model_table.getValueAt(i_row, 2) + "");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = simpleDateFormat.parse((String) model_table.getValueAt(i_row, 3));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sex_select = (String) model_table.getValueAt(i_row, 4);
		boolean sex = "Male".equals(sex_select);
		float grade1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float grade2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float grade3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		StudentModel sm = new StudentModel(idS, nameS, province, date, sex, grade1, grade2, grade3);
		return sm;
	}

	public void showStudentSelected() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		StudentModel sm = getStudent(i_row);

		this.textField_id.setText(sm.getIdStudent() + "");
		this.textField_name.setText(sm.getNameStudent());
		this.comboBox_province_1.setSelectedIndex(sm.getHometown().getIdProvince() + 1);
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
		this.textField_date.setText(simpleDateFormat2.format(sm.getBirth()));
		if (sm.isSex()) {
			RadioButton_male.setSelected(true);
		} else {
			RadioButton_female.setSelected(true);
		}
		this.textField_grade1.setText(sm.getGrade1() + "");
		this.textField_grade2.setText(sm.getGrade2() + "");
		this.textField_grade3.setText(sm.getGrade3() + "");
		this.label_total.setText(sm.getGrade1() + sm.getGrade2() + sm.getGrade3() + "");
	}

	public void deleteSelectedStudent() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int selected = JOptionPane.showConfirmDialog(this, "Do you really want to delete this?");
		if (selected == JOptionPane.YES_OPTION) {
			StudentModel sm = getStudent(i_row);
			this.managerStudentModel.delete(sm);
			model_table.removeRow(i_row);
		}

	}

	public void addStudent() {
		int idS = Integer.valueOf(this.textField_id.getText());
		String nameS = this.textField_name.getText();
		int place = this.comboBox_province_1.getSelectedIndex();
		ProvinceModel province = ProvinceModel.getProvinceById(place);
		Date date = new Date(this.textField_date.getText());
		String sex_select = this.btn_sex.getSelection().getActionCommand();
		System.out.println(sex_select);
		boolean sex = "Male".equals(sex_select);
		float grade1 = Float.valueOf(this.textField_grade1.getText());
		float grade2 = Float.valueOf(this.textField_grade2.getText());
		float grade3 = Float.valueOf(this.textField_grade3.getText());

		StudentModel st = new StudentModel(idS, nameS, province, date, sex, grade1, grade2, grade3);
		this.insertOrUpdateStudent(st);
	}

	public void search() {

		this.resetSearch();

		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String nameStudent = this.textField_nameSearch.getText();
		int place = this.comboBox_province.getSelectedIndex();
		int countRow = model_table.getRowCount();
		Set<Integer> row_unmatch = new TreeSet<>();
		if (place > 0) {
			ProvinceModel province = ProvinceModel.getProvinceById(place);
			System.out.println("Province: " + province.toString());
			for (int i = 0; i < countRow; i++) {
				String p = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!p.equals(province.getNameProvince())) {
					row_unmatch.add(Integer.valueOf(id));
				}
			}
		}
		if (nameStudent.length() > 0) {
			for (int i = 0; i < countRow; i++) {
				String name = model_table.getValueAt(i, 1) + "";

				String id = model_table.getValueAt(i, 0) + "";
				if (name.toLowerCase().indexOf(nameStudent.toLowerCase()) < 0) {
					row_unmatch.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer integer : row_unmatch) {
			System.out.println(integer);
			for (int i = 0; i < countRow; i++) {
				int idInTable = Integer.valueOf(model_table.getValueAt(i, 0) + "");
				if (idInTable == (integer)) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

	}

	public void resetSearch() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		while (true) {
			int row_count = model_table.getRowCount();
			if (row_count == 0) {
				break;
			} else {
				model_table.removeRow(0);
			}
		}
		for (StudentModel sm : this.managerStudentModel.getListStudent()) {
			this.addStudent(sm);
		}
	}

	public void showAbout() {
		JOptionPane.showMessageDialog(this, "Tôi là Hoàng Xuân Sang!" + "\nĐây là phần mềm quản lý sinh viên.");

	}

	public void exit() {
		int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát khỏi chương trình",
				"Thoát chương trình", JOptionPane.YES_NO_OPTION);

		if (choose == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void actionSave() {
		if (this.managerStudentModel.getFileName().length() > 0) {
			saveFile(this.managerStudentModel.getFileName());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	private void saveFile(String path) {
		try {
			this.managerStudentModel.setFileName(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (StudentModel sm : this.managerStudentModel.getListStudent()) {
				oos.writeObject(sm);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			resetSearch();
		}
	}

	private void openFile(File file) {
		ArrayList<StudentModel> arr = new ArrayList<StudentModel>();
		try {
			this.managerStudentModel.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			StudentModel sm = null;
			while((sm = (StudentModel) ois.readObject()) !=null){
				arr.add(sm);
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.managerStudentModel.setListStudent(arr);
	}
	}
