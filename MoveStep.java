package ChineseChess;

import java.awt.Point;

/**
 * Title:�߲���
 * 
 * Disruption:��¼���ӵ�������������������㡣
 */

public class MoveStep implements java.io.Serializable {
	public Point pStart, pEnd;

	/**���췽��**/
	public MoveStep(Point p1, Point p2) {
		pStart = p1;
		pEnd = p2;
	}
}
