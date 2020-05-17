package ChineseChess;


/**
 * Title:�����
 * 
 * Description:�������������ӵĶ�λ��
 */

public class ChessPoint {
	int x, y;
	boolean ������;
	ChessPiece piece = null;
	ChessBoard board = null;

	/**���췽��**/
	public ChessPoint(int x, int y, boolean boo) {
		this.x = x;
		this.y = y;
		������ = boo;
	}

	/**��ȡ��������**/
	public boolean isPiece() {
		return ������;
	}

	/**������������**/
	public void set������(boolean boo) {
		������ = boo;
	}

	/**��ȡ������**/
	public int getX() {
		return x;
	}

	/**��ȡ������**/
	public int getY() {
		return y;
	}

	/**���ض�������ض�����**/
	public void setPiece(ChessPiece piece, ChessBoard board) {
		this.board = board;
		this.piece = piece;
		board.add(piece);
		int w = (board.unitWidth);
		int h = (board.unitHeight);
		piece.setBounds(x - w / 2, y - h / 2, w, h);// ����λ�ã���ȣ��߶�
		������ = true;
		board.validate();
	}

	/**��ȡ���Ӷ���**/
	public ChessPiece getPiece() {
		return piece;
	}

	/**�Ƴ�����**/
	public void reMovePiece(ChessPiece piece, ChessBoard board) {
		this.board = board;
		this.piece = piece;
		board.remove(piece);
		board.validate();
		������ = false;
	}
}
