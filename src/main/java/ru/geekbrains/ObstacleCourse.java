package ru.geekbrains;

public class ObstacleCourse {
    Barrier[] barrier;

    public ObstacleCourse(Barrier barrier1, Barrier barrier2, Barrier barrier3, Barrier barrier4, Barrier barrier5) {
        this.barrier = new Barrier[]{barrier1, barrier2, barrier3, barrier4, barrier5};
    }

    public void go(Team team) {
        for (Creature creature : team.creatures) {
            for (Barrier barrier : barrier) {
                if (barrier instanceof Wall) {
                    creature.jump((Wall) barrier);
                    if (!creature.isJumpSussecc()) {
                        break;
                    }
                } else {
                    if (barrier instanceof TreadMill) {
                        creature.run((TreadMill) barrier);
                    }
                    if (!creature.isRunSussecc()) {
                        break;
                    }
                }
            }
        }
    }
}