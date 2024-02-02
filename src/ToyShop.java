import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyShop {
    private class Toy {
        public int id;
        public String name;
        public int weight;

        public Toy(int id, int weight, String name) {
            this.id = id;
            this.name = name;
            this.weight = weight;
        }
    }

    private PriorityQueue<ToyShop.Toy> toysQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.weight, t1.weight));

    public void put(String input) {
        String[] parts = input.split(" ");
        int id = Integer.parseInt(parts[0]);
        int weight = Integer.parseInt(parts[1]);
        String name = parts[2];
        Toy toy = new Toy(id, weight, name);
        toysQueue.add(toy);
    }

    public int get() {
        int totalWeight = toysQueue.stream().mapToInt(t -> t.weight).sum();
        Random random = new Random();
        int randomNumber = random.nextInt(totalWeight);
        int cumulativeWeight = 0;
        for (Toy toy : toysQueue) {
            cumulativeWeight += toy.weight;
            if (randomNumber < cumulativeWeight) {
                return toy.id;
            }
        }
        return -1;
    }

    public void writeResultsToFile(String filename, int count) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < count; i++) {
                int result = get();
                writer.write(Integer.toString(result));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}