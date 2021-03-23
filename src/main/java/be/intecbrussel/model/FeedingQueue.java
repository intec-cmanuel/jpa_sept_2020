package be.intecbrussel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class FeedingQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BrandFood> brandFood = new ArrayList<>();

    public void setName(BrandFood brandFood) {
        this.name = brandFood.getBrand();
    }

    public void addFood(BrandFood food) {
        brandFood.add(food);
    }

    public BrandFood getFood() {
        Random random = new Random();

        int randomIndex = random.nextInt(brandFood.size());
        return brandFood.get(randomIndex);
    }

    @Override
    public String toString() {
        return "FeedingQueue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandFood=" + brandFood +
                '}';
    }

    public String getName() {
        return name;
    }
}
