package com.fapethedev.ogine.controller.table;

import com.fapethedev.ogine.model.database.entities.SchoolStudent;
import com.fapethedev.ogine.model.database.entities.Student;
import com.fapethedev.ogine.model.database.manager.SchoolStudentManager;
import com.fapethedev.ogine.model.database.manager.StudentManager;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.QRGenerator;
import com.fapethedev.ogine.view.component.dialog.SchoolStudentViewerDialog;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.ArrayList;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class DataTableController
{
	public synchronized static void populateTable(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		var table = owner.getDataTable();
		ArrayList<SchoolStudent> schoolStudentList = new ArrayList<>();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        JTableHeader th = table.getTableHeader();
		
		try
		{
			schoolStudentList = SchoolStudentManager.getSingleton().getSchoolStudent();
			tableModel.setRowCount(0);
			for(SchoolStudent stu : schoolStudentList)
			{
				Object[] rows = {stu.year(), stu.matricule(), stu.lastName(), 
						stu.firstName(), stu.sex(), stu.institut(), stu.level(), stu.speciality()};
				tableModel.addRow(rows);
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
        table.setTableHeader(th);
        //JTableAutoReziser.fitToData(table);
	}
	
	public synchronized static void populateFromSearch(MainMenu owner)
	{
		var pan = owner.getCenterpane();
		var table = owner.getDataTable();
		ArrayList<SchoolStudent> schoolStudentList = new ArrayList<>();
		String title [] = {"Année".toUpperCase(), "Matricule".toUpperCase(), "Nom".toUpperCase(), "Prénoms".toUpperCase(),
                "Sexe".toUpperCase(), "Institut".toUpperCase(), "Niveau".toUpperCase(), "Spécialité".toUpperCase()};
		int row = 0;
		DefaultTableModel tableModel = new DefaultTableModel(title, row);
		try
		{
			schoolStudentList = SchoolStudentManager.getSingleton().searchSchoolStudent(owner.getSearchField().getText());
			for(SchoolStudent stu : schoolStudentList)
			{
				Object[] rows = {stu.year(), stu.matricule(), stu.lastName(), 
						stu.firstName(), stu.sex(), stu.institut(), stu.level(), stu.speciality()};
				tableModel.addRow(rows);
			}
                table.setModel(tableModel);
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
//		JTableAutoReziser.fitToData(table);
	}

	public synchronized static void showCard(MainMenu owner)
    {
		SchoolStudentViewerDialog dialog = new SchoolStudentViewerDialog(owner, true);
        var pan = owner.getCenterpane();
        var table = owner.getDataTable();
        int i = table.getSelectedRow();

        if(i < 0)
        {
            JOptionPane.showMessageDialog
            (
                pan,
                new Message("VEUILLEZ SELECTIONNER UN ETUDIANT !"),
                Message.DEFAULT_TITLE_MSG,
                JOptionPane.WARNING_MESSAGE,
                Iconifier.warningIcon
            );
        }
        else
        {
            var lastName = table.getModel().getValueAt(i, 2).toString();
            var firstName = table.getModel().getValueAt(i, 3).toString();

            var pL = dialog.getPictureLab();
            var matL = dialog.getMatriLab();
            var lastL = dialog.getLastNameLab();
            var firsL = dialog.getFirstNameLab();
            var birtL = dialog.getDateNLab();
            var sexlL = dialog.getSexeLab();
            var contL = dialog.getPhoneLab();
            var adL = dialog.getAddrLab();
            var iL = dialog.getInstitutLab();
            var lL = dialog.getLevelLab();
            var sL = dialog.getSpecLab();
            var pnL = dialog.getParNameLab();
            var ppL = dialog.getParPhoneLab();
            var bL = dialog.getBloodLab();
            var qcL = dialog.getQRLab();
            try
            {
                Student studentByName = StudentManager.getInstance().getStudentByName(new Student.PersonalInfo.Name(lastName, firstName));

				pL.setIcon(new ImageIcon(studentByName.personal().profile()));
                matL.setText(table.getModel().getValueAt(i, 1).toString());
                lastL.setText(studentByName.personal().name().last());
                firsL.setText(studentByName.personal().name().first());
                birtL.setText(studentByName.personal().birthDate().toString());
                sexlL.setText(studentByName.personal().sex());
                iL.setText(table.getModel().getValueAt(i, 5).toString());
                lL.setText(table.getModel().getValueAt(i, 6).toString());
                sL.setText(table.getModel().getValueAt(i, 7).toString());
                contL.setText(studentByName.more().phoneNumber());
                adL.setText(studentByName.more().address());
                bL.setText(studentByName.personal().bloodGroup());
                pnL.setText(studentByName.tutor().tutorName());
                ppL.setText(studentByName.tutor().tutorNumber());

                String data = QRGenerator.prepareData(matL.getText(), lastL.getText(), firsL.getText(), birtL.getText(),
                		sexlL.getText(), iL.getText(), lL.getText(), sL.getText(), contL.getText(),
                		adL.getText(), bL.getText(), pnL.getText(), ppL.getText());
				
                ImageIcon QRC = QRGenerator.createQRCode(
						data, studentByName.personal().name().last(), studentByName.personal().name().first());

				qcL.setIcon(QRC);
                dialog.setVisible(true);

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

	public synchronized static void confirmUpdate(MainMenu owner)
    {
//        var pan = owner.getCenterpane();
//        var table = owner.getDataTable();
//        int i = table.getSelectedRow();
//        int choice = JOptionPane.showConfirmDialog
//                        (
//                            pan,
//                            new Message(Message.CONFIRM_UPDATE_INFO_MSG),
//                            Message.DEFAULT_TITLE_MSG,
//                            JOptionPane.YES_NO_OPTION,
//                            JOptionPane.QUESTION_MESSAGE,
//                            Iconifier.questionIcon
//                        );
//        if(choice == JOptionPane.YES_OPTION)
//        {
//            if(i < 0)
//            {
//                JOptionPane.showMessageDialog
//                (
//                    pan,
//                    new Message("VEUILLEZ SELECTIONNER UN ETUDIANT !"),
//                    Message.DEFAULT_TITLE_MSG,
//                    JOptionPane.WARNING_MESSAGE,
//                    Iconifier.warningIcon
//                );
//            }
//            else
//            {
//                var lN = table.getModel().getValueAt(i, 2).toString();
//                var fN = table.getModel().getValueAt(i, 3).toString();
//                Student stu  = new Student(null, lN, fN, null, null, null, null, null, null, null ,null,
//                        null, null, null, null, null, null, null, null);
//
//                var pp = owner.getStudentClientprofile();
//                var lastF = owner.getLastnamefield();
//                var firsF = owner.getFirstnamefield();
//                var birtF = owner.getBirthdate();
//                var cniF = owner.getCnifield();
//                var sexlF = owner.getSexlist();
//                var blooF = owner.getBloodlist();
//                var fathF = owner.getFathernamefield();
//                var fatnF = owner.getFathernumberfield();
//                var fatfF = owner.getFatherfunctionfield();
//                var mothF = owner.getMothernamefield();
//                var motnF = owner.getMothernumberfield();
//                var motfF = owner.getMotherfunctionfield();
//                var tutoF = owner.getTutornamefield();
//                var tutnF = owner.getTutornumberfield();
//                var tutfF = owner.getTutorfunctionfield();
//                var reliF = owner.getReligionfield();
//                var phonF = owner.getPhonenumberfield();
//                var addrF = owner.getAddressfield();
//                var card = owner.getCard();
//
//                try
//                {
//                    Student sta = StudentManager.getInstance().getStudentByName(stu);
//                    pp.setIcon(new ImageIcon(sta.profile()));
//                    lastF.setText(sta.lastName());
//                    firsF.setText(sta.firstName());
//                    birtF.getDateEditor().setDate(sta.birthDate());
//                    cniF.setText(sta.cni());
//                    sexlF.setSelectedItem(sta.sex());
//                    blooF.setSelectedItem(sta.bloodGroup());
//                    fathF.setText(sta.fatherName());
//                    fatnF.setText(sta.fatherNumber());
//                    fatfF.setText(sta.fatherFunction());
//                    mothF.setText(sta.motherName());
//                    motnF.setText(sta.motherNumber());
//                    motfF.setText(sta.motherFunction());
//                    tutoF.setText(sta.tutorName());
//                    tutnF.setText(sta.tutorNumber());
//                    tutfF.setText(sta.tutorFunction());
//                    reliF.setText(sta.religion());
//                    phonF.setText(sta.phoneNumber());
//                    addrF.setText(sta.address());
//                    Placeholder.removePlaceholderStyle(lastF);
//                    Placeholder.removePlaceholderStyle(firsF);
//                    Placeholder.removePlaceholderStyle(cniF);
//                    Placeholder.removePlaceholderStyle(fathF);
//                    Placeholder.removePlaceholderStyle(fatnF);
//                    Placeholder.removePlaceholderStyle(fatfF);
//                    Placeholder.removePlaceholderStyle(mothF);
//                    Placeholder.removePlaceholderStyle(motnF);
//                    Placeholder.removePlaceholderStyle(motfF);
//                    Placeholder.removePlaceholderStyle(tutoF);
//                    Placeholder.removePlaceholderStyle(tutnF);
//                    Placeholder.removePlaceholderStyle(tutfF);
//                    Placeholder.removePlaceholderStyle(reliF);
//                    Placeholder.removePlaceholderStyle(phonF);
//                    Placeholder.removePlaceholderStyle(addrF);
//
//                    owner.getStudentValidate().setEnabled(false);
//                    owner.getStudentUpdate().setEnabled(true);
//                    card.show(pan, owner.getList(1));
//                }
//                catch(Exception exception)
//                {
//                    String errMsg = exception.getMessage();
//                    JOptionPane.showMessageDialog
//                    (
//                            pan,
//                            new Message(errMsg),
//                            Message.ERROR_TITLE_MSG,
//                            JOptionPane.ERROR_MESSAGE,
//                            Iconifier.errorIcon
//                    );
//                }
//            }
//        }
    }

	public synchronized static void delete(MainMenu owner)
	{
        var pan = owner.getCenterpane();
        var table = owner.getDataTable();
        int i = table.getSelectedRow();
        if(i < 0)
        {
            JOptionPane.showMessageDialog
            (
                pan,
                new Message("VEUILLEZ SELECTIONNER UN ETUDIANT !"),
                Message.DEFAULT_TITLE_MSG,
                JOptionPane.WARNING_MESSAGE,
                Iconifier.warningIcon
            );
        }
        else
        {
        	int choice = JOptionPane.showConfirmDialog
                    (
                        pan,
                        new Message(Message.CONFIRM_DELETE_INFO_MSG),
                        Message.DEFAULT_TITLE_MSG,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        Iconifier.questionIcon
                    );
		    if(choice == JOptionPane.YES_OPTION)
		    {

		        var matri = table.getModel().getValueAt(i, 1).toString();
		        var lN = table.getModel().getValueAt(i, 2).toString();
		        var fN = table.getModel().getValueAt(i, 3).toString();
		        int stu_id;
//		        Student stu  = new Student(null, lN, fN, null, null, null, null, null, null, null ,null,
//		                null, null, null, null, null, null, null, null);
//		        try
//		        {
//		            stu_id = StudentManager.getInstance().getId(stu);
//		            SchoolRegister.getSingleton().deleteRegistredStudent(new Register(matri, 0, stu_id, 0, 0, 0));
//		            StudentManager.getInstance().deleteStudentByName(stu);
//		            DataTableController.populateTable(owner);
//		            RegisterInfoController.inform(owner);
//
//		            JOptionPane.showMessageDialog
//                    (
//                        pan,
//                        new Message(Message.DELETE_SUCCES_MSG),
//                        Message.DEFAULT_TITLE_MSG,
//                        JOptionPane.INFORMATION_MESSAGE,
//                        Iconifier.confirmIcon
//                    );
//		        }
//		        catch(Exception exception)
//		        {
//		            String errMsg = exception.getMessage();
//		            JOptionPane.showMessageDialog
//		            (
//		                pan,
//		                new Message(errMsg),
//		                Message.ERROR_TITLE_MSG,
//		                JOptionPane.ERROR_MESSAGE,
//		                Iconifier.errorIcon
//		            );
//		        }
            }
        }
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
			owner.getCard().show(pan, owner.getList(0));
		}
	}
}
