package org.example.data_structures;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OpenAddressingSet<T> extends AbstractSet<T> {

    private final int bits;

    private final int capacity;

    private final Object[] storage;
    private final Object DELETED = new Object(); //метка удаленного элемента
    private int size = 0;

    public OpenAddressingSet(int bits) {
        if (bits < 2 || bits > 31) {
            throw new IllegalArgumentException();
        }
        this.bits = bits;
        capacity = 1 << bits;
        storage = new Object[capacity];
    }

    private int startingIndex(Object element) {
        return element.hashCode() & (0x7FFFFFFF >> (31 - bits));
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Проверка, входит ли данный элемент в таблицу
     */
    @Override
    public boolean contains(Object o) {
        int index = startingIndex(o);
        Object current = storage[index];
        while (current != null) {
            if (current.equals(o)) {
                return true;
            }
            index = (index + 1) % capacity;
            current = storage[index];
        }
        return false;
    }

    /**
     * Добавление элемента в таблицу.
     * <p>
     * Не делает ничего и возвращает false, если такой же элемент уже есть в таблице.
     * В противном случае вставляет элемент в таблицу и возвращает true.
     * <p>
     * Бросает исключение (IllegalStateException) в случае переполнения таблицы.
     * Обычно Set не предполагает ограничения на размер и подобных контрактов,
     * но в данном случае это было введено для упрощения кода.
     */
    @Override
    public boolean add(T t) {
        int startingIndex = startingIndex(t);
        int index = startingIndex;
        Object current = storage[index];
        while (current != null && current != DELETED) { //добавляем проверку условия удаленности элемента
            if (current.equals(t)) {
                return false;
            }
            index = (index + 1) % capacity;
            if (index == startingIndex) {
                throw new IllegalStateException("Table is full");
            }
            current = storage[index];
        }
        storage[index] = t;
        size++;
        return true;
    }

    /**
     * Удаление элемента из таблицы
     * <p>
     * Если элемент есть в таблица, функция удаляет его из дерева и возвращает true.
     * В ином случае функция оставляет множество нетронутым и возвращает false.
     * Высота дерева не должна увеличиться в результате удаления.
     */
    //временные затраты: O(N)
    //затраты памяти: O(1)
    @Override
    public boolean remove(Object o) {
        int startingIndex = startingIndex(o);
        int index = startingIndex;
        Object current = storage[index];
        while (!current.equals(o)) {
            index = (index + 1) % capacity;
            current = storage[index];
            if (current == null || index == startingIndex) return false;
        }
        size--;
        storage[index] = DELETED;
        return true;
    }

    /**
     * Создание итератора для обхода таблицы
     * <p>
     * Не забываем, что итератор должен поддерживать функции next(), hasNext(),
     * и опционально функцию remove()
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new OpenAddressingSetIterator();
    }

    public class OpenAddressingSetIterator implements Iterator<T> {
        private final int initialSize;
        private int passed;
        private int currentIndex;
        private Object currentObject;

        public OpenAddressingSetIterator() {
            initialSize = size();
            passed = 0;
            currentIndex = -1;
        }

        //временные затраты: O(1)
        //затраты памяти: O(1)
        @Override
        public boolean hasNext() {
            return passed < initialSize;
        }

        //временные затраты: O(N)
        //затраты памяти: O(1)
        @Override
        public T next() {
            if (passed == initialSize || initialSize == 0) throw new NoSuchElementException();
            passed++;
            currentObject = storage[++currentIndex];
            while (currentObject == null || currentObject == DELETED) {
                currentIndex++;
                currentObject = storage[currentIndex];
            }
            return (T) currentObject;
        }

        //временные затраты: O(1)
        //затраты памяти: O(1)
        @Override
        public void remove() {
            if (currentObject == null) throw new IllegalStateException();
            currentObject = null;
            storage[currentIndex] = DELETED;
            size--;
        }
    }
}
