package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.actions.Action;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;

public class Move<A extends Movable> implements Action<Movable> {
//finish 3.6
    private Direction direction;
    private float duration;
    private float defaultDuration;
    private Movable actor;
    private boolean isDoneBoolean;
    private boolean isCalled;


    public Move(Direction direction, float duration){
    isDoneBoolean=false;
    this.duration=duration;
    this.isCalled=true;
    this.direction=direction;
    this.defaultDuration=duration;
    }


    public Move(Direction direction){
        this(direction,0);
    }


    public Movable getActor() {
        return actor;
    }

    /**
     * Sets actor for the action
     *
     * @param actor actor to be set for action
     */

    public void setActor(Movable actor) {
        this.actor = actor;
    }
    public boolean isDone() {
        return isDoneBoolean;
    }

    /**
     * Executes (one step of) the action. Called by the scene this
     * action was scheduled on, prior to rendering.
     *
     * @param deltaTime time passed from the previous execution
     */
    @Override
    public void execute(float deltaTime) {
        if(isCalled)
        {
            isCalled = false;
            getActor().startedMoving(this.direction);
        }
        else if(isDoneBoolean) {return;}

        int posX= getActor().getPosX();
        int posY=getActor().getPosY();
        getActor().setPosition(
            getActor().getPosX() + (getActor().getSpeed()*direction.getDx()),
            getActor().getPosY() + (getActor().getSpeed()*direction.getDy())
        );
        if(getActor().getScene().getMap().intersectsWithWall(getActor())) {
            stop();
            getActor().setPosition(posX, posY); //return ripley to the place with no wall
            getActor().collidedWithWall();
        }

        if(duration==0) {
            stop();
            return;
        }

        duration -= deltaTime;

        if(  duration <= 1e-5)
        {
            stop();
        }



    }

    /**
     * Resets the state of the action, except the assigned actor.
     */
    @Override
    public void reset() {
        this.isDoneBoolean = false;
        this.isCalled=true;
        getActor().stoppedMoving();
        duration=defaultDuration;
    }

    public Direction getDirection() {
        return direction;
    }

    public void stop()
    {
        if(actor!=null)
        getActor().stoppedMoving();
        this.isDoneBoolean = true;
    }

}
