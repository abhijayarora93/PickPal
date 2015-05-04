package com.example.migo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class PickupClockRelativeView extends RelativeLayout{
	

	private String clicked;
	
	
	public PickupClockRelativeView(Context context) {
		super(context);
		//initViews(context, null);
		
		LayoutInflater.from(context).inflate(R.layout.contact_relative_view, this);
	}
	
	public PickupClockRelativeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initViews(context, attrs);
	}

	public PickupClockRelativeView(Context context, AttributeSet attrs, int defStyle) {
		this(context, attrs);
		initViews(context, attrs);
	}
	
	private void initViews(Context context, AttributeSet attrs) {
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.contactRelative, 0, 0);
		
		inflate(getContext(), R.layout.pickup_time, this);

		
		
		
		
	}
	
		public String getClicked(){
			return clicked;
		}
		
		public void setClicked(String click){
			this.clicked=click;
			
			
			
				System.out.println("clicked from setclick type is"+this.clicked);
				if(clicked.equals("true")){				
					inflate(getContext(), R.layout.contact_relative_pressed, this);
				}else {
					
					inflate(getContext(), R.layout.contact_relative_view, this);
				}
					
				
				
			
		}
				
		
		
		
		
		
		
		
		
		@Override
	    protected void onDraw(Canvas canvas) {
	    	super.onDraw(canvas);
	    	

	    	
	    	
		
		}

}
