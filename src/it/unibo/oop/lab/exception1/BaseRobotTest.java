package it.unibo.oop.lab.exception1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Testing class for PositionOutOfBound.
 * 
 */
public final class BaseRobotTest {

    /**
     * Simple test for testing a robot moving, wandering the available
     * environment.
     * @throws Exception 
     * 
     */
    @Test
    public void testRobotMovementBase() throws Exception {
        /*
         * FIRST OF ALL, take a look to "TestWithExceptions". Read the source and the
         * comments very carefully.
         */
        /*
         *  1) Create a Robot with battery level 100
         */
        final Robot r1 = new Robot("SimpleRobot", 100);
        // checking if robot is in position x=0; y=0
        assertEquals("[CHECKING ROBOT INIT POS X]", 0, r1.getEnvironment().getCurrPosX());
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        /*
         * 2) Move the robot right until it touches the world limit
         */
        try {
        	for (int i = 0; i < RobotEnvironment.WORLD_X_UPPER_LIMIT; i++) {
            r1.moveRight();
        	}
        	r1.moveRight();
        	fail("I cannot go here");
        } catch (PositionOutOfBoundException e) {
        	assertTrue(e.getMessage().contains("pos(" + (RobotEnvironment.WORLD_X_UPPER_LIMIT + 1) + ", 0)"));
        } catch (NotEnoughBatteryException e) {
        	fail ("Not enough battery");
        }
        /*
         * 2) Move to the top until it reaches the upper right conrner of the world
         */
        try {
        	for (int i = 0; i < RobotEnvironment.WORLD_Y_UPPER_LIMIT; i++) {
        		r1.moveUp();
        	}
        	r1.moveUp();
        } catch (PositionOutOfBoundException e) {
            assertTrue(e.getMessage().contains("pos(" + RobotEnvironment.WORLD_X_UPPER_LIMIT +
            		", " + (RobotEnvironment.WORLD_Y_UPPER_LIMIT + 1) + ")"));
        } catch (NotEnoughBatteryException e) {
            fail("not enough battery");
        }
        // checking positions x=50; y=80
        assertEquals("[MOVING RIGHT ROBOT POS X]", RobotEnvironment.WORLD_X_UPPER_LIMIT, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", RobotEnvironment.WORLD_Y_UPPER_LIMIT, r1.getEnvironment().getCurrPosY());
    }

    /**
     * Simple test for testing robot battery.
     * @throws Exception 
     * 
     */
    @Test
    public void testRobotBatteryBase() throws Exception {
        final Robot r2 = new Robot("SimpleRobot2", 20);
        /*
         * Repeatedly move the robot up and down until the battery is completely
         * exhausted.
         */
        try {
        	while (r2.getBatteryLevel() > 0) {
        		r2.moveUp();
        		r2.moveDown();
        	}
        	r2.moveDown();
        	fail("no battery");
        } catch (PositionOutOfBoundException e){
        	fail("position out of bound");
        } catch (NotEnoughBatteryException e) {
        	assertTrue(e.getMessage().contains("battery level is " + r2.getBatteryLevel()));
        }
    }
}
