package com.fapethedev.ogine.view.menu;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.alee.extended.layout.VerticalFlowLayout;
import com.fapethedev.ogine.controller.dashboard.DashboardController;
import com.fapethedev.ogine.controller.jasperreport.JasperReportSchoolStudentController;
import com.fapethedev.ogine.controller.jasperreport.JaspertReportRegisterController;
import com.fapethedev.ogine.controller.jasperreport.JaspertReportStudentController;
import com.fapethedev.ogine.controller.table.DataTableController;
import com.fapethedev.ogine.model.database.manager.SchoolRegister;
import com.fapethedev.ogine.model.database.manager.StudentManager;
import com.fapethedev.ogine.model.database.entities.Institut;
import com.fapethedev.ogine.model.database.entities.Speciality;
import com.fapethedev.ogine.model.database.entities.Student;
import com.fapethedev.ogine.model.database.exception.SchoolRegisterException;
import com.fapethedev.ogine.model.database.exception.StudentManagerException;
import com.fapethedev.ogine.utilities.ChartGenerator;
import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.OgineColor;
import com.fapethedev.ogine.utilities.SwingUtils;
import com.fapethedev.ogine.view.component.Dashboard;
import com.fapethedev.ogine.view.component.MenuBar;
import com.fapethedev.ogine.view.component.ToolBar;
import com.fapethedev.ogine.view.component.border.RoundedBorder;
import com.fapethedev.ogine.view.component.border.UnderlineBorder;
import com.fapethedev.ogine.view.component.button.ArrowButton;
import com.fapethedev.ogine.view.component.button.OButton;
import com.fapethedev.ogine.view.component.field.OJTextField;
import com.fapethedev.ogine.view.component.field.OSearchField;
import com.fapethedev.ogine.view.component.field.OTextField;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.view.component.renderer.BoldListCellRenderer;
import com.fapethedev.ogine.view.component.renderer.BoldTableCellRenderer;
import com.fapethedev.ogine.view.component.ui.ComboUI;
import com.fapethedev.ogine.view.component.ui.RoundComboUI;
import com.formdev.flatlaf.ui.FlatComboBoxUI;
import com.formdev.flatlaf.ui.FlatTableHeaderUI;
import com.fapethedev.ogine.controller.form.ReRegisterCancelController;
import com.fapethedev.ogine.controller.form.ReRegisterInfoController;
import com.fapethedev.ogine.controller.form.RegisterCancelController;
import com.fapethedev.ogine.controller.form.RegisterInfoController;
import com.fapethedev.ogine.controller.form.RegisterResetController;
import com.fapethedev.ogine.controller.form.RegisterUpdateController;
import com.fapethedev.ogine.controller.form.RegisterValidateController;
import com.fapethedev.ogine.controller.form.StudentRegisterController;
import com.fapethedev.ogine.controller.table.DataTableCancelController;
import com.fapethedev.ogine.controller.table.DataTableDeleteController;
import com.fapethedev.ogine.controller.table.DataTableShowController;
import com.fapethedev.ogine.controller.table.DataTableUpdateController;
import com.fapethedev.ogine.model.database.entities.Level;
import com.fapethedev.ogine.view.component.listeners.AlphaKeyListener;
import com.fapethedev.ogine.view.component.listeners.NewFormButAdapter;
import com.fapethedev.ogine.view.component.listeners.NumberCaretListener;
import com.fapethedev.ogine.view.component.listeners.NumberKeyListener;
import com.fapethedev.ogine.view.component.listeners.OButtonMouseAdapter;
import com.fapethedev.ogine.view.component.listeners.PaneMouseAdapter;
import com.fapethedev.ogine.view.component.panel.OPanel;
import com.fapethedev.ogine.view.component.panel.SliderPanel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import lombok.Getter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
@Getter
public class MainMenu extends JFrame 
{
    private static MainMenu singleton;

    public static final int WIDTH  = SwingUtils.getMainWidth();
    public static final int HEIGTH = SwingUtils.getHeight();
    public final Dimension MAINMENU_DIM = new Dimension(WIDTH, HEIGTH);

    private final int FORM_WIDTH = SwingUtils.getMainWidth() - 262;
    private final int FORM_HEIGTH = SwingUtils.getHeight() - 68;
    private final Dimension FORM_DIM = new Dimension(FORM_WIDTH, FORM_HEIGTH);

    private final Font FORM_BUT_FONT = new JButton().getFont().deriveFont(Font.BOLD);
    private final Font FORM_TITLE_FONT = new Font("Arial", Font.BOLD, 20);
    private final Font FORM_FONT = new Font("Arial", Font.BOLD, 18);
    private final Font COMBO_FONT = new Font("Arial", Font.BOLD, 16);
    private final Font CHART_FONT = new Font("Arial", Font.BOLD, 42);
    
    private JPanel defaultPane;
    private JPanel studentRegisterChartPane;
    private JPanel studentRegisterPane;
    private JPanel reRegisterPane;
    private JPanel registerChartPane;
    private JPanel registerPane;
    private JPanel dataChartPane;
    private JPanel dataPane;
	private JPanel jasperPane;
    private JPanel optionPane;
    private JTabbedPane tabbedPane;
    private SliderPanel studentSliderPane;
    private SliderPanel registerSliderPane;
    private SliderPanel reRegisterSliderPane;

    private BufferedImage image;
    private String[] list = {"DEFAULT", "SLIDE_1", "SLIDE_2", "LISTE", "OPTION", "JASPER"};
    private JPanel mainPane;
    private JPanel centerPane;
    private Dashboard dash;

    public CardLayout card;

    private ToolBar toolBar;
    private JTable dataTable;

    private OTextField lastnameField;
    private OTextField firstnameField;
    private JDateChooser birthdate;
    private OTextField cniField;
    private JComboBox<String> sexList;
    private JComboBox<String> bloodList;
    private OTextField fathernameField;
    private OTextField fathernumberField;
    private OTextField fatherfunctionField;
    private OTextField mothernameField;
    private OTextField mothernumberField;
    private OTextField motherfunctionField;
    private OTextField tutornameField;
    private OTextField tutornumberField;
    private OTextField tutorfunctionField;
    private OTextField phonenumberField;
    private OTextField addressField;
    private OTextField religionField;
	
    private OTextField lastnameField2;
    private OTextField firstnameField2;
    private OTextField birthField;
    private OTextField cniField2;
    private OTextField sexField;
    private OTextField phonenumberField2;
    private OTextField addressField2;

    private JComboBox<Student> studentBox;
    private JYearChooser yearField;
    private OJTextField matriculeField;
    private JComboBox<Institut> institutBox;
    private JComboBox<Level> levelBox;
    private JComboBox<Speciality> specialityBox;

    private OTextField lastnameField3;
    private OTextField firstnameField3;
    private OTextField birthField2;
    private OTextField institutField;
    private OTextField sexField2;
    private OTextField phonenumberField3;
    private OTextField addressField3;

    private JComboBox<Student> studentBox2;
    private JYearChooser yearField2;
    private OTextField matriculeField2;
    private JComboBox<Institut> institutBox2;
    private JComboBox<Level> levelBox2;
    private JComboBox<Speciality> specialityBox2;

    private OSearchField searchField;
    
    private JComboBox<String> yearSorter;
    private JComboBox<Institut> instiSorter;
    private JComboBox<Level> levelSorter;
    private JComboBox<Speciality> specSorter;

    private JLabel studentClientProfile;
    private JLabel registerClientProfile;
    private JLabel reRegisterClientProfile;
    //
    private JButton studentChartSaveBut;
    private OButton newStudentRegisterFormBut;
    private OButton studentPicturePicker;
    private JButton studentValidate;
    private JButton studentReset;
    private JButton studentCancel;
    private JButton studentUpdate;
    //
    private OButton newRegisterFormBut;
    private OButton newReRegisterFormBut;
    private JButton nrChartSaveBut;
    private JButton registerValidate;
    private JButton registerReset;
    private JButton registerCancel;
    private JButton registerUpdate;
    private JButton reRegisterValidate;
    private JButton reRegisterReset;
    private JButton reRegisterCancel;
    private JButton reRegisterUpdate;
    
    private JButton previewBut;
    private JButton updateBut;
    private JButton deleteBut;
    private JButton cancelBut;
    
    private OButton sorterBut;
    
    private JButton enregReportBut;
    private JButton listReportBut;
    private JButton fullReportBut;
    
    private final AlphaKeyListener alphaKeyListener = new AlphaKeyListener();
    private final NumberKeyListener numberKeyListener = new NumberKeyListener();
    private final NumberCaretListener numberCaretListener = new NumberCaretListener();
    
    private MainMenu()
    {
        super();
        this.addWindowFocusListener(new WindowFocusListener()
        {	
                @Override
                public void windowLostFocus(WindowEvent e) {}

                @Override
                public void windowGainedFocus(WindowEvent e) 
                {
                	MainMenu.this.requestFocusInWindow();
                }
        });
//        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice device = environment.getDefaultScreenDevice();
//        System.err.println(device.getDisplayMode());
        initMainMenu();
        buildContentPane();
        mainMenuListeners();
        this.pack();
        DataTableController.populateTable(this);
    }

    public static MainMenu getInstance()
    {
		if (singleton == null)
		{
			synchronized(MainMenu.class)
			{
				if(singleton == null)
				{
					singleton = new MainMenu();
				}
			}
		}

		return singleton;
    }

    private void buildContentPane()
    {
        this.setTitle("STRyG");
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setAlwaysOnTop(false);
        this.setLocation(0, 0);
        try
        {
            image = ImageIO.read(new File(getClass().getResource("/icon.png").toURI()));
        } 
        catch (IOException | URISyntaxException e) 
        {
            System.err.println(e.getMessage());
        } 
        this.setIconImage(image); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setJMenuBar(new MenuBar());
        this.setExtendedState(MAXIMIZED_BOTH);
        desktopBuilder();
        createTray();
        buildLeftTabbedPane();
        buildCenterPane();
        buildDefaultPane();
        buildStudentRegisterChartPane();
        buildStudentRegisterPane();
        buildRegisterAndReregisterChartPane();
        buildxxx();
        buildDataPane();
        buildJasperPane();
        buildOptionPane();
        this.pack();
    }
    
    private void desktopBuilder()
    {
    	JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setLayout(new BorderLayout());
        JInternalFrame internalFrame = new JInternalFrame("ESPACE DE GESTION", 
        	true, false, true, false);
        internalFrame.setLayout(new BorderLayout());
        JInternalFrame internalFrame2 = new JInternalFrame("BUREAU", 
            	true, false, true, false);
        internalFrame2.setLayout(new BorderLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, internalFrame2, internalFrame);
        splitPane.setBackground(Color.WHITE);
        splitPane.setDividerLocation(268);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(toolBar, BorderLayout.NORTH);
        this.getContentPane().add(desktopPane, BorderLayout.CENTER);
        desktopPane.add(splitPane, BorderLayout.CENTER);
        internalFrame.setContentPane(centerPane);
        internalFrame.setFrameIcon(Iconifier.workspaceIcon);
        internalFrame.setPreferredSize(FORM_DIM);
        internalFrame2.setContentPane(dash);
        internalFrame2.setFrameIcon(Iconifier.dashIcon);
        internalFrame2.setPreferredSize(dash.getDASH_DIM());
        internalFrame2.setVisible(true);
        internalFrame.setVisible(true);
        try
        {
			internalFrame2.setMaximum(true);
			internalFrame.setMaximum(true);
		}
        catch(PropertyVetoException e) 
        {
			System.err.println(e.getMessage());
		}
    }
    
