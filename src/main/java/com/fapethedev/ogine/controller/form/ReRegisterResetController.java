//package com.ogine.controller.form;
//
//import java.util.Calendar;
//
//import javax.swing.JOptionPane;
//
//import com.ogine.utilities.Iconifier;
//import com.ogine.utilities.Placeholder;
//import com.ogine.view.component.label.Message;
//import com.ogine.view.menu.MainMenu;
//
///**
// * @author FATIGBA Abiola Pierre-Edy
// *
// */
//public class ReRegisterResetController
//{
//	public synchronized static void clear(MainMenu owner)
//	{
//		var pan = owner.getCenterpane();
//		
//		int choice = JOptionPane.showConfirmDialog
//				(
//					pan,
//					new Message(Message.RESET_FORM_MSG),
//					Message.CONFIRM_TITLE,
//					JOptionPane.YES_NO_OPTION,
//					JOptionPane.QUESTION_MESSAGE,
//					Iconifier.questionIcon
//				);
//
//		if(choice == JOptionPane.YES_OPTION)
////		{
//			reset(owner);
//			JOptionPane.showMessageDialog
//			(
//				pan,
//				new Message(Message.RESET_SUCCES_MSG),
//				Message.DEFAULT_TITLE_MSG,
//				JOptionPane.INFORMATION_MESSAGE,
//				Iconifier.infoIcon
//			);
//		}
//	}
//	
//	public synchronized static void reset(MainMenu owner)
//	{
//		var pp = owner.getReRegisterClientProfile();
//		var sB = owner.getReRegisterStudentBox();
//		var iB = owner.getReRegisterInstitutBox();
//		var lB = owner.getReRegisterLevelBox();
//		var spB = owner.getReRegisterSpecialityBox();
//		var matriF = owner.getReRegisterMatriculeField();
//		var yearF = owner.getReRegisterYearField();
//		var lastF = owner.getReRegisterLastnameField();
//		var firsF = owner.getReRegisterFirstnameField();
//		var birtF = owner.getReRegisterBirthField();
//		var sexlF = owner.getReRegisterSexField();
//		var cniF = owner.getReRegisterCniField();
//		var phonF = owner.getReRegisterPhonenumberField();
//		var addrF = owner.getReRegisterAddressField();
//		
//		pp.setIcon(Iconifier.clientIcon);
//		
//		sB.setSelectedIndex(-1);
//		iB.setSelectedIndex(-1);
//		lB.setSelectedIndex(-1);
//		spB.setSelectedIndex(-1);
//		matriF.setText(Message.MATRICULE_TAG);
//		yearF.setYear(Calendar.getInstance().get(Calendar.YEAR));
//		lastF.setText(Message.LAST_NAME);
//		firsF.setText(Message.FIRST_NAME);
//		birtF.setText(Message.BIRTH_TAG);
//		cniF.setText(Message.CNI_TAG);
//		sexlF.setText(Message.SEX_TAG);
//		phonF.setText(Message.PHONE_TAG);
//		addrF.setText(Message.ADDR_TAG);
//		
//		Placeholder.addPlaceholderStyle(matriF);
//		Placeholder.addPlaceholderStyle(lastF);
//		Placeholder.addPlaceholderStyle(firsF);
//		Placeholder.addPlaceholderStyle(birtF);
//		Placeholder.addPlaceholderStyle(cniF);
//		Placeholder.addPlaceholderStyle(sexlF);
//		Placeholder.addPlaceholderStyle(phonF);
//		Placeholder.addPlaceholderStyle(addrF);
//		Placeholder.defaultFGetPlaceholder(matriF);
//		Placeholder.defaultFGetPlaceholder(lastF);
//		Placeholder.defaultFGetPlaceholder(firsF);
//		Placeholder.defaultFGetPlaceholder(birtF);
//		Placeholder.defaultFGetPlaceholder(cniF);
//		Placeholder.defaultFGetPlaceholder(sexlF);
//		Placeholder.defaultFGetPlaceholder(phonF);
//		Placeholder.defaultFGetPlaceholder(addrF);
//	}
//}
