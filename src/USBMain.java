import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * @Kyle
 * 13/05/2016
 * USBMain class, the program entrance
 */
public class USBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		USBMain u = new USBMain();  
        u.launchFrame();  
        //开启盘符检查线程  
        new CheckRootThread().start();

	}
	
	private void launchFrame() {  
        final JFrame frame = new JFrame();  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLocation(580, 250);  
        JButton hide = new JButton("点击隐藏窗口");  
        // 点击按钮后隐藏窗口事件监听  
        hide.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                frame.setVisible(false);  
            }  
        });  
        frame.add(hide);  
        frame.pack();  
        frame.setVisible(true);  
    }  

}
