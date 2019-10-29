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
    public PerpetualReactorHeating(float temperature){
        this.number = (int) temperature;
    }

    @Override

    public void execute(float deltaTime) {
        this.reactor=this.getActor();
        this.reactor.increaseTemperature(this.number);
    }

}
