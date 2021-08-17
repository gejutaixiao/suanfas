package leetcode.suanfa.zcybook._1;

import java.util.LinkedList;
import java.util.Queue;

public class _4_DogCatQueue {

    //猫狗队列
    /**
     * 用户可以调用add方法将cat类或dog类的实例放入队列中
     * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出
     * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
     * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
     * 用户可以调用isEmpty
     * 用户可以调用isDogEmpty
     * 用户可以调用isCatEmpty
     */

    Queue<PetEnterQueue> cat;
    Queue<PetEnterQueue> dog;
    int count;
    public _4_DogCatQueue() {
        cat = new LinkedList<>();
        dog = new LinkedList<>();
        count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("cat")) {
            cat.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType().equals("dog")){
            dog.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("pet is not cat or dog");
        }
    }

    public Pet pollAll() {
        if (!cat.isEmpty() && !dog.isEmpty()) {
            if (cat.peek().getCount() > dog.peek().getCount()) {
                return dog.remove().getPet();
            } else {
                return cat.remove().getPet();
            }
        } else if (!cat.isEmpty()) {
            return cat.remove().getPet();
        } else if (!dog.isEmpty()) {
            return dog.remove().getPet();
        } else {
            throw new RuntimeException("queue is empty!");
        }
    }

    public Pet pollDog() {
        if (dog.isEmpty()) {
            throw new RuntimeException("dog queue is empty!");
        } else {
            return dog.remove().getPet();
        }
    }

    public Pet pollCat() {
        if (cat.isEmpty()) {
            throw new RuntimeException("cat queue is empty!");
        } else {
            return cat.remove().getPet();
        }
    }

    public boolean isEmpty() {
        if (cat.isEmpty() && dog.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isDogEmpty() {
        return dog.isEmpty();
    }

    public boolean isCatEmpty() {
        return cat.isEmpty();
    }

}

class Pet {
    String type;
    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Dog extends Pet {

    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat() {
        super("cat");
    }
}
class PetEnterQueue {
    Pet pet;
    int count;
    public PetEnterQueue(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }
    public String getPetType() {
        return pet.getType();
    }
}
