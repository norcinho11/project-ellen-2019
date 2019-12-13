package sk.tuke.kpi.oop.game.behaviours;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.messages.Topic;

import java.util.function.Predicate;


public class Observing<A extends Actor, T>implements Behaviour<A> {
    private Behaviour<A> delegate;
    private A actor;
    private Predicate<T> predicate;
    private Topic<T> topic;

    public Observing(Topic<T> topic, Predicate<T> predicate,Behaviour<A>delegate){
    this.topic=topic;
    this.delegate=delegate;
    this.predicate=predicate;

    }
    @Override
    public void setUp(A actor) {
    if(actor==null){
        return;
    }
    this.actor=actor;
    actor.getScene().getMessageBus().subscribe(topic, this::testPredicate);
        }
        private void testPredicate(T test){
        if(predicate.test(test)){
            delegate.setUp(actor);
        }
        }
}
