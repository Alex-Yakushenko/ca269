interface MyList<E> {
    void add(E e);
    void add(E e, int pos);
    E remove();
    E remove(int pos);
    void clear();
    int size();
    int contains(E e);
}

class MyArrayList<E> implements MyList<E> {
    private E[] array = (E[])new Object[100]; // DANGEROUS!
    private int size = 0;

    public void add(E e) {
        this.array[size] = e;
        size += 1;
    }

    public String toString() {
        String output = "[";
        for(int i=0; i<size; i++) {
            output += array[i] + ",";
        }
        return output + "]";
    }

    // TODO: add
    public void add(E e, int pos) {
        this.array[pos] = e;
        size += 1;
    }
    // TODO: remove from end
    public E remove() {
        E element = array[size - 1];
        array[size - 1] = null;
        size -= 1;
        return element;
    }
    // TODO: remove at position
    public E remove(int pos) {
        E element = array[pos];
        for (int i = pos; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size -= 1;
        return element;
    }
    // TODO: clear
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    // TODO: size
    public int size() {
        return size;
    }
    // TODO: contains
    public int contains(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }
}
