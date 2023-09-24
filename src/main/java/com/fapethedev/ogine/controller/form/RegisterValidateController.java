package com.fapethedev.ogine.controller.form;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import com.fapethedev.ogine.model.database.entities.Institut;
import com.fapethedev.ogine.model.database.entities.Speciality;
import com.fapethedev.ogine.model.database.entities.Student;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.entities.Level;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class RegisterValidateController 
{
	public synchronized static void confirm(MainMenu owner)
	{
		var pan = owner.getCenterpane();
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
		
		int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.CONFIRM_INSCR_INFO_MSG),
					Message.CONFIRM_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
		if(choice == JOptionPane.YES_OPTION)
		{
			if(sB.getSelectedItem() == null || yearF.getYear() <= 0 || iB.getSelectedItem() == null 
					||lB.getSelectedItem() == null || spB.getSelectedItem() == null
					||matriF.getText().isEmpty()||matriF.getText().compareTo(matriF.getToolTipText()) == 0){
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
//					var inRegister = new Register(mat, yea, it1, it2, it3, it4);
//					if(!SchoolRegister.getSingleton().verifRegistredStudent(inRegister))
//					{
//						SchoolRegister.getSingleton().register(inRegister);
//
//						sB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//						iB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//						lB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//						spB.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//						yearF.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//						matriF.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
//
//						lastF.setBorderColor(Color.GREEN);
//						firsF.setBorderColor(Color.GREEN);
//						birtF.setBorderColor(Color.GREEN);
//						sexlF.setBorderColor(Color.GREEN);
//						cniF.setBorderColor(Color.GREEN);
//						phonF.setBorderColor(Color.GREEN);
//						addrF.setBorderColor(Color.GREEN);
//
//						JOptionPane.showMessageDialog
//						(
//							pan,
//							new Message(Message.REGISTRATION_SUCCESS_MSG),
//							Message.DEFAULT_TITLE_MSG,
//							JOptionPane.INFORMATION_MESSAGE,
//							Iconifier.confirmIcon
//						);
//
//						sB.setBorder(new JComboBox<>().getBorder());
//						iB.setBorder(new JComboBox<>().getBorder());
//						lB.setBorder(new JComboBox<>().getBorder());
//						spB.setBorder(new JComboBox<>().getBorder());
//						yearF.setBorder(new JYearChooser().getBorder());
//						matriF.setBorder(new JTextField().getBorder());
//
//						RegisterResetController.reset(owner);
//						int choice2 = JOptionPane.showConfirmDialog
//						(
//							pan,
//							new Message(Message.ASK_CHECK_DATA_MSG),
//							Message.CONFIRM_TITLE,
//							JOptionPane.YES_NO_OPTION,
//							JOptionPane.QUESTION_MESSAGE,
//							Iconifier.questionIcon
//						);
//						if(choice2 == JOptionPane.YES_OPTION)
//						{
//							var card = owner.getCard();
//							var list = owner.getList(5);
//							var tPan = owner.getTabbedPane();
//							tPan.setSelectedIndex(0);
//							card.show(pan, list);
//						}
//					}
//					else
//					{
//						JOptionPane.showMessageDialog
//						(
//							pan,
//							new Message(Message.IS_EXISTS_MSG),
//							Message.DEFAULT_TITLE_MSG,
//							JOptionPane.WARNING_MESSAGE,
//							Iconifier.warningIcon
//						);
//
//						int choice2 = JOptionPane.showConfirmDialog
//						(
//							pan,
//							new Message(Message.ASK_INSCR_INFO_MSG),
//							Message.CONFIRM_TITLE,
//							JOptionPane.YES_NO_OPTION,
//							JOptionPane.QUESTION_MESSAGE,
//							Iconifier.questionIcon
//						);
//						if(choice2 == JOptionPane.YES_OPTION)
//						{
//							var card = owner.getCard();
//							var list = owner.getList(4);
//							var tPan = owner.getTabbedPane();
//							tPan.setSelectedIndex(1);
//							card.show(pan, list);
//						}
//					}
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
			}
		}
	}
}
