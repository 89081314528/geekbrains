package ru.geekbrains;

public class ObstacleCourse {
    Barrier[] barrier;

    public ObstacleCourse(Barrier barrier1, Barrier barrier2, Barrier barrier3, Barrier barrier4, Barrier barrier5) {
        this.barrier = new Barrier[]{barrier1, barrier2, barrier3, barrier4, barrier5};
    }

    public void go(Team team) {
        for (Creature creature : team.getCreatures()) {
            for (Barrier barrier : barrier) {
                barrier.path(creature);
                if (!creature.isOverride()) {
                    break;
                }
            }
        }
    }
}