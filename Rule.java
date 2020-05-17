package ChineseChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title:�ƶ�������
 * 
 * Disruption:���治ͬ�������ӵ��ƶ�����
 */

public class Rule {
	ChessBoard board = null;
	ChessPiece piece = null;
	ChessPoint point[][];
	int startI, startJ, endI, endJ;

	/**���췽��**/
	public Rule(ChessBoard board, ChessPoint point[][]) {
		this.board = board;
		this.point = point;
	}

	/**��ʤ��ʾ**/
	public void isWine(ChessPiece piece) {
		this.piece = piece;
		
		if (piece.getName() == "��" || piece.getName() == "˧") {
			if (piece.��ɫ��� == "�췽") {
				JOptionPane.showMessageDialog(null, "�ڷ� ʤ����");
			} else {
				JOptionPane.showMessageDialog(null, "�췽 ʤ����");
			}
		}
	}

	/**�����ƶ�����**/
	public boolean movePieceRule(ChessPiece piece, int startI, int startJ, int endI, int endJ) {
		this.piece = piece;
		this.startI = startI;
		this.startJ = startJ;
		this.endI = endI;
		this.endJ = endJ;
		int minI = Math.min(startI, endI);
		int maxI = Math.max(startI, endI);
		int minJ = Math.min(startJ, endJ);
		int maxJ = Math.max(startJ, endJ);
		boolean �ɷ����� = false;
		
		// �����ƶ�����
		if (piece.getName().equals("��")) {
			if (startI == endI) {
				int j = 0;
				for (j = minJ + 1; j <= maxJ - 1; j++) {
					if (point[startI][j].isPiece()) {
						�ɷ����� = false;
						break;
					}
				}
				if (j == maxJ) {
					�ɷ����� = true;
				}
			} else if (startJ == endJ) {
				int i = 0;
				for (i = minI + 1; i <= maxI - 1; i++) {
					if (point[i][startJ].isPiece()) {
						�ɷ����� = false;
						break;
					}
				}
				if (i == maxI) {
					�ɷ����� = true;
				}
			} else {
				�ɷ����� = false;
			}

		// ܇���ƶ�����	
		} else if (piece.getName().equals("܇")) {
			if (startI == endI) {
				int j = 0;
				for (j = minJ + 1; j <= maxJ - 1; j++) {
					if (point[startI][j].isPiece()) {
						�ɷ����� = false;
						break;
					}
				}
				if (j == maxJ) {
					�ɷ����� = true;
				}
			} else if (startJ == endJ) {
				int i = 0;
				for (i = minI + 1; i <= maxI - 1; i++) {
					if (point[i][startJ].isPiece()) {
						�ɷ����� = false;
						break;
					}
				}
				if (i == maxI) {
					�ɷ����� = true;
				}
			} else {
				�ɷ����� = false;
			}

		// ����ƶ�����
		} else if (piece.getName().equals("��")) {
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);

			if (xAxle == 2 && yAxle == 1) {
				if (endI > startI) {
					if (point[startI + 1][startJ].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}
				if (endI < startI) {
					if (point[startI - 1][startJ].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}

			} else if (xAxle == 1 && yAxle == 2) {
				if (endJ > startJ) {
					if (point[startI][startJ + 1].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}
				if (endJ < startJ) {
					if (point[startI][startJ - 1].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}

			} else {
				�ɷ����� = false;
			}
		
		// �R���ƶ�����
		} else if (piece.getName().equals("�R")) {
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);

			if (xAxle == 2 && yAxle == 1) {
				if (endI > startI) {
					if (point[startI + 1][startJ].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}
				if (endI < startI) {
					if (point[startI - 1][startJ].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}
			} else if (xAxle == 1 && yAxle == 2) {
				if (endJ > startJ) {
					if (point[startI][startJ + 1].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}
				if (endJ < startJ) {
					if (point[startI][startJ - 1].isPiece()) {
						�ɷ����� = false;
					} else {
						�ɷ����� = true;
					}
				}

			} else {
				�ɷ����� = false;
			}
		
		// ����ƶ�����
		} else if (piece.getName().equals("��")) {
			int centerI = (startI + endI) / 2;
			int centerJ = (startJ + endJ) / 2;
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);
			if (xAxle == 2 && yAxle == 2 && endJ <= 5) {
				if (point[centerI][centerJ].isPiece()) {
					�ɷ����� = false;
				} else {
					�ɷ����� = true;
				}
			} else {
				�ɷ����� = false;
			}
			
		// ����ƶ�����
		} else if (piece.getName().equals("��")) {
			int centerI = (startI + endI) / 2;
			int centerJ = (startJ + endJ) / 2;
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);
			if (xAxle == 2 && yAxle == 2 && endJ >= 6) {
				if (point[centerI][centerJ].isPiece()) {
					�ɷ����� = false;
				} else {
					�ɷ����� = true;
				}
			} else {
				�ɷ����� = false;
			}
		
		// �ڵ��ƶ�����
		} else if (piece.getName().equals("��")) {
			int number = 0;
			if (startI == endI) {
				int j = 0;
				for (j = minJ + 1; j <= maxJ - 1; j++) {
					if (point[startI][j].isPiece()) {
						number++;
					}
				}
				if (number > 1) {
					�ɷ����� = false;
				} else if (number == 1) {
					if (point[endI][endJ].isPiece()) {
						�ɷ����� = true;
					}
				} else if (number == 0 && !point[endI][endJ].isPiece()) {
					�ɷ����� = true;
				}
			} else if (startJ == endJ) {
				int i = 0;
				for (i = minI + 1; i <= maxI - 1; i++) {
					if (point[i][startJ].isPiece()) {
						number++;
					}
				}
				if (number > 1) {
					�ɷ����� = false;
				} else if (number == 1) {
					if (point[endI][endJ].isPiece()) {
						�ɷ����� = true;
					}
				} else if (number == 0 && !point[endI][endJ].isPiece()) {
					�ɷ����� = true;
				}
			} else {
				�ɷ����� = false;
			}
		
		// �����ƶ�����
		} else if (piece.getName().equals("��")) {
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);

			if (endJ >= 6) {
				if (startJ - endJ == 1 && xAxle == 0) {
					�ɷ����� = true;
				}

				else {
					�ɷ����� = false;
				}
			} else if (endJ <= 5) {
				if ((startJ - endJ == 1) && (xAxle == 0)) {
					�ɷ����� = true;
				} else if ((endJ - startJ == 0) && (xAxle == 1)) {
					�ɷ����� = true;
				} else {
					�ɷ����� = false;
				}
			}
		
		// ����ƶ�����
		} else if (piece.getName().equals("��")) {
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);

			if (endJ <= 5) {
				if (endJ - startJ == 1 && xAxle == 0) {
					�ɷ����� = true;
				} else {
					�ɷ����� = false;
				}
			} else if (endJ >= 6) {
				if ((endJ - startJ == 1) && (xAxle == 0)) {
					�ɷ����� = true;
				} else if ((endJ - startJ == 0) && (xAxle == 1)) {
					�ɷ����� = true;
				} else {
					�ɷ����� = false;
				}
			}
		
		// ʿ���ƶ�����
		} else if (piece.getName().equals("ʿ")) {
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);
			if (endI <= 6 && endI >= 4 && xAxle == 1 && yAxle == 1) {
				�ɷ����� = true;
			} else {
				�ɷ����� = false;
			}
			
		// �˵��ƶ�����
		} else if (piece.getName().equals("��")) {
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);
			if (endI <= 6 && endI >= 4 && xAxle == 1 && yAxle == 1) {
				�ɷ����� = true;
			} else {
				�ɷ����� = false;
			}
			
		// ˧�ͽ����ƶ�����
		} else if ((piece.getName().equals("˧")) || (piece.getName().equals("��"))) {
			int xAxle = Math.abs(startI - endI);
			int yAxle = Math.abs(startJ - endJ);
			if (endI <= 6 && endI >= 4) {
				if ((xAxle == 1 && yAxle == 0) || (xAxle == 0 && yAxle == 1)) {
					�ɷ����� = true;
				} else {
					�ɷ����� = false;
				}
			} else {
				�ɷ����� = false;
			}
		}

		return �ɷ�����;

	}
}
