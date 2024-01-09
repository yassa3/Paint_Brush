import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

// The parent class which all shapes inherit from it
abstract class Shape{
		// The private variables which represent the coordinations, color, if solid or no and if dotted or no
		private int x1,y1,x2,y2;
		private Color color;
		private boolean isSolid=false;
		private boolean isDotted=false;
		// The private setters and getters that used to access my private variables
		public void setx1(int x1){
			this.x1=x1;
		}
		public int getx1(){
			return x1;
		}
		public void sety1(int y1){
			this.y1=y1;
		}
		public int gety1(){
			return y1;
		}
		public void setx2(int x2){
			this.x2=x2;
		}
		public int getx2(){
			return x2;
		}
		public void sety2(int y2){
			this.y2=y2;
		}
		public int gety2(){
			return y2;
		}
		public void setcolor(Color c){
			color=c;
		}
		public Color getcolor(){
			return color;
		}
		public void setsolid(boolean s){
			isSolid=s;
		}
		public boolean getsolid(){
			return isSolid;
		}
		public void setdotted(boolean d){
			isDotted=d;
		}
		public boolean getdotted(){
			return isDotted;
		}
		// The constuctor used in my class to assign my values to variables
		public Shape(int x1,int y1,int x2,int y2,Color c,boolean d){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.color = c;
			this.isDotted = d;
		}
		public Shape(int x1,int y1,Color c,boolean s,boolean d){
			this.x1=x1;
			this.y1=y1;
			this.color = c;
			this.isSolid = s;
			this.isDotted = d;
		}
		public Shape(int x1,int y1,int x2,int y2,Color c){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.color = c;
		}
		public Shape(int x1,int y1){
			this.x1=x1;
			this.y1=y1;
		}
		public Shape(){
			
		}
		// The method that used to draw the shapes and it is abstract because all shapes must implement it
		protected abstract void draw(Graphics g);
}
// The oval class which represent the Oval shape
class Oval extends Shape{
		// The private variables I used to set width and height
		private int w;
		private int h;
		// The setters and getters for accessing the private variables
		public void setw(int w){
			this.w=w;
		}
		public int getw(){
			return w;
		}
		public void seth(int h){
			this.h=h;
		}
		public int geth(){
			return h;
		}
		// The constructor related to the oval shape, it passes the x1,y1,c,s,d to the shape constructor and assign the w,h variables 
		public Oval(int x1,int y1,int w,int h,Color c,boolean s,boolean d){
			super(x1,y1,c,s,d);
			this.w=w;
			this.h=h;
		}
		// The method that i used to draw the oval shape. it first set the color then checking for the solid and dotted booleans
		protected void draw(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g.setColor(getcolor());
			if (getdotted()){
				float [] d1 = {5, 5, 5, 5};  
				BasicStroke BasicS2 = new BasicStroke (1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0F, d1, 0.F); 
				g2d.setStroke (BasicS2);
			}
			else {
				g2d.setStroke(new BasicStroke());
			}
			if (getsolid())
			{
				g.fillOval(getx1(),gety1(),w,h);
			}
			else
			{
				g.drawOval(getx1(),gety1(),w,h);
			}
		}
}
// The rectangle class which represent the Rectangle shape
class Rectangle extends Shape{
		// The private variables I used to set width and height
		private int w;
		private int h;
		// The setters and getters for accessing the private variables
		public void setw(int w){
			this.w=w;
		}
		public int getw(){
			return w;
		}
		public void seth(int h){
			this.h=h;
		}
		public int geth(){
			return h;
		}
		// The constructor related to the rectangle shape, it passes the x1,y1,c,s,d to the shape constructor and assign the w,h variables 
		public Rectangle(int x1,int y1,int w,int h,Color c,boolean s,boolean d){
			super(x1,y1,c,s,d);
			this.w=w;
			this.h=h;
		}
		// The method that i used to draw the rectangle shape. it first set the color then checking for the solid and dotted booleans
		protected void draw(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g.setColor(getcolor());
			if (getdotted()){
				float [] d1 = {5, 5, 5, 5};  
				BasicStroke BasicS2 = new BasicStroke (1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0F, d1, 0.F); 
				g2d.setStroke (BasicS2);
			}
			else {
				g2d.setStroke(new BasicStroke());
			}
			if (getsolid())
			{
				g.fillRect(getx1(),gety1(),w,h);
			}
			else
			{
				g.drawRect(getx1(),gety1(),w,h);
			}
			
		}
}
// The line class which represent the Line shape
class Line extends Shape{
		// The constructor related to the line shape, it passes the x1,y1,x2,y2,c,d to the shape constructor 
		public Line(int x1,int y1,int x2,int y2,Color c,boolean d){
			super(x1,y1,x2,y2,c,d);
		}
		// The method that i used to draw the line shape. it first set the color then checking for the dotted boolean
		protected void draw(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g.setColor(getcolor());
			if (getdotted()){
				float [] d1 = {5, 5, 5, 5};  
				BasicStroke BasicS2 = new BasicStroke (1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0F, d1, 0.F); 
				g2d.setStroke (BasicS2);
			}
			else {
				g2d.setStroke(new BasicStroke());
			}
			g2d.drawLine(getx1(),gety1(),getx2(),gety2());
		}
}
// The FreeHand class which represent the Pencil 
class FreeHand extends Shape{
		// The pencil is array of lines so I make an array list of lines to represent the pencil 
		ArrayList<Line> fh = new ArrayList();
		// The constructor related to the pencil, it passes the x1,y1,x2,y2,c to the shape constructor and assign the array list it takes to the one which i defined
		public FreeHand(int x1,int y1,int x2,int y2,Color c,ArrayList<Line> al){
			super(x1,y1,x2,y2,c);
			this.fh.addAll(al);
		}
		// The method that i used to draw the pencil.
		protected void draw(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke());
			g.setColor(getcolor());
			g.drawLine(getx1(),gety1(),getx2(),gety2());
		}
}
// The Eraser class which represent the eraser 
class Eraser extends Shape{
		// The eraser is array of rectangles or squares so I make an array list of rectangle to represent the eraser 
		ArrayList<Rectangle> erase = new ArrayList();
		// The constructor related to the eraser, it passes the x1,y1 to the shape constructor and assign the array list it takes to the one which i defined
		public Eraser(int x1,int y1,ArrayList<Rectangle> ar){
			super(x1,y1);
			this.erase.addAll(ar);
		}
		// The method that i used to draw the eraser.
		protected void draw(Graphics g){
			g.setColor(Color.WHITE);
			g.fillRect(getx1(),gety1(),15,15);
		}
}
public class PBrush extends Applet{
	//Here i declare all my variables, arraylists and buttons that i will use in my Paint APP
	Line l;
	Oval o;
	Rectangle r;
	FreeHand fh;
	Eraser er;
	private static final int line = 0;
	private static final int oval = 1;
	private static final int rectangle = 2;
	private static final int freehand = 3;
	private static final int eraser = 4;
	int currentlydrawing = -1;
	Color currentlycolor = Color.WHITE;
	Button boval,brect,bline,bfree,beraser,bred,bblue,bgreen,Undo,Redo,ClearAll;
	Checkbox csolid;
	Checkbox Dotted;
	int x1,x2,y1,y2;
	int x,y,w,h;
	int index,size;
	boolean solid;
	boolean dotted;
	boolean fdragged=false;
	boolean flag=true;
	boolean feraser = false;
	boolean fpen = false;
	ArrayList<Shape> arr = new ArrayList<Shape>();
	ArrayList<Shape> arr2 = new ArrayList<Shape>();
	ArrayList<Line> pen = new ArrayList<Line>();
	ArrayList<Rectangle> erarr = new ArrayList<Rectangle>();
	public void init(){
		//here I make an object for each button
		boval = new Button("Oval");
		brect = new Button("Rectangle");
		bline = new Button("Line");
		bfree = new Button("Pencil");
		beraser = new Button("Eraser");
		bred = new Button("Red");
		bblue = new Button("Blue");
		bgreen = new Button("Green");
		Undo = new Button("Undo");
		Redo = new Button("Redo");
		ClearAll = new Button("Clear All"); 
		csolid = new Checkbox("Solid");
		Dotted = new Checkbox("Dotted");
		// all the next lines of code in the init() method are related to the events and listeners and all of them are Anonymous Inner Class
		// there are 2 variables i used currentlydrawing and currentlycolor to set which shape and color I am useing now
		bline.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlydrawing = PBrush.line;
			}
		});
		add(bline);
		
		boval.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlydrawing = PBrush.oval;
			}
		});
		add(boval);
		
		brect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlydrawing = PBrush.rectangle;
			}
		});
		add(brect);
		
		bfree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlydrawing = PBrush.freehand;
				fpen = true;
			}
		});
		add(bfree);
		
		beraser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlydrawing = PBrush.eraser;
				feraser = true;
			}
		});
		add(beraser);
		
		bred.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlycolor = Color.RED;
			}
		});
		add(bred);
		
		bblue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlycolor = Color.BLUE;
			}
		});
		add(bblue);
		
		bgreen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentlycolor = Color.GREEN;
			}
		});
		add(bgreen);
		
		Undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = arr.size() - 1;
				if (index >= 0) {
					arr2.add(arr.get(index));
					arr.remove(index);					
				}
				repaint();
			}
		});
		add(Undo);
		
		Redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = arr2.size() - 1;
				if (size >= 0){
						arr.add(arr2.get(arr2.size() - 1));
						arr2.remove(arr2.size() - 1);					
				}
				repaint();
			}
		});
		add(Redo);
		
		ClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arr.clear();
				arr2.clear();
				repaint();
			}
		});
		add(ClearAll);
		// The listener of the Solid checkbox
		csolid.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(csolid.getState()){
					solid = true;
				}
				else
				{
					solid = false;
				}
			}
		});
		add(csolid);
		// The listener of the dotted checkbox
		Dotted.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(Dotted.getState()){
					dotted = true;
				}
				else
				{
					dotted = false;
				}
			}
		});
		add(Dotted);
		// The mouse listener for the pressing and releasing events
		this.addMouseListener(new MouseAdapter(){
			/*
			When pressing the mouse it will assign the x1 and y1 coordinates also it will make the flag boolean true 
			which i use in the paint method to make sure that when i release the mouse it will stop drawing.
			Also there are conditions for the eraser and the pen to clear the array list used for them before drawing the next one
			*/
			public void mousePressed(MouseEvent e){
				if (currentlydrawing != -1){
					x1=e.getX();
					y1=e.getY();
				}
				flag=true;
				if (feraser == false){
					erarr.clear();
					feraser = true;
				}
				if (fpen == false){
					pen.clear();
					fpen = true;
				}
			}
			/*
			When pressing the released button it will assign the x2 and y2 coordinates and check if 
			they are negative so that i can make the shapes moves in negative or positive directions.
			Then using the fdragged boolean to make sure that the shape is already dragged before saving it
			in the arraylist that will be used in paint method to draw all past shapes.
			*/
			public void mouseReleased(MouseEvent e){
				x2=e.getX();
				y2=e.getY();
				if (currentlydrawing==1 || currentlydrawing == 2)
				{
					if (x2<x1)
					{
						w=x1-x2;
						x=x2;
					}
					if (x2>x1)
					{
						w=x2-x1;
						x=x1;
					}	
					if (y2<y1)
					{
						h=y1-y2;
						y=y2;
					}	
					if (y2>y1)
					{
						h=y2-y1;
						y=y1;
					}		
				}
				if (fdragged){
				if (currentlydrawing == 0)
					arr.add(new Line(x1,y1,x2,y2,currentlycolor,dotted));
				else if (currentlydrawing == 1)
					arr.add(new Oval(x,y,w,h,currentlycolor,solid,dotted));
				else if (currentlydrawing == 2)
					arr.add(new Rectangle(x,y,w,h,currentlycolor,solid,dotted));
				else if (currentlydrawing == 3){
					arr.add(new FreeHand(x1,y1,x2,y2,currentlycolor,pen));
					fpen = false;
				}
				else if (currentlydrawing == 4){
					arr.add(new Eraser(x,y,erarr));
					feraser = false;
				}

				}
				fdragged=false;
				flag=false;
			}
		});	
		// The mousemotion listener for the dragging event
		this.addMouseMotionListener(new MouseAdapter(){
			/*
			There is only one method here is used so I used the mouseadapter class instead of mousemotion listener interface
			it is the dragged method and when i drag the mouse it will continue updating the x2 and y2 coordinates, checking for 
			the dirctions and keep drawing the shapes while dragging.
			Also it if is pencil or eraser it will continue to add the rectangles or lines to arraylist.
			then when releasing it will take this arraylisy and pass it to constructor of objects of type FreeHand or Eraser
			*/
			public void mouseDragged(MouseEvent e){
				fdragged=true;
				x2=e.getX();
				y2=e.getY();
				if (currentlydrawing == 1||currentlydrawing == 2){
					if (x2<x1)
					{
						w=x1-x2;
						x=x2;
					}
					if (x2>x1)
					{
						w=x2-x1;
						x=x1;
					}	
					if (y2<y1)
					{
						h=y1-y2;
						y=y2;
					}	
					if (y2>y1)
					{
						h=y2-y1;
						y=y1;
					}		
				}
				if (currentlydrawing == 3){
						pen.add(new Line(x1,y1,x2,y2,currentlycolor,false));
						x1 = x2;
						y1 = y2;
					}
				if (currentlydrawing == 4){
						x=x2;
						y=y2;
						erarr.add(new Rectangle(x,y,15,15,Color.WHITE,true,false));
					}
					repaint();
				}
				
			});
		
		
	}
	// The paint method which is callback method that used for drawing and it is divided into 2 parts
	public void paint(Graphics g){
		// The first part related to drawing past shapes which i already have drawn before and i saved it in the array list of type shape
		//also there is condition if it is eraser or pencil so it must draw the elements inside the arraylist of each of them
		for (int i=0;i<arr.size();i++){
			
			if (arr.get(i) instanceof Eraser){
				Eraser es = (Eraser) arr.get(i);
				for (int j=0;j<es.erase.size();j++){
					es.erase.get(j).draw(g);
				}
			}
			else if (arr.get(i) instanceof FreeHand){
				FreeHand p = (FreeHand) arr.get(i);
				for (int j=0;j<p.fh.size();j++){
					p.fh.get(j).draw(g);
				}
			}
			else{
				arr.get(i).draw(g);
			}
		}
		// The second part related to drawing the current shape and I used the switch case with currentlydrawing to specify the shape I draw now
		/* 
		The flag boolean i used it to make sure that when pressing or dragging the shape it will be drawn by this part but if the mouse 
		released it stop drawing until the next press of the mouse 
		*/
		if (flag){
			switch (currentlydrawing){
				case 0:
					l = new Line(x1,y1,x2,y2,currentlycolor,dotted);
					l.draw(g);
				break;
				case 1:
					o = new Oval(x,y,w,h,currentlycolor,solid,dotted);
					o.draw(g);
				break;
				case 2:
					r = new Rectangle(x,y,w,h,currentlycolor,solid,dotted);
					r.draw(g);
				break;
				case 3:
					for (int j=0;j<pen.size();j++){
						pen.get(j).draw(g);
					}
				break;
				case 4:		
					for (int j=0;j<erarr.size();j++){
						erarr.get(j).draw(g);
					}
				break;
			}
		}
	}
}