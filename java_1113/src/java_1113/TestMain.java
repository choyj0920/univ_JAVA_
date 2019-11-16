package java_1113;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMain {

	public static void lab_praSet() {
		Set<word_> set=new HashSet<>();
		set.add(new word_("Apple1","���1"));
		set.add(new word_("Apple1","���1"));
		set.add(new word_("Apple2","���2"));
		set.add(new word_("Apple3","���3"));
		set.add(new word_("Apple4","���4"));
		set.add(new word_("Apple1","���5"));
		
		Iterator<word_> it =set.iterator();
		
		while(it.hasNext()) {
			word_ word= it.next();
			System.out.println(word);
		}
	}
	public static void pra_Map() {
		Map<String,Integer> map=new HashMap<>();
		map.put("ȫ�浿1", 10);
		map.put("ȫ�浿2", 20);
		map.put("ȫ�浿3", 30);
		map.put("ȫ�浿4", 40);
		map.put("ȫ�浿5", 50);
		map.put("ȫ�浿6", 60);
		
		//Ű ��ü�� �����ͼ� ���
		Set<String> set =map.keySet();
		Iterator<String> setit=set.iterator();
		while(setit.hasNext()) {
			String key= setit.next();
			int value=map.get(key);
			System.out.println(key+" : "+value);
		}
		//��Ʈ�� ��ü�� �����ͼ� ����ϱ�
		Set<Map.Entry<String, Integer>>set2 =map.entrySet();
		Iterator<Map.Entry<String, Integer>> it2 =set2.iterator();
		
		while(it2.hasNext()) {
			Map.Entry<String, Integer> entry= it2.next();
			String key =entry.getKey();
			int value =entry.getValue();
			System.out.println(key+" : "+value);
		}
		
		//���� �����ͼ� ����ϱ�
		Collection<Integer> values =map.values();
		for(int v: values) {
			System.out.println(v);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pra_Map();
	}

}
class word_ {
	String eng;
	String kor;
	word_(String eng,String kor){
		this.eng=eng;
		this.kor=kor;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return eng+" : "+kor;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return eng.hashCode()+kor.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof word_) {
			word_ word= (word_)obj;
			if(word.eng.equals(eng) && word.kor.equals(kor)) {
				return true;
			}
			
		}
		return false;
	}
}