    private void createTray()
    {
    	if(SystemTray.isSupported())
        {
        	this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
        
        SystemTray systemTray = SystemTray.getSystemTray();
        TrayIcon trayIcon = new TrayIcon(image);
        PopupMenu popMenu = new PopupMenu();
        MenuItem show = new MenuItem("Afficher");
        MenuItem exit = new MenuItem("Quittez");
        trayIcon.setImageAutoSize(true);
        show.addActionListener(e -> this.setVisible(true) );
        exit.addActionListener(e -> System.exit(0) );
        popMenu.add(show);
        popMenu.addSeparator();
        popMenu.add(exit);
        trayIcon.setPopupMenu(popMenu);
        trayIcon.setToolTip("Gestionnaire STRyG");
        try 
        {
			systemTray.add(trayIcon);
		}
        catch (AWTException awte) 
        {
			System.err.println(awte.getMessage());
		}
    }

    private void initMainMenu()
    {
	    mainPane = new JPanel();
	    centerPane = new JPanel();
	    defaultPane = new JPanel(new GridBagLayout());
	    tabbedPane = new JTabbedPane();
	    dash = new Dashboard();
	
	    registerPane = new JPanel();
	    registerChartPane = new JPanel(new BorderLayout());
	    reRegisterPane = new JPanel();
	    studentRegisterChartPane = new JPanel(new BorderLayout());
	    studentRegisterPane = new JPanel(null);
	    dataPane = new JPanel();
	    jasperPane = new JPanel();
	    optionPane = new JPanel();

        studentSliderPane = new SliderPanel(SliderPanel.AnimationBehavior.LEFT);
        registerSliderPane = new SliderPanel(SliderPanel.AnimationBehavior.LEFT);
        reRegisterSliderPane = new SliderPanel(SliderPanel.AnimationBehavior.LEFT);
	
	    card = new CardLayout();
	    toolBar = new ToolBar("Barre d'Outils");
    }

    private void buildLeftTabbedPane()
    { 
        dash.setLocation(new Point(0, 25));
    }

    private void buildCenterPane()
    {
    	centerPane.setBorder(BorderFactory.createLineBorder(OgineColor.DARK_BLUE, 3));
        centerPane.setLayout(card);
        centerPane.add(defaultPane, list[0]);
        //centerPane.add(studentRegisterChartPane, list[1]);
        //centerPane.add(studentRegisterPane, list[2]);

        centerPane.add(studentSliderPane, list[1]);
        centerPane.add(registerSliderPane, list[2]);

        //centerPane.add(registerChartPane, list[3]);
        //centerPane.add(tabbedPane, list[4]);
        centerPane.add(dataPane, list[3]);
        centerPane.add(optionPane, list[4]);
        centerPane.add(jasperPane, list[5]);

        registerSliderPane.setLocation(4, 4);
        registerSliderPane.setSize(FORM_DIM);
        studentSliderPane.setLocation(4, 4);
        studentSliderPane.setSize(FORM_DIM);
        studentSliderPane.init(studentRegisterChartPane, studentRegisterPane);
        registerSliderPane.init(registerChartPane, tabbedPane);

        studentSliderPane.setAnimationSpeed(55);
        registerSliderPane.setAnimationSpeed(55);

        defaultPane.setLocation(4, 4);
        defaultPane.setSize(FORM_DIM);	
        defaultPane.setBackground(OgineColor.BLUE);
        
//        studentRegisterChartPane.setLocation(4, 4);
//        studentRegisterChartPane.setSize(FORM_DIM);
        studentRegisterChartPane.setBackground(Color.WHITE);
        studentRegisterPane.setLocation(4, 4);
        studentRegisterPane.setSize(FORM_DIM);
        studentRegisterPane.setBackground(OgineColor.BLUE);
        registerChartPane.setLocation(4, 4);
        registerChartPane.setSize(FORM_DIM);
        registerChartPane.setBackground(Color.WHITE);
        tabbedPane.setLocation(4, 4);
        tabbedPane.setSize(FORM_DIM);
        dataPane.setLocation(4, 4);
        dataPane.setSize(FORM_DIM);
        optionPane.setLocation(4, 4);
        optionPane.setSize(FORM_DIM);
        jasperPane.setLocation(4, 4);
        jasperPane.setSize(FORM_DIM);

        card.show(centerPane, list[0]);
    }

    private void buildDefaultPane()
    {
        JPanel splashPane;
        JLabel splashLabel;
        JLabel paneTitle;
        GridBagConstraints gbc = new GridBagConstraints();

        splashPane = new JPanel();
        paneTitle = new JLabel(Message.DEFAULT_PANE_FORM_TITLE);
        splashLabel = new JLabel(Iconifier.splashImage);

        paneTitle.setPreferredSize(new Dimension(600, 50));
        paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.WHITE, 2));
        paneTitle.setForeground(Color.WHITE);
        paneTitle.setHorizontalAlignment(JLabel.CENTER);
        paneTitle.setFont(FORM_TITLE_FONT);

        int y = FORM_HEIGTH / 4;
        int imgX = splashLabel.getIcon().getIconWidth();
        int imgY = splashLabel.getIcon().getIconHeight();

        splashPane.setPreferredSize(new Dimension(imgX + 5, imgY + 17));
        splashPane.setBackground(Color.WHITE);
        splashPane.setBorder(BorderFactory.createMatteBorder(4, 0, 4, 0, Color.BLACK));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(1, 1, 5, 1);
        defaultPane.add(paneTitle, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = -1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(y / 8, 1, y, 1);
        defaultPane.add(splashPane, gbc);
        splashPane.add(splashLabel, BorderLayout.PAGE_START);
    }
    
