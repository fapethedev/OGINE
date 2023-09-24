package com.fapethedev.ogine.controller.form;

import java.util.Calendar;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.Placeholder;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class RegisterResetController
{
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
