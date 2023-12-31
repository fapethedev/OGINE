package com.fapethedev.ogine.utilities;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Iconifier 
{
	public static ImageIcon aboutIcon;
	public static ImageIcon adminIcon;
	public static ImageIcon boyUpIcon;
	public static ImageIcon clientIcon;
	public static ImageIcon closeFolderIcon;
	public static ImageIcon confirmIcon;
	public static ImageIcon contactIcon;
	public static ImageIcon pdfIcon;
	public static ImageIcon errorIcon;
	public static ImageIcon errorFormIcon;
	public static ImageIcon errorLightIcon;
	public static ImageIcon exitIcon;
	public static ImageIcon exitIcon32;
    public static ImageIcon exportIcon;
	public static ImageIcon formIcon;
	public static ImageIcon girlUpIcon;
	public static ImageIcon importIcon;
	public static ImageIcon infoIcon;
	public static ImageIcon loginIcon;
	public static ImageIcon logoutIcon;
	public static ImageIcon maskIcon;
	public static ImageIcon newFormIcon;
	public static ImageIcon openIcon;
	public static ImageIcon openFolderIcon;
	public static ImageIcon passwordLabelIcon;
	public static ImageIcon pickerIcon;
	public static ImageIcon printIcon;
	public static ImageIcon resetIcon;
	public static ImageIcon revFormIcon;
	public static ImageIcon showIcon;
	public static ImageIcon saveIcon;
	public static ImageIcon shortcutIcon;
	public static ImageIcon updateFormIcon;
	public static ImageIcon userProfileIcon;
	public static ImageIcon userProfileIcon32;
	public static ImageIcon userProfileIcon48;
	public static ImageIcon userProfileIcon64;
	public static ImageIcon userFieldIcon;
	public static ImageIcon validateIcon;
	public static ImageIcon warningIcon;
	public static ImageIcon splashImage;
	public static ImageIcon searchIcon;
	public static ImageIcon calendarIcon;
	public static ImageIcon enregIcon;
	public static ImageIcon listIcon;
	public static ImageIcon inscrIcon;
	public static ImageIcon optIcon;
	public static ImageIcon questionIcon;
	public static ImageIcon paramIcon;
	public static ImageIcon deleteIcon16px;
	public static ImageIcon previewIcon;
	public static ImageIcon workspaceIcon;
	public static ImageIcon dashIcon;
	public static ImageIcon removeIcon;
	public static ImageIcon printerIcon;
	public static ImageIcon cardLogo;
	public static ImageIcon redoIcon;
	public static ImageIcon undoIcon;
	public static ImageIcon sshotIcon;
	public static ImageIcon newIcon;
	public static ImageIcon backIcon;
	public static ImageIcon teamIcon;
	
	static
	{
        userProfileIcon = new ImageIcon(Iconifier.class.getResource("/icons/userProfile.png"));
        userProfileIcon32 = new ImageIcon(Iconifier.class.getResource("/icons/userProfile32.png"));
        userProfileIcon48 = new ImageIcon(Iconifier.class.getResource("/icons/userProfile48.png"));
        userProfileIcon64 = new ImageIcon(Iconifier.class.getResource("/icons/userProfile64.png"));
        userFieldIcon = new ImageIcon(Iconifier.class.getResource("/icons/userIcon.png"));
        passwordLabelIcon = new ImageIcon(Iconifier.class.getResource("/icons/passwordIcon.png"));
        loginIcon = new ImageIcon(Iconifier.class.getResource("/icons/connexion.png"));
        resetIcon = new ImageIcon(Iconifier.class.getResource("/icons/close16px.png"));
        showIcon = new ImageIcon(Iconifier.class.getResource("/icons/eyecrossed.png"));
        maskIcon = new ImageIcon(Iconifier.class.getResource("/icons/eye.png"));
        exitIcon = new ImageIcon(Iconifier.class.getResource("/icons/exitLoginIcon64px2.png"));
        exitIcon32 = new ImageIcon(Iconifier.class.getResource("/icons/exitIcon.png"));
        confirmIcon = new ImageIcon(Iconifier.class.getResource("/icons/confirm.png"));
        errorIcon = new ImageIcon(Iconifier.class.getResource("/icons/errorIcon.png"));
        warningIcon = new ImageIcon(Iconifier.class.getResource("/icons/warningIcon.png"));
        adminIcon = new ImageIcon(Iconifier.class.getResource("/icons/adminIcon.png"));
        logoutIcon = new ImageIcon(Iconifier.class.getResource("/icons/logoutIcon.png"));
        clientIcon = new ImageIcon(Iconifier.class.getResource("/icons/clientprofileIcon.png"));
        pickerIcon = new ImageIcon(Iconifier.class.getResource("/icons/addIcon.png"));

        formIcon = new ImageIcon(Iconifier.class.getResource("/icons/formIcon.png"));
        newFormIcon = new ImageIcon(Iconifier.class.getResource("/icons/newFormIcon.png"));
        revFormIcon = new ImageIcon(Iconifier.class.getResource("/icons/revFormIcon.png"));
        aboutIcon = new ImageIcon(Iconifier.class.getResource("/icons/aboutIcon.png"));
        contactIcon = new ImageIcon(Iconifier.class.getResource("/icons/contactIcon.png"));
        shortcutIcon = new ImageIcon(Iconifier.class.getResource("/icons/shortcutIcon.png"));

        paramIcon = new ImageIcon(Iconifier.class.getResource("/icons/themeIcon.png"));
        openIcon = new ImageIcon(Iconifier.class.getResource("/icons/openIcon.png"));
        saveIcon = new ImageIcon(Iconifier.class.getResource("/icons/saveIcon.png"));
        printIcon = new ImageIcon(Iconifier.class.getResource("/icons/printIcon.png"));
        importIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/importIcon.png")).getImage().getScaledInstance(
        				16,
        				16,
        				Image.SCALE_DEFAULT));
        exportIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/exportIcon.png")).getImage().getScaledInstance(
				16,
				16,
				Image.SCALE_DEFAULT));

        closeFolderIcon = new ImageIcon(Iconifier.class.getResource("/icons/closeFolderIcon.png"));
        errorFormIcon = new ImageIcon(Iconifier.class.getResource("/icons/errorFormIcon.png"));
        pdfIcon = new ImageIcon(Iconifier.class.getResource("/icons/pdfIcon.png"));
        infoIcon = new ImageIcon(Iconifier.class.getResource("/icons/infoIcon.png"));
        openFolderIcon = new ImageIcon(Iconifier.class.getResource("/icons/openFolderIcon.png"));
        updateFormIcon = new ImageIcon(Iconifier.class.getResource("/icons/updateFormIcon.png"));

        validateIcon = new ImageIcon(Iconifier.class.getResource("/icons/validateIcon.png"));
        errorLightIcon = new ImageIcon(Iconifier.class.getResource("/icons/errorIconLight.png"));

        splashImage = new ImageIcon(Iconifier.class.getResource("/images/splashScreen.png"));

        searchIcon = new ImageIcon(Iconifier.class.getResource("/textfield_icon/loupeIcon16px.png"));
        calendarIcon = new ImageIcon(Iconifier.class.getResource("/icons/calendarIcon.png"));

        cardLogo = new ImageIcon(Iconifier.class.getResource("/icons/cardLogo.png"));

        questionIcon = new ImageIcon(Iconifier.class.getResource("/icons/questionIcon.png"));
        deleteIcon16px = new ImageIcon(Iconifier.class.getResource("/icons/deleteIcon16px.png"));
        previewIcon = new ImageIcon(Iconifier.class.getResource("/icons/previewIcon.png"));

        workspaceIcon = new ImageIcon(Iconifier.class.getResource("/icons/workspaceIcon.png"));
        dashIcon = new ImageIcon(Iconifier.class.getResource("/icons/dashIcon.png"));
        removeIcon = new ImageIcon(Iconifier.class.getResource("/icons/removeIcon.png"));
        
        printerIcon = new ImageIcon(Iconifier.class.getResource("/icons/printerIcon.png"));
        
        redoIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/redoIcon.png")).getImage().getScaledInstance(
				16,
				16,
				Image.SCALE_SMOOTH));
    	undoIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/undoIcon.png")).getImage().getScaledInstance(
				16,
				16,
				Image.SCALE_SMOOTH));
    	sshotIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/camIcon.png")).getImage().getScaledInstance(
				16,
				16,
				Image.SCALE_SMOOTH));
    	
    	newIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/newIcon.png")).getImage().getScaledInstance(
				16,
				16,
				Image.SCALE_SMOOTH));
    	
    	backIcon = new ImageIcon(Iconifier.class.getResource("/icons/backIcon.png"));
    	
    	boyUpIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/boyupicon.png")).getImage().getScaledInstance(
				48,
				48,
				Image.SCALE_SMOOTH));
    	
    	girlUpIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/girlupicon.png")).getImage().getScaledInstance(
				48,
				48,
				Image.SCALE_SMOOTH));
    	
    	teamIcon = new ImageIcon(new ImageIcon(Iconifier.class.getResource("/icons/teamIcon.png")).getImage().getScaledInstance(
				64,
				64,
				Image.SCALE_SMOOTH));
	}
}
