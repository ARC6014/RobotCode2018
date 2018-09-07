package frc.team6014.robot.autonomous.commands;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.*;
import jaci.pathfinder.followers.DistanceFollower;
import jaci.pathfinder.modifiers.TankModifier;
import frc.team6014.robot.Robot;

public class FollowPath extends Command {
    private final double MAX_VELOCITY = 1.5;
    private final double WHEELBASE_WIDTH = 0.50;

    private DistanceFollower left;
    private DistanceFollower right;

    public FollowPath() {
        super("FollowPath");
        requires(Robot.drive);
    }

    protected void initialize() {
        Waypoint[] points = new Waypoint[] {
                new Waypoint(-4, -1, Pathfinder.d2r(-45)),      // Waypoint @ x=-4, y=-1, exit angle=-45 degrees
                new Waypoint(-2, -2, 0),                        // Waypoint @ x=-2, y=-2, exit angle=0 radians
                new Waypoint(0, 0, 0)                           // Waypoint @ x=0, y=0,   exit angle=0 radians
        };

        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, MAX_VELOCITY, 2.0, 60.0);
        Trajectory trajectory = Pathfinder.generate(points, config);

        TankModifier modifier = new TankModifier(trajectory).modify(WHEELBASE_WIDTH);

        left = new DistanceFollower(modifier.getLeftTrajectory());
        right = new DistanceFollower(modifier.getRightTrajectory());

        left.configurePIDVA(1.0, 0.0, 0.0, 1 / MAX_VELOCITY, 0);
        right.configurePIDVA(1.0, 0.0, 0.0, 1 / MAX_VELOCITY, 0);
    }

    protected void execute() {
        System.out.println(Robot.perception.getLeftDistance());
        System.out.println(Robot.perception.getRightDistance());
        Robot.drive.tankDrive(left.calculate(Robot.perception.getLeftDistance()),
                right.calculate(Robot.perception.getRightDistance()));
    }

    protected boolean isFinished() {
        return false;
    }
}
