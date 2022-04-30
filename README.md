# CSCI-5437-Final-Project

package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.TextArea;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class model extends JFrame {
	
	public model() {
		GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
		Canvas3D cv = new Canvas3D(gc);
		Container pane = this.getContentPane();
		pane.add(cv, BorderLayout.CENTER);
		TextArea ta = new TextArea("",3,30,TextArea.SCROLLBARS_NONE);
		ta.setText("Translation: Drag with right button\n");
		ta.setEditable(false);
		add(ta, BorderLayout.SOUTH);
		BranchGroup bg = createSceneGraph(cv);
		bg.compile();
		SimpleUniverse su = new SimpleUniverse(cv);
		su.getViewingPlatform().setNominalViewingTransform();
		su.addBranchGraph(bg);
	}
	
	private BranchGroup createSceneGraph(Canvas3D cv) {
		BranchGroup root = new BranchGroup();
		// Transform group
		TransformGroup move = new TransformGroup();
		move.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		move.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		root.addChild(move);
		// Appearance
		Appearance ap = new Appearance();
		ap.setMaterial(new Material());
		// Box brush 
		move.addChild(new Box(0.1f,0.1f,0.1f,ap));
		// Translation
		MouseTranslate translator = new MouseTranslate(move);
		BoundingSphere bound = new BoundingSphere();
		translator.setSchedulingBounds(bound);
		move.addChild(translator);
		// Lights
		PointLight light = new PointLight(new Color3f(Color.RED),
										  new Point3f(1f,1f,1f),
										  new Point3f(1f,0.1f,0f));
		BoundingSphere bounds = new BoundingSphere();
		light.setInfluencingBounds(bounds);
		root.addChild(light);
		// Background
		Background bg = new Background(new Color3f(Color.WHITE));
		bg.setApplicationBounds(bounds);
		root.addChild(bg);
		return root;
	}
	
	  //Appearance createAppearance(){
		    //Appearance ap = new Appearance();
		    //return ap;
	  //}
	
	public static void main(String[] args) {
		System.setProperty("sun.awt.noerasebackground", "true");
		JFrame frame = new model();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
