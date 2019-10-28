package sk.tuke.kpi.oop.game.actions;


import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Reactor;


public class PerpetualReactorHeating extends AbstractAction<Reactor>{
    private Reactor reactor;


    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
    }
    public PerpetualReactorHeating(float number){

    }

    @Override

    public void execute(float deltaTime) {
        this.reactor=this.getActor();
        this.reactor.increaseTemperature(1);
    }

}
