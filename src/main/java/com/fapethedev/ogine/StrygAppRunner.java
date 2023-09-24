package com.fapethedev.ogine;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.fapethedev.ogine.model.database.manager.DBConnectionManager;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.fapethedev.ogine.model.properties.PropertiesManager;
import com.fapethedev.ogine.utilities.LookAndFeelSetter;
import com.fapethedev.ogine.utilities.Path;
import com.fapethedev.ogine.utilities.SwingUtils;
import com.fapethedev.ogine.view.launch.LauncherPage;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */

public class StrygAppRunner
{
    public static void main(String[] args)
    {
    	JFrame.setDefaultLookAndFeelDecorated(true);
    	LookAndFeelSetter.defineLAF(new FlatIntelliJLaf());
    	Path.createDirectory();
    	
        SwingUtilities.invokeLater(() ->
        {
            DBConnectionManager.getSingleton(PropertiesManager.getManager().getDatabaseProperties());
            LauncherPage mlll = LauncherPage.getInstance(true);
            
            mlll.setAlwaysOnTop(false);
            
            System.out.println(SwingUtils.getMainWidth());
            System.out.println(SwingUtils.getHeight());
        });
    }
}