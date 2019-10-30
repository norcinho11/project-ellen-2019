package sk.tuke.kpi.oop.game.actions;


import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Reactor;


public class PerpetualReactorHeating extends AbstractAction<Reactor>{
    private Reactor reactor;
    private int number;

    public void setReactor(Reactor reactor) {
        if(this.reactor==null){
            return;
        }
        this.reactor = reactor;
    }
    public PerpetualReactorHeating(int temperature){
        this.number = temperature;
    }

    @Override

    public void execute(float deltaTime) {
        this.reactor=this.getActor();
        if(this.reactor==null){
            return;
        }
        this.reactor.increaseTemperature(this.number);
    }

}
