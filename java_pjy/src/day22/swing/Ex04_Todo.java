package day22.swing;

import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex04_Todo {

	/* 오늘의 할일을 입력받아 엔터를 치거나 버튼을 클릭하면
	 * 오늘의 할일이 추가되는 코드를 작성하세요.
	 */
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Todo 예제");
		
		frame.setLayout(new FlowLayout());
		
		frame.setSize(400, 500); //프레임 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼
		
		JTextArea textArea = new JTextArea(20, 30);
		textArea.setEditable(false);
		
		JTextField textField = new JTextField(20);
		textField.addActionListener(e-> {
			String text = textField.getText();
			textArea.append(text + "\n");
			textField.setText("");
		});
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(e-> {
			String text = textField.getText();
			textArea.append(text + "\n");
			textField.setText("");
		});
		
		
		frame.add(textField);
		frame.add(btn);
		frame.add(textArea);
		
		frame.setVisible(true);

	}

}
