package model;

import model.balls.Bubbler;
import model.balls.Striker;
import model.balls.UserBall;
import model.balls.Wanderer;

import java.util.Random;

public class BallFactory {
     public UserBall createUserBall() {
         Random rand = new Random();
         int x = rand.nextInt(461)+20;
         int y = rand.nextInt(461)+20;
         Directions directions = this.randomDirections();
         return new UserBall(directions, x, y);
     }

     public Striker createStriker() {
         Random rand = new Random();
         int x = rand.nextInt(461)+20;
         int y = rand.nextInt(461)+20;
         Directions directions = this.randomDirections();
         return new Striker(directions, x, y);
     }

     public Wanderer createWanderer() {
         Random rand = new Random();
         int x = rand.nextInt(461)+20;
         int y = rand.nextInt(461)+20;
         Directions directions = this.randomDirections();
         return new Wanderer(directions, x, y);
     }

     public Bubbler createBubbler() {
         Random rand = new Random();
         int x = rand.nextInt(461)+20;
         int y = rand.nextInt(461)+20;
         Directions directions = this.randomDirections();
         return new Bubbler(directions, x, y);
     }

     public Directions randomDirections() {
         Random rand = new Random();
         return switch (rand.nextInt(8)) {
             case 0 -> Directions.Up;
             case 1 -> Directions.Down;
             case 2 -> Directions.Left;
             case 3 -> Directions.Right;
             case 4 -> Directions.DownLeft;
             case 5 -> Directions.UpRight;
             case 6 -> Directions.DownRight;
             default -> Directions.UpLeft;
         };
     }
}
