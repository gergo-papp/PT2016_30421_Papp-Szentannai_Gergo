package utcn.pt.orderManagement;

import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utcn.pt.orderManagement.entities.Customer;
import utcn.pt.orderManagement.entities.Model;
import utcn.pt.orderManagement.entities.Product;
import utcn.pt.orderManagement.entities.Warehouse;
import utcn.pt.orderManagement.presentation.gui.MainFrame;


/**
 * Entry point of the program.
 *
 */
public class App
{
	
	private static Model models;
	
	
    public static void main( String[] args )
    {
        System.out.println( "Program started" );
        
        initGui();
        
        setModels(new Model());
      
    }

	private static void initGui() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				MainFrame myFrame = new MainFrame();
			}
		});
	}

	public static Model getModels() {
		return models;
	}

	public static void setModels(Model models) {
		App.models = models;
	}


}