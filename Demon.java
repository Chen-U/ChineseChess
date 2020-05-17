package ChineseChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Title:��ʾ������
 * 
 * Disruption:�������׵���ʾ��
 */

public class Demon extends JPanel implements ActionListener, Runnable {
	public JButton replay = null, next = null, auto = null, stop = null;
	LinkedList ���� = null;
	Thread �Զ���ʾ = null;
	int index = -1;
	ChessBoard board = null;
	JTextArea text;
	JTextField ʱ���� = null;
	int time = 1000;
	String ��ʾ���� = "";
	JSplitPane splitH = null, splitV = null;

	/**���췽��**/
	public Demon(ChessBoard board) {
		this.board = board;
		replay = new JButton("������ʾ");
		next = new JButton("��һ��");
		auto = new JButton("�Զ���ʾ");
		stop = new JButton("��ͣ��ʾ");
		�Զ���ʾ = new Thread(this);
		replay.addActionListener(this);
		next.addActionListener(this);
		auto.addActionListener(this);
		stop.addActionListener(this);
		text = new JTextArea();
		ʱ���� = new JTextField("1");
		setLayout(new BorderLayout());
		JScrollPane pane = new JScrollPane(text);
		JPanel p = new JPanel(new GridLayout(3, 2));
		p.add(next);
		p.add(replay);
		p.add(auto);
		p.add(stop);
		p.add(new JLabel("ʱ����(��)", SwingConstants.CENTER));
		p.add(ʱ����);
		splitV = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pane, p);
		splitH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, board, splitV);
		splitV.setDividerSize(5);
		splitV.setDividerLocation(400);
		splitH.setDividerSize(5);
		splitH.setDividerLocation(460);
		add(splitH, BorderLayout.CENTER);
		validate();
	}

	/**��������**/
	public void set����(LinkedList ����) {
		this.���� = ����;
	}

	/**�к�����ת��ĸ����������**/
	public char numberToLetter(int n) {
		char c = '\0';
		switch (n) {
		case 1:
			c = 'A';
			break;
		case 2:
			c = 'B';
			break;
		case 3:
			c = 'C';
			break;
		case 4:
			c = 'D';
			break;
		case 5:
			c = 'E';
			break;
		case 6:
			c = 'F';
			break;
		case 7:
			c = 'G';
			break;
		case 8:
			c = 'H';
			break;
		case 9:
			c = 'I';
			break;
		case 10:
			c = 'J';
			break;
		}
		return c;
	}

	/**��ʾ��������¼���Ӧ**/
	public void actionPerformed(ActionEvent e) {
		
		//��һ��
		if (e.getSource() == next) {
			index++;
			if (index < ����.size()) {
				��ʾһ��(index);
			} else {
				��ʾ����("������ʾ���");
			}
		}
		
		//������ʾ
		if (e.getSource() == replay) {
			board = new ChessBoard(45, 45, 9, 10);
			splitH.remove(board);
			splitH.setDividerSize(5);
			splitH.setDividerLocation(460);
			splitH.setLeftComponent(board);
			splitH.validate();
			index = -1;
			text.setText(null);
		}
		
		//�Զ���ʾ
		if (e.getSource() == auto) {
			next.setEnabled(false);
			replay.setEnabled(false);
			try {
				time = 1000 * Integer.parseInt(ʱ����.getText().trim());
			} catch (NumberFormatException ee) {
				time = 1000;
			}

			if (!(�Զ���ʾ.isAlive())) {
				�Զ���ʾ = new Thread(this);
				board = new ChessBoard(45, 45, 9, 10);
				splitH.remove(board);
				splitH.setDividerSize(5);
				splitH.setDividerLocation(460);
				splitH.setLeftComponent(board);
				splitH.validate();
				text.setText(null);
				�Զ���ʾ.start();
			}

		}
		
		//ֹͣ��ʾ
		if (e.getSource() == stop) {
			if (e.getActionCommand().equals("��ͣ��ʾ")) {
				��ʾ���� = "��ͣ��ʾ";
				stop.setText("������ʾ");
				stop.repaint();
			}
			if (e.getActionCommand().equals("������ʾ")) {
				��ʾ���� = "������ʾ";
				�Զ���ʾ.interrupt();
				stop.setText("��ͣ��ʾ");
				stop.repaint();
			}
		}
	}

	/**�����߳�**/
	public synchronized void run() {
		for (index = 0; index < ����.size(); index++) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
			}
			while (��ʾ����.equals("��ͣ��ʾ")) {
				try {
					wait();
				} catch (InterruptedException e) {
					notifyAll();
				}
			}
			��ʾһ��(index);
		}
		if (index >= ����.size()) {
			��ʾ����("������ʾ���");
			next.setEnabled(true);
			replay.setEnabled(true);
		}
	}

	/**��ʾһ��**/
	public void ��ʾһ��(int index) {
		MoveStep step = (MoveStep) ����.get(index);
		Point pStart = step.pStart;
		Point pEnd = step.pEnd;
		int startI = pStart.x;
		int startJ = pStart.y;
		int endI = pEnd.x;
		int endJ = pEnd.y;
		ChessPiece piece = (board.point)[startI][startJ].getPiece();
		
		if ((board.point)[endI][endJ].isPiece() == true) {
			ChessPiece pieceRemoved = (board.point)[endI][endJ].getPiece();
			
			(board.point)[endI][endJ].reMovePiece(pieceRemoved, board);
			board.repaint();
			(board.point)[endI][endJ].setPiece(piece, board);
			(board.point)[startI][startJ].set������(false);
			board.repaint();
		} else {
			(board.point)[endI][endJ].setPiece(piece, board);
			(board.point)[startI][startJ].set������(false);

		}
		String ������� = piece.�������();
		String name = piece.getName();
		
		String m = "#" + ������� + name + ": " + startI + numberToLetter(startJ) + " �� " + endI + numberToLetter(endJ);
		text.append(m);
		if (piece.�������().equals(board.�ڷ���ɫ))
			text.append("\n");
	}

	/**��ʾ����**/
	public void ��ʾ����(String message) {
		splitH.remove(board);
		splitH.setDividerSize(5);
		splitH.setDividerLocation(460);
		JLabel label = new JLabel(message);
		label.setFont(new Font("����", Font.BOLD, 40));
		label.setForeground(Color.blue);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		splitH.setLeftComponent(label);
		splitH.validate();
	}
}
