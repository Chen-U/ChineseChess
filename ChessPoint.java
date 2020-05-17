package ChineseChess;


/**
 * Title:棋点类
 * 
 * Description:用于棋盘上棋子的定位。
 */

public class ChessPoint {
	int x, y;
	boolean 有棋子;
	ChessPiece piece = null;
	ChessBoard board = null;

	/**构造方法**/
	public ChessPoint(int x, int y, boolean boo) {
		this.x = x;
		this.y = y;
		有棋子 = boo;
	}

	/**获取有无棋子**/
	public boolean isPiece() {
		return 有棋子;
	}

	/**设置有无棋子**/
	public void set有棋子(boolean boo) {
		有棋子 = boo;
	}

	/**获取横坐标**/
	public int getX() {
		return x;
	}

	/**获取纵坐标**/
	public int getY() {
		return y;
	}

	/**在特定点放置特定棋子**/
	public void setPiece(ChessPiece piece, ChessBoard board) {
		this.board = board;
		this.piece = piece;
		board.add(piece);
		int w = (board.unitWidth);
		int h = (board.unitHeight);
		piece.setBounds(x - w / 2, y - h / 2, w, h);// 棋子位置，宽度，高度
		有棋子 = true;
		board.validate();
	}

	/**获取棋子对象**/
	public ChessPiece getPiece() {
		return piece;
	}

	/**移除棋子**/
	public void reMovePiece(ChessPiece piece, ChessBoard board) {
		this.board = board;
		this.piece = piece;
		board.remove(piece);
		board.validate();
		有棋子 = false;
	}
}
