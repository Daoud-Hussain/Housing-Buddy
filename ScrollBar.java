import java.awt.*;
import javax.swing.*;
  
 public class ScrollBar
{
    public static void main(String[] args)
    {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        buttonPanel.add(new CustomButton("Button 1", Color.red, Color.blue), gbc);
        buttonPanel.add(new CustomButton("Button 2", Color.yellow, Color.blue), gbc);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(buttonPanel);
        f.setSize(300,175);
        f.setLocation(300,300);
        f.setVisible(true);
    }
}
  
class CustomButton extends JButton
{
    Color color1, color2;
  
    public CustomButton(String text, Color color1, Color color2)
    {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(false);
    }
  
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        Paint gradient = new GradientPaint(0, 0, color1, width, height, color2);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, width, height);
        super.paintComponent(g);
    }
}