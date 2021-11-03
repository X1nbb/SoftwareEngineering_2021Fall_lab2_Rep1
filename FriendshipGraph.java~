package P3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;


public class FriendshipGraph {
	/* 邻接矩阵 */
	private ArrayList<ArrayList> Graph = new ArrayList<>();
	/* 利用HashSet判断新添加的人是否重名 */
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
		//未在图中节点的标识符
		int TRUE_NEW_PERSON = -1;

		//避免重复添加
		if (newPerson.getId() == TRUE_NEW_PERSON) {

			/* 重名的处理 */
			if (this.nameSet.contains(newPerson.getName())) {
				System.out.println(newPerson.getName() + "重名");
				System.exit(0);
			}

			//新建boolean型数组，描述新加入Person的邻接矩阵，同时对原来的每个节点的邻接矩阵增加一列false
			ArrayList<Boolean> newList = new ArrayList<Boolean>();
			for (int i = 0; i < this.Graph.size(); i++) {
				newList.add(false);	//不加入边，先赋值false
				Graph.get(i).add(false);	//原来每个节点和这个节点没有边，也是false
			}
			newList.add(true);	//自己到自己赋值为true
			Graph.add(newList);	//在整个邻接表中加上最后一行
			this.nameSet.add(newPerson.getName());	//名字集合中添加新节点的名字
			newPerson.setId(this.Graph.size() - 1);	//新节点的ID改为总人数-1

		}
		else {	//重复添加的处理
			System.out.println( newPerson.getName() + "已经添加到图中啦！" );
		}
	}

	public void addEdge(Person person1, Person person2) {
		//添加边，把邻接矩阵中的false改为true即可
		Graph.get(person1.getId()).set(person2.getId(), true);
	}

	public int getDistance(Person person1, Person person2) {
		/* 广度优先搜索计算最短路径-邻接矩阵实现-借助队列 */

		Queue<Integer> queue = new LinkedList<>();	//链表实现的队列
		boolean[] visited = new boolean[this.Graph.size()];	//标记访问过的节点的数组
		int[] distance = new int[this.Graph.size()];	//记录从person1开始到每个顶点的长度

		/* 初始化访问节点数组和路径长度 */
		for (int i = 0; i < this.Graph.size(); i++) {
			visited[i] = false;
			distance[i] = -1;
		}

		distance[person1.getId()] = 0;		//自己到自己的路径是0
		visited[person1.getId()] = true;	//从0号节点开始搜索
		queue.offer(person1.getId());		//第一个person的ID入队

		while (!queue.isEmpty()) {			//BFS算法的主过程
			int nowPerson = queue.poll();	//队头元素出队
			for(int i = 0; i < this.Graph.size(); i++){

				if(this.Graph.get(nowPerson).get(i).equals(true)){
					if(!visited[i]){		//尚未访问的邻接节点
						distance[i] = distance[nowPerson] + 1;	//路径长度+1
						visited[i] = true;	//标记为已访问
						queue.offer(i);		//这个顶点入队
					}

				}


			}
		}
		return distance[person2.getId()];
	}
}
