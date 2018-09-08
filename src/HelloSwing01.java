import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing01 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("HelloSwing - Frame Title");
    final JLabel label = new JLabel("Hello Swing");
    frame.getContentPane().add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    
    ///////////////////// Extend /////////
    
    frame.setSize(300,200);
    frame.setLocationRelativeTo(null);

  }
}