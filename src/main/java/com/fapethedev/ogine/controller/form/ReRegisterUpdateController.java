//package com.ogine.controller.form;
//
//import java.awt.Color;
//
//import javax.swing.BorderFactory;
//import javax.swing.JComboBox;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//
//import com.ogine.model.database.InstitutManager;
//import com.ogine.model.database.LevelManager;
//import com.ogine.model.database.SchoolRegister;
//import com.ogine.model.database.SpecialityManager;
//import com.ogine.model.database.StudentManager;
//import com.ogine.model.database.entities.Institut;
//import com.ogine.model.database.entities.Level;
//import com.ogine.model.database.entities.Register;
//import com.ogine.model.database.entities.Speciality;
//import com.ogine.model.database.entities.Student;
//import com.ogine.utilities.Iconifier;
//import com.ogine.utilities.Placeholder;
//import com.ogine.view.component.label.Message;
//import com.ogine.view.menu.MainMenu;
//import com.toedter.calendar.JYearChooser;
//
///**
// * @author FATIGBA Abiola Pierre-Edy
// *
// */
//public class ReRegisterUpdateController
//{
//	public synchronized static void confirm(MainMenu owner)
//	{
//		var pan = owner.getCenterpane();
//		
//		var pp = owner.getReRegisterClientProfile();
//		var sB = owner.getReRegisterStudentBox();
//		var iB = owner.getReRegisterInstitutBox();
//		var lB = owner.getReRegisterLevelBox();
//		var spB = owner.getReRegisterSpecialityBox();
//		var matriF = owner.getReRegisterMatriculeField();
//		var yearF = owner.getReRegisterYearField();
//		
//		var lastF = owner.getReRegisterLastnameField();
//		var firsF = owner.getReRegisterFirstnameField();
//		var birtF = owner.getReRegisterBirthField();
//		var sexlF = owner.getReRegisterSexField();
//		var cniF = owner.getReRegisterCniField();
//		var phonF = owner.getReRegisterPhonenumberField();
//		var addrF = owner.getReRegisterAddressField();
//		var table = owner.getDataTable();
//		var but = owner.getReRegisterUpdate();
//		var but1 = owner.getReRegisterValidate();
//		
//		int choice = JOptionPane.showConfirmDialog
//				(
//					pan,
//					new Message(Message.CONFIRM_UPDATE_INFO_MSG),
//					Message.CONFIRM_TITLE,
//					JOptionPane.YES_NO_OPTION,
//					JOptionPane.QUESTION_MESSAGE,
//					Iconifier.questionIcon
//				);
//		if(choice == JOptionPane.YES_OPTION)
//		{
//			if(sB.getSelectedItem() == null || yearF.getYear() <= 0 || iB.getSelectedItem() == null 
//					||lB.getSelectedItem() == null || spB.getSelectedItem() == null|| matriF.getText().isEmpty()
//					||matriF.getText().compareTo(matriF.getToolTipText()) == 0)
//			{
//				JOptionPane.showMessageDialog
//				(		
//						pan,
//						new Message(Message.ALL_OPTION_MISSING_MSG),
//						Message.DEFAULT_TITLE_MSG,
//						JOptionPane.WARNING_MESSAGE,
//						Iconifier.warningIcon
//				);
//				if(sB.getSelectedItem() == null)
//				{
//					sB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
//				}
//				if(yearF.getYear() <= 0)
//				{
//					yearF.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
//				}
//				if(iB.getSelectedItem() == null)
//				{
//					iB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
//				}
//				if(lB.getSelectedItem() == null)
//				{
//					lB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
//				}
//				if(spB.getSelectedItem() == null)
//				{
//					spB.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
//				}
//				if(matriF.getText().isEmpty() || matriF.getText().compareTo(matriF.getToolTipText()) == 0)
//				{
//					matriF.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
//				}
//			}
//			else
//			{
//				var stu = (Student)sB.getSelectedItem();
//				var ist = (Institut)iB.getSelectedItem();
//				var lvl = (Level)lB.getSelectedItem();
//				var spe = (Speciality)spB.getSelectedItem();
//				var mat = matriF.getText();
//				var yea = yearF.getYear();
//				
//				try
//				{
//					var it1 = StudentManager.getSingleton().getId(stu);
//					var it2 = InstitutManager.getSingleton().getId(ist);
//					var it3 = LevelManager.getSingleton().getId(lvl);
//					var it4 = SpecialityManager.getSingleton().getId(spe);
//					
//					int i = table.getSelectedRow();
//					var lN = table.getModel().getValueAt(i, 3).toString();
//					var tableMatri = table.getModel().getValueAt(i, 2).toString();
//					var fN = table.getModel().getValueAt(i, 4).toString();
//					Student oldStudent = new Student(null, lN, fN, null, null, null, null, null, null, null ,null, null, null, null, null, null, null, null, null);
//					int newID =  StudentManager.getSingleton().getId(oldStudent);
//					Register oldRegister = new Register(tableMatri, 0, newID, 0, 0, 0);
//					SchoolRegister.getSingleton().updateRegistredStudent(oldRegister, new Register(mat, yea, it1, it2, it3, it4));
//					
//					sB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//					iB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//					lB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//					spB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//					yearF.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//					matriF.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//					lastF.setBorderColor(Color.GREEN);
//					firsF.setBorderColor(Color.GREEN);
//					birtF.setBorderColor(Color.GREEN);
//					sexlF.setBorderColor(Color.GREEN);
//					cniF.setBorderColor(Color.GREEN);
//					phonF.setBorderColor(Color.GREEN);
//					addrF.setBorderColor(Color.GREEN);
//					
//					JOptionPane.showMessageDialog
//					(
//						pan,
//						new Message(Message.UPDATE_COMPLETE_MSG),
//						Message.DEFAULT_TITLE_MSG,
//						JOptionPane.INFORMATION_MESSAGE,
//						Iconifier.confirmIcon
//					);
//					
//					sB.setBorder(new JComboBox<>().getBorder());
//					iB.setBorder(new JComboBox<>().getBorder());
//					lB.setBorder(new JComboBox<>().getBorder());
//					spB.setBorder(new JComboBox<>().getBorder());
//					yearF.setBorder(new JYearChooser().getBorder());
//					matriF.setBorder(new JTextField().getBorder());
//					lastF.setBorderColor(Color.BLACK);
//					firsF.setBorderColor(Color.BLACK);
//					birtF.setBorderColor(Color.BLACK);
//					sexlF.setBorderColor(Color.BLACK);
//					cniF.setBorderColor(Color.BLACK);
//					phonF.setBorderColor(Color.BLACK);
//					addrF.setBorderColor(Color.BLACK);
//					pp.setIcon(Iconifier.clientIcon);
//					lastF.setText(Message.LAST_NAME);
//					firsF.setText(Message.FIRST_NAME);
//					birtF.setText(Message.BIRTH_TAG);
//					cniF.setText(Message.CNI_TAG);
//					sexlF.setText(Message.SEX_TAG);
//					phonF.setText(Message.PHONE_TAG);
//					addrF.setText(Message.ADDR_TAG);
//					
//					Placeholder.addPlaceholderStyle(lastF);
//					Placeholder.addPlaceholderStyle(firsF);
//					Placeholder.addPlaceholderStyle(cniF);
//					Placeholder.addPlaceholderStyle(birtF);
//					Placeholder.addPlaceholderStyle(sexlF);
//					Placeholder.addPlaceholderStyle(phonF);
//					Placeholder.addPlaceholderStyle(addrF);
//					Placeholder.defaultFGetPlaceholder(lastF);
//					Placeholder.defaultFGetPlaceholder(firsF);
//					Placeholder.defaultFGetPlaceholder(cniF);
//					Placeholder.defaultFGetPlaceholder(birtF);
//					Placeholder.defaultFGetPlaceholder(sexlF);
//					Placeholder.defaultFGetPlaceholder(phonF);
//					Placeholder.defaultFGetPlaceholder(addrF);
//				}
//				catch (Exception e)
//				{
//					var errMsg = e.getMessage();
//					JOptionPane.showMessageDialog
//					(		
//							pan,
//							new Message(errMsg),
//							Message.ERROR_TITLE_MSG,
//							JOptionPane.ERROR_MESSAGE,
//							Iconifier.errorIcon
//					);
//				}
//				
//				but.setEnabled(false);
//				but1.setEnabled(true);
//			}
//		}
//	}
//}
