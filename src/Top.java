import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.keyboard.event.GlobalKeyListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Top {

    private JLabel label;
    private JFrame frame;
    private ImageIcon image;

    public Top(File f, int key)
    {
        this.image=new ImageIcon(f.getAbsolutePath());
        frame=new JFrame()
        {
            public void paint(Graphics g)
            {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
                super.paint(g2d);
            }
        };
        frame.setSize(image.getIconWidth(), image.getIconHeight());
        label=new JLabel(image) {
            public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(getBackground());
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
                super.paint(g2d);
            }
        };
        label.setSize(frame.getSize());
        frame.add(label);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setBackground(new Color(0,0,0,0));
        frame.setLocationRelativeTo(null);

        GlobalKeyboardHook hook=new GlobalKeyboardHook(true);
        hook.addKeyListener(new GlobalKeyListener()
        {
            @Override
            public void keyPressed(GlobalKeyEvent e)
            {
                if(e.getVirtualKeyCode()==key)
                {
                    label.setVisible(true);
                }
            }

            @Override
            public void keyReleased(GlobalKeyEvent e)
            {
                if(e.getVirtualKeyCode()==key)
                {
                    label.setVisible(false);
                }
            }
        });

        label.setVisible(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
