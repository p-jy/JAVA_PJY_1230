package day22.swing;

import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex03_Event {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("애플리케이션 예제");
		
		frame.setLayout(new FlowLayout());
		
		frame.setSize(400, 500); //프레임 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(e-> {
//			System.out.println("버튼 클릭");
			JOptionPane.showMessageDialog(frame, "버튼 클릭");
		});
		
		JTextField textField = new JTextField(20);
		textField.addActionListener(e-> {
			String text = textField.getText();
			System.out.println(text);
			textField.setText("");
		});
		
		frame.add(textField);
		frame.add(btn);
		
		frame.setVisible(true);
		
	}

}
