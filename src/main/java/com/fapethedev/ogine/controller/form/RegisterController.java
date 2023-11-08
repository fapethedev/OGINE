package com.fapethedev.ogine.controller.form;

import com.fapethedev.ogine.model.database.entities.*;
import com.fapethedev.ogine.model.database.manager.*;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.Placeholder;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;
import com.toedter.calendar.JYearChooser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class RegisterController
{
	public synchronized static void addRegister(MainMenu owner)
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
					var it1 = StudentManager.getInstance().getIdByName(stu.personal().name());
					var it2 = InstitutManager.getSingleton().getId(ist);
					var it3 = LevelManager.getSingleton().getId(lvl);
					var it4 = SpecialityManager.getSingleton().getId(spe);
					var inRegister = new Register(mat, yea, it1, it2, it3, it4);

					if(!SchoolRegister.getSingleton().verifRegistredStudent(inRegister))
					{
						SchoolRegister.getSingleton().register(inRegister);

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
							new Message(Message.REGISTRATION_SUCCESS_MSG),
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

						RegisterController.reset(owner);
						int choice2 = JOptionPane.showConfirmDialog
						(
							pan,
							new Message(Message.ASK_CHECK_DATA_MSG),
							Message.CONFIRM_TITLE,
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							Iconifier.questionIcon
						);
						if(choice2 == JOptionPane.YES_OPTION)
						{
							var card = owner.getCard();
							var list = owner.getList(3);
							var tPan = owner.getTabbedPane();
							tPan.setSelectedIndex(0);
							card.show(pan, list);
						}
					}
					else
					{
						JOptionPane.showMessageDialog
						(
							pan,
							new Message(Message.IS_EXISTS_MSG),
							Message.DEFAULT_TITLE_MSG,
							JOptionPane.WARNING_MESSAGE,
							Iconifier.warningIcon
						);

						int choice2 = JOptionPane.showConfirmDialog
						(
							pan,
							new Message(Message.ASK_INSCR_INFO_MSG),
							Message.CONFIRM_TITLE,
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							Iconifier.questionIcon
						);
						if(choice2 == JOptionPane.YES_OPTION)
						{
							var card = owner.getCard();
							var list = owner.getList(2);
							var tPan = owner.getTabbedPane();
							tPan.setSelectedIndex(1);
							card.show(pan, list);
						}
					}
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

	public synchronized static void updateRegister(MainMenu owner)
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

	public synchronized static void setBoxListener(MainMenu owner)
	{
		var pan = owner.getCenterpane();

		var pp = owner.getRegisterClientProfile();
		var sB = owner.getRegisterStudentBox();
		var iB = owner.getRegisterInstitutBox();
		var lB = owner.getRegisterLevelBox();
		var spB = owner.getRegisterSpecialityBox();
		var lastF = owner.getRegisterLastnameField();
		var firsF = owner.getRegisterFirstnameField();
		var birtF = owner.getRegisterBirthField();
		var sexlF = owner.getRegisterSexField();
		var cniF = owner.getRegisterCniField();
		var phonF = owner.getRegisterPhonenumberField();
		var addrF = owner.getRegisterAddressField();

		sB.addItemListener(e -> {
			if(sB.getSelectedItem() instanceof Student student)
			{
				try
				{
					var studentByName = StudentManager.getInstance().getStudentByName(student.personal().name());

					pp.setIcon(new ImageIcon(studentByName.personal().profile()));
					lastF.setText(studentByName.personal().name().last());
					firsF.setText(studentByName.personal().name().first());
					birtF.setText(studentByName.personal().birthDate().toString());
					sexlF.setText(studentByName.personal().sex());
					cniF.setText(studentByName.personal().cni());
					phonF.setText(studentByName.more().phoneNumber());
					addrF.setText(studentByName.more().address());
				}
				catch (Exception exception)
				{
					String errMsg = exception.getMessage();
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
		});

		iB.addItemListener(e ->{
			if(iB.getSelectedItem() instanceof Institut institut)
			{
				ArrayList<Level> levels;
				lB.removeAllItems();
				try
				{
					levels =  LevelManager.getSingleton().getLevelList(institut);

					for(var level : levels)
					{
						lB.addItem(level);
					}
				}
				catch (Exception exception)
				{
					System.err.println(exception.getMessage());
				}
			}
			lB.setSelectedIndex(-1);
		});

		lB.addItemListener(e ->{
			if(lB.getSelectedItem() instanceof Level level &&
					iB.getSelectedItem() instanceof Institut institut)
			{
                ArrayList<Speciality> specialities;
                spB.removeAllItems();
				try
				{
					specialities =  SpecialityManager.getSingleton().getSpecialtyList(institut, level);

					for(var speciality : specialities)
					{
						spB.addItem(speciality);
					}
				}
				catch (Exception exception)
				{
					System.err.println(exception.getMessage());
				}
			}
			spB.setSelectedIndex(-1);
		});
	}

	public synchronized static void setData(MainMenu owner)
	{
		var sB = owner.getRegisterStudentBox();
		var iB = owner.getRegisterInstitutBox();

		try
		{
			var allStudents = StudentManager.getInstance().getAllStudents();

            if(sB.getItemCount() > 0)
            {
                sB.removeAllItems();
            }
			for(var student : allStudents)
			{
				sB.addItem(student);
			}
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		sB.setSelectedIndex(-1);

		try
		{
			var allInstituts = InstitutManager.getSingleton().getAllInstituts();

			if(iB.getItemCount() > 0)
            {
                iB.removeAllItems();
            }
			for(var institut : allInstituts)
			{
				iB.addItem(institut);
			}
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		iB.setSelectedIndex(-1);
	}

	public synchronized static void cancel(MainMenu owner)
	{
		var pan = owner.getCenterpane();

		int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.CANCEL_INFO_MSG),
					Message.DEFAULT_TITLE_MSG,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);
		if(choice == JOptionPane.YES_OPTION)
		{
			RegisterController.reset(owner);
			owner.getRegisterSliderPane().show(0);
		}
	}

	public synchronized static void clear(MainMenu owner)
	{
		var pan = owner.getCenterpane();

		int choice = JOptionPane.showConfirmDialog
				(
					pan,
					new Message(Message.RESET_FORM_MSG),
					Message.CONFIRM_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					Iconifier.questionIcon
				);

		if(choice == JOptionPane.YES_OPTION)
		{
			reset(owner);
			JOptionPane.showMessageDialog
			(
				pan,
				new Message(Message.RESET_SUCCES_MSG),
				Message.DEFAULT_TITLE_MSG,
				JOptionPane.INFORMATION_MESSAGE,
				Iconifier.infoIcon
			);
		}
	}

	public synchronized static void reset(MainMenu owner)
	{
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

		pp.setIcon(Iconifier.clientIcon);
		sB.setSelectedIndex(-1);
		iB.setSelectedIndex(-1);
		lB.setSelectedIndex(-1);
		spB.setSelectedIndex(-1);

		matriF.setText(Message.MATRICULE_TAG);
		yearF.setYear(Calendar.getInstance().get(Calendar.YEAR));
		lastF.setText(Message.LAST_NAME);
		firsF.setText(Message.FIRST_NAME);
		birtF.setText(Message.BIRTH_TAG);
		cniF.setText(Message.CNI_TAG);
		sexlF.setText(Message.SEX_TAG);
		phonF.setText(Message.PHONE_TAG);
		addrF.setText(Message.ADDR_TAG);

		lastF.setDefaultBorderColor(Color.BLACK);
		firsF.setDefaultBorderColor(Color.BLACK);
		birtF.setDefaultBorderColor(Color.BLACK);
		sexlF.setDefaultBorderColor(Color.BLACK);
		cniF.setDefaultBorderColor(Color.BLACK);
		phonF.setDefaultBorderColor(Color.BLACK);
		addrF.setDefaultBorderColor(Color.BLACK);

		Placeholder.addPlaceholderStyle(matriF);
		Placeholder.addPlaceholderStyle(lastF);
		Placeholder.addPlaceholderStyle(firsF);
		Placeholder.addPlaceholderStyle(birtF);
		Placeholder.addPlaceholderStyle(cniF);
		Placeholder.addPlaceholderStyle(sexlF);
		Placeholder.addPlaceholderStyle(phonF);
		Placeholder.addPlaceholderStyle(addrF);

		Placeholder.defaultFGetPlaceholder(matriF);
		Placeholder.defaultFGetPlaceholder(lastF);
		Placeholder.defaultFGetPlaceholder(firsF);
		Placeholder.defaultFGetPlaceholder(birtF);
		Placeholder.defaultFGetPlaceholder(cniF);
		Placeholder.defaultFGetPlaceholder(sexlF);
		Placeholder.defaultFGetPlaceholder(phonF);
		Placeholder.defaultFGetPlaceholder(addrF);
	}

}
