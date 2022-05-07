package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsMain {
	public static void main(String[] args) {
		// 전역변수는 new를 만나는 순간 초기화된다. 즉, new를 만나면 메모리에서 지워진다.
		// 하지만 static변수는 new를 만나도 지워지지 않고, 프로그램 종료시 메모리에서 해제된다.
		AmsField af = new AmsField();
		ImageIcon img = new ImageIcon("src/img/main.gif");
		// 절대 경로 : 내 위치가 어디든지 찾아갈 수 있는 경로
		// 상대 경로 : 내 위치에 따라서 변경되는 경로
		String [] arPlane = new String[5];
		String keyword = "";
		String [] menu = {"추가하기", "검색하기", "수정하기", "삭제하기", "목록보기"};
		String [] searchMenu = {"항공사", "항공기 번호", "최대 승객 수", "출발지", "도착지"};
		String [] updateMenu = {"출발지", "도착지"};
		
		int choice = 0;
		int index = 0;
		
		String insertMsg = "[추가하실 정보를 그대로 입력하세요(, 포함)]\n"
				+ "항공사, 항공기번호, 최대승객수, 출발지, 도착지";
		String searchMsg = "검색하실 항공사를 입력하세요\n";
		String deleteMsg = "삭제하실 항공기 번호를 입력하세요\n";
		String updateMsg = "수정하실 항공기 번호를 입력하세요\n";
		
		while(true) {
			choice = JOptionPane.showOptionDialog(null, "", "AMS", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, menu, null);
			
			if(choice == -1) break;
			
			switch(choice) {
			// 추가하기 영역
			case 0:
				arPlane = JOptionPane.showInputDialog(insertMsg).split(", "); //내가 입력한 문자열 값   //split(구분점으로 나눠줌)
				af.insert(arPlane);
				break;
			// 검색하기 영역
			case 1:
				index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.PLAIN_MESSAGE, img, searchMenu, null);
				if(index != -1) {
					keyword = JOptionPane.showInputDialog("검색하실 " + searchMenu[index] + "을(를) 입력하세요."); //검색keyword 입력받기
					JOptionPane.showMessageDialog(null, af.search(keyword, index));
				}
				break;
			// 수정하기 영역
			// 항공기 번호를 입력받고 해당 항공기의 출발지와 목적지를 수정
			// 항공기 번호가 존재할 때
			// JOptionPane.showOptionDialog() 사용하기
			// 출발지 수정   목적지 수정  -> 버튼으로 만들기
			// 출발지와 목적지가 동일하면 수정 실패
			case 2:
				String planeNum = JOptionPane.showInputDialog(updateMsg);
				String temp = af.search(planeNum, 1); // 항공기 번호를 찾음
				
				if(temp.equals("검색 결과 없음")) {
					JOptionPane.showMessageDialog(null, "수정 실패");
				}else {
					index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION, 
							JOptionPane.PLAIN_MESSAGE, img, updateMenu, null);
					String newValue = JOptionPane.showInputDialog("새로운 " + updateMenu[index] + "를 입력하세요.");
					af.update(index, newValue);
				}
				break;
			// 삭제하기 영역
			case 3:
				keyword = JOptionPane.showInputDialog(searchMsg); //검색keyword 입력받기
				if(af.delete(keyword)) {
					JOptionPane.showMessageDialog(null, "삭제 완료");
				}else {
					JOptionPane.showMessageDialog(null, "삭제 실패");
				}
				break;
			// 목록보기 영역
			case 4:
				JOptionPane.showMessageDialog(null, af.show());
				break;
			}
		}
		
	}
}
