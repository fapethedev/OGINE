package com.fapethedev.ogine.controller.table;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.component.dialog.SchoolStudentViewerDialog;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class DataTableShowController
{
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
//        else
//        {
//            var lN = table.getModel().getValueAt(i, 2).toString();
//            var fN = table.getModel().getValueAt(i, 3).toString();
//            Student stu  = new Student(null, lN, fN, null, null, null, null, null, null, null ,null,
//                    null, null, null, null, null, null, null, null);
//            var pL = dialog.getPictureLab();
//            var matL = dialog.getMatriLab();
//            var lastL = dialog.getLastNameLab();
//            var firsL = dialog.getFirstNameLab();
//            var birtL = dialog.getDateNLab();
//            var sexlL = dialog.getSexeLab();
//            var contL = dialog.getPhoneLab();
//            var adL = dialog.getAddrLab();
//            var iL = dialog.getInstitutLab();
//            var lL = dialog.getLevelLab();
//            var sL = dialog.getSpecLab();
//            var pnL = dialog.getParNameLab();
//            var ppL = dialog.getParPhoneLab();
//            var bL = dialog.getBloodLab();
//            var qcL = dialog.getQRLab();
//            try
//            {
//                Student sta = StudentManager.getInstance().getStudentByName(stu);
//                pL.setIcon(new ImageIcon(sta.profile()));
//                matL.setText(table.getModel().getValueAt(i, 1).toString());
//                lastL.setText(sta.lastName());
//                firsL.setText(sta.firstName());
//                birtL.setText(sta.birthDate().toString());
//                sexlL.setText(sta.sex());
//                iL.setText(table.getModel().getValueAt(i, 5).toString());
//                lL.setText(table.getModel().getValueAt(i, 6).toString());
//                sL.setText(table.getModel().getValueAt(i, 7).toString());
//                contL.setText(sta.phoneNumber());
//                adL.setText(sta.address());
//                bL.setText(sta.bloodGroup());
//                pnL.setText(sta.tutorName());
//                ppL.setText(sta.tutorNumber());
//
//                String data = QRGenerator.prepareData(matL.getText(), lastL.getText(), firsL.getText(), birtL.getText(),
//                		sexlL.getText(), iL.getText(), lL.getText(), sL.getText(), contL.getText(),
//                		adL.getText(), bL.getText(), pnL.getText(), ppL.getText());
//                ImageIcon QRC = QRGenerator.createQRCode(data, sta.lastName(), sta.firstName());
//                qcL.setIcon(QRC);
//                dialog.setVisible(true);
//
//            }
//            catch(Exception exception)
//            {
//                String errMsg = exception.getMessage();
//                JOptionPane.showMessageDialog
//                (
//                        pan,
//                        new Message(errMsg),
//                        Message.ERROR_TITLE_MSG,
//                        JOptionPane.ERROR_MESSAGE,
//                        Iconifier.errorIcon
//                );
//            }
//        }
    }
}
