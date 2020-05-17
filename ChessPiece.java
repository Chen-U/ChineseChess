package ChineseChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title:������
 * 
 * Description:�������ӵĻ��ƺ����Ӹ������Ե��������ȡ��
 */

public class ChessPiece extends JLabel {
	String name; 
	Color backColor = null, foreColor;
	String ��ɫ��� = null;
	ChessBoard board = null;
	int width, height;

	/**���췽��**/
	public ChessPiece(String name, Color fc, Color bc, int width, int height, ChessBoard board) {
		this.name = name;
		this.board = board;
		this.width = width;
		this.height = height;
		foreColor = fc;
		backColor = bc;
		
		setSize(width, height);
		setBackground(bc);
		addMouseMotionListener(board);
		addMouseListener(board);
	}

	/**��������**/
	public void paint(Graphics g) {
		g.drawImage(board.pieceImg, 2, 2, width - 2, height - 2, null);
		g.setColor(foreColor);
		g.setFont(new Font("����", Font.BOLD, 26));
		g.drawString(name, 7, height - 8);
		g.setColor(Color.black);
		// g.drawOval(1, 1, width - 1, height - 1);
		float lineWidth = 2.3f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
		((Graphics2D) g).drawOval(2, 2, width - 2, height - 2);
	}

	/**��ȡ���**/
	public int getWidth() {
		return width;
	}

	/**��ȡ�߶�**/
	public int getHeight() {
		return height;
	}

	/**��ȡ����**/
	public String getName() {
		return name;
	}

	/**��ȡ������ɫ**/
	public Color ��ȡ������ɫ() {
		return foreColor;
	}

	/**����������ɫ(��Ӫ)���**/
	public void set�������(String ���) {
		��ɫ��� = ���;
	}

	/**��ȡ������ɫ(��Ӫ)���**/
	public String �������() {
		return ��ɫ���;
	}
}
