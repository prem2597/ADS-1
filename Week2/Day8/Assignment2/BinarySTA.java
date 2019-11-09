public class BinarySTA<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
    int[] leftlinks,rightlinks,size;

    BinarySTA (final int sizeLimit) {
        keys = new Key[sizeLimit];
        values = new Value[sizeLimit];
        leftlinks = new int[sizeLimit];
        rightlinks = new int[sizeLimit];

        sizes = new int[sizeLimit];
    }

    public void put(Key key, Value value) {
		if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
		if (size() == keys.length) {
			System.out.println("Size Limit Reached.");
			return;
		}
		put(0, key, value);
	}

    private int put(int index, Key key, Value value) {
		if (index == -1 || keys[index] == null) {
			int nextElementIndex = size();
			keys[nextElementIndex] = key;
			values[nextElementIndex] = value;
			size[nextElementIndex] = 1;
			return nextElementIndex;
		}    

		int compare = key.compareTo(keys[index]);

		if (compare < 0) {
			leftLinks[index] = put(leftLinks[index], key, value);
		} else if (compare > 0) {
			rightLinks[index] = put(rightLinks[index], key, value);
		} else {
			values[index] = value;
		}

		size[index] = size(leftLinks[index]) + 1 + size(rightLinks[index]);
		return index;
    }
    
    

}