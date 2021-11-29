import java.util.List;

public class TestGeneriekeList {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main (String[] args){	
		GeneriekeList l = new GeneriekeList();
		l.voegToe("aa"); l.voegToe("b");
		List <String> l1 = l.getAll();
		System.out.println(l1);
		
		l = new GeneriekeList();
		l.voegToe(12); l.voegToe(14);
		List <Integer> l2 = l.getAll();
		System.out.println(l2);			
	}
}
