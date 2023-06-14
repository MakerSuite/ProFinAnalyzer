
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;


public class MainFrame extends JFrame {
	 JTextField textField;
	 JTable table1;
	 JTable table;
	 JLabel analysis;
	   public MainFrame() {
		      // Get the content-pane of this JFrame, which is a java.awt.Container
		      // All operations, such as setLayout() and add() operate on the content-pane 
		      Container cp = this.getContentPane(); 
		      FlowLayout layout = new FlowLayout();
		      cp.setLayout(layout);
		      JLabel label = new JLabel("Stock symbol to check:");
		      cp.add(label);
		      textField = new JTextField(10);
		      textField.setSize(500, 20);
		      textField.setMinimumSize(new Dimension(50, 20));
		      textField.setToolTipText("Ticker symbol (i.e. AAPL)");
		      cp.add(textField);
		      JButton  CheckButton= new JButton("Check");

				//Creates a table
				
				String[] columnNames = {"Indicator",
		                "Value"};

				String[] columnNames1 = {"Article title",
		        "Date published","URL"};
				
				table = new JTable();
				DefaultTableModel contactTableModel = (DefaultTableModel) table
				            .getModel();
				contactTableModel = new DefaultTableModel() {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        return false;
				    }
				};
				table.setModel(contactTableModel);
				contactTableModel.setColumnIdentifiers(columnNames);
			    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				JScrollPane scrollPane = new JScrollPane(table);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(160);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				//table.setFillsViewportHeight(true);
				table1 = new JTable();
				
				DefaultTableModel contactTableModel1 = (DefaultTableModel) table1
			            .getModel();
				contactTableModel1 = new DefaultTableModel() {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        return false;
				    }
				};
				table1.setModel(contactTableModel1);
				contactTableModel1.setColumnIdentifiers(columnNames1);
				//table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table1.setPreferredSize(new Dimension(520,400));
				table1.getColumnModel().getColumn(0).setPreferredWidth(400);
				table1.getColumnModel().getColumn(1).setPreferredWidth(120);
				table1.addMouseListener(new MouseAdapter() {
				    public void mousePressed(MouseEvent me) {
				        JTable table =(JTable) me.getSource();
				        Point p = me.getPoint();
				        int row = table.rowAtPoint(p);
				        if (me.getClickCount() == 2) {
				        	Object selectedObject = (Object) table1.getModel().getValueAt(row, 2);
				        	try{
				        	URL url = new URL(selectedObject.toString());
				        	 openWebpage(url.toURI());
				        	}catch(Exception ex)
				        	{
				        		ex.printStackTrace();
				        	}
				            // your valueChanged overridden method 