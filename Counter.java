import java.io.Closeable;
import java.io.IOException;

class Counter implements Closeable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() {
        count++;    // Увеличиваем счетчик на 1
    }

    public int getCount() {
        return count;   // Возвращаем текущее значение счетчика
    }

    @Override
    public void close() throws IOException {
        if (count == 0) {
            throw new IOException("Счетчик не был использован в блоке try-with-resources");
        }
        System.out.println("Счетчик закрыт");
    }
}