    private void buildStudentRegisterChartPane()
    {
    	JLabel paneTitle = new JLabel(Message.STUDENT_REGISTER_CHART_TITLE);
    	//
    	JLabel squadLab = new JLabel("Enregistrements");
    	JLabel squadMalLab = new JLabel("Garçons");
    	JLabel squadFemalLab = new JLabel("Filles");
    	JLabel squadNumLab = null;
    	JLabel squadMalNumLab = null;
    	JLabel squadFemalNumLab = null;
		try
		{
			squadNumLab = new JLabel("" + StudentManager.getInstance().getMaxStudents());
			squadMalNumLab = new JLabel("" + StudentManager.getInstance().getMaxMale());
	    	squadFemalNumLab = new JLabel("" + StudentManager.getInstance().getMaxFemale());
		} 
		catch(StudentManagerException e)
		{
			System.err.println(e.getMessage());
		}
    	//
    	JPanel topPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel midPane = new JPanel(new GridLayout(2, 1, 5, 5));
    	JPanel squadPane = new JPanel(new BorderLayout(1, 1));
    	JPanel squadMalPane = new JPanel(new BorderLayout(1, 1));
    	JPanel squadFemalPane = new JPanel(new BorderLayout(1, 1));
    	JPanel chartPanel = new JPanel(new BorderLayout());
    	JPanel backPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 75, 5));
    	JPanel butPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel saveButPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	//
    	topPane.setBackground(Color.WHITE);
    	//
    	midPane.setBackground(Color.WHITE);
    	//
    	backPane.setBackground(OgineColor.DARK_BLUE);
    	butPane.setBackground(OgineColor.DARK_BLUE);
    	butPane.setPreferredSize(new Dimension(250, 70));
    	//
    	squadPane.setBorder(BorderFactory.createEmptyBorder());
    	squadPane.setBackground(OgineColor.BLUE);
    	squadPane.addMouseListener(new PaneMouseAdapter());
    	//
    	squadMalPane.setBorder(BorderFactory.createEmptyBorder());
    	squadMalPane.setBackground(OgineColor.RED);
    	squadMalPane.addMouseListener(new PaneMouseAdapter());
    	//
    	squadFemalPane.setBorder(BorderFactory.createEmptyBorder());
    	squadFemalPane.setBackground(OgineColor.DARK_BLUE);
    	squadFemalPane.addMouseListener(new PaneMouseAdapter());
    	//
    	saveButPane.setBackground(Color.WHITE);
    	//
    	paneTitle.setFont(FORM_TITLE_FONT);
    	paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(2));
    	paneTitle.setHorizontalAlignment(JLabel.CENTER);
    	//
    	squadLab.setHorizontalAlignment(JLabel.CENTER);
    	squadLab.setVerticalAlignment(JLabel.CENTER);
    	squadLab.setFont(FORM_FONT);
    	squadLab.setForeground(Color.WHITE);
    	squadNumLab.setHorizontalAlignment(JLabel.CENTER);
    	squadNumLab.setVerticalAlignment(JLabel.CENTER);
    	squadNumLab.setFont(CHART_FONT);
    	squadNumLab.setForeground(Color.WHITE);
    	squadNumLab.setIcon(Iconifier.teamIcon);
    	squadNumLab.setHorizontalTextPosition(SwingConstants.LEFT);
    	squadNumLab.setIconTextGap(8);
    	//
    	squadMalLab.setHorizontalAlignment(JLabel.CENTER);
    	squadMalLab.setVerticalAlignment(JLabel.CENTER);
    	squadMalLab.setFont(FORM_FONT);
    	squadMalLab.setForeground(Color.WHITE);
    	squadMalNumLab.setHorizontalAlignment(JLabel.CENTER);
    	squadMalNumLab.setVerticalAlignment(JLabel.CENTER);
    	squadMalNumLab.setFont(CHART_FONT);
    	squadMalNumLab.setForeground(Color.WHITE);
    	squadMalNumLab.setIcon(Iconifier.boyUpIcon);
    	squadMalNumLab.setHorizontalTextPosition(SwingConstants.LEFT);
    	//
    	squadFemalLab.setHorizontalAlignment(JLabel.CENTER);
    	squadFemalLab.setVerticalAlignment(JLabel.CENTER);
    	squadFemalLab.setFont(FORM_FONT);
    	squadFemalLab.setForeground(Color.WHITE);
    	squadFemalNumLab.setHorizontalAlignment(JLabel.CENTER);
    	squadFemalNumLab.setVerticalAlignment(JLabel.CENTER);
    	squadFemalNumLab.setFont(CHART_FONT);
    	squadFemalNumLab.setForeground(Color.WHITE);
    	squadFemalNumLab.setIcon(Iconifier.girlUpIcon);
    	squadFemalNumLab.setHorizontalTextPosition(SwingConstants.LEFT);
    	//
    	studentChartSaveBut = new JButton(Iconifier.saveIcon);
    	studentChartSaveBut.setToolTipText("Enregistrer Le Graphique");
    	studentChartSaveBut.setHorizontalTextPosition(JButton.CENTER);
    	studentChartSaveBut.setVerticalTextPosition(JButton.CENTER);
    	//
    	newStudentRegisterFormBut = new OButton("COMMENCER UN ENREGISTREMENT");
    	newStudentRegisterFormBut.setToolTipText(Message.NEW_PAPERS_TAG);
    	newStudentRegisterFormBut.setBackground(OgineColor.BELGE);
    	newStudentRegisterFormBut.setForeground(Color.BLACK);
    	newStudentRegisterFormBut.setBorderColor(Color.BLACK);
    	newStudentRegisterFormBut.addMouseListener(new NewFormButAdapter());
    	//
    	studentRegisterChartPane.add(topPane, BorderLayout.NORTH);
    	studentRegisterChartPane.add(midPane, BorderLayout.CENTER);
    	studentRegisterChartPane.add(backPane, BorderLayout.SOUTH);
    	//
    	topPane.add(paneTitle);
    	//
    	Box b1 = Box.createHorizontalBox();
    	b1.add(squadPane);
    	Box b2 = Box.createHorizontalBox();
    	b2.add(squadMalPane);
    	b2.add(squadFemalPane);
    	Box b3 = Box.createVerticalBox();
    	b3.add(saveButPane);
    	saveButPane.add(studentChartSaveBut);
    	chartPanel.add(ChartGenerator.studentRegisterChart(), BorderLayout.CENTER);
    	chartPanel.add(b3, BorderLayout.WEST);
    	Box b4 = Box.createVerticalBox();
    	b4.add(b1);
    	b4.add(b2);
    	b4.repaint();
    	b4.revalidate();
    	midPane.add(b4);
    	midPane.add(chartPanel);
    	//
    	squadPane.add(squadLab, BorderLayout.CENTER);
    	squadPane.add(squadNumLab, BorderLayout.NORTH);
    	//
    	squadMalPane.add(squadMalLab, BorderLayout.CENTER);
    	squadMalPane.add(squadMalNumLab, BorderLayout.NORTH);
    	//
    	squadFemalPane.add(squadFemalLab, BorderLayout.CENTER);
    	squadFemalPane.add(squadFemalNumLab, BorderLayout.NORTH);
    	//
    	backPane.add(butPane);
    	butPane.add(newStudentRegisterFormBut);
    }
    
    private void buildStudentRegisterPane()
    {
        JLabel paneTitle = new JLabel(Message.STUDENT_REGISTER_FORM_TITLE);
        OPanel persPane = new OPanel(15, new GridLayout(6, 2, 8, 8));
        OPanel parPane = new OPanel(15, new GridLayout(6, 2, 8, 8));
        OPanel othPane = new OPanel(15, new GridLayout(3, 2, 6, 6));
        OPanel supPane = new OPanel(15, new GridLayout(3, 2, 6, 6));
        OPanel butPane = new OPanel(15);
        OPanel butPane2 = new OPanel(15);
        OPanel butPane3 = new OPanel(15);

        studentClientProfile = new JLabel(Iconifier.clientIcon);
        JLabel lastnameLabel = new JLabel("Nom :");
        JLabel firstnameLabel = new JLabel("Prénoms :");
        JLabel birthLabel = new JLabel("Date de Naissance :");
        JLabel sexLabel = new JLabel("Sexe :");
        JLabel cniLabel = new JLabel("N°CNI :");
        JLabel bloodLabel = new JLabel("Groupe Sanguin :");
        JLabel fathernameLabel = new JLabel("Nom du Père :");
        JLabel fathernumberLabel = new JLabel("Numéro du Père :");
        JLabel fatherfunctionLabel = new JLabel("Fonction du Père :");
        JLabel mothernameLabel = new JLabel("Nom de la Mère :");
        JLabel mothernumberLabel = new JLabel("Numéro de la Mère :");
        JLabel motherfunctionLabel = new JLabel("Fonction de la Mère :");
        JLabel tutornameLabel = new JLabel("Nom du Tuteur :");
        JLabel tutornumberLabel = new JLabel("Numéro du Tuteur :");
        JLabel tutorfunctionLabel = new JLabel("Fonction du Tuteur :");
        JLabel phonenumberLabel = new JLabel("Contact :");
        JLabel addressLabel = new JLabel("Adresse :");
        JLabel religionLabel = new JLabel("Religion :");

        bloodList = new JComboBox<>();
        sexList = new JComboBox<>();

        cniField = new OTextField(Message.CNI_TAG);
        fathernumberField = new OTextField(Message.FATH_NUM);
        tutornumberField = new OTextField(Message.TUTO_NUM);
        mothernumberField = new OTextField(Message.MOTH_NUM);
        phonenumberField = new OTextField(Message.PHONE_TAG);

        birthdate = new JDateChooser();

        lastnameField = new OTextField(Message.LAST_NAME);
        firstnameField = new OTextField(Message.FIRST_NAME);
        fathernameField = new OTextField(Message.FATH_NAME);
        fatherfunctionField = new OTextField(Message.FATH_FUNCT);
        mothernameField = new OTextField(Message.MOTH_NAME);
        motherfunctionField = new OTextField(Message.MOTH_FUNCT);
        tutornameField = new OTextField(Message.TUTO_NAME);
        tutorfunctionField = new OTextField(Message.TUTO_FUNCT);
        addressField = new OTextField(Message.ADDR_TAG);
        religionField = new OTextField(Message.FAITH_TAG);

        studentValidate = new JButton("Enregistrer", Iconifier.validateIcon);
        studentReset = new JButton("Effacer", Iconifier.errorFormIcon);
        studentCancel = new JButton("Retour", Iconifier.backIcon);
        studentUpdate = new JButton("Modifier", Iconifier.updateFormIcon);
        studentPicturePicker = new OButton(Message.PIC_TAG);

        
        persPane.setBounds(5, 180, 510, 255);
        persPane.setBackground(Color.WHITE);
        persPane.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEmptyBorder(5, 5, 1, 5),
	        Message.INFO_PERSONNELS,
	        TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
	        FORM_TITLE_FONT,
	        OgineColor.DARK_BLUE
        ));

        parPane.setBounds(535, 180, 510, 255);
        parPane.setBackground(Color.WHITE);
        parPane.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEmptyBorder(5, 5, 1, 5),
            Message.INFO_PARENTS,
            TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
            FORM_TITLE_FONT,
            OgineColor.DARK_BLUE
        ));

        othPane.setBounds(535, 440, 510, 130);
        othPane.setBackground(Color.WHITE);
        othPane.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEmptyBorder(5, 5, 1, 5),
	        Message.INFO_AUTRES,
	        TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
	        FORM_TITLE_FONT,
	        OgineColor.DARK_BLUE
        ));

        supPane.setBounds(5, 440, 510, 130);
        supPane.setBackground(Color.WHITE);
        supPane.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEmptyBorder(5, 5, 1, 5),
            Message.INFO_SUPPLEMENTAIRE,
            TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
            FORM_TITLE_FONT,
            OgineColor.DARK_BLUE
        ));

        butPane.setBounds(5, 580, 510, 50);
        butPane.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane.setBackground(OgineColor.BLUE);
        butPane.setBorderColor(OgineColor.BLUE);

        butPane2.setBounds(845, 580, 200, 50);
        butPane2.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane2.setBackground(OgineColor.BLUE);
        butPane2.setBorderColor(OgineColor.BLUE);

        butPane3.setBounds(535, 580, 200, 50);
        butPane3.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane3.setBackground(OgineColor.BLUE);
        butPane3.setBorderColor(OgineColor.BLUE);

        paneTitle.setBounds(180, 5, 600, 50);
        paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.WHITE, 2));
        paneTitle.setForeground(Color.WHITE);
        paneTitle.setHorizontalAlignment(JLabel.CENTER);
        paneTitle.setFont(FORM_TITLE_FONT);

        studentClientProfile.setBounds(5, 5, 135, 135);
        studentClientProfile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, OgineColor.DARK_BLUE, Color.LIGHT_GRAY));
        studentClientProfile.setVerticalAlignment(JLabel.CENTER);
        studentClientProfile.setHorizontalAlignment(JLabel.CENTER);

        //label font setting
        lastnameLabel.setFont(FORM_FONT);
        firstnameLabel.setFont(FORM_FONT);
        birthLabel.setFont(FORM_FONT);
        sexLabel.setFont(FORM_FONT);
        cniLabel.setFont(FORM_FONT);
        bloodLabel.setFont(FORM_FONT);
        fathernameLabel.setFont(FORM_FONT);
        fathernumberLabel.setFont(FORM_FONT);
        fatherfunctionLabel.setFont(FORM_FONT);
        mothernameLabel.setFont(FORM_FONT);
        mothernumberLabel.setFont(FORM_FONT);
        motherfunctionLabel.setFont(FORM_FONT);
        tutornameLabel.setFont(FORM_FONT);
        tutornumberLabel.setFont(FORM_FONT);
        tutorfunctionLabel.setFont(FORM_FONT);
        phonenumberLabel.setFont(FORM_FONT);
        addressLabel.setFont(FORM_FONT);
        religionLabel.setFont(FORM_FONT);
        
        lastnameLabel.setForeground(OgineColor.DARK_BLUE);
        firstnameLabel.setForeground(OgineColor.DARK_BLUE);
        birthLabel.setForeground(OgineColor.DARK_BLUE);
        sexLabel.setForeground(OgineColor.DARK_BLUE);
        cniLabel.setForeground(OgineColor.DARK_BLUE);
        bloodLabel.setForeground(OgineColor.DARK_BLUE);
        fathernameLabel.setForeground(OgineColor.DARK_BLUE);
        fathernumberLabel.setForeground(OgineColor.DARK_BLUE);
        fatherfunctionLabel.setForeground(OgineColor.DARK_BLUE);
        mothernameLabel.setForeground(OgineColor.DARK_BLUE);
        mothernumberLabel.setForeground(OgineColor.DARK_BLUE);
        motherfunctionLabel.setForeground(OgineColor.DARK_BLUE);
        tutornameLabel.setForeground(OgineColor.DARK_BLUE);
        tutornumberLabel.setForeground(OgineColor.DARK_BLUE);
        tutorfunctionLabel.setForeground(OgineColor.DARK_BLUE);
        phonenumberLabel.setForeground(OgineColor.DARK_BLUE);
        addressLabel.setForeground(OgineColor.DARK_BLUE);
        religionLabel.setForeground(OgineColor.DARK_BLUE);

        //personal informations field
        lastnameField.setPreferredSize(new Dimension(290, 30));
        firstnameField.setPreferredSize(new Dimension(290, 30));
        birthdate.setPreferredSize(new Dimension(290, 30));
        sexList.setPreferredSize(new Dimension(290, 30));
        cniField.setPreferredSize(new Dimension(290, 30));
        bloodList.setPreferredSize(new Dimension(290, 30));

        //father & mother informations field
        fathernameField.setPreferredSize(new Dimension(290, 30));
        fathernumberField.setPreferredSize(new Dimension(290, 30));
        fatherfunctionField.setPreferredSize(new Dimension(290, 30));
        mothernameField.setPreferredSize(new Dimension(290, 30));
        mothernumberField.setPreferredSize(new Dimension(290, 30));
        motherfunctionField.setPreferredSize(new Dimension(290, 30));

        //other information field
        tutornameField.setPreferredSize(new Dimension(290, 30));
        tutornumberField.setPreferredSize(new Dimension(290, 30));
        tutorfunctionField.setPreferredSize(new Dimension(290, 30));

        //supp .......
        phonenumberField.setPreferredSize(new Dimension(290, 30));
        addressField.setPreferredSize(new Dimension(290, 30));
        religionField.setPreferredSize(new Dimension(290, 30));
        //
        sexList.setModel(new DefaultComboBoxModel<>(new String[]{"Masculin", "Féminin"}));
        sexList.setSelectedIndex(-1);
        sexList.setEditable(true);
        sexList.setMaximumRowCount(2);
