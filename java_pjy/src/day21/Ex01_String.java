package day21;

public class Ex01_String {

	public static void main(String[] args) {
		//주어진 문자열에서 검색어가 몇 번 들어가있는지 확인하는 코드를 작성하세요.
		
		String str = "abcadfadfabaafdafbadfadccxabadfadcab"; //4
		String search = "ab";
		int index = -1, count = 0;
		
		String tmp = str;
		
		do {
			index = tmp.indexOf(search);
			
			if(index != -1) {
				count++;
				int pos = index + search.length();
				if(pos >= tmp.length()) {
					index = -1;
					continue;
				}
				tmp = tmp.substring(pos);
			}
			
		} while(index != -1);
		
		System.out.println(str + "에서 " + search + "의 갯수 : " + count);
		
		/* tmp에 str을 저장
		 * 
		 * 반복 : index가 -1이 되면 종료
		 * tmp에서 search가 몇번지에 있는지 확인 : index
		 * index가 0이상이면 index + 1 번지 부터 부분 문자열을 추출해서 tmp에 저장
		 * count를 1증가
		 */
	}

}
