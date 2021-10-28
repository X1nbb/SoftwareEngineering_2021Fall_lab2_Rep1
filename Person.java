package P3;

public class Person {
	private String name;	//人名
	private int id = -1;	//用于在邻接矩阵中确定这个人的位置

	/* 默认构造 */
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
