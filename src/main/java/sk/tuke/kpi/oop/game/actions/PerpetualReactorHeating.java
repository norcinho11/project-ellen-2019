package sk.tuke.kpi.oop.game.actions;


import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Reactor;


public class PerpetualReactorHeating extends AbstractAction<Reactor>{
    private Reactor reactor;
    private int number;

    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
    }
    public PerpetualReactorHeating(float number){
        this.number = (int) number;
    }

    @Override

    public void execute(float deltaTime) {
        this.reactor=this.getActor();
        this.reactor.increaseTemperature(this.number);
    }

}
