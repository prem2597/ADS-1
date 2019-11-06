class Queue {
	/**
	 * intialize the array.
	 */
	private static int[] arr;
	/**
	 * intialize its size.
	 */
	private static int size;
	
	Queue(final int range) {
		arr = new int[range];
		size = range;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}
	public int[] getArr() {
		return arr;
	}
	public int getSize() {
		return size;
	}
	public void enqueue(final int item) {
		arr[size++] = item;
	}
	public int dequeue() {
		if (!isempty()) {
			int remove = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[--size] = 0;
			return remove;
		}
		return 0;
	}
	public boolean isempty() {
		return size == 0;
	}

}