
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