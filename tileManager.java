/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproj;

import static com.jogamp.common.util.ReflectionUtil.instanceOf;
import java.awt.Event;
import java.util.Enumeration;
import javax.media.j3d.Behavior;
import javax.media.j3d.Transform3D;
import javax.media.j3d.WakeupCriterion;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.media.j3d.WakeupOnElapsedTime;
import javax.media.j3d.WakeupOr;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author PRC RYZEN RTX GAMING
 */
public class tileManager  {
    //shape
    Cube cube;
    Movement mover;
    public tileManager(Cube cube){
        this.cube=cube;
        this.mover = new Movement(this.cube);
    }
    //action
    
    //move when player moves
    class Movement extends Behavior{
        Cube cube;
        WakeupCriterion[] events = new WakeupCriterion[4];
        public Movement(Cube cube){
            this.cube=cube;
            
        }
        public void initialize(){
            events[0]= new WakeupOnAWTEvent(Event.DOWN);
            events[0]= new WakeupOnAWTEvent(Event.UP);
            events[0]= new WakeupOnAWTEvent(Event.LEFT);
            events[0]= new WakeupOnAWTEvent(Event.RIGHT);
            wakeupOn(new WakeupOr(events));
        }
        public void processStimulus(Enumeration e){
            WakeupCriterion event = (WakeupCriterion)e.nextElement();
            Transform3D tr = new Transform3D();
            if(event.equals(events[0])){
                tr.setTranslation(new Vector3d(0,.5,0));
                cube.setTransform(tr);
                System.out.println("I worked");
            }else if(event.equals(events[1])){
                tr.setTranslation(new Vector3d(0,-.5,0));
                cube.setTransform(tr);
                System.out.println("I worked");
            }else if(event.equals(events[2])){
                tr.setTranslation(new Vector3d(-5,0,0));
                cube.setTransform(tr);
                System.out.println("I worked");
            }else if(event.equals(events[0])){
                tr.setTranslation(new Vector3d(0,5,0));
                cube.setTransform(tr);
                System.out.println("I worked");
            }
            wakeupOn(new WakeupOr(events));
        }
    }
    //if bumb into diff stop
    //ifbumb into same delete
    //if same bumbs into change value
}
