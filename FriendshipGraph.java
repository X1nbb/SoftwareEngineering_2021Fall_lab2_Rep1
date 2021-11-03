package P3;


//C4分支修改内容
//C4分支修改文件
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;


public class FriendshipGraph {
	/* ÁÚ½Ó¾ØÕó */
	private ArrayList<ArrayList> Graph = new ArrayList<>();
	/* ÀûÓÃHashSetÅÐ¶ÏÐÂÌí¼ÓµÄÈËÊÇ·ñÖØÃû */
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
		//Î´ÔÚÍ¼ÖÐ½ÚµãµÄ±êÊ¶·û
		int TRUE_NEW_PERSON = -1;

		//±ÜÃâÖØ¸´Ìí¼Ó
		if (newPerson.getId() == TRUE_NEW_PERSON) {

			/* ÖØÃûµÄ´¦Àí */
			if (this.nameSet.contains(newPerson.getName())) {
				System.out.println(newPerson.getName() + "ÖØÃû");
				System.exit(0);
			}

			//ÐÂ½¨booleanÐÍÊý×é£¬ÃèÊöÐÂ¼ÓÈëPersonµÄÁÚ½Ó¾ØÕó£¬Í¬Ê±¶ÔÔ­À´µÄÃ¿¸ö½ÚµãµÄÁÚ½Ó¾ØÕóÔö¼ÓÒ»ÁÐfalse
			ArrayList<Boolean> newList = new ArrayList<Boolean>();
			for (int i = 0; i < this.Graph.size(); i++) {
				newList.add(false);	//²»¼ÓÈë±ß£¬ÏÈ¸³Öµfalse
				Graph.get(i).add(false);	//Ô­À´Ã¿¸ö½ÚµãºÍÕâ¸ö½ÚµãÃ»ÓÐ±ß£¬Ò²ÊÇfalse
			}
			newList.add(true);	//×Ô¼ºµ½×Ô¼º¸³ÖµÎªtrue
			Graph.add(newList);	//ÔÚÕû¸öÁÚ½Ó±íÖÐ¼ÓÉÏ×îºóÒ»ÐÐ
			this.nameSet.add(newPerson.getName());	//Ãû×Ö¼¯ºÏÖÐÌí¼ÓÐÂ½ÚµãµÄÃû×Ö
			newPerson.setId(this.Graph.size() - 1);	//ÐÂ½ÚµãµÄID¸ÄÎª×ÜÈËÊý-1

		}
		else {	//ÖØ¸´Ìí¼ÓµÄ´¦Àí
			System.out.println( newPerson.getName() + "ÒÑ¾­Ìí¼Óµ½Í¼ÖÐÀ²£¡" );
		}
	}

	public void addEdge(Person person1, Person person2) {
		//Ìí¼Ó±ß£¬°ÑÁÚ½Ó¾ØÕóÖÐµÄfalse¸ÄÎªtrue¼´¿É
		Graph.get(person1.getId()).set(person2.getId(), true);
	}

	public int getDistance(Person person1, Person person2) {
		/* ¹ã¶ÈÓÅÏÈËÑË÷¼ÆËã×î¶ÌÂ·¾¶-ÁÚ½Ó¾ØÕóÊµÏÖ-½èÖú¶ÓÁÐ */

		Queue<Integer> queue = new LinkedList<>();	//Á´±íÊµÏÖµÄ¶ÓÁÐ
		boolean[] visited = new boolean[this.Graph.size()];	//±ê¼Ç·ÃÎÊ¹ýµÄ½ÚµãµÄÊý×é
		int[] distance = new int[this.Graph.size()];	//¼ÇÂ¼´Óperson1¿ªÊ¼µ½Ã¿¸ö¶¥µãµÄ³¤¶È

		/* ³õÊ¼»¯·ÃÎÊ½ÚµãÊý×éºÍÂ·¾¶³¤¶È */
		for (int i = 0; i < this.Graph.size(); i++) {
			visited[i] = false;
			distance[i] = -1;
		}

		distance[person1.getId()] = 0;		//×Ô¼ºµ½×Ô¼ºµÄÂ·¾¶ÊÇ0
		visited[person1.getId()] = true;	//´Ó0ºÅ½Úµã¿ªÊ¼ËÑË÷
		queue.offer(person1.getId());		//µÚÒ»¸öpersonµÄIDÈë¶Ó

		while (!queue.isEmpty()) {			//BFSËã·¨µÄÖ÷¹ý³Ì
			int nowPerson = queue.poll();	//¶ÓÍ·ÔªËØ³ö¶Ó
			for(int i = 0; i < this.Graph.size(); i++){

				if(this.Graph.get(nowPerson).get(i).equals(true)){
					if(!visited[i]){		//ÉÐÎ´·ÃÎÊµÄÁÚ½Ó½Úµã
						distance[i] = distance[nowPerson] + 1;	//Â·¾¶³¤¶È+1
						visited[i] = true;	//±ê¼ÇÎªÒÑ·ÃÎÊ
						queue.offer(i);		//Õâ¸ö¶¥µãÈë¶Ó
					}

				}


			}
		}
		return distance[person2.getId()];
	}
}
