package com.chapeau.view;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class OrganisationCard extends JPanel {

	private static final long serialVersionUID = 1274024428390540940L;

	private class MyMouseListener extends MouseInputAdapter{
		
		Point previousMousePosition = null;
		@Override
		public void mouseDragged (MouseEvent e)
		{
			// TODO Gérer la souris qui sort des limites de l'écran
			Point mousePosition = e.getComponent().getParent().getMousePosition();
			if(previousMousePosition != null)
			{
				//Frank: !!!The position change on a drag is simply the change between the mouse position before and after the drag action. So we need to remember the previous mouse position to compare with the current one.
				int deltaX = mousePosition.x - previousMousePosition.x;
				int deltaY = mousePosition.y - previousMousePosition.y;
				updatePosition(deltaX, deltaY);
			}
			previousMousePosition = mousePosition;
		}
		
		public void mousePressed(MouseEvent e)
		{
			//Frank: this is to make sure that when we place the mouse pointer somewhere else, we update our previousMousePosition before dragging
			Point mousePosition = e.getComponent().getParent().getMousePosition();
			previousMousePosition = mousePosition;
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
	
	public void updatePosition(int deltaX, int deltaY)
	{//Frank: I changed this function so it now takes a delta positionChange instead of a final position
		this.setLocation(this.getX()+deltaX, this.getY()+deltaY);
	}
}
