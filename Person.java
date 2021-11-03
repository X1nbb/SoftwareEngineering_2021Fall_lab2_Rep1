package P3;

//C4分支修改


public class Person {
	private String name;	//ÈËÃû
	private int id = -1;	//ÓÃÓÚÔÚÁÚ½Ó¾ØÕóÖÐÈ·¶¨Õâ¸öÈËµÄÎ»ÖÃ

	/* Ä¬ÈÏ¹¹Ôì */
	public Person(String name) {
		this.name = name;
	}

	//setters and getters
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
}
