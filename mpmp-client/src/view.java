
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javafx.scene.layout.Background;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.svg.SVGDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Klaus, Oskar
 */
public class view extends javax.swing.JFrame {

    JSVGCanvas canvas;

    public view() {
	initComponents();
	canvas = new JSVGCanvas();

	
	try {
     		setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/res/background.png")))));
     	} catch (IOException e) {
     		e.printStackTrace();
     	}
	//Background optimieren:
	//https://tips4java.wordpress.com/2008/10/12/background-panel/
	//TODO: Herr Hanauska fragen, ob das geht.
	
	//setLayout(new BoxLayout(getContentPane(), 0));
	setLayout(new BorderLayout());

	canvas.setURI(new File("src/res/gameboard.svg").toURI().toString());
	try{
	canvas.setFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/res/SourceSansPro-Light.ttf")));
	} catch (FontFormatException | IOException e){
	    e.printStackTrace();
	}
	
	canvas.setAutoscrolls(true);
	
	this.addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent e) {
		Dimension d = getPreferredSize();
		d.height = d.height - 50;
		d.width = d.width - 50;
		canvas.setPreferredSize(d);
		canvas.setBackground(new Color(0, 0, 0, 0));
		canvas.setEnableRotateInteractor(true);
		canvas.setEnableImageZoomInteractor(true);
		add(canvas);
		//("transform=scale(0.2)"
		SVGDocument svgd = canvas.getSVGDocument();
	    }
	});
	
	//http://stackoverflow.com/questions/22010658/boxlayout-inside-a-borderlayout
	
	JPanel buttons = new JPanel();
	JPanel chat = new JPanel();
	buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
	buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
	
	JButton btn1 = new JButton("Hello World 1");
	JButton btn2 = new JButton("Hello World 2");
	JButton btn3 = new JButton("Hello World 3");
	JButton btn4 = new JButton("Hello World 4");
	JButton btn5 = new JButton("Hello World 5");
	JButton btn6 = new JButton("Hello World 6");
	JButton btn7 = new JButton("Me is chat box");
	
	buttons.add(btn1);
	buttons.add(btn2);
	buttons.add(btn3);
	buttons.add(btn4);
	buttons.add(btn5);
	buttons.add(btn6);
	chat.add(btn7);
	
	add(buttons, BorderLayout.WEST);
	add(canvas, BorderLayout.CENTER);
	add(chat, BorderLayout.EAST);
	setTitle("Monopoly Multiplayer");
	pack();
	setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
// TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new view().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
