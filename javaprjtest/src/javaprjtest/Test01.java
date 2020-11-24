package javaprjtest;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test01 extends JFrame {
	private Container c;
	private GridLayout grid;
	private JLabel numberJl, msgJl;
	private JButton sendBtn, resetBtn;
	private JTextField numberTf, msgTf;

	public Test01() {
		// 1. 필요한 오브젝트를 메모리에 로딩
		initObject();

		// 2. 세팅
		initSetting();

		// 3. 배치
		initBatch();
	}

	private void initBatch() {
		c.add(numberJl);
		c.add(numberTf);
		c.add(msgJl);
		c.add(msgTf);
		c.add(sendBtn);
		c.add(resetBtn);

		sendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String numberString = numberTf.getText();
				String msgString = msgTf.getText();
				ExampleSend.SMS(numberString, msgString);
				System.out.println(numberString);
				System.out.println(msgString);
			}
		});

		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numberTf.setText("");
				msgTf.setText("");

			}
		});

	}

	private void initSetting() {
		setTitle("TEST");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		c = getContentPane();
		c.setLayout(grid);
	}

	private void initObject() {
		grid = new GridLayout(3, 2);

		numberJl = new JLabel("전화번호");
		msgJl = new JLabel("메세지");

		sendBtn = new JButton("전송");
		resetBtn = new JButton("초기화");

		numberTf = new JTextField();
		msgTf = new JTextField();
	}

	public static void main(String[] args) {
		new Test01();
	}

}
