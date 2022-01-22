import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Select {

    private JFrame frame;
    private JPanel panel;
    private JButton selectButton;
    private JFileChooser chooser;
    private File file;
    private int key;

    public Select()
    {
        frame=new JFrame();
        panel=new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        frame.setVisible(true);
        frame.setSize(150, 100);
        frame.setResizable(false);
        JLabel label=new JLabel("Press Key");
        panel.add(label);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                key=e.getKeyCode();
                frame.remove(label);
                selectButton=new JButton("Select");
                selectButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        selectImage();
                    }
                });
                selectButton.setVisible(true);
                panel.add(selectButton);
                selectButton.setSize(75,50);
                frame.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void selectImage()
    {
        chooser=new JFileChooser();
//        chooser.setFileFilter(new FileNameExtensionFilter("Images", ".png",".jpg",".jpeg"));
        chooser.showDialog(panel, "Select image");
        this.file=chooser.getSelectedFile();

        frame.dispose();
        JOptionPane.showMessageDialog(null,"Super you chosed","Nice cock", JOptionPane.PLAIN_MESSAGE);
        new Top(this.file, this.key);
    }
}
