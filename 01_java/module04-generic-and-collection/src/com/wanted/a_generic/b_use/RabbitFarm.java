package com.wanted.a_generic.b_use;

/* T <- 타입 변수에는 어떤 값이 들어올지 모른다.
* 단. extends Rabbit 이라고 작성을 하게 되면
* T 타입변수에는 Rabbit 혹은 Rabbit 을 상속 받은 클래스만 들어올 수 있게 된다.
* */
// 제네릭 클래스

public class RabbitFarm<T extends Rabbit> {
    private T animal;

    // 기본 생성자
    public RabbitFarm(){}

    // alt + insert -> 생성자
    public RabbitFarm(T animal) {
        this.animal = animal;
    }

    // alt + insert -> getter, setter
    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
