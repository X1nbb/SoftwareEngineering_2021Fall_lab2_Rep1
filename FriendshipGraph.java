package P3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;


public class FriendshipGraph {
	/* �ڽӾ��� */
	private ArrayList<ArrayList> Graph = new ArrayList<>();
	/* ����HashSet�ж������ӵ����Ƿ����� */
	private HashSet nameSet = new HashSet();

	public static void main(String[] argv) {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		System.out.println(graph.getDistance(rachel, ross));
		System.out.println(graph.getDistance(rachel, ben));
		System.out.println(graph.getDistance(rachel, rachel));
		System.out.println(graph.getDistance(rachel, kramer));
	}

	public void addVertex(Person newPerson) {
		//δ��ͼ�нڵ�ı�ʶ��
		int TRUE_NEW_PERSON = -1;

		//�����ظ�����
		if (newPerson.getId() == TRUE_NEW_PERSON) {

			/* �����Ĵ��� */
			if (this.nameSet.contains(newPerson.getName())) {
				System.out.println(newPerson.getName() + "����");
				System.exit(0);
			}

			//�½�boolean�����飬�����¼���Person���ڽӾ���ͬʱ��ԭ����ÿ���ڵ���ڽӾ�������һ��false
			ArrayList<Boolean> newList = new ArrayList<Boolean>();
			for (int i = 0; i < this.Graph.size(); i++) {
				newList.add(false);	//������ߣ��ȸ�ֵfalse
				Graph.get(i).add(false);	//ԭ��ÿ���ڵ������ڵ�û�бߣ�Ҳ��false
			}
			newList.add(true);	//�Լ����Լ���ֵΪtrue
			Graph.add(newList);	//�������ڽӱ��м������һ��
			this.nameSet.add(newPerson.getName());	//���ּ����������½ڵ������
			newPerson.setId(this.Graph.size() - 1);	//�½ڵ��ID��Ϊ������-1

		}
		else {	//�ظ����ӵĴ���
			System.out.println( newPerson.getName() + "�Ѿ����ӵ�ͼ������" );
		}
	}

	public void addEdge(Person person1, Person person2) {
		//���ӱߣ����ڽӾ����е�false��Ϊtrue����
		Graph.get(person1.getId()).set(person2.getId(), true);
	}

	public int getDistance(Person person1, Person person2) {
		/* ������������������·��-�ڽӾ���ʵ��-�������� */

		Queue<Integer> queue = new LinkedList<>();	//����ʵ�ֵĶ���
		boolean[] visited = new boolean[this.Graph.size()];	//��Ƿ��ʹ��Ľڵ������
		int[] distance = new int[this.Graph.size()];	//��¼��person1��ʼ��ÿ������ĳ���

		/* ��ʼ�����ʽڵ������·������ */
		for (int i = 0; i < this.Graph.size(); i++) {
			visited[i] = false;
			distance[i] = -1;
		}

		distance[person1.getId()] = 0;		//�Լ����Լ���·����0
		visited[person1.getId()] = true;	//��0�Žڵ㿪ʼ����
		queue.offer(person1.getId());		//��һ��person��ID���

		while (!queue.isEmpty()) {			//BFS�㷨��������
			int nowPerson = queue.poll();	//��ͷԪ�س���
			for(int i = 0; i < this.Graph.size(); i++){

				if(this.Graph.get(nowPerson).get(i).equals(true)){
					if(!visited[i]){		//��δ���ʵ��ڽӽڵ�
						distance[i] = distance[nowPerson] + 1;	//·������+1
						visited[i] = true;	//���Ϊ�ѷ���
						queue.offer(i);		//����������
					}

				}


			}
		}
		return distance[person2.getId()];
	}
}