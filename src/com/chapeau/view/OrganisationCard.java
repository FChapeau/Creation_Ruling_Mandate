package com.chapeau.view;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class OrganisationCard extends JPanel {
	private class MyMouseListener extends MouseInputAdapter{
		@Override
		public void mouseDragged (MouseEvent e){
			// TODO Gérer la souris qui sort des limites de l'écran
			Point mousePosition = e.getComponent().getParent().getMousePosition();
			Integer x = mousePosition.x - e.getX();
			Integer y = mousePosition.y - e.getY();
			
			if (x >= 0 || y >= 0)
			{
				updatePosition(mousePosition.x, mousePosition.y);
			}
		}
	}
	
	public OrganisationCard ()
	{
		
		MyMouseListener myMouseListener = new MyMouseListener();
		this.addMouseListener(myMouseListener);
		this.addMouseMotionListener(myMouseListener);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("M:\\workspace\\Creation_Ruling_Mandate\\resources\\NicCageFace.jpg"));
		this.add(lblNewLabel);
	}
	
	public void updatePosition(int x, int y)
	{
		this.setLocation(x, y);
	}
}
