package com.chapeau.controller;

import java.awt.EventQueue;

import com.chapeau.view.OrganisationManager;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}
	
	public Controller()
	{
		StartView();
	}
	
	private void StartView()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganisationManager frame = new OrganisationManager(Controller.this);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


