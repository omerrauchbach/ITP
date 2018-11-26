import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BreadthFirstSearch  extends ASearch
{

	public List<ASearchNode> Open;
	public List<ASearchNode> Close;

	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		Open = new ArrayList<ASearchNode>();
		Close = new ArrayList<ASearchNode>();
	}

	private int getHashCode(ASearchNode node){
		return node.hashCode();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if(node == null)
			return null;
		if(isOpen(node)){
			for(ASearchNode noden: Open){
				if(noden.equals(node)&& noden.getG()!= node.getG() )
					return noden;
			}
		}
		return node;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		if(node== null)
			return false;
		for(ASearchNode noden: Open){
			if(noden.equals(node))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node)
	{
		if(node== null || Close== null)
			return false;

		for(ASearchNode noden: Close){
			if(noden.equals(node))
				return true;
		}
		return false;

	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		if(node== null || Open== null)
			return;
		/*
		int index = Open.indexOf(node);
		if(index != -1)
			Open.remove(index);
			*/
		Open.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node) {

		if (node == null || Open == null )
			return;
		Close.add(node);

		/*
		double G=node.getG();
		int index =0;
		for(ASearchNode noden: Open){
			if(noden.equals(node) && noden.getG()==G)
				break;
			index++;
		}

		Open.remove(index);
		*/



	}

	@Override
	public int openSize() 
	{
		if(Open==null)
			return 0;
		else{
			return Open.size();
		}


	}

	@Override
	public ASearchNode getBest() 
	{
		if(this.openSize()>0)
			return Open.remove(0);

		return null;
	}

	

}