//        sexList.configureEditor(sexList.getEditor(), Message.SEX_TAG);
//        sexList.setSelectedItem(sexList.getItemAt(sexList.getSelectedIndex()));
//        sexList.setToolTipText("Sélectionner le sexe de l'étudiant");
        sexList.setToolTipText(Message.SEX_TAG);

        sexList.setBorder(new RoundedBorder(15));
        sexList.setUI(new RoundComboUI());

        bloodList.setModel(new DefaultComboBoxModel<>(new String[]{"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
        bloodList.setSelectedIndex(-1);
        bloodList.setEditable(true);
        bloodList.setMaximumRowCount(4);
        bloodList.setToolTipText(Message.BLOOD_TAG);

        bloodList.setBorder(new RoundedBorder(15));
        bloodList.setUI(new RoundComboUI());

        birthdate.setBorder(new RoundedBorder(15));
        birthdate.setIcon(Iconifier.calendarIcon);
        birthdate.setBackground(Color.WHITE);
        birthdate.setDateFormatString("yyyy-MM-dd");
        birthdate.getCalendarButton().setBorderPainted(false);
        birthdate.getDateEditor().getUiComponent().setBorder(new EmptyBorder(5, 10, 5, 5));
        birthdate.getDateEditor().getUiComponent().setOpaque(false);
        birthdate.getDateEditor().getUiComponent().setFont(birthdate.getDateEditor().getUiComponent().getFont().deriveFont(Font.BOLD));
        birthdate.setToolTipText("Entrer une date : AAAA-MM-JJ");
        //but config
        studentPicturePicker.setBounds(5, 145, 135, 25);
        studentPicturePicker.setToolTipText(Message.PIC_TAG2);
        studentPicturePicker.setFont(FORM_BUT_FONT);
        studentPicturePicker.addMouseListener(new OButtonMouseAdapter());
        studentValidate.setPreferredSize(new Dimension(170, 35));
        studentValidate.setToolTipText(Message.OK_TAG);
        studentValidate.setFont(FORM_BUT_FONT);
        studentValidate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentValidate.setBorder(new RoundedBorder(15));
        studentReset.setPreferredSize(new Dimension(170, 35));
        studentReset.setToolTipText(Message.RESET_TAG);
        studentReset.setFont(FORM_BUT_FONT);
        studentReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentCancel.setPreferredSize(new Dimension(170, 35));
        studentCancel.setToolTipText(Message.EXIT_TAG);
        studentCancel.setFont(FORM_BUT_FONT);
        studentCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentUpdate.setPreferredSize(new Dimension(170, 35));
        studentUpdate.setToolTipText(Message.UPDATE_TAG);
        studentUpdate.setFont(FORM_BUT_FONT);
        studentUpdate.setEnabled(false);
        studentUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //
        studentRegisterPane.add(paneTitle);
        studentRegisterPane.add(studentClientProfile);
        studentRegisterPane.add(persPane);
        studentRegisterPane.add(parPane);
        studentRegisterPane.add(othPane);
        studentRegisterPane.add(supPane);
        studentRegisterPane.add(butPane);
        studentRegisterPane.add(butPane2);
        studentRegisterPane.add(butPane3);
        studentRegisterPane.add(studentPicturePicker);
        //
        persPane.add(lastnameLabel);
        persPane.add(lastnameField);
        persPane.add(firstnameLabel);
        persPane.add(firstnameField);
        persPane.add(birthLabel);
        persPane.add(birthdate);
        persPane.add(sexLabel);
        persPane.add(sexList);
        persPane.add(cniLabel);
        persPane.add(cniField);
        persPane.add(bloodLabel);
        persPane.add(bloodList);
        //
        parPane.add(fathernameLabel);
        parPane.add(fathernameField);
        parPane.add(fathernumberLabel);
        parPane.add(fathernumberField);
        parPane.add(fatherfunctionLabel);
        parPane.add(fatherfunctionField);
        parPane.add(mothernameLabel);
        parPane.add(mothernameField);
        parPane.add(mothernumberLabel);
        parPane.add(mothernumberField);
        parPane.add(motherfunctionLabel);
        parPane.add(motherfunctionField);
        //
        othPane.add(tutornameLabel);
        othPane.add(tutornameField);
        othPane.add(tutornumberLabel);
        othPane.add(tutornumberField);
        othPane.add(tutorfunctionLabel);
        othPane.add(tutorfunctionField);
        //
        supPane.add(phonenumberLabel);
        supPane.add(phonenumberField);
        supPane.add(addressLabel);
        supPane.add(addressField);
        supPane.add(religionLabel);
        supPane.add(religionField);
        //
        butPane.add(studentValidate);
        butPane.add(studentReset);
        butPane2.add(studentCancel);
        butPane3.add(studentUpdate);
    }
    
    private void buildRegisterAndReregisterChartPane()
    {
    	JLabel paneTitle = new JLabel(Message.STUDENT_REGISTER_CHART_TITLE);
    	//
    	JLabel squadILab = new JLabel("Nombre d'Inscription");
    	JLabel squadIMalLab = new JLabel("Garçon(s) Inscrit(s)");
    	JLabel squadIFemalLab = new JLabel("Fille(s) Inscrite(s)");
    	JLabel squadRLab = new JLabel("Nombre de Ré-Inscription");
    	JLabel squadRMalLab = new JLabel("Garçon(s) Ré-Inscrit(s)");
    	JLabel squadRFemalLab = new JLabel("Fille(s) Ré-Inscrite()s");
    	JLabel squadINumLab = null;
    	JLabel squadIMalNumLab = null;
    	JLabel squadIFemalNumLab = null;
		try
		{
			squadINumLab = new JLabel(String.valueOf(SchoolRegister.getSingleton().getMax()));
			squadIMalNumLab = new JLabel(String.valueOf(SchoolRegister.getSingleton().getMaxMale()));
	    	squadIFemalNumLab = new JLabel(String.valueOf(SchoolRegister.getSingleton().getMaxFemale()));
		} 
		catch(SchoolRegisterException e)
		{
			System.err.println(e.getMessage());
		}
    	//
    	JPanel topPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel midPane = new JPanel(new GridLayout(2, 1, 5, 5));
    	JPanel squadPane = new JPanel(new BorderLayout(1, 1));
    	JPanel squadMalPane = new JPanel(new BorderLayout(1, 1));
    	JPanel squadFemalPane = new JPanel(new BorderLayout(1, 1));
    	JPanel chartPanel = new JPanel(new BorderLayout());
    	JPanel backPane = new JPanel(new FlowLayout());
    	JPanel butPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel butPane2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel butPane3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JPanel saveButPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	//
    	topPane.setBackground(Color.WHITE);
    	//
    	midPane.setBackground(Color.WHITE);
    	//
    	backPane.setBackground(OgineColor.DARK_BLUE);
    	//
    	butPane.setPreferredSize(new Dimension(600, 100));
    	butPane.setBackground(OgineColor.DARK_BLUE);
    	butPane.setBorder(BorderFactory.createTitledBorder(
    			BorderFactory.createMatteBorder(2, 0, 0, 0, OgineColor.BLUE),
    			"FICHES",
    			TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
    			FORM_TITLE_FONT,
    			Color.WHITE 
		));
    	//
    	butPane2.setBackground(OgineColor.DARK_BLUE);
    	butPane2.setPreferredSize(new Dimension(250, 70));
    	butPane2.setBorder(BorderFactory.createTitledBorder(
    			BorderFactory.createMatteBorder(0, 0, 2, 0, OgineColor.BLUE),
    			"Fiche d'Inscription",
    			TitledBorder.CENTER,
				TitledBorder.BOTTOM,
    			FORM_TITLE_FONT,
    			Color.WHITE 
		));
    	//
    	butPane3.setBackground(OgineColor.DARK_BLUE);
    	butPane3.setPreferredSize(new Dimension(250, 70));
    	butPane3.setBorder(BorderFactory.createTitledBorder(
    			BorderFactory.createMatteBorder(0, 0, 2, 0, OgineColor.BLUE),
    			"Fiche de Ré-Inscription",
    			TitledBorder.CENTER,
				TitledBorder.BOTTOM,
    			FORM_TITLE_FONT,
    			Color.WHITE 
		));
    	
    	//
    	squadPane.setBorder(BorderFactory.createEmptyBorder());
    	squadPane.setBackground(OgineColor.BLUE);
    	squadPane.addMouseListener(new PaneMouseAdapter());
    	//
    	squadMalPane.setBorder(BorderFactory.createEmptyBorder());
    	squadMalPane.setBackground(OgineColor.RED);
    	squadMalPane.addMouseListener(new PaneMouseAdapter());
    	//
    	squadFemalPane.setBorder(BorderFactory.createEmptyBorder());
    	squadFemalPane.setBackground(OgineColor.DARK_BLUE);
    	squadFemalPane.addMouseListener(new PaneMouseAdapter());
    	//
    	saveButPane.setBackground(Color.WHITE);
    	//
    	paneTitle.setFont(FORM_TITLE_FONT);
    	paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(2));
    	paneTitle.setHorizontalAlignment(JLabel.CENTER);
    	//
    	squadILab.setHorizontalAlignment(JLabel.CENTER);
    	squadILab.setVerticalAlignment(JLabel.CENTER);
    	squadILab.setFont(FORM_FONT);
    	squadILab.setForeground(Color.WHITE);
    	squadINumLab.setHorizontalAlignment(JLabel.CENTER);
    	squadINumLab.setVerticalAlignment(JLabel.CENTER);
    	squadINumLab.setFont(CHART_FONT);
    	squadINumLab.setForeground(Color.WHITE);
    	//
    	squadIMalLab.setHorizontalAlignment(JLabel.CENTER);
    	squadIMalLab.setVerticalAlignment(JLabel.CENTER);
    	squadIMalLab.setFont(FORM_FONT);
    	squadIMalLab.setForeground(Color.WHITE);
    	squadIMalNumLab.setHorizontalAlignment(JLabel.CENTER);
    	squadIMalNumLab.setVerticalAlignment(JLabel.CENTER);
    	squadIMalNumLab.setFont(CHART_FONT);
    	squadIMalNumLab.setForeground(Color.WHITE);
    	//
    	squadIFemalLab.setHorizontalAlignment(JLabel.CENTER);
    	squadIFemalLab.setVerticalAlignment(JLabel.CENTER);
    	squadIFemalLab.setFont(FORM_FONT);
    	squadIFemalLab.setForeground(Color.WHITE);
    	squadIFemalNumLab.setHorizontalAlignment(JLabel.CENTER);
    	squadIFemalNumLab.setVerticalAlignment(JLabel.CENTER);
    	squadIFemalNumLab.setFont(CHART_FONT);
    	squadIFemalNumLab.setForeground(Color.WHITE);
    	//
    	nrChartSaveBut = new JButton(Iconifier.saveIcon);
    	nrChartSaveBut.setToolTipText("Enregistrer Le Graphique");
    	nrChartSaveBut.setHorizontalTextPosition(JButton.CENTER);
    	nrChartSaveBut.setVerticalTextPosition(JButton.CENTER);
    	//
    	newRegisterFormBut = new OButton("NOUVEAU");
    	newRegisterFormBut.setToolTipText(Message.NEW_PAPERS_TAG);
    	newRegisterFormBut.setBackground(OgineColor.BELGE);
    	newRegisterFormBut.setForeground(Color.BLACK);
    	newRegisterFormBut.setBorderColor(Color.BLACK);
    	newRegisterFormBut.addMouseListener(new NewFormButAdapter());
    	//
    	newReRegisterFormBut = new OButton("NOUVEAU");
    	newReRegisterFormBut.setToolTipText(Message.NEW_PAPERS_TAG);
    	newReRegisterFormBut.setBackground(OgineColor.BELGE);
    	newReRegisterFormBut.setForeground(Color.BLACK);
    	newReRegisterFormBut.setBorderColor(Color.BLACK);
    	newReRegisterFormBut.addMouseListener(new NewFormButAdapter());
    	//
    	registerChartPane.add(topPane, BorderLayout.NORTH);
    	registerChartPane.add(midPane, BorderLayout.CENTER);
    	registerChartPane.add(backPane, BorderLayout.SOUTH);
    	//
    	topPane.add(paneTitle);
    	//
    	Box b1 = Box.createHorizontalBox();
    	b1.add(squadPane);
    	Box b2 = Box.createHorizontalBox();
    	b2.add(squadMalPane);
    	b2.add(squadFemalPane);
    	Box b3 = Box.createVerticalBox();
    	b3.add(saveButPane);
    	saveButPane.add(nrChartSaveBut);
    	chartPanel.add(ChartGenerator.registerChart(), BorderLayout.CENTER);
    	chartPanel.add(b3, BorderLayout.WEST);
    	Box b4 = Box.createVerticalBox();
    	b4.add(b1);
    	b4.add(b2);
    	b4.repaint();
    	b4.revalidate();
    	midPane.add(b4);
    	midPane.add(chartPanel);
    	//
    	squadPane.add(squadILab, BorderLayout.CENTER);
    	squadPane.add(squadINumLab, BorderLayout.NORTH);
    	//
    	squadMalPane.add(squadIMalLab, BorderLayout.CENTER);
    	squadMalPane.add(squadIMalNumLab, BorderLayout.NORTH);
    	//
    	squadFemalPane.add(squadIFemalLab, BorderLayout.CENTER);
    	squadFemalPane.add(squadIFemalNumLab, BorderLayout.NORTH);
    	//
    	backPane.add(butPane);
    	//
    	Box b5 = Box.createHorizontalBox();
    	Box b6 = Box.createHorizontalBox();
    	Box b7 = Box.createHorizontalBox();
    	//
    	b5.add(butPane2);
    	b6.add(butPane3);
    	b7.add(b5);
    	b7.add(new JSeparator(SwingConstants.VERTICAL));
    	b7.add(b6);
    	butPane.add(b7);
    	butPane2.add(newRegisterFormBut);
    	butPane3.add(newReRegisterFormBut);
    }
    
    private void buildDataChartPane()
    {
    	
    }
    
    private void buildxxx()
    {
        tabbedPane.add(registerPane);
        tabbedPane.add(reRegisterPane);
        tabbedPane.setBackground(Color.MAGENTA);
        tabbedPane.setTitleAt(0, "Inscription".toUpperCase());
        tabbedPane.setTitleAt(1, "Ré-Inscription".toUpperCase());
        tabbedPane.setBackgroundAt(0, Color.WHITE);
        tabbedPane.setBackgroundAt(1, Color.WHITE);
        tabbedPane.setForegroundAt(0, OgineColor.DARK_BLUE);
        tabbedPane.setForegroundAt(1, OgineColor.DARK_BLUE);
        tabbedPane.setIconAt(0, Iconifier.formIcon);
        tabbedPane.setIconAt(1, Iconifier.formIcon);
        tabbedPane.setToolTipTextAt(0, Message.REGISTER_FORM_TITLE);
        tabbedPane.setToolTipTextAt(1, Message.REREGISTER_FORM_TITLE);
        buildRegisterPane();
        buildReRegisterPane();
    }

    private void buildRegisterPane()
    {
        JLabel paneTitle;

        JPanel regPanel;
        JPanel infoPanel;
        OPanel butPane;
        OPanel butPane2;
        OPanel butPane3;

        JLabel studentLabel;
        JLabel yearLabel;
        JLabel matriculeLabel;
        JLabel institutLabel;
        JLabel levelLabel;
        JLabel specialityLabel;

        JLabel lastnameLabel;
        JLabel firstnameLabel;
        JLabel birthLabel;
        JLabel sexLabel;
        JLabel cniLabel;
        JLabel phonenumberLabel;
        JLabel addressLabel;

        paneTitle = new JLabel(Message.REGISTER_FORM_TITLE);
        registerClientProfile = new JLabel(Iconifier.clientIcon);
        regPanel = new JPanel(null);
        infoPanel = new JPanel(null);
        butPane = new OPanel(15, new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane2 = new OPanel(15, new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane3 = new OPanel(15, new FlowLayout(FlowLayout.CENTER, 2, 2));
        studentLabel = new JLabel("Etudiant :");
        yearLabel = new JLabel("Année :");
        matriculeLabel = new JLabel("N° Matricule :");
        institutLabel = new JLabel("Institut :");
        specialityLabel = new JLabel("Spécialité :");
        levelLabel = new JLabel("Niveau :");
        lastnameLabel = new JLabel("Nom :");
        firstnameLabel = new JLabel("Prénoms :");
        birthLabel = new JLabel("Date de Naissance :");
        sexLabel = new JLabel("Sexe :");
        cniLabel = new JLabel("N°CNI :");
        phonenumberLabel = new JLabel("N° de Téléphone :");
        addressLabel = new JLabel("Adresse :");
        //
        studentBox = new JComboBox<>();
        yearField = new JYearChooser();
        matriculeField = new OJTextField("N° Matricule de L'Etudiant");
        institutBox = new JComboBox<>();
        specialityBox = new JComboBox<>();
        levelBox = new JComboBox<>();
        lastnameField2 = new OTextField(Message.LAST_NAME);
        firstnameField2 = new OTextField(Message.FIRST_NAME);
        birthField = new OTextField(Message.BIRTH_TAG);
        cniField2 = new OTextField(Message.CNI_TAG);
        sexField = new OTextField(Message.SEX_TAG);
        phonenumberField2 = new OTextField(Message.PHONE_TAG);
        addressField2 = new OTextField(Message.ADDR_TAG);
        //
        registerValidate = new JButton("Enregistrer", Iconifier.validateIcon);
        registerReset = new JButton("Effacer", Iconifier.errorFormIcon);
        registerCancel = new JButton("Retour", Iconifier.backIcon);
        registerUpdate = new JButton("Modifier", Iconifier.updateFormIcon);
        //
        regPanel.setBounds(5, 70, 510, 470);
        regPanel.setBackground(OgineColor.GRAY);
        regPanel.setBorder(BorderFactory.createTitledBorder(
    		BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, OgineColor.DARK_BLUE),
            Message.INFO_INSCRIPTIONS,
            TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
            FORM_TITLE_FONT
        ));

        infoPanel.setBounds(535, 70, 510, 470);
        infoPanel.setBackground(OgineColor.BLUE);
        infoPanel.setBorder(BorderFactory.createTitledBorder(
    		BorderFactory.createBevelBorder(BevelBorder.RAISED, OgineColor.DARK_BLUE, Color.LIGHT_GRAY),
            Message.INFO_ETUDIANTS,
            TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
            FORM_TITLE_FONT,
            Color.WHITE
        ));

        butPane.setBounds(5, 550, 510, 45);
        butPane.setBackground(Color.WHITE);
        butPane.setBorderColor(Color.WHITE);
        butPane2.setBounds(845, 550, 200, 45);
        butPane2.setBackground(Color.WHITE);
        butPane2.setBorderColor(Color.WHITE);
        butPane3.setBounds(535, 550, 200, 45);
        butPane3.setBackground(Color.WHITE);
        butPane3.setBorderColor(Color.WHITE);
        paneTitle.setBounds(180, 5, 600, 50);
        paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        paneTitle.setForeground(Color.BLACK);
        paneTitle.setHorizontalAlignment(JLabel.CENTER);
        paneTitle.setFont(FORM_TITLE_FONT);
        //
        registerClientProfile.setBounds(10, 25, 135, 135);
        registerClientProfile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, OgineColor.DARK_BLUE, Color.LIGHT_GRAY));
        registerClientProfile.setVerticalAlignment(JLabel.CENTER);
        registerClientProfile.setHorizontalAlignment(JLabel.CENTER);
        //registring information label
        studentLabel.setBounds(50, 35, 150, 25);
        yearLabel.setBounds(50, 105, 150, 25);
        institutLabel.setBounds(50, 175, 150, 25);
        levelLabel.setBounds(50, 245, 150, 25);
        specialityLabel.setBounds(50, 315, 150, 25);
        matriculeLabel.setBounds(50, 385, 150, 25);
        //font setting
        studentLabel.setFont(FORM_TITLE_FONT);
        yearLabel.setFont(FORM_TITLE_FONT);
        matriculeLabel.setFont(FORM_TITLE_FONT);
        institutLabel.setFont(FORM_TITLE_FONT);
        levelLabel.setFont(FORM_TITLE_FONT);
        specialityLabel.setFont(FORM_TITLE_FONT);
        lastnameLabel.setFont(FORM_TITLE_FONT);
        firstnameLabel.setFont(FORM_TITLE_FONT);
        birthLabel.setFont(FORM_TITLE_FONT);
        sexLabel.setFont(FORM_TITLE_FONT);
        cniLabel.setFont(FORM_TITLE_FONT);
        phonenumberLabel.setFont(FORM_TITLE_FONT);
        addressLabel.setFont(FORM_TITLE_FONT);
        //
        lastnameLabel.setForeground(Color.WHITE);
        firstnameLabel.setForeground(Color.WHITE);
        birthLabel.setForeground(Color.WHITE);
        sexLabel.setForeground(Color.WHITE);
        cniLabel.setForeground(Color.WHITE);
        phonenumberLabel.setForeground(Color.WHITE);
        addressLabel.setForeground(Color.WHITE);
        //personal information field
        studentBox.setBounds(175, 65, 270, 30);
        yearField.setBounds(175, 135, 270, 30);
        institutBox.setBounds(175, 205, 270, 30);
        levelBox.setBounds(175, 275, 270, 30);
        specialityBox.setBounds(175, 345, 270, 30);
        matriculeField.setBounds(175, 415, 270, 30);
        //
        lastnameLabel.setBounds(10, 180, 150, 25);
        firstnameLabel.setBounds(10, 220, 150, 25);
        birthLabel.setBounds(10, 260, 180, 25);
        sexLabel.setBounds(10, 300, 150, 25);
        cniLabel.setBounds(10, 340, 150, 25);
        phonenumberLabel.setBounds(10, 380, 180, 25);
        addressLabel.setBounds(10, 420, 150, 25);
        lastnameField2.setBounds(190, 180, 270, 30);
        firstnameField2.setBounds(190, 220, 270, 30);
        birthField.setBounds(190, 260, 270, 30);
        sexField.setBounds(190, 300, 270, 30);
        cniField2.setBounds(190, 340, 270, 30);
        phonenumberField2.setBounds(190, 380, 270, 30);
        addressField2.setBounds(190, 420, 270, 30);
        //
        studentBox.setBackground(OgineColor.GRAY);
        institutBox.setBackground(OgineColor.GRAY);
        yearField.getSpinner().setBackground(OgineColor.GRAY);
        yearField.setBackground(OgineColor.GRAY);
        specialityBox.setBackground(OgineColor.GRAY);
        levelBox.setBackground(OgineColor.GRAY);
        matriculeField.setBackground(OgineColor.GRAY);
        //
        studentBox.setUI(new ComboUI());
        specialityBox.setUI(new ComboUI());
        levelBox.setUI(new ComboUI());
        institutBox.setUI(new ComboUI());
        //
        studentBox.setRenderer(new BoldListCellRenderer());
        specialityBox.setRenderer(new BoldListCellRenderer());
        levelBox.setRenderer(new BoldListCellRenderer());
        institutBox.setRenderer(new BoldListCellRenderer());
        //
        studentBox.setFont(COMBO_FONT);
        specialityBox.setFont(COMBO_FONT);
        levelBox.setFont(COMBO_FONT);
        institutBox.setFont(COMBO_FONT);
        //
        lastnameField2.setBackground(Color.WHITE);
        firstnameField2.setBackground(Color.WHITE);
        birthField.setBackground(Color.WHITE);
        sexField.setBackground(Color.WHITE);
        cniField2.setBackground(Color.WHITE);
        phonenumberField2.setBackground(Color.WHITE);
        addressField2.setBackground(Color.WHITE);
        //
        studentBox.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        yearField.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        institutBox.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        levelBox.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        specialityBox.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        //
        lastnameField2.setEditable(false);
        firstnameField2.setEditable(false);
        birthField.setEditable(false);
        sexField.setEditable(false);
        cniField2.setEditable(false);
        phonenumberField2.setEditable(false);
        addressField2.setEditable(false);
        //
        studentBox.setEditable(true);
        specialityBox.setEditable(true);
        levelBox.setEditable(true);
        institutBox.setEditable(true);
        //
        studentBox.setMaximumRowCount(4);
        institutBox.setMaximumRowCount(4);
        specialityBox.setMaximumRowCount(4);
        levelBox.setMaximumRowCount(4);
        studentBox.setSelectedIndex(-1);
        institutBox.setSelectedIndex(-1);
        specialityBox.setSelectedIndex(-1);
        levelBox.setSelectedIndex(-1);
        //
        registerValidate.setPreferredSize(new Dimension(150, 35));
        registerValidate.setToolTipText(Message.OK_TAG);
        registerValidate.setFont(FORM_BUT_FONT);
        registerValidate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerReset.setPreferredSize(new Dimension(150, 35));
        registerReset.setToolTipText(Message.RESET_TAG);
        registerReset.setFont(FORM_BUT_FONT);
        registerReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerCancel.setPreferredSize(new Dimension(150, 35));
        registerCancel.setToolTipText(Message.EXIT_TAG);
        registerCancel.setFont(FORM_BUT_FONT);
        registerCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerUpdate.setPreferredSize(new Dimension(150, 35));
        registerUpdate.setToolTipText(Message.UPDATE_TAG);
        registerUpdate.setFont(FORM_BUT_FONT);
        registerUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerUpdate.setEnabled(false);
        //
        registerPane.setLayout(null);
        registerPane.setBackground(Color.WHITE);
        registerPane.add(paneTitle);
        registerPane.add(regPanel);
        registerPane.add(infoPanel);
        registerPane.add(butPane);
        registerPane.add(butPane2);
        registerPane.add(butPane3);
        //
        regPanel.add(studentLabel);
        regPanel.add(yearLabel);
        regPanel.add(matriculeLabel);
        regPanel.add(institutLabel);
        regPanel.add(levelLabel);
        regPanel.add(specialityLabel);
        regPanel.add(studentBox);
        regPanel.add(yearField);
        regPanel.add(matriculeField);
        regPanel.add(institutBox);
        regPanel.add(levelBox);
        regPanel.add(specialityBox);
        //
        infoPanel.add(registerClientProfile);
        infoPanel.add(lastnameLabel);
        infoPanel.add(lastnameField2);
        infoPanel.add(firstnameLabel);
        infoPanel.add(firstnameField2);
        infoPanel.add(birthLabel);
        infoPanel.add(birthField);
        infoPanel.add(sexLabel);
        infoPanel.add(sexField);
        infoPanel.add(cniLabel);
        infoPanel.add(cniField2);
        infoPanel.add(phonenumberLabel);
        infoPanel.add(phonenumberField2);
        infoPanel.add(addressLabel);
        infoPanel.add(addressField2);
        //
        butPane.add(registerValidate);
        butPane.add(registerReset);
        butPane2.add(registerCancel);
        butPane3.add(registerUpdate);
    }

    private void buildReRegisterPane()
    {
        JLabel paneTitle;

        JPanel regPanel;
        JPanel infoPanel;
        OPanel butPane;
        OPanel butPane2;
        OPanel butPane3;

        JLabel studentLabel;
        JLabel yearLabel;
        JLabel matriculeLabel;
        JLabel institutLabel;
        JLabel levelLabel;
        JLabel specialityLabel;

        JLabel lastnameLabel;
        JLabel firstnameLabel;
        JLabel oldInstitLabel;
        JLabel sexLabel;
        JLabel phonenumberLabel;
        JLabel addressLabel;

        paneTitle = new JLabel(Message.REREGISTER_FORM_TITLE);
        reRegisterClientProfile = new JLabel(Iconifier.clientIcon);
        regPanel = new JPanel(null);
        infoPanel = new JPanel(null);
        butPane = new OPanel(15, new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane2 = new OPanel(15, new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane3 = new OPanel(15, new FlowLayout(FlowLayout.CENTER, 2, 2));

        studentLabel = new JLabel("Etudiant :");
        yearLabel = new JLabel("Année :");        
        institutLabel = new JLabel("Institut :");
        specialityLabel = new JLabel("Spécialité :");
        levelLabel = new JLabel("Niveau :");
        lastnameLabel = new JLabel("Nom :");
        firstnameLabel = new JLabel("Prénoms :");
        matriculeLabel = new JLabel("N° Matricule :");
        sexLabel = new JLabel("Sexe :");
        oldInstitLabel = new JLabel("Institut");
        phonenumberLabel = new JLabel("N° de Téléphone :");
        addressLabel = new JLabel("Adresse :");

        studentBox2 = new JComboBox<>();
        yearField2 = new JYearChooser();
        institutBox2 = new JComboBox<>();
        specialityBox2 = new JComboBox<>();
        levelBox2= new JComboBox<>();
        
        matriculeField2 = new OTextField("N° Matricule de L'Etudiant");
        lastnameField3 = new OTextField(Message.LAST_NAME);
        firstnameField3 = new OTextField(Message.FIRST_NAME);
        institutField = new OTextField("Institut Actuelle");
        sexField2 = new OTextField(Message.SEX_TAG);
        phonenumberField3 = new OTextField(Message.PHONE_TAG);
        addressField3 = new OTextField(Message.ADDR_TAG);

        reRegisterValidate = new JButton("Enregistrer", Iconifier.validateIcon);
        reRegisterReset = new JButton("Effacer", Iconifier.errorFormIcon);
        reRegisterCancel = new JButton("Retour", Iconifier.backIcon);
        reRegisterUpdate = new JButton("Modifier", Iconifier.updateFormIcon);

        regPanel.setBounds(5, 70, 510, 470);
        regPanel.setBackground(OgineColor.GRAY);
        regPanel.setBorder(BorderFactory.createTitledBorder(
    		BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, OgineColor.DARK_BLUE),
            Message.INFO_INSCRIPTIONS,
            TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
            FORM_TITLE_FONT
        ));

        infoPanel.setBounds(535, 70, 510, 470);
        infoPanel.setBackground(OgineColor.BLUE);
        infoPanel.setBorder(BorderFactory.createTitledBorder(
    		BorderFactory.createBevelBorder(BevelBorder.RAISED, OgineColor.DARK_BLUE, Color.LIGHT_GRAY),
            Message.INFO_ETUDIANTS,
            TitledBorder.DEFAULT_JUSTIFICATION,
			TitledBorder.DEFAULT_POSITION,
            FORM_TITLE_FONT,
            Color.WHITE
        ));

        butPane.setBounds(5, 550, 510, 45);
        butPane.setBackground(Color.WHITE);
        butPane.setBorderColor(Color.WHITE);

        butPane2.setBounds(845, 550, 200, 45);
        butPane2.setBackground(Color.WHITE);
        butPane2.setBorderColor(Color.WHITE);

        butPane3.setBounds(535, 550, 200, 45);
        butPane3.setBackground(Color.WHITE);
        butPane3.setBorderColor(Color.WHITE);

        paneTitle.setBounds(180, 5, 600, 50);
        paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        paneTitle.setForeground(Color.BLACK);
        paneTitle.setHorizontalAlignment(JLabel.CENTER);
        paneTitle.setFont(FORM_TITLE_FONT);

        reRegisterClientProfile.setBounds(10, 25, 135, 135);
        reRegisterClientProfile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, OgineColor.DARK_BLUE, Color.LIGHT_GRAY));
        reRegisterClientProfile.setVerticalAlignment(JLabel.CENTER);
        reRegisterClientProfile.setHorizontalAlignment(JLabel.CENTER);

        //registring information label
        studentLabel.setBounds(50, 35, 150, 25);
        yearLabel.setBounds(50, 105, 150, 25);
        institutLabel.setBounds(50, 175, 150, 25);
        levelLabel.setBounds(50, 245, 150, 25);
        specialityLabel.setBounds(50, 315, 150, 25);
        //personal information label
        matriculeLabel.setBounds(10, 180, 150, 25);
        lastnameLabel.setBounds(10, 220, 150, 25);
        firstnameLabel.setBounds(10, 260, 180, 25);
        oldInstitLabel.setBounds(10, 300, 150, 25);
        sexLabel.setBounds(10, 340, 150, 25);
        phonenumberLabel.setBounds(10, 380, 180, 25);
        addressLabel.setBounds(10, 420, 150, 25);
        //font setting
        studentLabel.setFont(FORM_TITLE_FONT);
        yearLabel.setFont(FORM_TITLE_FONT);
        matriculeLabel.setFont(FORM_TITLE_FONT);
        institutLabel.setFont(FORM_TITLE_FONT);
        levelLabel.setFont(FORM_TITLE_FONT);
        specialityLabel.setFont(FORM_TITLE_FONT);
        lastnameLabel.setFont(FORM_TITLE_FONT);
        firstnameLabel.setFont(FORM_TITLE_FONT);
        sexLabel.setFont(FORM_TITLE_FONT);
        oldInstitLabel.setFont(FORM_TITLE_FONT);
        phonenumberLabel.setFont(FORM_TITLE_FONT);
        addressLabel.setFont(FORM_TITLE_FONT);
        //label foreground setting
        lastnameLabel.setForeground(Color.WHITE);
        firstnameLabel.setForeground(Color.WHITE);
        sexLabel.setForeground(Color.WHITE);
        oldInstitLabel.setForeground(Color.WHITE);
        phonenumberLabel.setForeground(Color.WHITE);
        addressLabel.setForeground(Color.WHITE);
        matriculeLabel.setForeground(Color.WHITE);
        //personal information field
        studentBox2.setBounds(175, 65, 270, 30);
        yearField2.setBounds(175, 135, 270, 30);
        institutBox2.setBounds(175, 205, 270, 30);
        levelBox2.setBounds(175, 275, 270, 30);
        specialityBox2.setBounds(175, 345, 270, 30);
        //
        matriculeField2.setBounds(190, 180, 270, 30);
        lastnameField3.setBounds(190, 220, 270, 30);
        firstnameField3.setBounds(190, 260, 270, 30);
        institutField.setBounds(190, 300, 270, 30);
        sexField2.setBounds(190, 340, 270, 30);
        phonenumberField3.setBounds(190, 380, 270, 30);
        addressField3.setBounds(190, 420, 270, 30);
        //
        lastnameField3.setEditable(false);
        firstnameField3.setEditable(false);
        sexField2.setEditable(false);
        institutField.setEditable(false);
        phonenumberField3.setEditable(false);
        addressField3.setEditable(false);
        matriculeField2.setEditable(false);
        //
        studentBox2.setMaximumRowCount(4);
        institutBox2.setMaximumRowCount(4);
        specialityBox2.setMaximumRowCount(4);
        levelBox2.setMaximumRowCount(4);
        //
        studentBox2.setSelectedIndex(-1);
        institutBox2.setSelectedIndex(-1);
        specialityBox2.setSelectedIndex(-1);
        levelBox2.setSelectedIndex(-1);
        //
        studentBox2.setBackground(OgineColor.GRAY);
        institutBox2.setBackground(OgineColor.GRAY);
        yearField2.getSpinner().setBackground(OgineColor.GRAY);
        yearField2.setBackground(OgineColor.GRAY);
        specialityBox2.setBackground(OgineColor.GRAY);
        levelBox2.setBackground(OgineColor.GRAY);
        matriculeField2.setBackground(Color.WHITE);
        //
        studentBox2.setUI(new FlatComboBoxUI(){
			@Override
			protected JButton createArrowButton() 
			{
				return new ArrowButton(
						SwingConstants.SOUTH,
                        arrowType,
                        Color.BLACK,
                        null,
                        Color.BLACK,
                        Color.LIGHT_GRAY,
                        Color.WHITE,
                        Color.LIGHT_GRAY);                                                                    
			}});
        specialityBox2.setUI(new FlatComboBoxUI(){
			@Override
			protected JButton createArrowButton() 
			{
				return new ArrowButton(
						SwingConstants.SOUTH,
						arrowType,
                        Color.BLACK,
                    	null,
                        Color.BLACK,
                        Color.LIGHT_GRAY,
                        Color.WHITE,
                        Color.LIGHT_GRAY);                                                                    
			}});
        levelBox2.setUI(new FlatComboBoxUI(){
			@Override
			protected JButton createArrowButton() 
			{
				return new ArrowButton(
						SwingConstants.SOUTH, 
						arrowType, 
						Color.BLACK,
						null, 
						Color.BLACK, 
						Color.LIGHT_GRAY, 
						Color.WHITE, 
						Color.LIGHT_GRAY);                                                                   
			}});
        institutBox2.setUI(new FlatComboBoxUI(){
			@Override
			protected JButton createArrowButton() 
			{
				return new ArrowButton(
						SwingConstants.SOUTH,
                        arrowType,
                        Color.BLACK,
                        null,
                        Color.BLACK,
                        Color.LIGHT_GRAY,
                        Color.WHITE,
                        Color.LIGHT_GRAY);                                                                    
			}});
        //
        studentBox2.setRenderer(new BoldListCellRenderer());
        specialityBox2.setRenderer(new BoldListCellRenderer());
        levelBox2.setRenderer(new BoldListCellRenderer());
        institutBox2.setRenderer(new BoldListCellRenderer());
        //
        studentBox2.setFont(COMBO_FONT);
        specialityBox2.setFont(COMBO_FONT);
        levelBox2.setFont(COMBO_FONT);
        institutBox2.setFont(COMBO_FONT);
        //
        lastnameField3.setBackground(Color.WHITE);
        firstnameField3.setBackground(Color.WHITE);
        matriculeField2.setBackground(Color.WHITE);
        sexField2.setBackground(Color.WHITE);
        institutField.setBackground(Color.WHITE);
        phonenumberField3.setBackground(Color.WHITE);
        addressField3.setBackground(Color.WHITE);
        //
        studentBox2.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        yearField2.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        institutBox2.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        levelBox2.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        specialityBox2.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        //
        reRegisterValidate.setPreferredSize(new Dimension(150, 35));
        reRegisterValidate.setToolTipText(Message.OK_TAG);
        reRegisterValidate.setFont(FORM_BUT_FONT);
        reRegisterValidate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reRegisterReset.setPreferredSize(new Dimension(150, 35));
        reRegisterReset.setToolTipText(Message.RESET_TAG);
        reRegisterReset.setFont(FORM_BUT_FONT);
        reRegisterReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reRegisterCancel.setPreferredSize(new Dimension(150, 35));
        reRegisterCancel.setToolTipText(Message.EXIT_TAG);
        reRegisterCancel.setFont(FORM_BUT_FONT);
        reRegisterCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reRegisterUpdate.setPreferredSize(new Dimension(150, 35));
        reRegisterUpdate.setToolTipText(Message.EXIT_TAG);
        reRegisterUpdate.setFont(FORM_BUT_FONT);
        reRegisterUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reRegisterUpdate.setEnabled(false);
        //
        reRegisterPane.setLayout(null);
        reRegisterPane.setBackground(Color.WHITE);
        reRegisterPane.add(paneTitle);
        reRegisterPane.add(regPanel);
        reRegisterPane.add(infoPanel);
        reRegisterPane.add(butPane);
        reRegisterPane.add(butPane2);
        reRegisterPane.add(butPane3);
        //
        regPanel.add(studentLabel);
        regPanel.add(yearLabel);
        regPanel.add(institutLabel);
        regPanel.add(levelLabel);
        regPanel.add(specialityLabel);
        regPanel.add(studentBox2);
        regPanel.add(yearField2);
        regPanel.add(institutBox2);
        regPanel.add(levelBox2);
        regPanel.add(specialityBox2);
        //
        infoPanel.add(reRegisterClientProfile);
        infoPanel.add(lastnameLabel);
        infoPanel.add(firstnameLabel);
        infoPanel.add(sexLabel);
        infoPanel.add(oldInstitLabel);
        infoPanel.add(phonenumberLabel);
        infoPanel.add(addressLabel);
        infoPanel.add(matriculeLabel);
        infoPanel.add(lastnameField3);
        infoPanel.add(firstnameField3);
        infoPanel.add(matriculeField2);
        infoPanel.add(sexField2);
        infoPanel.add(institutField);
        infoPanel.add(phonenumberField3);
        infoPanel.add(addressField3);
        //
        butPane.add(reRegisterValidate);
        butPane.add(reRegisterReset);
        butPane2.add(reRegisterCancel);
        butPane3.add(reRegisterUpdate);
    }

    private void buildDataPane()
    {
		JPanel dataPane2;
		JPanel optionPane;

		OPanel sorterPane;
		OPanel butPane;
		OPanel searchPane;
		
		OPanel opa1;
		OPanel opa2;
		OPanel opa3;
		OPanel opa4;

		
		JScrollPane tablePane;

		JLabel paneTitle;
		JLabel sorterLabel;
		JLabel searchLabel;

        paneTitle = new JLabel(Message.DATA_PANE_FORM_TITLE);
        dataPane2 = new JPanel();
        searchPane = new OPanel(10);
        optionPane = new JPanel();
        sorterPane = new OPanel(15);
        butPane = new OPanel(15);
        
        opa1 = new OPanel(30);
        opa2 = new OPanel(30);
        opa3 = new OPanel(30);
        opa4 = new OPanel(30);

        
        dataTable = new JTable();
        tablePane = new JScrollPane(dataTable);

        sorterLabel = new JLabel(Message.SORTER_TITLE);
        searchLabel = new JLabel("RECHERCHER :");
        searchField = new OSearchField();

        yearSorter = new JComboBox<>();
        instiSorter = new JComboBox<>();
        levelSorter = new JComboBox<>();
        specSorter = new JComboBox<>();

        
        sorterBut = new OButton("Trier");
        previewBut = new JButton("Voir", Iconifier.previewIcon);
        updateBut = new JButton("Modifier", Iconifier.updateFormIcon);
        deleteBut = new JButton("Supprimer", Iconifier.deleteIcon16px);
        cancelBut = new JButton("Retour", Iconifier.backIcon);

        dataPane2.setBounds(405, 60, 670, 485);
        dataPane2.setLayout(null);
        dataPane2.setBorder(BorderFactory.createLineBorder(OgineColor.DARK_BLUE, 2, true));

        tablePane.setBounds(3, 3, 666, 481);
        tablePane.setBackground(Color.YELLOW);
        tablePane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        tablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tablePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tablePane.setColumnHeaderView(dataTable.getTableHeader());

		searchPane.setBounds(15, 60, 380, 485);
		searchPane.setLayout(new VerticalFlowLayout(VerticalFlowLayout.TOP, 55, 20));
		searchPane.setBorder(BorderFactory.createLineBorder(OgineColor.DARK_BLUE, 2, true));
		searchPane.setBackground(OgineColor.DARK_BLUE);

        optionPane.setBounds(15, 560, 650, 80);
        optionPane.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 2));
        optionPane.setBackground(Color.WHITE);
        optionPane.setBorder(BorderFactory.createTitledBorder(
                        BorderFactory.createMatteBorder(2, 0, 0, 0, Color.LIGHT_GRAY),
                        Message.ACTION_TAG, 
                        TitledBorder.DEFAULT_JUSTIFICATION,
        				TitledBorder.DEFAULT_POSITION,
                        FORM_TITLE_FONT));

