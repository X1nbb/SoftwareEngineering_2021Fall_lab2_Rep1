package P3;

public class Person {
	private String name;	//����
	private int id = -1;	//�������ڽӾ�����ȷ������˵�λ��

	/* Ĭ�Ϲ��� */
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
