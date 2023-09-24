package com.fapethedev.ogine.controller.form;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fapethedev.ogine.model.database.entities.Speciality;
import com.fapethedev.ogine.model.database.entities.Student;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.entities.Institut;
import com.fapethedev.ogine.model.database.entities.Level;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.Placeholder;
import com.fapethedev.ogine.view.menu.MainMenu;
import com.toedter.calendar.JYearChooser;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class RegisterUpdateController
{
	public synchronized static void confirm(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		
		var pp = owner.getRegisterClientProfile();
		var sB = owner.getRegisterStudentBox();
		var iB = owner.getRegisterInstitutBox();
		var lB = owner.getRegisterLevelBox();
		var spB = owner.getRegisterSpecialityBox();
		var matriF = owner.getRegisterMatriculeField();
		var yearF = owner.getYearField();
		
		var lastF = owner.getRegisterLastnameField();
		var firsF = owner.getRegisterFirstnameField();
		var birtF = owner.getRegisterBirthField();
		var sexlF = owner.getRegisterSexField();
		var cniF = owner.getRegisterCniField();
		var phonF = owner.getRegisterPhonenumberField();
		var addrF = owner.getRegisterAddressField();
		var table = owner.getDataTable();
		var but = owner.getRegisterUpdate();
		var but1 = owner.getRegisterValidate();
		
		int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.CONFIRM_UPDATE_INFO_MSG),
					Message.CONFIRM_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
		if(choice == JOptionPane.YES_OPTION)
		{
			if(sB.getSelectedItem() == null || yearF.getYear() <= 0 || iB.getSelectedItem() == null 
					||lB.getSelectedItem() == null || spB.getSelectedItem() == null|| matriF.getText().isEmpty()
					||matriF.getText().compareTo(matriF.getToolTipText()) == 0)
			{
				JOptionPane.showMessageDialog
				(		
						pan,
						new Message(Message.ALL_OPTION_MISSING_MSG),
						Message.DEFAULT_TITLE_MSG,
						JOptionPane.WARNING_MESSAGE,
						Iconifier.warningIcon
				);
				if(sB.getSelectedItem() == null)
				{
					sB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
				}
				if(yearF.getYear() <= 0)
				{
					yearF.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
				}
				if(iB.getSelectedItem() == null)
				{
					iB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
				}
				if(lB.getSelectedItem() == null)
				{
					lB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
				}
				if(spB.getSelectedItem() == null)
				{
					spB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
				}
				if(matriF.getText().isEmpty() || matriF.getText().compareTo(matriF.getToolTipText()) == 0)
				{
					matriF.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
				}
			}
			else
			{
				var stu = (Student)sB.getSelectedItem();
				var ist = (Institut)iB.getSelectedItem();
				var lvl = (Level)lB.getSelectedItem();
				var spe = (Speciality)spB.getSelectedItem();
				var mat = matriF.getText();
				var yea = yearF.getYear();
				
				try
				{
//					var it1 = StudentManager.getInstance().getId(stu);
//					var it2 = InstitutManager.getSingleton().getId(ist);
//					var it3 = LevelManager.getSingleton().getId(lvl);
//					var it4 = SpecialityManager.getSingleton().getId(spe);
//
//					int i = table.getSelectedRow();
//					var tableMatri = table.getModel().getValueAt(i, 1).toString();
//					var lN = table.getModel().getValueAt(i, 2).toString();
//					var fN = table.getModel().getValueAt(i, 3).toString();
//					Student oldStudent = new Student(null, lN, fN, null, null, null, null, null, null, null ,null, null, null, null, null, null, null, null, null);
//					int newID =  StudentManager.getInstance().getId(oldStudent);
//					Register oldRegister = new Register(tableMatri, 0, newID, 0, 0, 0);
//					SchoolRegister.getSingleton().updateRegistredStudent(oldRegister, new Register(mat, yea, it1, it2, it3, it4));
					
					sB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
					iB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
					lB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
					spB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
					yearF.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
					matriF.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
					lastF.setDefaultBorderColor(Color.GREEN);
					firsF.setDefaultBorderColor(Color.GREEN);
					birtF.setDefaultBorderColor(Color.GREEN);
					sexlF.setDefaultBorderColor(Color.GREEN);
					cniF.setDefaultBorderColor(Color.GREEN);
					phonF.setDefaultBorderColor(Color.GREEN);
					addrF.setDefaultBorderColor(Color.GREEN);

					JOptionPane.showMessageDialog
					(
						pan,
						new Message(Message.UPDATE_COMPLETE_MSG),
						Message.DEFAULT_TITLE_MSG,
						JOptionPane.INFORMATION_MESSAGE,
						Iconifier.confirmIcon
					);
					
					sB.setBorder(new JComboBox<>().getBorder());
					iB.setBorder(new JComboBox<>().getBorder());
					lB.setBorder(new JComboBox<>().getBorder());
					spB.setBorder(new JComboBox<>().getBorder());
					yearF.setBorder(new JYearChooser().getBorder());
					matriF.setBorder(new JTextField().getBorder());
					lastF.setDefaultBorderColor(Color.BLACK);
					firsF.setDefaultBorderColor(Color.BLACK);
					birtF.setDefaultBorderColor(Color.BLACK);
					sexlF.setDefaultBorderColor(Color.BLACK);
					cniF.setDefaultBorderColor(Color.BLACK);
					phonF.setDefaultBorderColor(Color.BLACK);
					addrF.setDefaultBorderColor(Color.BLACK);
					pp.setIcon(Iconifier.clientIcon);
					lastF.setText(Message.LAST_NAME);
					firsF.setText(Message.FIRST_NAME);
					birtF.setText(Message.BIRTH_TAG);
					cniF.setText(Message.CNI_TAG);
					sexlF.setText(Message.SEX_TAG);
					phonF.setText(Message.PHONE_TAG);
					addrF.setText(Message.ADDR_TAG);
					
					Placeholder.addPlaceholderStyle(lastF);
					Placeholder.addPlaceholderStyle(firsF);
					Placeholder.addPlaceholderStyle(cniF);
					Placeholder.addPlaceholderStyle(birtF);
					Placeholder.addPlaceholderStyle(sexlF);
					Placeholder.addPlaceholderStyle(phonF);
					Placeholder.addPlaceholderStyle(addrF);
					Placeholder.defaultFGetPlaceholder(lastF);
					Placeholder.defaultFGetPlaceholder(firsF);
					Placeholder.defaultFGetPlaceholder(cniF);
					Placeholder.defaultFGetPlaceholder(birtF);
					Placeholder.defaultFGetPlaceholder(sexlF);
					Placeholder.defaultFGetPlaceholder(phonF);
					Placeholder.defaultFGetPlaceholder(addrF);
				}
				catch (Exception e)
				{
					var errMsg = e.getMessage();
					JOptionPane.showMessageDialog
					(		
							pan,
							new Message(errMsg),
							Message.ERROR_TITLE_MSG,
							JOptionPane.ERROR_MESSAGE,
							Iconifier.errorIcon
					);
				}
				
				but.setEnabled(false);
				but1.setEnabled(true);
			}
		}
	}
}