//        sorterPane.setLayout(new VerticalFlowLayout(VerticalFlowLayout.TOP, 15, 5));
//        sorterPane.setBackground(Color.WHITE);
//        sorterPane.setBorderColor(Color.WHITE);

        butPane.setBounds(865, 580, 200, 50);
        butPane.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        butPane.setBackground(Color.WHITE);
        butPane.setBorderColor(Color.WHITE);
        //
        paneTitle.setBounds(180, 5, 600, 50);
        paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        paneTitle.setForeground(Color.BLACK);
        paneTitle.setHorizontalAlignment(JLabel.CENTER);
        paneTitle.setFont(FORM_TITLE_FONT);
        //
        sorterLabel.setFont(FORM_TITLE_FONT);
        sorterLabel.setForeground(Color.WHITE);
        //
        searchLabel.setFont(FORM_TITLE_FONT);
        searchLabel.setForeground(Color.WHITE);
        searchField.setBorderColor(Color.LIGHT_GRAY);
        //
        opa1.setBackground(Color.WHITE);
        opa2.setBackground(Color.WHITE);
        opa3.setBackground(Color.WHITE);
        opa4.setBackground(Color.WHITE);
        opa1.setBorderColor(Color.WHITE);
        opa2.setBorderColor(Color.WHITE);
        opa3.setBorderColor(Color.WHITE);
        opa4.setBorderColor(Color.WHITE);
        //
        String title [] = {"Année".toUpperCase(), "Matricule".toUpperCase(), "Nom".toUpperCase(), "Prénoms".toUpperCase(),
                        "Sexe".toUpperCase(), "Spécialité".toUpperCase()};
        int row = 0;
        DefaultTableModel dtm = new DefaultTableModel(title, row);
        dataTable.setModel(dtm);
        dataTable.setGridColor(Color.BLACK);
        dataTable.setShowGrid(true);
        dataTable.setRowHeight(30);
        dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        dataTable.setAutoCreateRowSorter(true);
        dataTable.setAutoCreateColumnsFromModel(true);
        dataTable.setSurrendersFocusOnKeystroke(true);
        dataTable.getTableHeader().setUI(new FlatTableHeaderUI() 
        {{
        	header = dataTable.getTableHeader();
    		header.setFont(header.getFont().deriveFont(Font.BOLD));
    		header.setForeground(Color.WHITE);
    		header.setBackground(OgineColor.DARK_BLUE);
    		header.setBorder(BorderFactory.createLineBorder(OgineColor.DARK_BLUE));
        }});
        dataTable.getTableHeader().setReorderingAllowed(true);
        dataTable.setDefaultRenderer(Object.class, new BoldTableCellRenderer());
        //
        yearSorter.setToolTipText(Message.YEAR_OPTION_TIP);
        instiSorter.setToolTipText(Message.INSTI_OPTION_TIP);
        levelSorter.setToolTipText(Message.LEVEL_OPTION_TIP);
        specSorter.setToolTipText(Message.SPEC_OPTION_TIP);

        updateBut.setPreferredSize(new Dimension(180, 35));
        updateBut.setToolTipText(Message.UPDATE_TAG);
        updateBut.setFont(FORM_BUT_FONT);
        deleteBut.setPreferredSize(new Dimension(180, 35));
        deleteBut.setToolTipText(Message.DELETE_TAG);
        deleteBut.setFont(FORM_BUT_FONT);
        previewBut.setPreferredSize(new Dimension(180, 35));
        previewBut.setToolTipText(Message.PREVIEW_TAG);
        previewBut.setFont(FORM_BUT_FONT);
        cancelBut.setPreferredSize(new Dimension(180, 35));
        cancelBut.setToolTipText(Message.CANCEL_TAG);
        cancelBut.setFont(FORM_BUT_FONT);
        
        sorterBut.addMouseListener(new OButtonMouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e)
        	{
        		super.mousePressed(e);
        		if(e.getSource() instanceof OButton button)
        		{
        			button.setFont(button.getFont().deriveFont(com.lowagie.text.Font.UNDERLINE));
        			button.setForeground(OgineColor.BELGE);
        			button.setBackground(OgineColor.DARK_GREEN);
        			button.setBorderColor(OgineColor.DARK_GREEN);
        		}
        	}

        	@Override
        	public void mouseReleased(MouseEvent e)
        	{
        		super.mouseReleased(e);
        		if(e.getSource() instanceof OButton button)
        		{
        			button.setFont(button.getFont().deriveFont(Font.BOLD));
        			sorterBut.setForeground(OgineColor.BELGE);
        	        sorterBut.setBackground(OgineColor.DARK_GREEN.brighter());
        	        sorterBut.setBorderColor(OgineColor.DARK_GREEN.brighter());
        		}
        	}

        	@Override
        	public void mouseEntered(MouseEvent e) 
        	{
        		super.mouseEntered(e);
        		if(e.getSource() instanceof OButton button)
        		{
        			button.setForeground(Color.BLACK);
        			button.setBackground(new Color(240, 240, 240));
        			button.setBorderColor(new Color(240, 240, 240));
        		}
        	}

        	@Override
        	public void mouseExited(MouseEvent e) 
        	{
        		super.mouseExited(e);
        		if(e.getSource() instanceof OButton button)
        		{
        			sorterBut.setForeground(OgineColor.BELGE);
        	        sorterBut.setBackground(OgineColor.DARK_GREEN.brighter());
        	        sorterBut.setBorderColor(OgineColor.DARK_GREEN.brighter());
        		}
        	}
        });
        
        sorterBut.setForeground(OgineColor.BELGE);
        sorterBut.setBackground(OgineColor.DARK_GREEN.brighter());
        sorterBut.setBorderColor(OgineColor.DARK_GREEN.brighter());
        
        dataPane.setLayout(null);
        dataPane.setBackground(Color.WHITE);
        dataPane.add(paneTitle);
        dataPane.add(dataPane2);
        dataPane.add(searchPane);
        dataPane.add(optionPane);
        dataPane.add(butPane);
        
        searchPane.add(searchLabel);
        searchPane.add(searchField);
        searchPane.add(sorterLabel);
