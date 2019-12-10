package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.gamelib.framework.Scenario;
import sk.tuke.kpi.oop.game.Cooler;
import sk.tuke.kpi.oop.game.Helicopter;
import sk.tuke.kpi.oop.game.Reactor;
import sk.tuke.kpi.oop.game.TimeBomb;



public class TrainingGameplay extends Scenario {

    public TrainingGameplay(){

    }


    @Override
    public void setupPlay(@NotNull Scene scene) {
        TimeBomb chain1 = new TimeBomb(10);
        TimeBomb chain2 = new TimeBomb(10);
        scene.addActor(chain1, 265, 15);
        scene.addActor(chain2, 25, 180);
        Reactor reactor = new Reactor();
//        Hammer hammer = new Hammer();
        scene.addActor(reactor,64,64);
        reactor.turnOn();
        Cooler cooler= new Cooler(reactor);
        scene.addActor(cooler,22 , 22);
        cooler.turnOn();
        Helicopter helicopter = new Helicopter();
        scene.addActor(helicopter,125,125);
        new ActionSequence<>(
            new Wait<>(5),
            new Invoke<>(cooler::turnOn)
        ).scheduleFor(cooler);

        new When<>(
            () -> {
                return reactor.getTemperature() >= 3000;
            },
            new Invoke<>(() -> reactor.repair())
        ).scheduleFor(reactor);
    }
}
// 1.5 must make
