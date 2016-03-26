package utcn.pt.orderManagement;

import javax.swing.SwingUtilities;

import utcn.pt.orderManagement.presentation.gui.MainFrame;


/**
 * Entry point of the program.
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Program started" );
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				MainFrame myFrame = new MainFrame();
			}
		});
    }
}