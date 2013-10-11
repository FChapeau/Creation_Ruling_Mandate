package com.chapeau.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.chapeau.controller.Controller;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class OrganisationManager extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public OrganisationManager(Controller controller) {
		Initialize();
		this.controller = controller;
	}

	private void Initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		OrganisationCard organisationCard = new OrganisationCard();
		organisationCard.setBounds(63, 32, 400, 395);
		panel.add(organisationCard);
	}
	
	@SuppressWarnings("static-access")
	private void OnImageDragged(MouseEvent mouseEvent){
		//if (mouseEvent.getButton() == mouseEvent.BUTTON1)
		//{
			int x = mouseEvent.getXOnScreen();
			int y = mouseEvent.getYOnScreen();
			int width = mouseEvent.getComponent().getWidth();
			int height = mouseEvent.getComponent().getHeight();
			
			mouseEvent.getComponent().setBounds(x, y, width, height);
			System.out.println("It occured!");
		//}
	}
}
