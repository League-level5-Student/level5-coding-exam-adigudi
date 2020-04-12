package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;


public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		String numR = JOptionPane.showInputDialog("How many Robots?");
		int numRobots = Integer.parseInt(numR);
		String colorS = JOptionPane.showInputDialog("What color do you want the shapes to be? (Red, Green, Blue)");
		String numS = JOptionPane.showInputDialog("How many sides each shape will have? (>0)");
		int sides = Integer.parseInt(numS);
		
		Thread[] robots = new Thread[numRobots];
		for (int i = 0; i < robots.length; i++) {
			int y = i;
			robots[i] = new Thread (() -> {
				Robot robot = new Robot();
				robot.setSpeed(10);
				robot.moveTo(50 + (150*y), 300);
				robot.penDown();
				if(colorS.equalsIgnoreCase("red")) {
					robot.setPenColor(Color.RED);
				}
				else if(colorS.equalsIgnoreCase("green")){
					robot.setPenColor(Color.GREEN);
				}
				else {
					robot.setPenColor(Color.BLUE);
				}
			for (int j = 0; j < sides; j++) {
				robot.move(50);
				int degree = 360/sides;
				robot.turn(degree);
			}
		});
			robots[i].start();
	}
}
}
	
