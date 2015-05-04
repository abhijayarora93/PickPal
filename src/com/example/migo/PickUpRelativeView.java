package com.example.migo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;

public class PickUpRelativeView extends RelativeLayout{
	
	private String clicked_pick ;
	
	
		public String getClicked(){
			return clicked_pick;
		}
		
		public void setClicked(){
			System.out.println("clicked from setclick type is"+this.clicked_pick);
			if(clicked_pick.equals("false")){	
				
				inflate(getContext(), R.layout.pick_relative_view_pressed, this);
				
				this.clicked_pick = "true";
			}else {
				
				inflate(getContext(), R.layout.pick_relative_view_unpressed, this);
				this.clicked_pick="false";
			}
		}
				
		
		

		public PickUpRelativeView(Context context) {
			super(context);
			//initViews(context, null);
			
			//LayoutInflater.from(context).inflate(R.layout.car_view, this);
		}
		
		public PickUpRelativeView(Context context, AttributeSet attrs) {
			super(context, attrs);
			initViews(context, attrs);
		}

		public PickUpRelativeView(Context context, AttributeSet attrs, int defStyle) {
			this(context, attrs);
			initViews(context, attrs);
		}
		
		public void initViews(Context context, AttributeSet attrs) {
			TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
					R.styleable.pickUpRelative, 0, 0);
			
			try {
				clicked_pick = a.getString(R.styleable.pickUpRelative_clicked_pick);
		
			System.out.println("clicked type is"+clicked_pick);
			if(clicked_pick.equals("true")){
				inflate(getContext(), R.layout.pick_relative_view_pressed, this);
			}else 
				inflate(getContext(), R.layout.pick_relative_view_unpressed, this);
			}finally{
				a.recycle();
			}
			
			
			
		}
		
		@Override
	    protected void onDraw(Canvas canvas) {
	    	super.onDraw(canvas);
//	    	initViews(this.getContext(), )
	    	
	    	
		
		}
		
		

		
		
		
		

	

}
