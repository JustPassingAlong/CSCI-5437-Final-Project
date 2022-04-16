/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamePkg;

import com.sun.j3d.utils.picking.PickCanvas;
import com.sun.j3d.utils.picking.PickResult;
import java.awt.Event;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import javax.media.j3d.Behavior;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Shape3D;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.media.j3d.WakeupOnElapsedTime;

/**
 *
 * @author PRC RYZEN RTX GAMING
 */
public class TestItem {
    //picking
    Canvas3D scene;
    BranchGroup branch = new BranchGroup();
    PickCanvas selector = new PickCanvas(scene,branch);
    Object posessor = new Object();
    //modifiers
    int damage;
    int health;
     MouseListener mouse = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
            selector.setShapeLocation(e);
            PickResult[] result = selector.pickAll();
            if(result[0].getObject() instanceof Shape3D){
                //add item multiplers to player
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    };
     //behavior
        public class TestCharItemBehavior extends  Behavior{
       //if player has item modifer
        
        @Override
        public void initialize() {
            //at start of game
            wakeupOn(new WakeupOnElapsedTime(1));
        }

        @Override
        public void processStimulus(Enumeration enumeration) {
            wakeupOn(new WakeupOnAWTEvent(Event.MOUSE_DOWN));
        }
   }
     //appearance
     Shape3D shape;
}