//        searchPane.add(sorterPane);
        searchPane.add(opa1);
        searchPane.add(opa2);
        searchPane.add(opa3);
        searchPane.add(opa4);
        
        opa1.add(yearSorter);
        opa2.add(instiSorter);
        opa3.add(levelSorter);
        opa4.add(specSorter);
        searchPane.add(sorterBut);

 
        dataPane2.add(tablePane);
        butPane.add(cancelBut);
        optionPane.add(previewBut);
        optionPane.add(updateBut);
        optionPane.add(deleteBut);
    }	

    private void buildOptionPane()
    {
        JLabel paneTitle = new JLabel(Message.OPTION_PANE_FORM_TITLE);
        JLabel userPaneTitle = new JLabel("Gestion des Utilisateur");
        JLabel DBPaneTitle = new JLabel("Gestion de la Base de Données");
        JLabel customPaneTitle = new JLabel("Gestion des Thèmes");
        JLabel accessPaneTitle = new JLabel("Option d'accessibilés");
        JPanel midPane = new JPanel(new GridLayout(2, 2));
        JPanel userPane = new JPanel(new BorderLayout());
        JPanel DBPane = new JPanel(new BorderLayout());
        JPanel customPane = new JPanel(new BorderLayout());
        JPanel accessPane = new JPanel(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        paneTitle.setBounds(180, 5, 600, 50);
        paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        paneTitle.setForeground(Color.BLACK);
        paneTitle.setHorizontalAlignment(JLabel.CENTER);
        paneTitle.setFont(FORM_TITLE_FONT);
        
        midPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        optionPane.setBackground(Color.WHITE);
        optionPane.setLayout(new GridBagLayout());

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(1, 1, 5, 1);
        optionPane.add(paneTitle, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(1, 1, 5, 1);
        optionPane.add(midPane, gbc);
        
        midPane.add(userPane);
        midPane.add(DBPane);
        midPane.add(customPane);
        midPane.add(accessPane);
        
        midPane.add(userPaneTitle, BorderLayout.NORTH);
        
        DBPane.add(DBPaneTitle, BorderLayout.NORTH);
        
        customPane.add(customPaneTitle, BorderLayout.NORTH);
        
        accessPane.add(accessPaneTitle, BorderLayout.NORTH);
    }
    
    private void buildJasperPane()
    {
        JLabel paneTitle;
        JPanel topPane;
        JPanel midPane;
        JPanel enregReportPane;
        JPanel listReportPane;
        JPanel fullReportPane;
        
        JLabel enregReportTitle;
        JLabel listReportTitle;
        JLabel fullReportTitle;
        
        JLabel enregReportIcon;
        JLabel listReportIcon;
        JLabel fullReportIcon;
        
        paneTitle = new JLabel(Message.JASPER_PANE_FORM_TITLE);
        topPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        midPane = new JPanel(new GridLayout(1, 3, 35, 35));
        enregReportPane = new JPanel(new BorderLayout());
        listReportPane = new JPanel(new BorderLayout());
        fullReportPane = new JPanel(new BorderLayout());
        
        enregReportTitle = new JLabel("LISTE DES ETUDIANTS ENREGISTER");
        listReportTitle = new JLabel("LISTE DES ETUDIANTS INSCRIT");
        fullReportTitle = new JLabel("LISTE DES ETUDIANTS");
        enregReportIcon = new JLabel(new ImageIcon(Iconifier.printerIcon.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT)));
        listReportIcon = new JLabel(new ImageIcon(Iconifier.printerIcon.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT)));
        fullReportIcon = new JLabel(new ImageIcon(Iconifier.printerIcon.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT)));
        
        enregReportBut = new JButton("Imprimer", Iconifier.printIcon);
        listReportBut = new JButton("Imprimer", Iconifier.printIcon);
        fullReportBut = new JButton("Imprimer", Iconifier.printIcon);

        paneTitle.setPreferredSize(new Dimension (600, 50));
        paneTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
        paneTitle.setForeground(Color.BLACK);
        paneTitle.setHorizontalAlignment(JLabel.CENTER);
        paneTitle.setFont(FORM_TITLE_FONT);
        
        enregReportTitle.setHorizontalAlignment(JLabel.CENTER);
        listReportTitle.setHorizontalAlignment(JLabel.CENTER);
        fullReportTitle.setHorizontalAlignment(JLabel.CENTER);
        enregReportTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 1));
        listReportTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 1));
        fullReportTitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 1));
        enregReportTitle.setFont(FORM_TITLE_FONT);
        listReportTitle.setFont(FORM_TITLE_FONT);
        fullReportTitle.setFont(FORM_TITLE_FONT);
        
        jasperPane.setBackground(Color.WHITE);
        jasperPane.setLayout(new BorderLayout(1, 35));
        
        topPane.setBackground(Color.WHITE);
        midPane.setBackground(Color.WHITE);
        listReportPane.setBackground(Color.WHITE);
        enregReportPane.setBackground(Color.WHITE);
        fullReportPane.setBackground(Color.WHITE);
        
        jasperPane.add(topPane, BorderLayout.NORTH);
        jasperPane.add(midPane, BorderLayout.CENTER);
        topPane.add(paneTitle);
        midPane.add(enregReportPane);
        midPane.add(listReportPane);
        midPane.add(fullReportPane);
        enregReportPane.add(enregReportTitle, BorderLayout.NORTH);
        listReportPane.add(listReportTitle, BorderLayout.NORTH);
        fullReportPane.add(fullReportTitle, BorderLayout.NORTH);
        enregReportPane.add(enregReportIcon, BorderLayout.CENTER);
        listReportPane.add(listReportIcon, BorderLayout.CENTER);
        fullReportPane.add(fullReportIcon, BorderLayout.CENTER);
        enregReportPane.add(enregReportBut, BorderLayout.SOUTH);
        listReportPane.add(listReportBut, BorderLayout.SOUTH);
        fullReportPane.add(fullReportBut, BorderLayout.SOUTH);
        
    }

    private void mainMenuListeners()
    {
        dashListeners();
        formListeners();
    }

    private void dashListeners()
    {
        newStudentRegisterFormBut.addActionListener(e ->{
        	this.studentSliderPane.show(1);
        });
        
		newRegisterFormBut.addActionListener(e ->{
			this.registerSliderPane.show(1);
			this.tabbedPane.setSelectedIndex(0);
		});
		
        newReRegisterFormBut.addActionListener(e ->{
        	this.registerSliderPane.show(1);
        	this.tabbedPane.setSelectedIndex(1);
        });

        DashboardController.showInsInfo(this);
        DashboardController.showListInfo(this);
        DashboardController.showEnregInfo(this);
        DashboardController.showReportInfo(this);
        DashboardController.showOptionInfo(this);
        DashboardController.exit(this);
    }

	private void formListeners() {
		new Runnable() {
			@Override
			public void run() 
			{
				studentPicturePicker.addActionListener(e -> {
					StudentRegisterController.addPicture(MainMenu.this);
				});
		        	
				studentValidate.addActionListener(e -> {
					StudentRegisterController.addStudent(MainMenu.this);
				});
		        studentReset.addActionListener(e -> {
		        	StudentRegisterController.askResetForm(MainMenu.this);
		        });
		        studentUpdate.addActionListener(e ->{
		        	StudentRegisterController.confirmUpdate(MainMenu.this);
		        });
		        studentCancel.addActionListener(e -> {
		        	StudentRegisterController.cancel(MainMenu.this);
		        });
		        //
		        registerValidate.addActionListener(e ->{
		        	RegisterValidateController.confirm(MainMenu.this);
		            DataTableController.populateTable(MainMenu.this);
		        });
		        registerReset.addActionListener(e -> {
		        	RegisterResetController.clear(MainMenu.this);
		        });
		        registerUpdate.addActionListener(e -> {
		        	RegisterUpdateController.confirm(MainMenu.this);
		        });
		        registerCancel.addActionListener(e -> {
		        	RegisterCancelController.cancel(MainMenu.this);
		        });
		        //
		        RegisterInfoController.inform(MainMenu.this);
		        //
		        reRegisterValidate.addActionListener(e ->{});
//		        DataTableController.populateTable(this)
//		        reRegisterReset.addActionListener(e ->{
//		        	ReRegisterResetController.clear(this);});
//		        reRegisterUpdate.addActionListener(e ->{
//		        	ReRegisterUpdateController.confirm(this);});
		        reRegisterCancel.addActionListener(e ->{
		        	ReRegisterCancelController.cancel(MainMenu.this);
		        });
		        ReRegisterInfoController.inform(MainMenu.this);
		        DataTableController.populateTable(MainMenu.this);
		        searchField.addKeyListener(new KeyAdapter(){
		            @Override
		            public void keyReleased(KeyEvent e)
		            {
		                DataTableController.populateFromSearch(MainMenu.this);
		            }	
		        });
		        searchField.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent e)
					{
						super.mouseClicked(e);
						if(SwingUtilities.isLeftMouseButton(e) && searchField.checkMouseOver(e.getPoint()))
						{
							DataTableController.populateFromSearch(MainMenu.this);
						}
					}
				});
		        //
		        updateBut.addActionListener(e -> {
		        	DataTableUpdateController.confirm(MainMenu.this);
		        });
		        cancelBut.addActionListener(e ->{
		        	DataTableCancelController.cancel(MainMenu.this);
		    	});
		        deleteBut.addActionListener(e ->{
		        	DataTableDeleteController.erase(MainMenu.this);
		    	});
		        previewBut.addActionListener(e ->{
		        	DataTableShowController.showCard(MainMenu.this);
		    	});
		        enregReportBut.addActionListener(e-> {
		            JaspertReportStudentController.printReport(MainMenu.this);
		        });
		        listReportBut.addActionListener(e-> {
		            JaspertReportRegisterController.printReport(MainMenu.this);
		        });
		        fullReportBut.addActionListener(e-> {
		            JasperReportSchoolStudentController.printReport(MainMenu.this);
		        });
		        //
		        lastnameField.addKeyListener(alphaKeyListener);
		        firstnameField.addKeyListener(alphaKeyListener);
		        fathernameField.addKeyListener(alphaKeyListener);
		        fatherfunctionField.addKeyListener(alphaKeyListener);
		        mothernameField.addKeyListener(alphaKeyListener);
		        motherfunctionField.addKeyListener(alphaKeyListener);
		        tutornameField.addKeyListener(alphaKeyListener);
		        tutorfunctionField.addKeyListener(alphaKeyListener);
		        addressField.addKeyListener(alphaKeyListener);
		        fathernumberField.addKeyListener(numberKeyListener);
		        mothernumberField.addKeyListener(numberKeyListener);
		        tutornumberField.addKeyListener(numberKeyListener);
		        phonenumberField.addKeyListener(numberKeyListener);
		        //
		        fathernumberField.addCaretListener(numberCaretListener);
		        mothernumberField.addCaretListener(numberCaretListener);
		        tutornumberField.addCaretListener(numberCaretListener);
		        fathernumberField.addCaretListener(numberCaretListener);
			}
		}.run();
	}

    public CardLayout getCard() 
    {
        return card;
    }

    public String getList(int i)
    {
        return list[i];
    }

    public JPanel getMainpane()
    {
        return mainPane;
    }

    public JPanel getCenterpane() 
    {
        return centerPane;
    }

    public Dashboard getDash() 
    {
        return dash;
    }
    
	public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }

    public SliderPanel getStudentSliderPane() {
        return studentSliderPane;
    }

    public SliderPanel getRegisterSliderPane() {
        return registerSliderPane;
    }

    public SliderPanel getReRegisterSliderPane() {
        return reRegisterSliderPane;
    }

    public JLabel getStudentClientprofile()
    {
        return studentClientProfile;
    }

    public OTextField getLastnamefield() 
    {
        return lastnameField;
    }

    public OTextField getFirstnamefield() 
    {
        return firstnameField;
    }

    public JDateChooser getBirthdate()
    {
        return birthdate;
    }

    public OTextField getCnifield()
    {
        return cniField;
    }

    public JComboBox<String> getBloodlist()
    {
        return bloodList;
    }

    public OTextField getFathernamefield() 
    {
        return fathernameField;
    }

    public OTextField getFathernumberfield() 
    {
        return fathernumberField;
    }

    public OTextField getFatherfunctionfield() 
    {
        return fatherfunctionField;
    }

    public OTextField getMothernamefield()
    {
        return mothernameField;
    }

    public OTextField getMothernumberfield() 
    {
        return mothernumberField;
    }

    public OTextField getMotherfunctionfield() 
    {
        return motherfunctionField;
    }

    public OTextField getTutornamefield() 
    {
        return tutornameField;
    }

    public OTextField getTutornumberfield() 
    {
        return tutornumberField;
    }

    public OTextField getTutorfunctionfield() 
    {
        return tutorfunctionField;
    }

    public OTextField getReligionfield() 
    {
        return religionField;
    }

    public OTextField getAddressfield() 
    {
        return addressField;
    }

    public JComboBox<String> getSexlist() 
    {
        return sexList;
    }

    public OTextField getPhonenumberfield() 
    {
        return phonenumberField;
    }

    public JButton getStudentPicturepicker()
    {
        return studentPicturePicker;
    }

    public JButton getStudentValidate()
    {
        return studentValidate;
    }

    public JButton getStudentReset() 
    {
        return studentReset;
    }

    public JButton getStudentUpdate()
    {
        return studentUpdate;
    }
