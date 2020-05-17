package ChineseChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title:棋子类
 * 
 * Description:负责棋子的绘制和棋子各种属性的设置与获取。
 */

public class ChessPiece extends JLabel {
	String name; 
	Color backColor = null, foreColor;
	String 颜色类别 = null;
	ChessBoard board = null;
	int width, height;

	/**构造方法**/
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

	/**绘制棋子**/
	public void paint(Graphics g) {
		g.drawImage(board.pieceImg, 2, 2, width - 2, height - 2, null);
		g.setColor(foreColor);
		g.setFont(new Font("楷体", Font.BOLD, 26));
		g.drawString(name, 7, height - 8);
		g.setColor(Color.black);
		// g.drawOval(1, 1, width - 1, height - 1);
		float lineWidth = 2.3f;
		((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
		((Graphics2D) g).drawOval(2, 2, width - 2, height - 2);
	}

	/**获取宽度**/
	public int getWidth() {
		return width;
	}

	/**获取高度**/
	public int getHeight() {
		return height;
	}

	/**获取名字**/
	public String getName() {
		return name;
	}

	/**获取棋子颜色**/
	public Color 获取棋子颜色() {
		return foreColor;
	}

	/**设置棋子颜色(阵营)类别**/
	public void set棋子类别(String 类别) {
		颜色类别 = 类别;
	}

	/**获取棋子颜色(阵营)类别**/
	public String 棋子类别() {
		return 颜色类别;
	}
}
