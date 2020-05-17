package ChineseChess;

import java.awt.Point;

/**
 * Title:走步类
 * 
 * Disruption:记录棋子的起子坐标点和落子坐标点。
 */

public class MoveStep implements java.io.Serializable {
	public Point pStart, pEnd;

	/**构造方法**/
	public MoveStep(Point p1, Point p2) {
		pStart = p1;
		pEnd = p2;
	}
}
