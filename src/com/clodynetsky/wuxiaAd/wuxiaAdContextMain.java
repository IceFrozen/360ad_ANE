package com.clodynetsky.wuxiaAd;

import android.app.Activity;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.clodynetsky.wuxiaAdutil.AppData;

public class wuxiaAdContextMain extends Activity implements FREExtension {
	
	public static CenterBanner centerBanner;  //¼òµ¥ºá·ùÀÛ

	@Override
	public void dispose() {
		
		centerBanner = null;
	
	}
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public FREContext createContext(String adSpecaId) {
		
		if(null == adSpecaId || ("").equals(adSpecaId.trim())){
			AppData.adSpeadId = AppData.defaultSpaceId;
			
		}else{
			AppData.adSpeadId = adSpecaId;
		}
	
		
		centerBanner =  new CenterBanner();
		
		
		return centerBanner;
	}

}
