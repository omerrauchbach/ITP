import java.util.*;

public class PureHeuristicSearch  extends ASearch
{
	// Define lists here ...
	private List<ASearchNode> Open;
	private List<ASearchNode> Close;
	
	@Override
	public String getSolverName() 
	{
		return "PHS";
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
		Open.sort(Comparator.comparing(ASearchNode::getH));
	}


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