package com.wanted.a_generic.b_use.run;

import com.wanted.a_generic.b_use.Bunny;
import com.wanted.a_generic.b_use.DrunkenBunny;
import com.wanted.a_generic.b_use.Rabbit;
import com.wanted.a_generic.b_use.RabbitFarm;

public class Application01 {
    public static void main(String[] args) {

//        RabbitFarm<Animal> farm1 = new RabbitFarm<>(); // Animal 은 토끼 클래스를 상속받지 않아서 에러
        RabbitFarm<Rabbit> farm2 = new RabbitFarm<>(); // 두 번쩨 <> 안은 비워놔도 됨
        RabbitFarm<Bunny> farm3 = new RabbitFarm<>();
        RabbitFarm<DrunkenBunny> farm4 = new RabbitFarm<>();

//        Rabbit rabbit = new Rabbit();
//        farm2.setAnimal(rabbit);
        farm2.setAnimal(new Rabbit()); // 위에 두 줄이 이 줄과 같음

//        Rabbit rabbit = farm2.getAnimal();
//        rabbit.cry();
        farm2.getAnimal().cry(); // 위에 두 줄이 이 줄과 같음
        // T 를 래빗으로 해놔서 래빗임

        farm3.setAnimal(new Bunny());
        farm3.getAnimal().cry();

        farm4.setAnimal(new DrunkenBunny());
        farm4.getAnimal().cry();

    }
}
