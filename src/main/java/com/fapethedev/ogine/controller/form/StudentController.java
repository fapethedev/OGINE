package com.fapethedev.ogine.controller.form;

import com.fapethedev.ogine.model.database.manager.StudentManager;
import com.fapethedev.ogine.model.database.entities.Student;
import com.fapethedev.ogine.model.database.exception.StudentManagerException;
import com.fapethedev.ogine.utilities.*;
import com.fapethedev.ogine.view.component.field.OTextField;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.component.border.RoundedBorder;
import com.fapethedev.ogine.view.component.panel.SliderPanel;
import com.fapethedev.ogine.view.menu.MainMenu;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.File;
import java.util.Locale;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class StudentController
{
	private static File inputfile;

	/**
	 * Confirm the register of all information provide by the srf
	 * field's
	 *
	 * @param owner a StudentRegisterForm object
	 */
	public synchronized static void addStudent(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		var pp = owner.getStudentClientprofile();
		var lastF = owner.getLastnamefield();
		var firsF = owner.getFirstnamefield();
		var birtF = owner.getBirthdate();
		var cniF = owner.getCnifield();
		var sexlF = owner.getSexlist();
		var blooF = owner.getBloodlist();
		var fathF = owner.getFathernamefield();
		var fatnF = owner.getFathernumberfield();
		var fatfF = owner.getFatherfunctionfield();
		var mothF = owner.getMothernamefield();
		var motnF = owner.getMothernumberfield();
		var motfF = owner.getMotherfunctionfield();
		var tutoF = owner.getTutornamefield();
		var tutnF = owner.getTutornumberfield();
		var tutfF = owner.getTutorfunctionfield();
		var reliF = owner.getReligionfield();
		var phonF = owner.getPhonenumberfield();
		var addrF = owner.getAddressfield();

		int choice = JOptionPane.showConfirmDialog
			(
				pan,
				new Message(Message.CONFIRM_INFO_MSG),
				Message.CONFIRM_TITLE,
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				Iconifier.questionIcon
			);

		if(choice == JOptionPane.YES_OPTION)
		{
			if(pp.getIcon() == null || pp.getIcon() == Iconifier.clientIcon
				||lastF.getText().isEmpty() || lastF.getText().compareTo(lastF.getToolTipText()) == 0
				||firsF.getText().isEmpty() || firsF.getText().compareTo(firsF.getToolTipText()) == 0
				||birtF.getJCalendar().getDate() == null
				||cniF.getText().isEmpty() || cniF.getText().compareTo(cniF.getToolTipText()) == 0
				||sexlF.getSelectedItem() == null || sexlF.getSelectedItem().toString().compareTo(sexlF.getToolTipText()) == 0
				||blooF.getSelectedItem() == null || blooF.getSelectedItem().toString().compareTo(blooF.getToolTipText()) == 0
				||fathF.getText().isEmpty() || fathF.getText().compareTo(fathF.getToolTipText()) == 0
				||fatnF.getText().isEmpty() || fatnF.getText().compareTo(fatnF.getToolTipText()) == 0
				||fatfF.getText().isEmpty() || fatfF.getText().compareTo(fatfF.getToolTipText()) == 0
				||mothF.getText().isEmpty() || mothF.getText().compareTo(mothF.getToolTipText()) == 0
				||motnF.getText().isEmpty() || motnF.getText().compareTo(motnF.getToolTipText()) == 0
				||motfF.getText().isEmpty() || motfF.getText().compareTo(motfF.getToolTipText()) == 0
				||tutoF.getText().isEmpty() || tutoF.getText().compareTo(tutoF.getToolTipText()) == 0
				||tutnF.getText().isEmpty() || tutnF.getText().compareTo(tutnF.getToolTipText()) == 0
				||tutfF.getText().isEmpty() || tutfF.getText().compareTo(tutfF.getToolTipText()) == 0
				||reliF.getText().isEmpty() || reliF.getText().compareTo(reliF.getToolTipText()) == 0
				||phonF.getText().isEmpty() || phonF.getText().compareTo(phonF.getToolTipText()) == 0
				||addrF.getText().isEmpty() || addrF.getText().compareTo(addrF.getToolTipText()) == 0) {
				fieldCheckFinder(pan, pp, lastF, firsF, birtF, cniF, sexlF, blooF, fathF, fatnF, fatfF,
                        mothF, motnF, motfF, tutoF, tutnF, tutfF, reliF, phonF, addrF);
			}
            else
            {
				Student.PersonalInfo.Name name = new Student.PersonalInfo.Name(
						lastF.getText().toUpperCase(),
						ToCase.nameToFormat(firsF.getText())
				);
				Student.PersonalInfo personalInfo = new Student.PersonalInfo(
						PicRedrawer.redrawerPath(name.last(), name.first()),
						name,
						DateConverter.toSQLDate(birtF.getDate()),
						sexlF.getSelectedItem().toString(),
						cniF.getText(),
						blooF.getSelectedItem().toString()
				);
				Student.FatherInfo fatherInfo = new Student.FatherInfo(
						ToCase.nameToFormat(fathF.getText()),
						fatnF.getText(),
						ToCase.nameToFormat(fatfF.getText())
				);
				Student.MotherInfo motherInfo = new Student.MotherInfo(
						ToCase.nameToFormat(mothF.getText()),
						motnF.getText(),
						ToCase.nameToFormat(motfF.getText())
				);
				Student.TutorInfo tutorInfo = new Student.TutorInfo(
						ToCase.nameToFormat(tutoF.getText()),
						tutnF.getText(),
						ToCase.nameToFormat(tutfF.getText())
				);
				Student.MoreInfo moreInfo = new Student.MoreInfo(
						ToCase.nameToFormat(reliF.getText()),
						ToCase.nameToFormat(phonF.getText()),
						ToCase.nameToFormat(addrF.getText())
				);
				try
				{
					if(!StudentManager.getInstance().checkStudentName(name))
					{
						StudentManager.getInstance().addStudent(new Student(personalInfo, fatherInfo,
								motherInfo, tutorInfo, moreInfo));
						borderValidator(pp, lastF, firsF, birtF, cniF, sexlF,
								blooF, fathF, fatnF, fatfF, mothF, motnF, motfF,
								tutoF, tutnF, tutfF, reliF, phonF, addrF);
						//
						JOptionPane.showMessageDialog
						(
							pan,
							new Message(Message.REGISTRATION_SUCCESS_MSG),
							Message.DEFAULT_TITLE_MSG,
							JOptionPane.INFORMATION_MESSAGE,
							Iconifier.confirmIcon
						);

						borderReset(owner, pp, lastF, firsF, birtF, cniF, sexlF, blooF, fathF, fatnF, fatfF, mothF,
                                motnF, motfF, tutoF, tutnF, tutfF, reliF, phonF, addrF);
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
							var slide = owner.getRegisterSliderPane();
							var tPan = owner.getTabbedPane();
							var iStudent = owner.getRegisterStudentBox();

							finder(pan, card, list, slide, tPan, 1, iStudent, name);
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
					}

				}
				catch(StudentManagerException | HeadlessException exception)
				{
					String errMsg = exception.getMessage();
					System.err.println(errMsg);
					exception.printStackTrace();
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

	public synchronized static void addPicture(MainMenu owner)
	{
		PicChooser chooser = new PicChooser();
		chooser.setLocale(Locale.FRANCE);
		ImageIcon icon;
		var pan = owner.getCenterpane();
		var cltP = owner.getStudentClientprofile();
		int action = chooser.showOpenDialog(pan);
		if(action == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputfile = new File(chooser.getSelectedFile().getAbsolutePath());
				icon = PicResizer.getSingleton().imageResizer(inputfile);
				cltP.setIcon(icon);
				cltP.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog
				(
					pan,
					new Message(exception.getMessage()),
					Message.ERROR_TITLE_MSG,
					JOptionPane.ERROR_MESSAGE,
					Iconifier.errorIcon
				);
			}
		}
	}

	public synchronized static void askResetForm(MainMenu owner)
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
			resetForm(owner);
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

	public synchronized static void resetForm(MainMenu owner)
	{
		var pp = owner.getStudentClientprofile();
		var lastF = owner.getLastnamefield();
		var firsF = owner.getFirstnamefield();
		var birtF = owner.getBirthdate();
		var cniF = owner.getCnifield();
		var sexlF = owner.getSexlist();
		var blooF = owner.getBloodlist();
		var fathF = owner.getFathernamefield();
		var fatnF = owner.getFathernumberfield();
		var fatfF = owner.getFatherfunctionfield();
		var mothF = owner.getMothernamefield();
		var motnF = owner.getMothernumberfield();
		var motfF = owner.getMotherfunctionfield();
		var tutoF = owner.getTutornamefield();
		var tutnF = owner.getTutornumberfield();
		var tutfF = owner.getTutorfunctionfield();
		var reliF = owner.getReligionfield();
		var phonF = owner.getPhonenumberfield();
		var addrF = owner.getAddressfield();

		pp.setIcon(Iconifier.clientIcon);
		lastF.setText("");
		firsF.setText("");
		birtF.setDate(null);
		cniF.setText("");
		sexlF.setSelectedIndex(-1);
		blooF.setSelectedIndex(-1);
//		sexlF.setSelectedItem(Message.SEX_TAG);
//		blooF.setSelectedItem(Message.BLOOD_TAG);
		fathF.setText("");
		fatnF.setText("");
		fatfF.setText("");
		mothF.setText("");
		motnF.setText("");
		motfF.setText("");
		tutoF.setText("");
		tutnF.setText("");
		tutfF.setText("");
		reliF.setText("");
		phonF.setText("");
		addrF.setText("");

//		Placeholder.addPlaceholderStyle(lastF);
//		Placeholder.addPlaceholderStyle(firsF);
//		Placeholder.addPlaceholderStyle(cniF);
//		Placeholder.addPlaceholderStyle(fathF);
//		Placeholder.addPlaceholderStyle(fatnF);
//		Placeholder.addPlaceholderStyle(fatfF);
//		Placeholder.addPlaceholderStyle(mothF);
//		Placeholder.addPlaceholderStyle(motnF);
//		Placeholder.addPlaceholderStyle(motfF);
//		Placeholder.addPlaceholderStyle(tutoF);
//		Placeholder.addPlaceholderStyle(tutnF);
//		Placeholder.addPlaceholderStyle(tutfF);
//		Placeholder.addPlaceholderStyle(reliF);
//		Placeholder.addPlaceholderStyle(phonF);
//		Placeholder.addPlaceholderStyle(addrF);
//
//		Placeholder.defaultFGetPlaceholder(lastF);
//		Placeholder.defaultFGetPlaceholder(firsF);
//		Placeholder.defaultFGetPlaceholder(cniF);
//		Placeholder.defaultFGetPlaceholder(fathF);
//		Placeholder.defaultFGetPlaceholder(fatnF);
//		Placeholder.defaultFGetPlaceholder(fatfF);
//		Placeholder.defaultFGetPlaceholder(mothF);
//		Placeholder.defaultFGetPlaceholder(motnF);
//		Placeholder.defaultFGetPlaceholder(motfF);
//		Placeholder.defaultFGetPlaceholder(tutoF);
//		Placeholder.defaultFGetPlaceholder(tutnF);
//		Placeholder.defaultFGetPlaceholder(tutfF);
//		Placeholder.defaultFGetPlaceholder(reliF);
//		Placeholder.defaultFGetPlaceholder(phonF);
//		Placeholder.defaultFGetPlaceholder(addrF);
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
			StudentController.resetForm(owner);
			owner.getStudentSliderPane().show(0);
		}
	}

	/**
	 * Confirm the update of past registered information provide by the srf
	 * field's
	 *
	 * @param owner a StudentRegisterForm object
	 */
	public synchronized static void updateStudent(MainMenu owner)
	{
        var pan = owner.getCenterpane();
        var pp = owner.getStudentClientprofile();
        var lastF = owner.getLastnamefield();
        var firsF = owner.getFirstnamefield();
        var birtF = owner.getBirthdate();
        var cniF = owner.getCnifield();
        var sexlF = owner.getSexlist();
        var blooF = owner.getBloodlist();
        var fathF = owner.getFathernamefield();
        var fatnF = owner.getFathernumberfield();
        var fatfF = owner.getFatherfunctionfield();
        var mothF = owner.getMothernamefield();
        var motnF = owner.getMothernumberfield();
        var motfF = owner.getMotherfunctionfield();
        var tutoF = owner.getTutornamefield();
        var tutnF = owner.getTutornumberfield();
        var tutfF = owner.getTutorfunctionfield();
        var reliF = owner.getReligionfield();
        var phonF = owner.getPhonenumberfield();
        var addrF = owner.getAddressfield();
        var table = owner.getDataTable();
        var but = owner.getStudentUpdate();
        var but1 = owner.getStudentValidate();

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
        	if(pp.getIcon() == null || pp.getIcon() == Iconifier.clientIcon
                ||lastF.getText().isEmpty() || lastF.getText().compareTo(lastF.getToolTipText()) == 0
                ||firsF.getText().isEmpty() || firsF.getText().compareTo(firsF.getToolTipText()) == 0
                ||birtF.getJCalendar().getDate() == null
                ||cniF.getText().isEmpty() || cniF.getText().compareTo(cniF.getToolTipText()) == 0
                ||sexlF.getSelectedItem() == null || sexlF.getSelectedItem().toString().compareTo(sexlF.getToolTipText()) == 0
                ||blooF.getSelectedItem() == null || blooF.getSelectedItem().toString().compareTo(blooF.getToolTipText()) == 0
                ||fathF.getText().isEmpty() || fathF.getText().compareTo(fathF.getToolTipText()) == 0
                ||fatnF.getText().isEmpty() || fatnF.getText().compareTo(fatnF.getToolTipText()) == 0
                ||fatfF.getText().isEmpty() || fatfF.getText().compareTo(fatfF.getToolTipText()) == 0
                ||mothF.getText().isEmpty() || mothF.getText().compareTo(mothF.getToolTipText()) == 0
                ||motnF.getText().isEmpty() || motnF.getText().compareTo(motnF.getToolTipText()) == 0
                ||motfF.getText().isEmpty() || motfF.getText().compareTo(motfF.getToolTipText()) == 0
                ||tutoF.getText().isEmpty() || tutoF.getText().compareTo(tutoF.getToolTipText()) == 0
                ||tutnF.getText().isEmpty() || tutnF.getText().compareTo(tutnF.getToolTipText()) == 0
                ||tutfF.getText().isEmpty() || tutfF.getText().compareTo(tutfF.getToolTipText()) == 0
                ||reliF.getText().isEmpty() || reliF.getText().compareTo(reliF.getToolTipText()) == 0
                ||phonF.getText().isEmpty() || phonF.getText().compareTo(phonF.getToolTipText()) == 0
                ||addrF.getText().isEmpty() || addrF.getText().compareTo(addrF.getToolTipText()) == 0) {
				fieldCheckFinder(pan, pp, lastF, firsF, birtF, cniF, sexlF, blooF, fathF, fatnF, fatfF, mothF, motnF, motfF, tutoF, tutnF, tutfF, reliF, phonF, addrF);
			}
            else
            {
                Student.PersonalInfo.Name name = new Student.PersonalInfo.Name(
						lastF.getText().toUpperCase(),
						ToCase.nameToFormat(firsF.getText())
				);
				Student.PersonalInfo personalInfo = new Student.PersonalInfo(
						PicRedrawer.redrawerPath(name.last(), name.first()),
						name,
						DateConverter.toSQLDate(birtF.getDate()),
						cniF.getText(),
						sexlF.getSelectedItem().toString(),
						blooF.getSelectedItem().toString()
				);
				Student.FatherInfo fatherInfo = new Student.FatherInfo(
						ToCase.nameToFormat(fathF.getText()),
						fatnF.getText(),
						ToCase.nameToFormat(fatfF.getText())
				);
				Student.MotherInfo motherInfo = new Student.MotherInfo(
						ToCase.nameToFormat(mothF.getText()),
						motnF.getText(),
						ToCase.nameToFormat(motfF.getText())
				);
				Student.TutorInfo tutorInfo = new Student.TutorInfo(
						ToCase.nameToFormat(tutoF.getText()),
						tutnF.getText(),
						ToCase.nameToFormat(tutfF.getText())
				);
				Student.MoreInfo moreInfo = new Student.MoreInfo(
						ToCase.nameToFormat(reliF.getText()),
						ToCase.nameToFormat(phonF.getText()),
						ToCase.nameToFormat(addrF.getText())
				);

                int i = table.getSelectedRow();
				Student.PersonalInfo.Name oldName = new Student.PersonalInfo.Name(
						table.getModel().getValueAt(i, 2).toString(),
						table.getModel().getValueAt(i, 3).toString()
				);
				try
                {
                    StudentManager.getInstance().updateStudentByName(oldName, new Student(personalInfo, fatherInfo,
								motherInfo, tutorInfo, moreInfo));

					borderValidator(pp, lastF, firsF, birtF, cniF, sexlF, blooF, fathF, fatnF, fatfF, mothF, motnF, motfF, tutoF, tutnF, tutfF, reliF, phonF, addrF);
					JOptionPane.showMessageDialog
                    (
                        pan,
                        new Message(Message.UPDATE_SUCCESS_MSG),
                        Message.DEFAULT_TITLE_MSG,
                        JOptionPane.INFORMATION_MESSAGE,
                        Iconifier.confirmIcon
                    );
					borderReset(owner, pp, lastF, firsF, birtF, cniF, sexlF, blooF, fathF, fatnF, fatfF, mothF, motnF, motfF, tutoF, tutnF, tutfF, reliF, phonF, addrF);
					but.setEnabled(false);
                    but1.setEnabled(true);
                    int choice2 = JOptionPane.showConfirmDialog
                    (
                            pan,
                            new Message(Message.ASK_INSCR_UPD_INFO_MSG),
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
                        var slider = owner.getRegisterSliderPane();
                        var iStudent = owner.getRegisterStudentBox();
                        var but2 = owner.getRegisterUpdate();
                        var but3 = owner.getRegisterValidate();
                        but2.setEnabled(true);
                        but3.setEnabled(false);

						finder(pan, card, list, slider, tPan, 2, iStudent, name);
					}
                }
                catch(Exception exception)
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
        }
	}

	private static void finder(JPanel pan, CardLayout card, String list, SliderPanel slide, JTabbedPane tPan,
                               int index, JComboBox<Student> iStudent, Student.PersonalInfo.Name name) {
		for(int i = 0 ; iStudent.getItemCount() > i ; i++ )
		{
			if(iStudent.getItemAt(i).personal().name().compareTo(name) == 0)
			{
				iStudent.setSelectedIndex(i);
				break;
			}
		}
		slide.show(index);
		tPan.setSelectedIndex(index - 1);
		card.show(pan, list);
	}

	private static void fieldCheckFinder(JPanel pan, JLabel pp, OTextField lastF, OTextField firsF, JDateChooser birtF,
										 OTextField cniF, JComboBox<String> sexlF, JComboBox<String> blooF,
										 OTextField fathF, OTextField fatnF, OTextField fatfF, OTextField mothF,
										 OTextField motnF, OTextField motfF, OTextField tutoF, OTextField tutnF,
										 OTextField tutfF, OTextField reliF, OTextField phonF, OTextField addrF) {
		JOptionPane.showMessageDialog
		(
			pan,
			new Message(Message.ALL_FIELD_MISSING_MSG),
			Message.DEFAULT_TITLE_MSG,
			JOptionPane.WARNING_MESSAGE,
			Iconifier.warningIcon
		);
		if(pp.getIcon() == null || pp.getIcon() == Iconifier.clientIcon)
		{
			pp.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
		}
		if(lastF.getText().isEmpty() || lastF.getText().compareTo(lastF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(lastF);
		}
		if(firsF.getText().isEmpty() || firsF.getText().compareTo(firsF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(firsF);
		}
		if(birtF.getDate() == null)
		{
			birtF.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		if(cniF.getText().isEmpty() || cniF.getText().compareTo(cniF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(cniF);
		}
		if(sexlF.getSelectedItem() == null)
		{
			sexlF.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		if(blooF.getSelectedItem() == null)
		{
			blooF.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		checkerComparator(fathF, fatnF, fatfF, mothF, motnF, motfF);
		checkerComparator(tutoF, tutnF, tutfF, reliF, phonF, addrF);
	}

	private static void checkerComparator(OTextField fathF, OTextField fatnF, OTextField fatfF, OTextField mothF,
                                          OTextField motnF, OTextField motfF) {
		if(fathF.getText().isEmpty() || fathF.getText().compareTo(fathF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(fathF);
		}
		if(fatnF.getText().isEmpty() || fatnF.getText().compareTo(fatnF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(fatnF);
		}
		if(fatfF.getText().isEmpty() || fatfF.getText().compareTo(fatfF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(fatfF);
		}
		if(mothF.getText().isEmpty() || mothF.getText().compareTo(mothF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(mothF);
		}
		if(motnF.getText().isEmpty() || motnF.getText().compareTo(motnF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(motnF);
		}
		if(motfF.getText().isEmpty() || motfF.getText().compareTo(motfF.getToolTipText()) == 0)
		{
			Placeholder.defaultRedPlaceholderStyle(motfF);
		}
	}

	private static void borderValidator(JLabel pp, OTextField lastF, OTextField firsF, JDateChooser birtF,
                                        OTextField cniF, JComboBox<String> sexlF, JComboBox<String> blooF,
                                        OTextField fathF, OTextField fatnF, OTextField fatfF, OTextField mothF,
                                        OTextField motnF, OTextField motfF, OTextField tutoF, OTextField tutnF,
                                        OTextField tutfF, OTextField reliF, OTextField phonF, OTextField addrF) {
		pp.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
		lastF.setDefaultBorderColor(Color.GREEN);
		firsF.setDefaultBorderColor(Color.GREEN);
		birtF.setBorder(new RoundedBorder(Color.GREEN));
		cniF.setDefaultBorderColor(Color.GREEN);
		sexlF.setBorder(new RoundedBorder(Color.GREEN));
		blooF.setBorder(new RoundedBorder(Color.GREEN));
		fathF.setDefaultBorderColor(Color.GREEN);
		fatnF.setDefaultBorderColor(Color.GREEN);
		fatfF.setDefaultBorderColor(Color.GREEN);
		mothF.setDefaultBorderColor(Color.GREEN);
		motnF.setDefaultBorderColor(Color.GREEN);
		motfF.setDefaultBorderColor(Color.GREEN);
		tutoF.setDefaultBorderColor(Color.GREEN);
		tutnF.setDefaultBorderColor(Color.GREEN);
		tutfF.setDefaultBorderColor(Color.GREEN);
		reliF.setDefaultBorderColor(Color.GREEN);
		phonF.setDefaultBorderColor(Color.GREEN);
		addrF.setDefaultBorderColor(Color.GREEN);
	}

	private static void borderReset(MainMenu owner, JLabel pp, OTextField lastF, OTextField firsF, JDateChooser birtF,
                                    OTextField cniF, JComboBox<String> sexlF, JComboBox<String> blooF, OTextField fathF,
                                    OTextField fatnF, OTextField fatfF, OTextField mothF, OTextField motnF,
                                    OTextField motfF, OTextField tutoF, OTextField tutnF, OTextField tutfF,
                                    OTextField reliF, OTextField phonF, OTextField addrF) {
		pp.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Colors.getInstance().DARK_BLUE, Color.LIGHT_GRAY));
		lastF.setDefaultBorderColor(Color.BLACK);
		firsF.setDefaultBorderColor(Color.BLACK);
		birtF.setBorder(new RoundedBorder(Color.BLACK));
		cniF.setDefaultBorderColor(Color.BLACK);
		sexlF.setBorder(new RoundedBorder(Color.BLACK));
		blooF.setBorder(new RoundedBorder(Color.BLACK));
		fathF.setDefaultBorderColor(Color.BLACK);
		fatnF.setDefaultBorderColor(Color.BLACK);
		fatfF.setDefaultBorderColor(Color.BLACK);
		mothF.setDefaultBorderColor(Color.BLACK);
		motnF.setDefaultBorderColor(Color.BLACK);
		motfF.setDefaultBorderColor(Color.BLACK);
		tutoF.setDefaultBorderColor(Color.BLACK);
		tutnF.setDefaultBorderColor(Color.BLACK);
		tutfF.setDefaultBorderColor(Color.BLACK);
		reliF.setDefaultBorderColor(Color.BLACK);
		phonF.setDefaultBorderColor(Color.BLACK);
		addrF.setDefaultBorderColor(Color.BLACK);
		StudentController.resetForm(owner);
		RegisterController.setData(owner);
	}

	public static File getInputfile()
	{
		return inputfile;
	}
}