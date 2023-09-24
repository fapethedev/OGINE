package com.fapethedev.ogine.controller.form;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fapethedev.ogine.model.database.manager.SpecialityManager;
import com.fapethedev.ogine.model.database.entities.Speciality;
import com.fapethedev.ogine.model.database.entities.Student;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.manager.InstitutManager;
import com.fapethedev.ogine.model.database.manager.LevelManager;
import com.fapethedev.ogine.model.database.manager.StudentManager;
import com.fapethedev.ogine.model.database.entities.Institut;
import com.fapethedev.ogine.model.database.entities.Level;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.view.menu.MainMenu;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class RegisterInfoController 
{
	public synchronized static void inform(MainMenu owner)
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
		
		try
		{
			var studentList = StudentManager.getInstance().getAllStudents();
			
            if(sB.getItemCount() > 0)
            {
                sB.removeAllItems();
            }
			for(var student : studentList)
			{
				sB.addItem(student);
			}
		}
		catch (Exception e) 
		{
			System.err.println(e);
		}
		sB.setSelectedIndex(-1);
		
		try
		{
			var institutList = InstitutManager.getSingleton().getInstitutList();
			
			if(iB.getItemCount() > 0)
            {
                iB.removeAllItems();
            }
			for(var instit : institutList)
			{
				iB.addItem(instit);
			}
		}
		catch (Exception e) 
		{
			System.err.println(e);
		}
		iB.setSelectedIndex(-1);
		
		sB.addItemListener(e ->{
			if(sB.getSelectedItem() instanceof Student student)
			{
				try
				{
//					var selectedStudent = StudentManager.getInstance().getStudentByName(student);
//
//					pp.setIcon(new ImageIcon(selectedStudent.profile()));
//					lastF.setText(selectedStudent.lastName());
//					firsF.setText(selectedStudent.firstName());
//					birtF.setText(selectedStudent.birthDate().toString());
//					sexlF.setText(selectedStudent.sex());
//					cniF.setText(selectedStudent.cni());
//					phonF.setText(selectedStudent.phoneNumber());
//					addrF.setText(selectedStudent.address());
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
				ArrayList<Level> levelList = new ArrayList<>();
				lB.removeAllItems();
				try
				{
					levelList =  LevelManager.getSingleton().getLevelList(institut);
					
					for(var level : levelList)
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
			if(lB.getSelectedItem() instanceof Level level && iB.getSelectedItem() instanceof Institut institut)
			{
                ArrayList<Speciality> specialityList = new ArrayList<>();
                spB.removeAllItems();
				try
				{
					specialityList =  SpecialityManager.getSingleton().getSpecialtyList(institut, level);
					
					for(var speciality : specialityList)
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
}
