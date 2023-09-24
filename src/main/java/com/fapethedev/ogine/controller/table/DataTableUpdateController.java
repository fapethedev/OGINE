package com.fapethedev.ogine.controller.table;

import com.fapethedev.ogine.view.menu.MainMenu;

/**
 *
 * @author FATIGBA Abiola Pierre-Edy
 */
public class DataTableUpdateController
{
    public synchronized static void confirm(MainMenu owner)
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
}
