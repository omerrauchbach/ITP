import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AStarSearch   extends ASearch
{
	// Define lists here ...
	private List<ASearchNode> Open;
	private List<ASearchNode> Close;
	
	@Override
	public String getSolverName() 
	{
		return "AStar";
	}
	
	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists() 
	{
		Open = new ArrayList<>();
		Close = new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		if(node== null || Open == null)
			return null;
		for(Iterator<ASearchNode> res = Open.iterator(); res.hasNext() ;){
			ASearchNode tmpNode = res.next() ;
			if(tmpNode.equals(node))
				return tmpNode;
		}
		return node;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		if (node == null || Open == null)
			return false;
		return Open.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		if(node == null)
			return false;
		return Close.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		if(node== null)
			return;
		Open.add(node);
		Open.sort(nodeSort);
	}

	private Comparator<ASearchNode> nodeSort = new Comparator<ASearchNode>() {

		public int compare(ASearchNode s1, ASearchNode s2) {

			double f1 = s1.getG()+s1.getH();
			double f2 = s2.getG()+s2.getH();

			int res = (int)(f1-f2);
			return res;


		}};

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		if(node!= null)
			Close.add(node);
	}

	@Override
	public int openSize() 
	{
		if(Open==null)
			return 0;
		else
			return Open.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		ASearchNode res = Open.get(0);
		Open.remove(0);
		return res;
	}

}
