package ams;

public class AmsField {
	//항공사, 항공기번호, 최대승객수, 출발지, 도착지
	//2차원배열[0] = 1차원배열;
	
	String [][] arrPlane = new String[100][5]; //100개의 비행기
	int cnt; // 행의 길이
	int cLength = arrPlane[0].length; //열의 길이
	String result = "";
	int updateIndex;
	
	//추가하기
	void insert(String [] arPlane) { // 다섯칸 짜리 배열 하나 받음
		arrPlane[cnt] = arPlane;
		cnt++; // 배열에 넣고 나서 증가
	}
	
	//검색하기
	/*
	 * 검색한 항공사와 문자열이 일치하는 행의 index를 구해서 그 인덱스를 가진 행의 정보를 보여준다. 
	 */
	String search(String keyword, int index) {
		int arIndex[]; // 배열을 선언만 해줌(몇칸으로 선언해야 할 지 아직 모름(->검색결과가 몇 개나 있을 지 모르니깐))
		String result = "";
		int searchCnt = 0; //검색결과의 갯수
		for (int i = 0; i < cnt; i++) {
			if(keyword.equals(arrPlane[i][index])) { // 항공사 종류 검색
				searchCnt++;
				updateIndex = i; // 검색된 항공기 번호의 행번호를 받아옴
				result += "" + i + ","; // 검색한 keyword와 항공사가 일치하는 행의 번호를 result에 넣는다.  "," -> 구분하는 용도
			}
		}
		arIndex = new int[searchCnt]; //여기서 값을 담아줌
		
		for (int i = 0; i < arIndex.length; i++) { //검색결과만큼 반복을 돈다.
			arIndex[i] = Integer.parseInt(result.split(",")[i]); // result에 담긴 인덱스들을 ","로 구분해서 각각의 index번호를 arIndex 배열에 하나씩 넣어준다
			//result.split 전체를 배열로 볼 줄 알아야 함(result에 0,2,3, 이런식으로 들어가 있기 때문)
		}
		return show(arIndex);
	}
	
	//수정하기
	void update(int btnIndex, String newValue) { // 항공기번호, 버튼종류, 수정된 값
		arrPlane[updateIndex][btnIndex+3] = newValue;
		//btnIndex
		//출발지 : 0
		//도착지 : 1
		//열 index 번호 (arPlane)
		//출발지 : 3
		//도착지 : 4
	}
	
	//삭제하기
	boolean delete(String keyword) { // keyword는 항공기번호(행번호) 입력받음
		boolean deleteCheck = false; // 삭제가 됐는지 안됐는지 확인
		
		for (int i = 0; i < cnt; i++) {
			if(arrPlane[i][1].equals(keyword)) {
				//cnt - 1 : 마지막 정보가 담긴 행
				//cnt : null이 담긴 행
				for(int j = i; j < cnt; j++) {
					arrPlane[j] = arrPlane[j+1];
	// 마지막 반복 때 -> cnt-1   =           cnt
				}
				deleteCheck = true;
				cnt--; // 행 하나 삭제
				break;
			}
		}
		return deleteCheck;
	}
	
	//목록보기
	String show() {
		String result = "항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n"; // 매번 초기화
		
		for(int i = 0; i < cnt; i++) {
			result += "▶";
			for(int j = 0; j < cLength; j++) {
				result += (j == cLength-1 ? arrPlane[i][j] : arrPlane[i][j] + ",  ");
			}
			result += "\n";
		}
		if(cnt == 0) result = "목록 없음";
		return result;
	}
	
	// 검색결과 보기
	String show(int[] arIndex) { //오버로딩
		String result = "항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n"; //여기서 result는 지역변수
		
		for(int i = 0; i < arIndex.length; i++) { // 검색결과 만큼 반복 돌기
			result += "▶";
			for(int j = 0; j < cLength; j++) { // cLength == 5
				result += arrPlane[arIndex[i]][j]; // arIndex에는 행번호가 들어가 있음
				result += (j == cLength-1 ? "" : ",  "); // 마지막값이면 쉼표 안붙임
			}
			result += "\n";
		}
		if(arIndex.length == 0) result = "검색 결과 없음";
		return result;
	}
}
