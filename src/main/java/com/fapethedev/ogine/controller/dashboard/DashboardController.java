package com.fapethedev.ogine.controller.dashboard;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.Colors;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.launch.LauncherPage;
import com.fapethedev.ogine.view.menu.MainMenu;

import javax.swing.*;
import java.awt.*;

/**
 * @author FATIGBA Abiola Pierre-Edy
 * 
 */
public class DashboardController
{
	public static synchronized void logout(MainMenu owner)
	{
		int choice = JOptionPane.showConfirmDialog
				 (
					owner,
					new Message(Message.LOGOUT_INFO_MSG),
					Message.LOGOUT_TITLE_MSG,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE,
					Iconifier.warningIcon
				 );
		if(choice == JOptionPane.YES_OPTION)
		{
			LauncherPage log = LauncherPage.getInstance(false);
			MainMenu.getInstance().dispose();
			log.setVisible(true);
		}
	}
	
	public static synchronized void showInsInfo(MainMenu owner)
	{
		owner.getDash().getInscrBut().addActionListener(e ->{
        	owner.card.show(owner.getCenterpane(), owner.getList(2));
        	owner.getToolBar().getShowRButtonIcon().setForeground(Color.BLACK);
        	owner.getToolBar().getShowRButtonIcon().setBackground(Color.WHITE);
        	owner.getToolBar().getShowIButtonIcon().setForeground(Color.WHITE);
        	owner.getToolBar().getShowIButtonIcon().setBackground(Colors.getInstance().BLUE);
        	owner.getToolBar().getShowLButtonIcon().setForeground(Color.BLACK);
        	owner.getToolBar().getShowLButtonIcon().setBackground(Color.WHITE);
        	owner.getToolBar().getShowPButtonIcon().setForeground(Color.BLACK);
        	owner.getToolBar().getShowPButtonIcon().setBackground(Color.WHITE);
        	owner.getToolBar().getShowOButtonIcon().setForeground(Color.BLACK);
        	owner.getToolBar().getShowOButtonIcon().setBackground(Color.WHITE);
        });
	}

	public static synchronized void showListInfo(MainMenu owner) {
		owner.getDash().getListBut().addActionListener(e -> {
			owner.card.show(owner.getCenterpane(), owner.getList(3));
			owner.getToolBar().getShowRButtonIcon().setForeground(Color.BLACK);
			owner.getToolBar().getShowRButtonIcon().setBackground(Color.WHITE);
			owner.getToolBar().getShowLButtonIcon().setForeground(Color.WHITE);
			owner.getToolBar().getShowLButtonIcon().setBackground(Colors.getInstance().BLUE);
			a(owner);
		});
	}




	public static synchronized void showEnregInfo(MainMenu owner) {
		owner.getDash().getEnregBut().addActionListener(e -> {

			owner.card.show(owner.getCenterpane(), owner.getList(1));
			owner.getToolBar().getShowRButtonIcon().setForeground(Color.WHITE);
			owner.getToolBar().getShowRButtonIcon().setBackground(Colors.getInstance().BLUE);
			owner.getToolBar().getShowLButtonIcon().setForeground(Color.BLACK);
			owner.getToolBar().getShowLButtonIcon().setBackground(Color.WHITE);
			a(owner);
		});
	}

	public static synchronized void showReportInfo(MainMenu owner) {
		owner.getDash().getReportBut().addActionListener(e -> {
			owner.card.show(owner.getCenterpane(), owner.getList(5));
			b(owner);
			owner.getToolBar().getShowPButtonIcon().setForeground(Color.WHITE);
			owner.getToolBar().getShowPButtonIcon().setBackground(Colors.getInstance().BLUE);
			owner.getToolBar().getShowOButtonIcon().setForeground(Color.BLACK);
			owner.getToolBar().getShowOButtonIcon().setBackground(Color.WHITE);
		});
	}

	public static synchronized void showOptionInfo(MainMenu owner) {
		owner.getDash().getOptBut().addActionListener(e -> {
			owner.card.show(owner.getCenterpane(), owner.getList(4));
			b(owner);
			owner.getToolBar().getShowPButtonIcon().setForeground(Color.BLACK);
			owner.getToolBar().getShowPButtonIcon().setBackground(Color.WHITE);
			owner.getToolBar().getShowOButtonIcon().setForeground(Color.WHITE);
			owner.getToolBar().getShowOButtonIcon().setBackground(Colors.getInstance().BLUE);
		});
	}

	public static synchronized void exit(MainMenu owner) {
		owner.getDash().getLogoutBut().addActionListener(e -> {
			logout(owner);
			owner.getToolBar().getShowRButtonIcon().setForeground(Color.BLACK);
			owner.getToolBar().getShowRButtonIcon().setBackground(Color.WHITE);
			owner.getToolBar().getShowLButtonIcon().setForeground(Color.BLACK);
			owner.getToolBar().getShowLButtonIcon().setBackground(Color.WHITE);
			a(owner);
		});
	}

	private static void a(MainMenu owner) {
		owner.getToolBar().getShowIButtonIcon().setForeground(Color.BLACK);
		owner.getToolBar().getShowIButtonIcon().setBackground(Color.WHITE);
		owner.getToolBar().getShowPButtonIcon().setForeground(Color.BLACK);
		owner.getToolBar().getShowPButtonIcon().setBackground(Color.WHITE);
		owner.getToolBar().getShowOButtonIcon().setForeground(Color.BLACK);
		owner.getToolBar().getShowOButtonIcon().setBackground(Color.WHITE);
	}

	private static void b(MainMenu owner) {
		owner.getToolBar().getShowRButtonIcon().setForeground(Color.BLACK);
		owner.getToolBar().getShowRButtonIcon().setBackground(Color.WHITE);
		owner.getToolBar().getShowLButtonIcon().setForeground(Color.BLACK);
		owner.getToolBar().getShowLButtonIcon().setBackground(Color.WHITE);
		owner.getToolBar().getShowIButtonIcon().setForeground(Color.BLACK);
		owner.getToolBar().getShowIButtonIcon().setBackground(Color.WHITE);
	}
}
