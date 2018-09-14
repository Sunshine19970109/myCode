package com.dell.sunshinemap;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;
import com.baidu.mapapi.map.MKMapViewListener;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity{
	public Toast mToast;
	private BMapManager manager; 
	MapView mMapView=null;
	private MapController mMapController =null;
	MKMapViewListener mMapListener = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	//发送KEY到百度服务器
	checkKey();
	
	
	
	}
	private void checkKey() {
		manager = new BMapManager(getApplicationContext());
		// TODO Auto-generated method stub
		//验证Key
		manager.init(ConstantValue.KEY, new MKGeneralListener() {
			
			@Override
			public void onGetPermissionState(int iError) {
				// TODO Auto-generated method stub
				if(iError==MKEvent.ERROR_PERMISSION_DENIED)
				{
				//提示授权验证通过
					//PromptManager.showNoNetWork(MainActivity.this);	
//					showToast("API KEY错误，请检查！");
				}
			}
			
//			private void showToast(String msg) {
//				// TODO Auto-generated method stub
//				if(mToast == null){
//					mToast = Toast.makeText(this, 0, Toast.LENGTH_SHORT);
//				}else{
//					mToast.setText(msg);
//					mToast.setDuration(Toast.LENGTH_SHORT);
//				}
//				mToast.show;
//			}

			@Override
			public void onGetNetworkState(int iError) {
				// TODO Auto-generated method stub
				if(iError==MKEvent.ERROR_NETWORK_CONNECT)
				{
					//提示无网络
					Toast.makeText(getApplication(), null, Toast.LENGTH_LONG).show();
				}
			}
		});
		setContentView(R.layout.activity_main);
		mMapView=(MapView)findViewById(R.layout.activity_main);
		mMapController = mMapView.getController();
		mMapController.enableClick(true);
		mMapController.setZoom(12);
		mMapView.setBuiltInZoomControls(true);
		GeoPoint p = new GeoPoint((int)(22.547923*1E6),(int)(114.067368*1E6));
		mMapController.setCenter(p);
		mMapView.regMapViewListener(manager, new MKMapViewListener() {
			
			@Override
			public void onMapMoveFinish() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onMapAnimationFinish() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onGetCurrentMap(Bitmap arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClickMapPoi(MapPoi arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mMapView.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mMapView.onPause();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		mMapView.destroy();
		if(manager!=null){
			manager.destroy();
			manager = null;
		}
		super.onDestroy();
	}
	

}
