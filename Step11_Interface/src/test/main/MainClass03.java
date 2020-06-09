package test.main;

import test.mypac.Drill;
import test.mypac.Multiplayer;
import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		//MultiPlayer 객체는 3가지 type 이 모두 될수 있기 떄문에
		Multiplayer mp = new Multiplayer();
		//아래의 3개 메소드를 호출하면서 인자로 전달 할 수 있다.
		useRemocon(mp);
		useDrill(mp);
		useMultiPlayer(mp);
		
	};
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	};
	
	public static void useDrill(Drill d) {
		d.hole();
	};
	
	public static void useMultiPlayer(Multiplayer mp) {
		mp.up();
		mp.down();
		mp.hole();
	};
};
