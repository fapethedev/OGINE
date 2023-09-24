package com.fapethedev.ogine.view.menu.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fapethedev.ogine.utilities.Iconifier;
import com.fapethedev.ogine.utilities.SwingUtils;
import com.fapethedev.ogine.view.component.border.UnderlineBorder;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public abstract class Form extends JPanel 
{
	private final int FORM_WIDTH = SwingUtils.getMainWidth() - 262;
	private final int FORM_HEIGTH = SwingUtils.getHeight() - 68;
	
	protected final Font FORM_BUT_FONT = new JButton().getFont().deriveFont(Font.BOLD);
	protected final Font FORM_TITLE_FONT = new Font("Arial", Font.BOLD, 18);
	protected final Font FORM_FONT = new Font("Arial", Font.BOLD, 16);
	
	protected JLabel formtitle;
	
	protected JButton validate;
	protected JButton reset;
	
	public Form()
	{
		super(true);
		initForm();
		buildFormPane();
		buildRegisterForm();
		getInForm();
		addListeners();
		this.setSize(new Dimension(FORM_WIDTH, FORM_HEIGTH));
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public Form(LayoutManager layout)
	{
		super(layout, true);
		initForm();
		buildFormPane();
		buildRegisterForm();
		getInForm();
		addListeners();
		this.setSize(new Dimension(FORM_WIDTH, FORM_HEIGTH));
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void initForm()
	{
		validate = new JButton("Enregistrer", Iconifier.validateIcon);
		reset = new JButton("Effacer", Iconifier.errorFormIcon);
	}
	
	public void getInForm()
	{
		this.add(formtitle);
		//this.add(validate);
		//this.add(reset);
	}
	
	public void buildFormPane() {}
	
	public void buildRegisterForm()
	{
		formtitle.setBounds(180, 5, 600, 50);
		formtitle.setBorder(UnderlineBorder.createUnderlineBorder(Color.BLACK, 2));
		formtitle.setForeground(Color.BLACK);
		formtitle.setHorizontalAlignment(JLabel.CENTER);
		formtitle.setFont(FORM_TITLE_FONT);
	}
	
	public void onPicturepickerclick(ActionEvent e) {}
	
	public void onValidateClick(ActionEvent e) {}
	
	public void onResetClick(ActionEvent e) {}
	
	public void onCancelClick(ActionEvent e) {}
	
	/**
	 * add listener for form button by use method's reference 
	 */
	public void addListeners() 
	{
		validate.addActionListener(this::onValidateClick);
		reset.addActionListener(this::onResetClick);
	}

	public int getFORM_WIDTH()
	{
		return FORM_WIDTH;
	}

	public int getFORM_HEIGTH()
	{
		return FORM_HEIGTH;
	}
	
	public JButton getValidate()
	{
		return validate;
	}

	public JButton getReset() 
	{
		return reset;
	}
}
