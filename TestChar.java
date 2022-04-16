/*

 */
package gamePkg;

import java.awt.Event;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_UP;
import static java.awt.event.KeyEvent.VK_W;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import javax.media.j3d.Behavior;
import javax.media.j3d.BoundingBox;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.media.j3d.WakeupOnCollisionMovement;
import javax.media.j3d.WakeupOnElapsedTime;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Vector3d;

/**
 *
 * @author PRC RYZEN RTX GAMING
 */
public class TestChar {
    Transform3D tr = new Transform3D();
    TransformGroup tGroup = new TransformGroup(tr);
    int health;
    int damage;
    boolean isEnemy;
    //bounds
    BoundingBox bounds = new BoundingBox() ;
    //aperance
    Shape3D shape;
    //movement
    KeyListener key = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==VK_UP||e.getKeyCode()==VK_W){
                //move char foward
                tr.setTranslation(new Vector3d(0,0,1));
            }else if(e.getKeyCode()==VK_DOWN||e.getKeyCode()==VK_S){
                //move char back
                tr.setTranslation(new Vector3d(0,0,-1));
            }
            if(e.getKeyCode()==VK_LEFT||e.getKeyCode()==VK_A){
                //turn left
                tr.setRotation(new AxisAngle4d(-1,0,0,30));
            }else if(e.getKeyCode()==VK_RIGHT||e.getKeyCode()==VK_D){
                //turn right
                tr.setRotation(new AxisAngle4d(1,0,0,30));
            }
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    };
    //behavior
     public class TestCharCollBehavior extends  Behavior{
      //if player collides stop moving
        
        @Override
        public void initialize() {
            //at start of game
            wakeupOn(new WakeupOnElapsedTime(1));
        }

        @Override
        public void processStimulus(Enumeration enumeration) {
            //this bounds
            wakeupOn(new WakeupOnCollisionMovement(bounds));
        }
   }
      public class TestCharHealthBehavior extends  Behavior{
        //if player hit damage
        @Override
        public void initialize() {
            //at start of game
            wakeupOn(new WakeupOnElapsedTime(1));
        }

        @Override
        public void processStimulus(Enumeration enumeration) {
            //this bounds
            wakeupOn(new WakeupOnCollisionMovement(bounds));
        }
   }

    //apearance
    
}
