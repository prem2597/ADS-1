import java.util.Arrays;

public class BinarySTA<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
	int[] leftLinks,rightLinks,size;
	private final int sizeLimit = 1000;
	int count;

	BinarySTA () {
        keys = (Key[]) new Comparable[sizeLimit];
        values = (Value[]) new Object[sizeLimit];
        leftLinks = new int[sizeLimit];
        rightLinks = new int[sizeLimit];

		size = new int[sizeLimit];
		count = 0;
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
	
	private void put(int index, Key key, Value value) {
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
		return;
	}

	public void display() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                System.out.println("(" + i + "-" + keys[i] + "," + values[i] + ")" + "-" + leftLinks[i] + "-" + rightLinks[i]);
            }
        }
	}
	
	public void resize() {
        keys = Arrays.copyOf(keys, 2 * keys.length);
        values = Arrays.copyOf(values, 2 * values.length);
        leftLinks = Arrays.copyOf(leftLinks, 2 * leftLinks.length);
        rightLinks = Arrays.copyOf(rightLinks, 2 * leftLinks.length);
        size = Arrays.copyOf(size, 2 * size.length);
	}

    public Value get(Key newKey) {
        if (newKey == null){
            throw new IllegalArgumentException("argument passed is null");
        }
        return get(1, newKey);
    }

    private Value get(int index, Key newKey) {
        if (keys[index] == null) {
            return null;
        }
        int cmp = newKey.compareTo(keys[index]);
        
        if (cmp < 0) {
            return get(2 * index, newKey);
        } else if (cmp > 0) {
            return get(1 + (2 * index),newKey);
        } else {
            return values[index];
        }
    }
}
