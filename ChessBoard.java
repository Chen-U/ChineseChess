package ChineseChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title:������
 * 
 * Description:�����������̣�����ȫ�����ӵ����ԣ���ȫ�����Ӱڷ������̵���Ӧλ�ã��������������Ĳ�ͬ������
 */

public class ChessBoard extends JPanel implements MouseListener, MouseMotionListener {
	public ChessPoint point[][];
	public int unitWidth, unitHeight;
	private int x�᳤, y�᳤;
	private int x, y;
	private Image img;
	protected Image pieceImg;
	private boolean move = false;
	public String �췽��ɫ = "�췽", �ڷ���ɫ = "�ڷ�";
	ChessPiece �쳵1, �쳵2, ����1, ����2, ����1, ����2, ��˧, ��ʿ1, ��ʿ2, ���1, ���2, ���3, ���4, ���5, ����1, ����2;
	ChessPiece �ڳ�1, �ڳ�2, ����1, ����2, �ڽ�, ��ʿ1, ��ʿ2, ����1, ����2, ����3, ����4, ����5, ����1, ����2, ����1, ����2;

	int startX, startY;
	int startI, startJ;
	public boolean �췽���� = true, �ڷ����� = false;
	Rule rule = null;
	public MakeChessManual record = null;

	/**���췽��**/
	public ChessBoard(int w, int h, int r, int c) {
		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
		Color bc = getBackground();
		unitWidth = w;
		unitHeight = h;
		x�᳤ = r;
		y�᳤ = c;

		point = new ChessPoint[r + 1][c + 1];

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				point[i][j] = new ChessPoint(i * unitWidth, j * unitHeight, false);
			}
		}

		rule = new Rule(this, point);
		record = new MakeChessManual(this, point);

		img = Toolkit.getDefaultToolkit().getImage("board.jpg");
		pieceImg = Toolkit.getDefaultToolkit().getImage("piece.gif");

		// ����������ۺ���Ӫ
		�쳵1 = new ChessPiece("܇", Color.red, bc, w - 4, h - 4, this);
		�쳵1.set�������(�췽��ɫ);
		�쳵2 = new ChessPiece("܇", Color.red, bc, w - 4, h - 4, this);
		�쳵2.set�������(�췽��ɫ);
		����1 = new ChessPiece("�R", Color.red, bc, w - 4, h - 4, this);
		����1.set�������(�췽��ɫ);
		����2 = new ChessPiece("�R", Color.red, bc, w - 4, h - 4, this);
		����2.set�������(�췽��ɫ);
		����1 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		����1.set�������(�췽��ɫ);
		����2 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		����2.set�������(�췽��ɫ);
		����1 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		����1.set�������(�췽��ɫ);
		����2 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		����2.set�������(�췽��ɫ);
		��ʿ1 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		��ʿ1.set�������(�췽��ɫ);
		��ʿ2 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		��ʿ2.set�������(�췽��ɫ);
		��˧ = new ChessPiece("˧", Color.red, bc, w - 4, h - 4, this);
		��˧.set�������(�췽��ɫ);
		���1 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		���1.set�������(�췽��ɫ);
		���2 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		���2.set�������(�췽��ɫ);
		���3 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		���3.set�������(�췽��ɫ);
		���4 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		���4.set�������(�췽��ɫ);
		���5 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
		���5.set�������(�췽��ɫ);

		�ڽ� = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		�ڽ�.set�������(�ڷ���ɫ);
		��ʿ1 = new ChessPiece("ʿ", Color.black, bc, w - 4, h - 4, this);
		��ʿ1.set�������(�ڷ���ɫ);
		��ʿ2 = new ChessPiece("ʿ", Color.black, bc, w - 4, h - 4, this);
		��ʿ2.set�������(�ڷ���ɫ);
		�ڳ�1 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		�ڳ�1.set�������(�ڷ���ɫ);
		�ڳ�2 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		�ڳ�2.set�������(�ڷ���ɫ);
		����1 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����1.set�������(�ڷ���ɫ);
		����2 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����2.set�������(�ڷ���ɫ);
		����1 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����1.set�������(�ڷ���ɫ);
		����2 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����2.set�������(�ڷ���ɫ);
		����1 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����1.set�������(�ڷ���ɫ);
		����2 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����2.set�������(�ڷ���ɫ);
		����1 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����1.set�������(�ڷ���ɫ);
		����2 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����2.set�������(�ڷ���ɫ);
		����3 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����3.set�������(�ڷ���ɫ);
		����4 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����4.set�������(�ڷ���ɫ);
		����5 = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
		����5.set�������(�ڷ���ɫ);
		
		//�����������ø�����λ��
		point[1][10].setPiece(�쳵1, this);
		point[2][10].setPiece(����1, this);
		point[3][10].setPiece(����1, this);
		point[4][10].setPiece(��ʿ1, this);
		point[5][10].setPiece(��˧, this);
		point[6][10].setPiece(��ʿ2, this);
		point[7][10].setPiece(����2, this);
		point[8][10].setPiece(����2, this);
		point[9][10].setPiece(�쳵2, this);
		point[2][8].setPiece(����1, this);
		point[8][8].setPiece(����2, this);
		point[1][7].setPiece(���1, this);
		point[3][7].setPiece(���2, this);
		point[5][7].setPiece(���3, this);
		point[7][7].setPiece(���4, this);
		point[9][7].setPiece(���5, this);

		point[1][1].setPiece(�ڳ�1, this);
		point[2][1].setPiece(����1, this);
		point[3][1].setPiece(����1, this);
		point[4][1].setPiece(��ʿ1, this);
		point[5][1].setPiece(�ڽ�, this);
		point[6][1].setPiece(��ʿ2, this);
		point[7][1].setPiece(����2, this);
		point[8][1].setPiece(����2, this);
		point[9][1].setPiece(�ڳ�2, this);
		point[2][3].setPiece(����1, this);
		point[8][3].setPiece(����2, this);
		point[1][4].setPiece(����1, this);
		point[3][4].setPiece(����2, this);
		point[5][4].setPiece(����3, this);
		point[7][4].setPiece(����4, this);
		point[9][4].setPiece(����5, this);
	}

	/**��������**/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int imgWidth = img.getWidth(this);
		int imgHeight = img.getHeight(this);
		int FWidth = getWidth();
		int FHeight = getHeight();
		int x = (FWidth - imgWidth) / 2;
		int y = (FHeight - imgHeight) / 2;
		g.drawImage(img, x, y, null);

		for (int j = 1; j <= y�᳤; j++) {
			g.drawLine(point[1][j].x, point[1][j].y, point[x�᳤][j].x, point[x�᳤][j].y);
		}
		for (int i = 1; i <= x�᳤; i++) {
			if (i != 1 && i != x�᳤) {
				g.drawLine(point[i][1].x, point[i][1].y, point[i][y�᳤ - 5].x, point[i][y�᳤ - 5].y);
				g.drawLine(point[i][y�᳤ - 4].x, point[i][y�᳤ - 4].y, point[i][y�᳤].x, point[i][y�᳤].y);
			} else {
				g.drawLine(point[i][1].x, point[i][1].y, point[i][y�᳤].x, point[i][y�᳤].y);
			}
		}

		g.drawLine(point[4][1].x, point[4][1].y, point[6][3].x, point[6][3].y);
		g.drawLine(point[6][1].x, point[6][1].y, point[4][3].x, point[4][3].y);
		g.drawLine(point[4][8].x, point[4][8].y, point[6][y�᳤].x, point[6][y�᳤].y);
		g.drawLine(point[4][y�᳤].x, point[4][y�᳤].y, point[6][8].x, point[6][8].y);

		for (int i = 1; i <= x�᳤; i++) {
			g.drawString("" + i, i * unitWidth, unitHeight / 2);
		}
		int j = 1;
		for (char c = 'A'; c <= 'J'; c++) {
			g.drawString("" + c, unitWidth / 4, j * unitHeight);
			j++;
		}

	}

	/**��갴���¼���Ӧ**/
	public void mousePressed(MouseEvent e) {
		ChessPiece piece = null;
		Rectangle rect = null;
		
		if (e.getSource() == this)
			move = false;
		if (move == false)
			if (e.getSource() instanceof ChessPiece) {
				piece = (ChessPiece) e.getSource();
				startX = piece.getBounds().x;
				startY = piece.getBounds().y;
				rect = piece.getBounds();
				for (int i = 1; i <= x�᳤; i++) {
					for (int j = 1; j <= y�᳤; j++) {
						int x = point[i][j].getX();
						int y = point[i][j].getY();
						if (rect.contains(x, y)) {
							startI = i;
							startJ = j;
							break;
						}

					}
				}
			}
	}

	/**����϶��¼���Ӧ**/
	public void mouseDragged(MouseEvent e) {
		ChessPiece piece = null;
		if (e.getSource() instanceof ChessPiece) {
			piece = (ChessPiece) e.getSource();

			move = true;

			e = SwingUtilities.convertMouseEvent(piece, e, this);
		}

		if (e.getSource() == this) {
			if (move && piece != null) {
				x = e.getX();
				y = e.getY();
				if (�췽���� && ((piece.�������()).equals(�췽��ɫ))) {
					piece.setLocation(x - piece.getWidth() / 2, y - piece.getHeight() / 2);
				}
				if (�ڷ����� && (piece.�������().equals(�ڷ���ɫ))) {
					piece.setLocation(x - piece.getWidth() / 2, y - piece.getHeight() / 2);
				}
			}
		}
	}

	/**�ɿ�����¼�**/
	public void mouseReleased(MouseEvent e) {
		ChessPiece piece = null;
		move = false;
		Rectangle rect = null;
		
		if (e.getSource() instanceof ChessPiece) {
			piece = (ChessPiece) e.getSource();
			rect = piece.getBounds();

			e = SwingUtilities.convertMouseEvent(piece, e, this);
		}
		if (e.getSource() == this) {
			boolean containChessPoint = false;
			int x = 0, y = 0;
			int m = 0, n = 0;
			
			if (piece != null) {
				for (int i = 1; i <= x�᳤; i++) {
					for (int j = 1; j <= y�᳤; j++) {
						x = point[i][j].getX();
						y = point[i][j].getY();
						if (rect.contains(x, y)) {
							containChessPoint = true;
							m = i;
							n = j;
							break;
						}
					}
				}
			}
			
			if (piece != null && containChessPoint) {
				Color pieceColor = piece.��ȡ������ɫ();				
				if (point[m][n].isPiece()) {
					Color c = (point[m][n].getPiece()).��ȡ������ɫ();					
					if (pieceColor.getRGB() == c.getRGB()) {
						piece.setLocation(startX, startY);
						(point[startI][startJ]).set������(true);
					} else {
						boolean ok = rule.movePieceRule(piece, startI, startJ, m, n);						
						if (ok) {
							ChessPiece pieceRemoved = point[m][n].getPiece();
							point[m][n].reMovePiece(pieceRemoved, this);
							point[m][n].setPiece(piece, this);
							(point[startI][startJ]).set������(false);
							record.��¼����(piece, startI, startJ, m, n);
							record.��¼�Ե�������(pieceRemoved);
							rule.isWine(pieceRemoved);
							
							if (piece.�������().equals(�췽��ɫ)) {
								�췽���� = false;
								�ڷ����� = true;
							}
							if (piece.�������().equals(�ڷ���ɫ)) {
								�ڷ����� = false;
								�췽���� = true;
							}
							validate();
							repaint();
						} else {
							piece.setLocation(startX, startY);
							(point[startI][startJ]).set������(true);
						}
					}

				} 
				
				else {
					boolean ok = rule.movePieceRule(piece, startI, startJ, m, n);					
					if (ok) {						
						point[m][n].setPiece(piece, this);
						(point[startI][startJ]).set������(false);
						record.��¼����(piece, startI, startJ, m, n);
						record.��¼�Ե�������("û������");

						if (piece.�������().equals(�췽��ɫ)) {
							�췽���� = false;
							�ڷ����� = true;
						}
						if (piece.�������().equals(�ڷ���ɫ)) {
							�ڷ����� = false;
							�췽���� = true;
						}
					} else {
						piece.setLocation(startX, startY);
						(point[startI][startJ]).set������(true);
					}
				}
			}

			if (piece != null && !containChessPoint) {
				piece.setLocation(startX, startY);
				(point[startI][startJ]).set������(true);
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}