/*--------------------------------------------------------*/

    public OTextField getRegisterLastnameField() 
    {
        return lastnameField2;
    }

    public OTextField getRegisterFirstnameField() 
    {
        return firstnameField2;
    }
    public OTextField getRegisterSexField()
    {
        return sexField;
    }

    public OTextField getRegisterAddressField()
    {
        return addressField2;
    }

    public JComboBox<Student> getRegisterStudentBox() 
    {
        return studentBox;
    }

    public JYearChooser getYearField()
    {
        return yearField;
    }

    public OJTextField getRegisterMatriculeField()
    {
        return matriculeField;
    }

    public JComboBox<Institut> getRegisterInstitutBox()
    {
        return institutBox;
    }

    public JComboBox<Level> getRegisterLevelBox()
    {
        return levelBox;
    }

    public JComboBox<Speciality> getRegisterSpecialityBox() 
    {
        return specialityBox;
    }

    public OTextField getRegisterCniField()
    {
        return cniField2;
    }

    public OTextField getRegisterPhonenumberField()
    {
        return phonenumberField2;
    }

    public OTextField getRegisterBirthField()
    {
        return birthField;
    }

    public JLabel getRegisterClientProfile()
    {
        return registerClientProfile;
    }

    public JButton getRegisterValidate()
    {
        return registerValidate;
    }

    public JButton getRegisterReset()
    {
        return registerReset;
    }

    public JButton getRegisterUpdate()
    {
        return registerUpdate;
    }

    public JButton getRegisterCancel()
    {
        return registerCancel;
    }
/*-----------------------------------------------------------------------------------------*/

    public OTextField getReRegisterLastnameField()
    {
        return lastnameField3;
    }

    public OTextField getReRegisterFirstnameField()
    {
        return firstnameField3;
    }

    public OTextField getReRegisterOldField()
    {
        return institutField;
    }

    public OTextField getReRegisterSexField()
    {
        return sexField2;
    }

    public OTextField getReRegisterPhonenumberField()
    {
        return phonenumberField3;
    }

    public OTextField getReRegisterAddressField()
    {
        return addressField3;
    }

    public JComboBox<Student> getReRegisterStudentBox()
    {
        return studentBox2;
    }

    public JYearChooser getReRegisterYearField()
    {
        return yearField2;
    }

    public OTextField getReRegisterMatriculeField()
    {
        return matriculeField2;
    }

    public JComboBox<Institut> getReRegisterInstitutBox()
    {
        return institutBox2;
    }

    public JComboBox<Level> getReRegisterLevelBox()
    {
        return levelBox2;
    }

    public JComboBox<Speciality> getReRegisterSpecialityBox()
    {
        return specialityBox2;
    }
}