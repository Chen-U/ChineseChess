package ChineseChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;

/**
 * Title:��������
 * 
 * Description:�����û����棬�������������ʵ���ͳ�Ա�������������������С��Ϸ��ʵ�֡�
 */

public class ChineseChess extends JFrame implements ActionListener {
	ChessBoard board = null;
	Demon demon = null;
	MakeChessManual record = null;
	Container con = null;
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem ��������, ��������, ��ʾ����;
	JFileChooser fileChooser = null;
	LinkedList ���� = null;

	/**���췽��**/
	public ChineseChess() {
		bar = new JMenuBar();
		fileMenu = new JMenu("�й�����");
		�������� = new JMenuItem("��������");
		�������� = new JMenuItem("��������");
		��������.setEnabled(false);
		��ʾ���� = new JMenuItem("��ʾ����");
		fileMenu.add(��������);
		fileMenu.add(��������);
		fileMenu.add(��ʾ����);
		bar.add(fileMenu);
		setJMenuBar(bar);
		setTitle(��������.getText());
		��������.addActionListener(this);
		��������.addActionListener(this);
		��ʾ����.addActionListener(this);
		board = new ChessBoard(45, 45, 9, 10);
		record = board.record;
		con = getContentPane();
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, board, record);//ˮƽ�ָ�
		split.setDividerSize(5);
		split.setDividerLocation(460);
		con.add(split, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(60, 20, 690, 540);
		fileChooser = new JFileChooser();
		con.validate();
		validate();
	}

	/**�˵�����궯���¼�����Ӧ **/
	public void actionPerformed(ActionEvent e) {

		// ��������
		if (e.getSource() == ��������) {
			con.removeAll();
			��������.setEnabled(true);
			this.setTitle(��������.getText());
			board = new ChessBoard(45, 45, 9, 10);
			record = board.record;
			JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, board, record);
			split.setDividerSize(5);
			split.setDividerLocation(460);
			con.add(split, BorderLayout.CENTER);
			validate();
		}

		// ��������
		if (e.getSource() == ��������) {
			int state = fileChooser.showSaveDialog(null);
			File saveFile = fileChooser.getSelectedFile();
			if (saveFile != null && state == JFileChooser.APPROVE_OPTION) {
				try {
					FileOutputStream outOne = new FileOutputStream(saveFile);
					ObjectOutputStream outTwo = new ObjectOutputStream(outOne);
					outTwo.writeObject(record.��ȡ����());
					outOne.close();
					outTwo.close();
				} catch (IOException event) {
				}
			}
		}

		// ��ʾ����
		if (e.getSource() == ��ʾ����) {
			con.removeAll();
			con.repaint();
			con.validate();
			validate();
			��������.setEnabled(false);

			int state = fileChooser.showOpenDialog(null);
			File openFile = fileChooser.getSelectedFile();

			if (openFile != null && state == JFileChooser.APPROVE_OPTION) {
				try {
					FileInputStream inOne = new FileInputStream(openFile);
					ObjectInputStream inTwo = new ObjectInputStream(inOne);
					���� = (LinkedList) inTwo.readObject();
					inOne.close();
					inTwo.close();
					ChessBoard board = new ChessBoard(45, 45, 9, 10);
					demon = new Demon(board);
					demon.set����(����);
					con.add(demon, BorderLayout.CENTER);
					con.validate();
					validate();
					this.setTitle(��ʾ����.getText() + ":" + openFile);
				} catch (Exception event) {

					// �޷���ʾʱ���쳣����
					JLabel label = new JLabel("���������ļ�");
					label.setFont(new Font("����", Font.BOLD, 60));
					label.setForeground(Color.red);
					label.setHorizontalAlignment(SwingConstants.CENTER);
					con.add(label, BorderLayout.CENTER);
					con.validate();
					this.setTitle("û�д�����");
					validate();
				}
			} else {
				JLabel label = new JLabel("û�д������ļ���");
				label.setFont(new Font("����", Font.BOLD, 50));
				label.setForeground(Color.pink);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				con.add(label, BorderLayout.CENTER);
				con.validate();
				this.setTitle("û�д������ļ���");
				validate();
			}
		}
	}

	public static void main(String args[]) {
		new ChineseChess();
	}
}
