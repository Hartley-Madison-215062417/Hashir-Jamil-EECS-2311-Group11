package tab2mxl;


public class Main {

	public static void main(String[] args ) {

		System.out.println("Restart Repo");
		
		AttributesJAXB obj = new AttributesJAXB();
		obj.marshall();

		//Parser p = new Parser();
		//System.out.println(p.tabToPrimitiveArray("e|-------5-7-----7-|"));
		//System.out.println(p.tabToPrimitiveArray("|-----5-----5-----|---5-------3-----|---1---1-----1---|-0-1-1-----------|"));
		//System.out.println(p.tabToPrimitiveArray("|---5---------5---|-----5-------2---|-----2---------2-|-0-2-2---2-------|"));
		//System.out.println(p.tabToPrimitiveArray("|-7-------6-------|-5-------4-------|-3---------------|-----------------|"));
		//System.out.println(p.tabToPrimitiveArray("|-----------------|-----------------|-----------------|-2-0-0---0--/8-7-|"));
		//System.out.println(p.tabToPrimitiveArray("|-----------------|-----------------|-----------------|-----------------|"));

	}

	/*
	 * Stairway To Heaven tab by Led Zeppelin 
	 * 
	 * 	e|-------5-7-----7-|-8-----8-2-----2-|-0---------0-----|-----------------|
		B|-----5-----5-----|---5-------3-----|---1---1-----1---|-0-1-1-----------|
		G|---5---------5---|-----5-------2---|-----2---------2-|-0-2-2---2-------|
		D|-7-------6-------|-5-------4-------|-3---------------|-----------------|
		A|-----------------|-----------------|-----------------|-2-0-0---0--/8-7-|
		E|-----------------|-----------------|-----------------|-----------------|
	 * 
	 * 
	 */

}
