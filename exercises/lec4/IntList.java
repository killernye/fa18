public class IntList {

	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** If 2 numbers in a row are the same, we add them together
	*	and make one large node. For example:
	*	1 => 1 => 2 => 3 which becomes 2 => 2 => 3 becomes 4 => 3
	*	1. Thinking
	*	Could do it recursively?
	*	Base case: Only one item, just return
	*	Recursive case: 
	*	if first one equals to second item, then add them together 
	*	and continue to do addAdjacent() again 
	*	if first and the second item aren't same, just do 
	*	rest.addAdjacent
	*/  
	public void addAdjacent() {
		if (this == null || rest == null) {
			return;
		} else if (first == rest.first) {
			first *= 2;
			rest = rest.rest;
			addAdjacent();
		} else {
			rest.addAdjacent();
		}
	}

	@Override
	public String toString() {
		String returnValue = "[";
		IntList p = this;
		Boolean isEmpty = true;
		while (p != null) {
			if (isEmpty) {
				returnValue += p.first;
				p = p.rest;
				isEmpty = false;
			}
			returnValue = returnValue + " , " + p.first;
			p = p.rest;
		}
		returnValue += "]";
		return returnValue;
	}
}