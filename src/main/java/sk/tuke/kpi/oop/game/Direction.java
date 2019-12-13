package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0),
    NORTHEAST(1, 1), NORTHWEST(-1, 1), SOUTHEAST(1, -1), SOUTHWEST(-1, -1), NONE(0, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dy = dy;
        this.dx = dx;

    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public float getAngle() {
        switch (this) {
            case EAST:
                return 360f - 90f;
            case WEST:
                return 360f - 270f;
            case NORTH:
                return 0f;
            case SOUTH:
                return 360f - 180f;
            case NORTHEAST:
                return  360f-45f;
            case NORTHWEST:
                return 45f;
            case SOUTHEAST:
                return 180f + 45f;
            case SOUTHWEST:
                return 180f - 45f;
            default: return -1f;
        }
    }

    public Direction combine(Direction other) {
        Direction[] ways = Direction.values();
        if (this.equals(other)) {
            return other;
        }
        int y = this.dy + other.dy;
            if(y==2 || y== -2){y=y/2;}
        int x = this.dx + other.dx;
            if(x==2 || x== -2){x=x/2;}

        for (int i = 0; i < ways.length; i++){
            if(ways[i].dx == x && ways[i].dy == y){
               return ways[i];
            }
        }
        return Direction.NONE;
    }
    public static Direction fromAngle(float angle) {
        if (angle == 270.0f) {
            return EAST;
        } else if (angle == 45.0f) {
            return NORTHWEST;
        } else if (angle == 0.0f) {
            return NORTH;
        } else if (angle == 135.0f) {
            return SOUTHWEST;
        } else if (angle == 225.0f) {
            return SOUTHEAST;
        } else if (angle == 315.0f) {
            return NORTHEAST;
        } else if (angle == 90.0f) {
            return WEST;
        } else if (angle == 180.0f) {
            return SOUTH;
        }
        return NONE;

    }
}

