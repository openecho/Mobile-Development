package openecho.checkmyballs;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

class GameObject extends ReferenceChecker {
	public List<GameObject> mComponents;

	public GameObject() {
		super();
		mComponents = new ArrayList<GameObject>();
	}
	
	public GameObject(List<GameObject> components) {
		super();
		mComponents = components;
	}

	public void addComponent(GameObject component) {
		mComponents.add(component);
	}

	public void update(long time, GameObject parent) {
		 for (GameObject component : mComponents) {
			 component.update(time, this);
		 }
	}
	
	public void draw(Canvas canvas) {
		 for (GameObject component : mComponents) {
			 component.draw(canvas);
		 }
	}
}