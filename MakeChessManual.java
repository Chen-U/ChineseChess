package ChineseChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * Title:����������
 * 
 * Disruption:��ʾ���������ף���ʵ�ֻ��幦�ܡ�
 */

public class MakeChessManual extends JPanel implements ActionListener {
	JTextArea text = null;
	JScrollPane scroll = null;
	ChessBoard board = null;
	ChessPoint[][] point;
	LinkedList ���� = null;
	LinkedList �Ե������� = null;
	JButton buttonUndo;
	int i = 0;

	/**���췽��**/
	public MakeChessManual(ChessBoard board, ChessPoint[][] point) {
		this.board = board;
		this.point = point;
		text = new JTextArea();
		scroll = new JScrollPane(text);
		���� = new LinkedList();
		�Ե������� = new LinkedList();
		buttonUndo = new JButton("����");
		buttonUndo.setFont(new Font("����", Font.PLAIN, 18));
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		add(buttonUndo, BorderLayout.SOUTH);
		buttonUndo.addActionListener(this);
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

	/**��¼����**/
	public void ��¼����(ChessPiece piece, int startI, int startJ, int endI, int endJ) {
		Point pStart = new Point(startI, startJ);
		Point pEnd = new Point(endI, endJ);
		MoveStep step = new MoveStep(pStart, pEnd);
		����.add(step);

		String ������� = piece.�������();
		String name = piece.getName();
		String m = "#" + ������� + name + ": " + startI + numberToLetter(startJ) + " �� " + endI + numberToLetter(endJ);
		text.append(m);
		if (piece.�������().equals(board.�ڷ���ɫ))
			text.append("\n");
	}

	/**��¼����**/
	public void ��¼�Ե�������(Object object) {
		�Ե�������.add(object);
	}

	/**��ȡ����**/
	public LinkedList ��ȡ����() {
		return ����;
	}

	/**����**/
	public void actionPerformed(ActionEvent e) {
		int position = text.getText().lastIndexOf("#");
		if (position != -1)
			text.replaceRange("", position, text.getText().length());
		if (����.size() > 0) {
			MoveStep lastStep = (MoveStep) ����.getLast();
			����.removeLast();
			Object qizi = �Ե�������.getLast();
			�Ե�������.removeLast();
			String temp = qizi.toString();
			
			//û������
			if (temp.equals("û������")) {
				int startI = lastStep.pStart.x;
				int startJ = lastStep.pStart.y;
				int endI = lastStep.pEnd.x;
				int endJ = lastStep.pEnd.y;
				ChessPiece piece = point[endI][endJ].getPiece();

				point[startI][startJ].setPiece(piece, board);
				(point[endI][endJ]).set������(false);

				if (piece.�������().equals(board.�췽��ɫ)) {
					board.�췽���� = true;
					board.�ڷ����� = false;
				}
				if (piece.�������().equals(board.�ڷ���ɫ)) {
					board.�ڷ����� = true;
					board.�췽���� = false;
				}
			} 
			
			//����
			else {
				ChessPiece removedPiece = (ChessPiece) qizi;
				int startI = lastStep.pStart.x;
				int startJ = lastStep.pStart.y;
				int endI = lastStep.pEnd.x;
				int endJ = lastStep.pEnd.y;
				ChessPiece piece = point[endI][endJ].getPiece();
				point[startI][startJ].setPiece(piece, board);
				point[endI][endJ].setPiece(removedPiece, board);
				(point[endI][endJ]).set������(true);

				if (piece.�������().equals(board.�췽��ɫ)) {
					board.�췽���� = true;
					board.�ڷ����� = false;
				}
				if (piece.�������().equals(board.�ڷ���ɫ)) {
					board.�ڷ����� = true;
					board.�췽���� = false;
				}
			}
		}
	}
}
