package com.example.migo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class CarView extends RelativeLayout{
	
	
	private int seats;
	private String car_type;
	


	public CarView(Context context) {
		super(context);
		
		//LayoutInflater.from(context).inflate(R.layout.car_view, this);
	}
	
	public CarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initViews(context, attrs);
	}

	public CarView(Context context, AttributeSet attrs, int defStyle) {
		this(context, attrs);
		initViews(context, attrs);
	}
	
	private void initViews(Context context, AttributeSet attrs) {
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.CarView, 0, 0);
		//inflate(getContext(), R.layout.car_view, this);
	
		try {
			setSeats(a.getInt(R.styleable.CarView_car_seats, 5));
			car_type = a.getString(R.styleable.CarView_car_type);
			
			System.out.println("car type is"+car_type);
			if(car_type.equals("small")){
				inflate(getContext(), R.layout.car_view_small, this);
			}
			if(car_type.equals("medium")){
				System.out.println("car view is medium");
				inflate(getContext(), R.layout.car_view, this);
			}
			if(car_type.equals("large")){
				inflate(getContext(), R.layout.car_view_small, this);
			}
			
			
			
			
			
		} finally {
			a.recycle();
		}

	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public String getCarType() {
		return this.car_type;
	}

	public void setCarType(String car_type) {
		this.car_type = car_type;
	}
	
	
	

}